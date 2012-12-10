package classes;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Tab;


public class Page extends Tab{
    
    private Canvas canvas;
    private double left, right, top, bottom; // Bounds
    private double width, height;
    private java.util.List<classes.Word> words;
    private int wordCount; 
    private double curX, curY; // Cursor
    
    
}
