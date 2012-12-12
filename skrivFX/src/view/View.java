package view;

import classes.Page;
import classes.Word;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;


public class View {
    
    private java.util.List<Page> tabs;
    private Canvas writingCanvas; // Writing Box
    private int currentIndex; // Current tab
    
    public View(){
        tabs = new java.util.ArrayList<>();
    }
    
    public void makeWritingCanvas(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        writingCanvas = new Canvas();
        writingCanvas.widthProperty().bind(width);
        writingCanvas.heightProperty().bind(height);
    }
    
    public void addHandlers(EventHandler<MouseEvent> e){
        writingCanvas.setOnMousePressed(e);
        writingCanvas.setOnMouseDragged(e);
        writingCanvas.setOnMouseReleased(e);
    }
    
    // Must return a page so that it can be added to the TabPane
    public Page addTab(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        tabs.add(new Page(width, height));
        currentIndex = tabs.size()-1;
        return tabs.get(currentIndex);
    }
    
    public void setCurrentIndex(int i){
        currentIndex = i;
    }
    
    public void drawWord(Word w){
        tabs.get(currentIndex).drawWord(w);
    }
    
    public Image getSnapshot(int x, int y, int width, int height){
        SnapshotParameters sp = new SnapshotParameters();
        sp.setViewport(new javafx.geometry.Rectangle2D(x, y, width, height));
        return writingCanvas.snapshot(sp, null);
    }
    
    public void startLine(double x, double y){
        writingCanvas.getGraphicsContext2D().beginPath();
        writingCanvas.getGraphicsContext2D().moveTo(x, y);
    }
    
    public void updateLine(double x, double y){
        writingCanvas.getGraphicsContext2D().lineTo(x, y);
        writingCanvas.getGraphicsContext2D().stroke();
    }
    
    public Canvas getWritingCanvas(){
        return writingCanvas;
    }
}