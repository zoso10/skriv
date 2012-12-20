package views;

import classes.Word;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import skrivfx.TestController;


public class ViewSingleton {
    
    private java.util.List<views.Page> tabs;
    private javafx.scene.canvas.Canvas writingCanvas; // Writing box
    private javafx.scene.canvas.GraphicsContext writingGC;
    private int currentIndex; // Current tab
    private java.util.List<Double> xPoints;
    private java.util.List<Double> yPoints;
    private int counter;
    private static ViewSingleton instance;
    
    private ViewSingleton(){
        tabs = new java.util.ArrayList<>();
        xPoints = new java.util.ArrayList<>();
        yPoints = new java.util.ArrayList<>();
    }
    
    public static ViewSingleton getInstance(){
        if(instance == null){
            instance = new ViewSingleton();
        }
        return instance;
    }
   
    public void makeWritingCanvas(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        writingCanvas = new javafx.scene.canvas.Canvas();
        writingCanvas.widthProperty().bind(width);
        writingCanvas.heightProperty().bind(height);
        writingGC = writingCanvas.getGraphicsContext2D();
    }
    
    public void addHandlers(EventHandler<MouseEvent> e){
        writingCanvas.setOnMousePressed(e);
        writingCanvas.setOnMouseDragged(e);
        writingCanvas.setOnMouseReleased(e);
    }
    
    // Must return a page so that it can be added to the TabPane
    public Page addTab(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height, TestController tc){
        tabs.add(new Page(width, height, tc));
        currentIndex = tabs.size()-1;
        return tabs.get(currentIndex);
    }
    
    public void addPageHandlers(EventHandler<Event> e){
        tabs.get(currentIndex).addPageHandlers(e);
    }
    
    public void carriageReturn(){
        tabs.get(currentIndex).carriageReturn();
    }
    
    public void setLineWidth(double d){
        writingGC.setLineWidth(d);
    }
    
    public void setStrokeColor(Color c){
        writingGC.setStroke(c);
    }
    
    public void setCurrentIndex(int i){
        currentIndex = i;
    }
    
    public void drawWord(Word w){
        tabs.get(currentIndex).drawWord(w);
    }
    
    public void eraseWord(Word w){
        tabs.get(currentIndex).eraseWord(w);
    }
    
    public void highlightWord(Word w){
        tabs.get(currentIndex).highlightWord(w);
    }
    public Image getSnapshot(int x, int y, int width, int height){
        SnapshotParameters sp = new SnapshotParameters();
        sp.setViewport(new javafx.geometry.Rectangle2D(x, y, width, height));
        return writingCanvas.snapshot(sp, null);
    }
    
    public void startLine(double x, double y){
        xPoints.add(x);
        yPoints.add(y);
        counter = 0;
        writingGC.beginPath();
        writingGC.moveTo(x, y);
    }
    
    public void updateLine(double x, double y){
        xPoints.add(x);
        yPoints.add(y);
        if(xPoints.size() > 2){
            writingGC.bezierCurveTo(xPoints.get(counter), yPoints.get(counter), 
                                    xPoints.get(counter+1), yPoints.get(counter+1), 
                                    xPoints.get(counter+2), yPoints.get(counter+2));
            writingGC.stroke();
            ++counter;
        }
    }
    
    public void endLine(){
        xPoints.clear();
        yPoints.clear();
    }
    
    public javafx.scene.canvas.Canvas getWritingCanvas(){
        return writingCanvas;
    }
    
    public javafx.scene.canvas.Canvas getCurrentPageCanvas(){
        return tabs.get(currentIndex).getCanvas();
    }
    
    public javafx.scene.canvas.Canvas getCurrentPageMiniMap(){
        return tabs.get(currentIndex).getMiniMap();
    }
    
    public views.Page getCurrentPage(){
        return tabs.get(currentIndex);
    }
    
    public void clearWritingCanvas(){
        writingGC.clearRect(0, 0, writingCanvas.getWidth(), writingCanvas.getHeight());
    }
}
