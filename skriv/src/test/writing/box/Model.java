package test.writing.box;

import classes.Word;
import java.awt.Point;
import java.util.ArrayList;


public class Model {
    
    // Sketchy Model
    // I'll add to it as I need to
    
    private Word liveWord = null;
    private ArrayList<Word> words;
    // Scale Factor is super important
    private final static int spaceFactor = 50;
    
    public Model(){
        words = new ArrayList<Word>();
    }
    
    public void addPoint(Point p){
        if(liveWord == null){
             liveWord = new Word(p);
        } else if(Math.abs(liveWord.right() - p.x) > spaceFactor){
            Word temp = liveWord;
            words.add(temp);
            liveWord = new Word(p);
            System.out.println("NEW WORD SON!!");
        } else{
            liveWord.add(p);
        }
    }
    
    public void addDraggedPoint(Point p){
        liveWord.add(p);
    }
    
    public void addWord(Word w){
        words.add(w);
    }
    
    // This will need tweaked
    public ArrayList<Word> getViewData(){
        ArrayList<Word> temp = new ArrayList<Word>();
        temp.add(liveWord);
        return temp;
    }
}
