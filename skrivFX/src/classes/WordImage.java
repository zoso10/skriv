package classes;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;


public class WordImage {
    
    private Image image; // This image holds the Word essentially
    private int width, height;
    private Color c;
    // etc...
    
    public WordImage(WritableImage image){
        this.image = image;
    }
    
    public Image getImage(){
        return image;
    }
}
