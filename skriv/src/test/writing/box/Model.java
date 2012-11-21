package test.writing.box;

import classes.Word;
import classes.SmartPoint;
import java.util.ArrayList;


public class Model {
    
    // Sketchy Model
    // I'll add to it as I need to
    
    // Keep track of the current Word that gets fed points
    private Word liveWord = null;
    // Probably just use an ArrayList to hold all the Words
    private ArrayList<Word> words;
    // Scale Factor is super important
    private final static int spaceFactor = 100;
    
    public Model(){
        words = new ArrayList<Word>();
    }
    
    public void addPoint(SmartPoint p){
        if(liveWord == null){
            liveWord = new Word(p);
            System.out.println("new Word");
        } else if(Math.abs(liveWord.right() - p.x) > spaceFactor && !liveWord.contains(p)){
            Word temp = liveWord;
            words.add(temp);
            liveWord = new Word(p);
            System.out.println("new Word");
        } else{
            liveWord.add(p);
        }
    }
    
    public void addPointDirect(SmartPoint p){
        liveWord.add(p);
    }
    
    public void addWord(Word w){
        words.add(w);
    }
    
    // THIS IS INCORRECT
    public ArrayList<Word> getViewData(){
        ArrayList<Word> temp = new ArrayList<Word>();
        temp.add(liveWord);
        return temp;
    }
}