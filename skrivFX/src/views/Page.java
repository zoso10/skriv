package views;

import classes.Word;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import skrivfx.TestController;

public class Page extends Tab {

    private static double scale = .65;
    private final double mmScale = .1727;
    private Canvas mmCanvas;
    private GraphicsContext mmGC;
    private Canvas canvas;
    private GraphicsContext gc;
    private double curX, curY; // Cursor
    private boolean isFirst = true;
    private TestController tc;
    // Maybe...
    // A Page can only have one set of Notes
    //private Notes notes;

    public Page(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height, TestController tc) {
        this(width, height, "Untitled", tc);
    }

    public Page(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height, String title, TestController tc) {
        super();
        this.setText(title);
        makeCanvas(width, height);
        this.setContent(canvas);
        curX = 20;
        curY = 10;
        this.tc = tc;
    }

    private void makeCanvas(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height) {
        canvas = new Canvas();
//        canvas.widthProperty().bind(width);
//        canvas.heightProperty().bind(height);
        canvas.setWidth(width.doubleValue());
        canvas.setHeight(height.doubleValue());
        
        // 106 X 717
        mmCanvas = new Canvas();
        mmCanvas.setWidth(106);
        mmCanvas.setHeight(717);
        

        gc = canvas.getGraphicsContext2D();
        mmGC = mmCanvas.getGraphicsContext2D();
    }
    
    public void addPageHandlers(EventHandler<Event> e){
        canvas.setOnMouseClicked(e);
        canvas.setOnMouseDragged(e);
        canvas.setOnMouseReleased(e);
        canvas.setOnKeyPressed(e);
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public Canvas getMiniMap(){
        return mmCanvas;
    }

    public void drawWord(Word w) {
        if (canvas.getWidth() - curX < w.getWidth()) {
            curX = 20;
            curY = curY + 50;
            tc.moveViewportDown();
        }
        // Change stuff around, maybe keep it within bounds?
        if(isFirst && w.getHeight() > 1 || scale*w.getHeight() > 40){ 
            scale = 40/w.getHeight(); 
            isFirst = false;
            gc.drawImage(w.getImage(), curX, curY, scale * w.getWidth(), 40);
            mmGC.drawImage(w.getImage(), mmScale*curX, mmScale*curY, mmScale*w.getWidth(), mmScale*40);
        }
        else{
            gc.drawImage(w.getImage(), curX, curY, scale * w.getWidth(), scale * w.getHeight());
            mmGC.drawImage(w.getImage(), mmScale*curX, mmScale*curY, mmScale*w.getWidth(), mmScale*w.getHeight());
        }
        curX = curX + 40 + scale * w.getWidth();
    }
    
    public void carriageReturn(){
        curX = 20;
        curY = curY + 50;
    }
    
    
}