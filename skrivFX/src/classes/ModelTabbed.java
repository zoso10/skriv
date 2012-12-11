package classes;


public class ModelTabbed {
    
    private static final int spaceFactor = 70;
    private double left, right, top, bottom;
    private double width, height;
    private java.util.List<classes.Notes> pages;
    private int currentIndex;
    
    public ModelTabbed(){
        pages = new java.util.ArrayList<>();
        currentIndex = -1;
        reset();
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