package classes;

import java.util.ArrayList;
import java.util.List;


public class WordNoLoc{
    
    private List<SmartPoint> points;
    private javafx.geometry.Point2D offset;
    private double width, height;
    
    
    public WordNoLoc(SmartPoint p){
        points = new ArrayList<>();
        points.add(new SmartPoint(0,0,false));
        offset = p.getPoint();
        width = height = 0;
    }
    
    // For when the point is to the right and below the offset
    public void addPoint(SmartPoint p){
        double xTranslate = p.getX() - offset.getX();
        double yTranslate = p.getY() - offset.getY();
        width = width < xTranslate ? xTranslate : width;
        height = height < yTranslate ? yTranslate : height;
        SmartPoint pTranslated = new SmartPoint(xTranslate, yTranslate, p.isLast());
        points.add(pTranslated);
        
        //return new SmartPoint(xTranslate, yTranslate, p.isLast());
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public void draw(javafx.scene.canvas.GraphicsContext gc){
        
    }
}
