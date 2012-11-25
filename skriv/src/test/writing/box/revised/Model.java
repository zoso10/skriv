package test.writing.box.revised;

import classes.revised.WordTranslated;
import classes.revised.WordUntranslated;
import classes.SmartPoint;
import java.util.List;
import java.util.ArrayList; 


public class Model {
    
    // Model class using the revised Word class
    private WordUntranslated liveWord = null;
    private List<WordTranslated> words;
    private final static int spaceFactor = 100;

    
    public Model(){
        words = new ArrayList<WordTranslated>();
    }
    
    public void addPoint(SmartPoint p){
        if(liveWord == null){
            liveWord = new WordUntranslated(p);
            System.out.println("liveWord was null");
        } else if(Math.abs(liveWord.right() - p.x) > spaceFactor && !liveWord.contains(p)){
            WordTranslated temp = liveWord.translate();
            words.add(temp);
            liveWord = new WordUntranslated(p);
            System.out.println("New Word");
        } else{
            liveWord.add(p);
        }
    }
    
    public void addPointDirect(SmartPoint p){
        liveWord.add(p);
    }
    
    public void addWord(WordTranslated w){
        words.add(w);
    }
    
    public ArrayList<WordTranslated> getViewData(){
        return new ArrayList<WordTranslated>();
    }
}