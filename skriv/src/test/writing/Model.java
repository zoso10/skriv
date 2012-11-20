package test.writing;

import classes.*;
import java.awt.Point;
import java.util.ArrayList;

public class Model {

    // Super sketchy Model
    //private Notes notes;
    private Word liveWord = null;
    private ArrayList<Word> words;
    // This scale factor blows
    private static int spaceFactor = 50;

    public Model() {
        words = new ArrayList<Word>();
    }

    public void addPoint(Point p) {
        if (liveWord == null) {
            // Edited quickly so it'll compile without errors
            liveWord = new Word(new classes.SmartPoint(p, Boolean.FALSE));
        } else if (Math.abs(liveWord.right() - p.x) > spaceFactor) {
            Word temp = liveWord;
            words.add(temp);
            // Edited quickly so it'll compile without errors
            liveWord = new Word(new classes.SmartPoint(p, Boolean.FALSE));
        } else {
            liveWord.add(new classes.SmartPoint(p, Boolean.FALSE));
        }
    }

    public void addDraggedPoint(Point p) {
        // Edited quickly so it'll compile without errors
        liveWord.add(new classes.SmartPoint(p, Boolean.FALSE));
    }

    public void addWord(Word w) {
        words.add(w);
    }

    /*
     * later on this will actually calculate what will actually be visible
     * to the user in the View but for now it just returns all the words
     */
    public ArrayList<Word> getViewData() {
        ArrayList<Word> temp = new ArrayList<Word>();
        temp.add(liveWord);
        return temp;
    }
}
