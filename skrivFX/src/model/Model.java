package model;

import classes.*;
import java.util.ArrayList;
import java.util.List;


public class Model {
    
    private final static int spaceFactor = 100;
    private classes.WordLoc liveWord; // May not need this, might be able to just keep bounds
    private List<classes.WordNoLoc> words;
    private int wordCount = 0; // Also used to access the last word
    private double left, right;
    
    
    public Model(){
        words = new ArrayList<>();
        liveWord = new classes.WordLoc();
    }
    
    // Called for Mouse Pressed
    public void addPoint(SmartPoint p){
        if(liveWord == null){
            System.out.println("Word was null");
            left = right = p.getX();
            
            
            //liveWord = new WordLoc(p);          
        } else if(liveWordContains(p)){
            System.out.println("New Word");
            left = right = p.getX();
            
            
            // Do stuff to the words List
            //liveWord = new WordLoc(p);
        } else{
            left = left > p.getX() ? p.getX() : left;
            right = right < p.getX() ? p.getX() : right;
            
            
            //liveWord.addPoint(p);
        }
    }
    
    // Called for Dragging
    public void addPointDirect(SmartPoint p){
        left = left > p.getX() ? p.getX() : left;
        right = right < p.getX() ? p.getX() : right;
        
        //liveWord.addPoint(p);
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
