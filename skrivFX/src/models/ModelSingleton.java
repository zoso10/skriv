package models;


public class ModelSingleton {
    
    private static final int spaceFactor = 70;
    private double left, right, top, bottom;
    private double width, height;
    private java.util.List<models.Notes> pages;
    private int currentIndex; // current Notes page
    private static ModelSingleton instance;
    
    private ModelSingleton(){
        pages = new java.util.ArrayList<>();
        currentIndex = -1;
        reset();
    }
    
    public static ModelSingleton getInstance(){
        if(instance == null){
            instance = new ModelSingleton();
        }
        return instance;
    }
    
    public void addPage(){
        pages.add(new models.Notes());
        currentIndex = pages.size()-1;
    }
    
    public void setCurrentIndex(int i){
        currentIndex = i;
    }
    
    public int getCurrentIndex(){
        return currentIndex;
    }
    
    // For adding/deleting Words
    public void addWord(classes.Word w){
        pages.get(currentIndex).addWord(w);
        reset();
    }
    
    public void deleteWord(classes.Word w){
        pages.get(currentIndex).deleteWord(w);
    }
    
    public void deleteWordAtIndex(int index){
        pages.get(currentIndex).deleteWordAtIndex(index);
    }
    
    public java.util.List<classes.Word> getWords(){
        return pages.get(currentIndex).getWords();
    }
    
    // For adding points to Word
    public void addPoint(double x, double y){
        checkBounds(x, y);
    }
    
    public boolean isNewWord(double x, double y){
        if(right + spaceFactor < x || left - spaceFactor > x){
            System.out.println("New Word: " + pages.get(currentIndex).getWordCount());
            return true;
        }
        else{
            System.out.println("Still in Word");
            checkBounds(x,y);
            return false;
        }
    }
    
    public int getWordCount(){
        return pages.get(currentIndex).getWordCount();
    }
    
    // Getters for bounds
    public int left(){
        return (int)left;
    }
    
    public int right(){
        return (int)right;
    }
    
    public int top(){
        return (int)top;
    }
    
    public int getWidth(){
        return (int)width;
    }
    
    public int getHeight(){
        return (int)height;
    }
    
    public int getSpaceFactor(){
        return spaceFactor;
    }
    
    private void reset(){
        right = bottom = 0;
        left = top = 1000;
        width = height = 0;
    }
    
    private void checkBounds(double x, double y){
        left = left > x ? x : left;
        right = right < x ? x : right;
        top = top > y ? y : top;
        bottom = bottom < y ? y : bottom;
        width = right - left;
        height = bottom - top;
    }
}
