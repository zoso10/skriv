package models;

public class Notes{

    private java.util.List<classes.Word> words;
    private int wordCount; 
    
    public Notes(){
        wordCount = 0;
        words = new java.util.ArrayList<>();
    }
    
    public java.util.List<classes.Word> getWords(){
        return words;
    }
    
    public void addWord(classes.Word w){
        ++wordCount;
        words.add(w);
    }
    
    public int getWordCount(){
        return wordCount;
    }
}