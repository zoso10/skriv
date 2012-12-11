package classes;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.canvas.Canvas;


public class ViewTabbed {
    
    private java.util.List<Canvas> pages;
    private Canvas writingCanvas;
    private Canvas currentPage;
    private int currentIndex;
    
    public ViewTabbed(){
        pages = new java.util.ArrayList<>();
    }
    
    
}