package model;

import classes.*;
import java.util.ArrayList;
import java.util.List;


public class ModelLegacy {
    
    private final static int spaceFactor = 100;
    private classes.Word liveWord; // May not need this, might be able to just keep bounds
    private List<classes.Word> words;
    private int wordCount; // Also used to access the last word
    private double left, right;
    
    
    public ModelLegacy(){
        words = new ArrayList<>();
        wordCount = 0;
        //liveWord = new classes.Word();
    }
    
    // Called for Mouse Pressed
    // Returns TRUE when it is a new Word
    public boolean addPoint(SmartPoint p){
        if(liveWord == null){
            System.out.println("Word was null");
            left = right = p.getX();
            liveWord = new Word(p);
            return false;
        } else if(liveWordContains(p)){
            // This is where the magic happens!!
            System.out.println("New Word");
            left = right = p.getX();
            Word temp = liveWord;
            words.add(temp);
            liveWord = new Word(p);
            ++wordCount;
            return true;
        } else{
            left = left > p.getX() ? p.getX() : left;
            right = right < p.getX() ? p.getX() : right;
            liveWord.addPoint(p);
            return false;
        }
    }
    
    // Called for Dragging
    public void addPointDirect(SmartPoint p){
        left = left > p.getX() ? p.getX() : left;
        right = right < p.getX() ? p.getX() : right;
        liveWord.addPoint(p);
    }
    
    public Word getLast(){
        System.out.println(wordCount + " words");
        return words.get(wordCount-1);
    }
    
    public void endWord(){
        System.out.println("Ended Word");
        // Do stuff to the words List
        liveWord = null;
        
//        Word temp = liveWord;
//        words.add(temp);
//        liveWord = null;        
    }
    
    // I think we'll use this for the Clear Thread as well
    public boolean liveWordContains(SmartPoint p){
        if(liveWord == null){ return false; }
        else{ return right + spaceFactor < p.getX() || left - spaceFactor > p.getX(); }
    }
}
