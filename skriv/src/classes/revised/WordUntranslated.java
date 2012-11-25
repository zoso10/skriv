package classes.revised;

import classes.SmartPoint;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class WordUntranslated {
    
    private List<SmartPoint> points;
    // Probably won't need this garbage
    private Color c;
    private Boolean isHighlighted;
    private Color hc; // Highlighted Color
    private Rectangle boundingBox;
    private int top, bottom, left, right;
    
    public WordUntranslated(SmartPoint p){
        isHighlighted = false;
        hc = Color.YELLOW;
        c = Color.BLACK;
        top = p.y;
        bottom = p.y;
        left = p.x;
        right = p.x;
        boundingBox = new Rectangle(p.getPoint());
        
        points = new ArrayList<SmartPoint>();
        this.add(p);
    }
    
    public void add(SmartPoint p){
        left = left > p.x ? p.x : left;
        right = right < p.x ? p.x : right;
        top = top > p.y ? p.y : top;
        bottom = bottom < p.y ? p.y : bottom;
        createBoundingBox();
        
        points.add(p);
    }
    
    public WordTranslated translate(){
        ArrayList<SmartPoint> temp = new ArrayList<SmartPoint>();
        for(SmartPoint p : points){
            // left and top are the "offset"
            temp.add(new SmartPoint(p.x-left, p.y-top, p.isLast()));
        }
        return new WordTranslated(temp);
    }
    
    public int right(){
        return right;
    }
    
    public int left(){
        return left;
    }
    
    private void createBoundingBox(){
        boundingBox = new Rectangle(left, top, right-left, bottom-top);
    }
    
    public boolean contains(SmartPoint p){
        return boundingBox.contains(p.getPoint());
    }
}
