package view;

import classes.Word;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class View {
    
    private Canvas writingCanvas;
    private Canvas pageCanvas;
    private GraphicsContext writingGC;
    private GraphicsContext pageGC;
    private List<Word> words;
    private double cursorX;
    private double cursorY;
    
    
    public View(){
        words = new ArrayList<>();
        cursorX = 10;
        cursorY = 10;
    }
    
    public void makeWritingCanvas(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        writingCanvas = new Canvas();
        writingCanvas.widthProperty().bind(width);
        writingCanvas.heightProperty().bind(height);
        
        writingGC = writingCanvas.getGraphicsContext2D();
        writingGC.setFill(Color.BLACK);
        writingGC.setLineWidth(2);
    }
    
    public void makePageCanvas(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        pageCanvas = new Canvas();
        pageCanvas.widthProperty().bind(width);
        pageCanvas.heightProperty().bind(height);
        
        pageGC = pageCanvas.getGraphicsContext2D();       
        pageGC.setFill(Color.BLACK);
        pageGC.setLineWidth(1);
        //pageGC.fillRect(0, 0, 100, 100);
    }
    
    public void addHandlers(EventHandler<MouseEvent> e){
        writingCanvas.setOnMousePressed(e);
        writingCanvas.setOnMouseDragged(e);
        writingCanvas.setOnMouseReleased(e);
        //pageCanvas.setOnMouseDragged(e);
    }
    
    public GraphicsContext getWritingGraphics(){
        return writingGC;
    }
    
    public GraphicsContext getPageGraphics(){
        return pageGC;
    }
    
    public Canvas getWritingCanvas(){
        return writingCanvas;
    } 
    
    public Canvas getPageCanvas(){
        return pageCanvas;
    }  
    
    public void addWord(Word w){
        // I don't think I need this
        //words.add(w);
        // Check to make sure there is room first
        if(556-cursorX < w.getWidth()){
            cursorX = 10;
            cursorY = cursorY + w.getHeight() + 20;
        }     
        w.draw(pageGC, cursorX, cursorY);
        cursorX = cursorX + w.getWidth() + 20;
    }
   
    // This is all for drawing the Words in the Writing Box
    public void startLine(Point2D p){
        writingGC.beginPath();
        writingGC.moveTo(p.getX(), p.getY());
        writingGC.lineTo(p.getX()+.01, p.getY()+.01);
        writingGC.stroke();
    }
    
    public void updateLine(Point2D p){
        writingGC.lineTo(p.getX(), p.getY());
        writingGC.stroke();
    }
}
