package classes;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.canvas.Canvas;


public class ViewTabbed {
    
    private java.util.List<Page> tabs;
    private Canvas writingCanvas;
    private int currentIndex;
    
    public ViewTabbed(){
        tabs = new java.util.ArrayList<>();
    }
    
    public void makeWritingCanvas(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        writingCanvas = new Canvas();
        writingCanvas.widthProperty().bind(width);
        writingCanvas.heightProperty().bind(height);
    }
    
    public void addTab(){
        
    }
}