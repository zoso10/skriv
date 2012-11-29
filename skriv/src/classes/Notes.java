package classes;

import java.util.ArrayList;

/**
 * @author Tyler Ewing modified by Jacob Shaffer 11/29/2012
 */
public class Notes {

    /*
     * Index of the reference Word for the View
     */
    int referenceIndex;

    /* 
     * Collection to hold all the Words
     */
    private ArrayList<Word> words; // Maybe LinkedList...

    /**
     * Default Constructor
     */
    public Notes() {
        words = new ArrayList();
    }

    /**
     * Adds the specified Word to the collection of Words
     *
     * @param w
     */
    public void addWord(Word w) {
        words.add(w);
    }

    /**
     * Inserts the provided Word at the specified index.
     *
     * @param w
     * @param index
     */
    public void insertWord(Word w, int index) {
        words.add(index, w);
    }

    /**
     * Removes the specified Word from the Collection of Words.
     *
     * @param w
     */
    public void removeWord(Word w) {
        words.remove(w);
    }

    /**
     * Removes the Word at the specified index and returns the word removed.
     *
     * @param index
     * @return
     */
    public Word removeWord(int index) {
        Word remove = words.get(index);
        words.remove(index);
        return remove;
    }

    /**
     * Removes the last Word added and returns the word removed.
     *
     * @return
     */
    public Word removeLastWord() {
        Word remove = words.remove(words.size() - 1);
        return remove;
    }
}
