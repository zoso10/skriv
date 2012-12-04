package model;

import classes.*;
import java.util.ArrayList;
import java.util.List;


public class Model {
    
    private final static int spaceFactor = 100;
    private classes.WordLoc liveWord; // May not need this, might be able to just keep bounds
    private List<classes.WordNoLoc> words;
    private int wordCount = 0; // Also used to access the last word
    
    
    public Model(){
        words = new ArrayList<>();
    }
    
    // Called for Mouse Pressed
    public void addPoint(SmartPoint p){
        if(liveWord == null){
            System.out.println("Word was null");
            liveWord = new WordLoc(p);
            
//            liveWord = new Word(p);            
        } else if(liveWordContains(p)){
            System.out.println("New Word");
            // Do stuff to the words List
            liveWord = new WordLoc(p);
            
//            Word temp = liveWord;          
//            words.add(temp);
//            liveWord = new Word(p);
        } else{
            liveWord.addPoint(p);
//            liveWord.add(p);
        }
    }
    
    // Called for Dragging
    public void addPointDirect(SmartPoint p){
        liveWord.addPoint(p);
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
        else{ return liveWord.right() + spaceFactor < p.getX() || liveWord.left() - spaceFactor > p.getX(); }
    }
}
