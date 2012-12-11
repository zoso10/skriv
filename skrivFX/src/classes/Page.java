package classes;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;


public class Page extends Tab{
    
    private Canvas canvas;
    private GraphicsContext gc;
    private double curX, curY; // Cursor
    // Maybe...
    // A Page can only have one set of Notes
    //private Notes notes;
    
    public Page(){
        curX = 20;
        curY = 20;
    }
    
    public void makeCanvas(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        canvas = new Canvas();
        canvas.widthProperty().bind(width);
        canvas.heightProperty().bind(height);
        
        gc = canvas.getGraphicsContext2D();
    }
}
