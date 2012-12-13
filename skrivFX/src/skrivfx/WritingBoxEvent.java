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
public class WritingBoxEvent implements EventHandler<MouseEvent>{

    @Override
    public void handle(MouseEvent e) {
         if(e.getEventType().equals(MouseEvent.MOUSE_PRESSED)){ }
         else if(e.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){ }
         else{ }
    }
    
    // We need clever ways of identifying what the user is doing
    
}
