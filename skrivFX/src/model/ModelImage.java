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
    private double width, height;
    private java.util.List<classes.WordImage> words;
    private int wordCount;
    
    public ModelImage(){
        words = new java.util.ArrayList<>();
        wordCount = 0;
        // Force a new Word initially
        right = 0;
        left = 1000;
        top = 1000;
        bottom = 0;
        width = height = 0;
    }
    
    // Returns TRUE when the Point is forming a new Word
    public boolean isNewWord(double x, double y){
        if(right + spaceFactor < x || left - spaceFactor > x){
            System.out.println("New Word");
            ++wordCount;
            return true;
        }
        else{
            System.out.println("Still in Word");
            checkBounds(x, y);
            return false;
        }
    }
    
    public void addPoint(double x, double y){
        checkBounds(x, y);
    }
    
    public int left(){
        return (int)left;
    }
    
    public int top(){
        return (int)top;
    }
    
    public int getWidth(){
        return (int)width;
    }
    
    public int getHeight(){
        return (int)height;
    }
    
    private void checkBounds(double x, double y){
        left = left > x ? x : left;
        right = right < x ? x : right;
        top = top > y ? y : top;
        bottom = bottom < y ? y : bottom;
        width = right - left;
        height = bottom - top;
    }
}