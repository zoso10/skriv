package models;


public class ModelSingleton {
    
    private static final int spaceFactor = 70;
    private double left, right, top, bottom;
    private double width, height;
    private java.util.List<models.Notes> pages;
    private int currentIndex;
    private static ModelSingleton instance;
    private int wordCount = 0;
    
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
    
    public boolean isNewWord(double x, double y){
        if(right + spaceFactor < x || left - spaceFactor > x){
            wordCount++;
            System.out.println("New Word: " + wordCount);
            return true;
        }
        else{
            System.out.println("Still in Word");
            checkBounds(x,y);
            return false;
        }
    }
    
    public void addPoint(double x, double y){
        checkBounds(x, y);
    }
    
    public void addWord(classes.Word w){
        pages.get(currentIndex).addWord(w);
        reset();
    }
    
    public java.util.List<classes.Word> getWords(){
        return pages.get(currentIndex).getWords();
    }
    
    public int left(){
        return (int)left;
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
    
    private int getWordCount(){
        return this.wordCount;
    }
}
