/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skrivfx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Path;

/**
 *
 * @author Tyler
 */
public class PageEvent implements EventHandler<Event>{

    
    private views.ViewSingleton view;
    private models.ModelSingleton model;
    private TestController tc;
    private Path path;
    
    public PageEvent(TestController t){
        tc = t;
        view = views.ViewSingleton.getInstance();
        model = models.ModelSingleton.getInstance();
        
    }
    
    @Override
    public void handle(Event e) {
         
         if (e.getEventType() == MouseEvent.MOUSE_PRESSED){
             mousePressed((MouseEvent)e);
         }
         if (e.getEventType() == MouseEvent.MOUSE_DRAGGED){
             mouseDragged((MouseEvent)e);
         }
         if (e.getEventType() == MouseEvent.MOUSE_RELEASED){
             mouseReleased((MouseEvent)e);
         }
         
    }
    
    public void mousePressed(MouseEvent e){
        if(e.isShiftDown()){
            view.getCurrentPageCanvas().getGraphicsContext2D().beginPath();
            view.getCurrentPageCanvas().getGraphicsContext2D().moveTo(e.getX(), e.getY());
            System.out.println("mouse pressed");
        }
        System.out.println("inside mouse pressed");
    }
    
    // We need clever ways of identifying what the user is doing

    private void mouseDragged(MouseEvent e) {
        if(e.isShiftDown()){
            view.getCurrentPageCanvas().getGraphicsContext2D().lineTo(e.getX(), e.getY());
            view.getCurrentPageCanvas().getGraphicsContext2D().stroke();
            System.out.println("mouse dragged");
            System.out.println((e.getX()) + ", " + e.getY());            
            
        }
        System.out.println("inside mouse dragged");
    }

    private void mouseReleased(MouseEvent e) {
        System.out.println("inside mouse released");
        
    }
    
}
