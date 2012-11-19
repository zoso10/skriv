package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Word {

    /* Keep track of the leftmost and rightmost points
     * This is used to calculate distance so it can start a new Word */
    private Point rightMost, leftMost;
    /* This is the list of Points that actually are the Word
     * Need to be able to iterate through them for drawing the Word */
    private List<Point> points;
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
    // STILL NEEDS WORK
    // Keeping track of location may end up being a crutch and causing a lot of recalculations
    private Point location;
    // Possibly keeping track of the row will be much easier
    private int row;
    // For testing
    private boolean showBoundingBox = true;
    private Point top, bottom;


    /*
     * I actually hate that you have to pass a location of the Word into the Constructor
     */
    public Word(Point initialPoint) {
        this(new Point(0, 0), initialPoint);
    }

    /*
     * Constructs a word at the given location on the Document and adds an initial point in the List of Points
     */
    // I might get rid of the initial point garbage
    public Word(Point location, Point initialPoint) {
        this.location = location;
        isHighlighted = false;
        highlightedColor = Color.YELLOW;
        c = Color.BLACK;
        rightMost = initialPoint;
        leftMost = initialPoint;
        
        //For testing
        top = initialPoint;
        bottom = initialPoint;
        
        points = new ArrayList<Point>();
        this.add(initialPoint);
    }

    /*
     * Constructs a word at the given (x,y) coordinate on the Document and adds an initial point in the List of Points
     */
    public Word(int x, int y, Point initialPoint) {
        this(new Point(x, y), initialPoint);
    }

    /*
     * Adds a poing to the List of Points
     */
    public void add(Point p) {
        leftMost = leftMost.x > p.x ? p : leftMost;
        rightMost = rightMost.x < p.x ? p : rightMost;
        points.add(p);
        
        //For testing
        top = top.y > p.y ? p : top;
        bottom = bottom.y < p.y ? p : bottom;
    }

    /*
     *
     */
    public int right() {
        return rightMost.x;
    }

    /*
     *
     */
    public int left() {
        return leftMost.x;
    }

    /*
     * Sets the location of the word to the specified new location
     */
    private void setLocation(Point location) {
        this.location = location;
    }

    /*
     * Returns the location of the Word on the Document
     */
    private Point getLocation() {
        return this.location;
    }

    /*
     * Draws the word with the specified Graphics object from the List of Points
     *
     */
    public void drawWord(Graphics g) {
        // Need an intelligent way to know when the 'pen' was lifted
        // Let's try when it gets the Point (-1,-1) we know the pen was lifted
        Point mask = new Point(-1, -1);
        for (int i = 0; i < points.size() - 2; ++i) { 
           if(points.get(i).equals(mask)){
                System.out.println("Pen has been lifted");
                ++i;
            }
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
        }
        // Draw the bounding box
        g.drawRect(leftMost.x, top.y, rightMost.x-leftMost.x, bottom.y-top.y);
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
