package classes.revised;

import classes.SmartPoint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Word {
    
    // Trying to keep this Word class independent
    
    private List<SmartPoint> points;
    private Color c;
    private Color hc; // Highlighted Color
    private boolean isHighlighted;
    private Rectangle boundingBox; // May not need this
    private int length;
    private int height;
    // I'm still trying to decide if I need this or even how to calculate it
    //private int row;
    // I don't think this will be needed since location isn't important
    //private int top, bottom, left, right;
    
    
    // I may can this default constructor
    public Word(){
        isHighlighted = false;
        hc = Color.YELLOW;
        c = Color.BLACK;
        boundingBox = new Rectangle();
        length = 0;
        height = 0;
        points = new ArrayList<SmartPoint>();
    }
    
    public Word(SmartPoint p){
        this();
        this.add(p);
    }
    
    public void add(SmartPoint p){
        points.add(p);
        boundingBox.add(p.getPoint());
        length = boundingBox.width;
        height = boundingBox.height;
    }
    
    public int getLength(){
        return length;
    }
    
    public int getHeight(){
        return height;
    }
    
    public boolean contains(SmartPoint p){
        return boundingBox.contains(p.getPoint());
    }
    
    public void setColor(Color c){
        this.c = c;
    }
    
    // Hmm...
    public void drawWord(Graphics g){
        
    }
}
