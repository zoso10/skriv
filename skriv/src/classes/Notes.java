package classes;

import java.util.ArrayList;

public class Notes {

    /*
     * Index of the reference Word for the View
     */
    int referenceIndex;

    /* 
     * Collection to hold all the Words
     */
    private ArrayList<Word> words; // Maybe LinkedList...

    /*
     * Default Constructor takes zero arguments
     */
    public Notes() {
        words = new ArrayList<Word>();
    }

    // Adds the specified Word to the collection of Words
    public void addWord(Word w) {
        words.add(w);
    }

    // Removes the specified Word from the collection of Words
    public void removeWord(Word w) {
        words.remove(w);
    }
}
