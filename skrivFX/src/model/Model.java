package model;

import classes.*;
import java.util.ArrayList;
import java.util.List;


public class Model {
    
    private classes.Word liveWord;
    private List<classes.Word> words;
    private final static int spaceFactor = 100;
    
    
    public Model(){
        words = new ArrayList<>();
    }
    
    // Called for Mouse Pressed
    public void addPoint(SmartPoint p){
        if(liveWord == null){
            liveWord = new Word(p);
            System.out.println("Word was null");
        } else if(liveWordContains(p)){
            Word temp = liveWord;
            System.out.println("New Word");
            System.out.println(temp.left());
            words.add(temp);
            liveWord = new Word(p);
        } else{
            liveWord.add(p);
        }
    }
    
    // Called for Dragging
    public void addPointDirect(SmartPoint p){
        liveWord.add(p);
    }
    
    public void endWord(){
        Word temp = liveWord;
        words.add(temp);
        liveWord = null;
        System.out.println("Ended Word");
    }
    
    // I think we'll use this for the Clear Thread
    public boolean liveWordContains(SmartPoint p){
        if(liveWord == null){ return false; }
        else{ return liveWord.right() + spaceFactor < p.getX() || liveWord.left() - spaceFactor > p.getX(); }
    }
}
