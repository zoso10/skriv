package classes;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Word {
    
    private Image image; // This image holds the Word essentially
    private double x, y, width;
    private Color c;
    // etc...
    
    public Word(Image image){
        this.image = image;
        width = image.getWidth();
    }
    
    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Image getImage(){
        return image;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return image.getHeight(); 
    }
    
    public double getX(){ return x; }
    
    public double getY(){ return y; }

    public void setWidth(double d) {
        width = d;
    }
}
