package models;

public class Notes{

    private java.util.List<classes.Word> words;
    private java.util.Stack<classes.Word> undoStack;
    private int wordCount; 
    
    public Notes(){
        wordCount = 0;
        words = new java.util.ArrayList<>();
        undoStack = new java.util.Stack<>();
    }
    
    public java.util.List<classes.Word> getWords(){
        return words;
    }
    
    public void addWord(classes.Word w){
        ++wordCount;
        words.add(w);
    }
    
    public void deleteWord(classes.Word w){
        undoStack.push(w);
        words.remove(w);
    }
    
    public void deleteWordAtIndex(int index){
        undoStack.push(words.get(index));
        words.remove(index);
    }
    
    public int getWordCount(){
        return wordCount;
    }
}