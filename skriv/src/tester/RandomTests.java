/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;


import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author Tyler
 */
public class RandomTests {
    public static void main(String[] args){
        
        Point p = new Point(-1,-1);
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(-1,-1));
        
        // IMPORTANT: .equals() is different than ==ß
        System.out.println(points.get(0).x + ", " + points.get(0).y);
        System.out.println(p.equals(points.get(0)) ? "EQUAL" : "NOT EQUAL");
        System.out.println(p == points.get(0) ? "EQUAL" : "NOT EQUAL");
    }
}
