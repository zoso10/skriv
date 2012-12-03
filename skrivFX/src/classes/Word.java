/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tyler
 */
public class Word {
    
    private List<SmartPoint> points;
    private double left, right;
    
    public Word(SmartPoint p){
        points = new ArrayList<>();
        left = right = p.getX();
        points.add(p);
    }
    
    public void add(SmartPoint p){
        left = left > p.getX() ? p.getX() : left;
        right = right < p.getX() ? p.getX() : right;
        points.add(p);
    }
    
    public double right(){
        return right;
    }
    
    public double left(){
        return left;
    }
}
