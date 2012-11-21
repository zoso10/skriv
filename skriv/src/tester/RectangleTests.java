package tester;

import java.awt.Point;
import java.awt.Rectangle;


public class RectangleTests {
    
    public static void main(String[] args){
        Rectangle r = new Rectangle(0,0, 10, 10);
        r.add(new Point(20,20));
        
        System.out.println(r.x + " " + r.y);
        System.out.println(r.width + " " + r.height);
        System.out.println(r.contains(new Point(15,15)));
    }
}
