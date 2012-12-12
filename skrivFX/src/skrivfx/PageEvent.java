/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skrivfx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Tyler
 */
public class PageEvent implements EventHandler<MouseEvent>{

    private views.ViewSingleton view;
    private models.ModelSingleton model;
    
    public PageEvent(){
        view = views.ViewSingleton.getInstance();
        model = models.ModelSingleton.getInstance();
    }
    
    @Override
    public void handle(MouseEvent e) {
        if(e.getEventType().equals(MouseEvent.MOUSE_PRESSED)){}
        else if(e.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){}
        else{}
    }
    
    public void mousePressedEvent(MouseEvent e){
        
    }
    
    public void mouseDraggedEvent(MouseEvent e){
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
}
