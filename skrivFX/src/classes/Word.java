package classes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;


public class Word {
    
    private List<SmartPoint> points;
    private double offsetX;
    private double offsetY;
    private double width, height;
    // Time to transition to BufferedImages and JavaFX Images
    private BufferedImage bi;
    private Image image;
    
    
    public Word(SmartPoint p){
        points = new ArrayList<>();
        points.add(new SmartPoint(0,0,false));
        offsetX = p.getX();
        offsetY = p.getY();
        width = height = 0;
        bi = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
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
        
        // Draw on BufferedImage
        
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public void draw(javafx.scene.canvas.GraphicsContext gc, double cursorX, double cursorY){
        System.out.println("Drawing Word: " + points.get(0).getX() + ", " + points.get(0).getY());
        // Convert BufferedImage to Image and return it or draw it
        
        gc.moveTo(points.get(0).getX()+cursorX, points.get(0).getY()+cursorY);
        for(int i = 1; i < points.size()-1; ++i){
            if(points.get(i).isLast()){
                ++i;
                gc.moveTo(points.get(i).getX()+cursorX, points.get(i).getY()+cursorY);
            }else{
                gc.lineTo(points.get(i).getX()+cursorX, points.get(i).getY()+cursorY);
                gc.stroke();
            }
        }
        System.out.println("Number of points: " + points.size());
    }
    
    private void translateX(double newX){
        double oldOffset = offsetX;
        offsetX = newX;
        double difference = oldOffset - offsetX;
        for(SmartPoint p : points){
            p.translateX(difference);
        }
    }
    
    private void translateY(double newY){
        double oldOffset = offsetY;
        offsetY = newY;
        double difference = oldOffset - offsetY;
        for(SmartPoint p : points){
            p.translateY(difference);
        }
    }
}
