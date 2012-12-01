/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skrivfx;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.PGNode;
import java.awt.Rectangle;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.ImageView;

/**
 *
 * @author davidecker
 */
public class MiniMap extends Control{
    
    DoubleProperty min;
    DoubleProperty max;
    ImageView track;
    Rectangle thumb = new Rectangle();
    
    MiniMap(){
        
    }
    
    public void updateTrack(){
        
    }
    
}
