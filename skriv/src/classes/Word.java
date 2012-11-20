package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Word {

    /* This is the list of Points that actually are the Word
     * Need to be able to iterate through them for drawing the Word */
    private List<SmartPoint> points;
    /* The actual Color of the word */
    private Color c;
    /* Boolean flag to determine if the Word is highlighted */
    private Boolean isHighlighted;
    /* Color of the highlight on the Word
    This value can be filled even if the highglighting flag is false */
    private Color highlightedColor;
    /* Bounding box that surrounds the Word
     * Used for detecting selection, highlighting, and deleting
     * We cheat by actually filling the rectangle with white when we delete */
    private Rectangle boundingBox;

    // Possibly keeping track of the row will be much easier
    private int row;
    // For testing
    private boolean showBoundingBox = true;
    //private Point top, bottom;
    
    /*
     * I think we can get by with keeping track of left, right, top, bottom
     * Then constructing the bounding Rectangle from those ints
     */
    private int top, bottom, left, right;
    



    /*
     * Constructs a Word with the given initial Point
     */
    public Word(SmartPoint initialPoint) {
        isHighlighted = false;
        highlightedColor = Color.YELLOW;
        c = Color.BLACK;
        
        // Slowly transitioning to this hopefully
        top = initialPoint.y;
        bottom = initialPoint.y;
        left = initialPoint.x;
        right = initialPoint.x; 
        
        points = new ArrayList<SmartPoint>();
        this.add(initialPoint);
    }

    /*
     * Adds a poing to the List of Points
     */
    public void add(SmartPoint p) {      
        // Slowyly transitioning to this hopefully
        left = left > p.x ? p.x : left;
        right = right < p.x ? p.x : right;
        top = top > p.y ? p.y : top;
        bottom = bottom < p.y ? p.y : bottom;
        
        points.add(p);
        
        //For testing
        //top = top.y > p.y ? p : top;
        //bottom = bottom.y < p.y ? p : bottom;
    }

    /*
     *
     */
    public int right() {
        return right;
    }

    /*
     *
     */
    public int left() {
        return left;
    }

    /*
     * Draws the word with the specified Graphics object from the List of Points
     *
     */
    public void drawWord(Graphics g) {
        // Need an intelligent way to know when the pen was 'lifted'
        
        for (int i = 0; i < points.size() - 2; ++i) { 
           if(points.get(i).isLast()){
                System.out.println("Pen has been lifted");
                ++i;
            }
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
        }
    }

    /*
     * Set the Color of the Word
     */
    public void setColor(Color c) {
        this.c = c;
    }

    /*
     * Creates a bounding Rectangle around the word
     */
    public void createBoundingBox() {
    }
}
