package classes;

import java.util.ArrayList;


public class Notes {
    
    /* 
     * Collection to hold all the Words
     */
    private ArrayList<Word> words; // Maybe LinkedList...
    /*
     * Index of the reference Word for the View
     */
    int referenceIndex;
    
    /*
     * Default Constructor takes zero arguments
     */
    public Notes(){
        words = new ArrayList<Word>();
    }
    
    /*
     * Adds the specified Word to the collection of Words
     */
    public void addWord(Word w){
        words.add(w);
    }
    
    
}
