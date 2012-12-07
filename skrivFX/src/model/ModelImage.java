/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tyler
 */
public class ModelImage {
    
    private static final int spaceFactor = 70;
    // Bounds of "current Word" that we'll end up using to take the snapshot
    private double left, right, top, bottom;
    private java.util.List<classes.WordImage> words;
    private int wordCount;
    
    public ModelImage(){
        words = new java.util.ArrayList<>();
        wordCount = 0;
    }
    
    public boolean addPoint(double x, double y){
        
        
    }
}
