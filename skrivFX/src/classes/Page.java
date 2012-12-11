package classes;

import javafx.scene.control.Tab;


public class Page extends Tab{

    private java.util.List<classes.Word> words;
    private int wordCount; 
    private double curX, curY; // Cursor
    
    public Page(String title){
        super(title);
        curX = 20;
        curY = 20;
        wordCount = 0;
        words = new java.util.ArrayList<>();
    }
}