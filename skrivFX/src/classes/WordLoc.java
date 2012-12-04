package classes;

import java.util.ArrayList;
import java.util.List;


public class WordLoc{
    
    private List<SmartPoint> points;
    private double left, right; // left and right bounds
    
    public WordLoc(SmartPoint p){
        left = right = p.getX();
        points = new ArrayList<>();
        points.add(p);
    }
    
    public void addPoint(SmartPoint p){
        left = left > p.getX() ? p.getX() : left;
        right = right < p.getX() ? p.getX() : right;
        points.add(p);
    }
    
    public double left(){
        return left;
    }
    
    public double right(){
        return right;
    }
}