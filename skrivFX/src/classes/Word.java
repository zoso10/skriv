package classes;

import java.util.ArrayList;
import java.util.List;


public class Word {
    
    private List<SmartPoint> points;
    private double offsetX;
    private double offsetY;
    private double width, height;
    
    
    public Word(SmartPoint p){
        points = new ArrayList<>();
        points.add(new SmartPoint(0,0,false));
        offsetX = p.getX();
        offsetY = p.getY();
        width = height = 0;
    }
    
    // For when the point is to the right and below the offset
    public void addPoint(SmartPoint p){
        if(p.getX() < offsetX){ translateX(p.getX()); }
        if(p.getY() < offsetY){ translateY(p.getY()); }
        // Check if we need to translate because we have a new offset
        double xTranslated = p.getX() - offsetX;
        double yTranslated = p.getY() - offsetY;
        width = width < xTranslated ? xTranslated : width;
        height = height < yTranslated ? yTranslated : height;
        SmartPoint pTranslated = new SmartPoint(xTranslated, yTranslated, p.isLast());
        points.add(pTranslated);
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public void draw(javafx.scene.canvas.GraphicsContext gc, double cursorX, double cursorY){
        System.out.println("Drawing Word: " + points.get(0).getX() + ", " + points.get(0).getY());
        gc.moveTo(points.get(0).getX()+cursorX, points.get(0).getY()+cursorY);
        for(int i = 1; i < points.size()-1; ++i){
            //System.out.println("Points in here");
            if(points.get(i).isLast()){
                ++i;
                gc.moveTo(points.get(i).getX()+cursorX, points.get(i).getY()+cursorY);
            }else{
                gc.lineTo(points.get(i).getX()+cursorX, points.get(i).getY()+cursorY);
                gc.stroke();
            }
        }
    }
    
    private void translateX(double newX){
        offsetX = offsetX - newX;
        for(SmartPoint p : points){
            p.translateX(offsetX);
        }
    }
    
    private void translateY(double newY){
        offsetY = offsetX - newY;
        for(SmartPoint p : points){
            p.translateY(offsetY);
        }
    }
}
