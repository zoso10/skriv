package classes.revised;

import classes.SmartPoint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class WordTranslated {
    
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
    public WordTranslated(){
        isHighlighted = false;
        hc = Color.YELLOW;
        c = Color.BLACK;
        boundingBox = new Rectangle();
        length = 1;
        height = 1;
        points = new ArrayList<SmartPoint>();
    }
  
    public WordTranslated(ArrayList<SmartPoint> pointsIncoming){
        this();
        //this.points = points; // <----- This is where the problem arises
        // DUH I don't set any of the length, height, or boundingBox constraints
        for(SmartPoint p : pointsIncoming){
            this.add(p);
        }
    }
    
//    public WordTranslated(SmartPoint p){
//        this();
//        this.add(p);
//    }
    
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
    
    public BufferedImage toImage(){
        // ARGB is what I want, but it gives weird behavior
        BufferedImage image = new BufferedImage(length, height, BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics g = image.getGraphics();
        g.setColor(java.awt.Color.BLACK);
        for (int i = 0; i < points.size() - 2; ++i) {
            if(points.get(i).isLast()) ++i;
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
        }
        
        return image;
    }
}