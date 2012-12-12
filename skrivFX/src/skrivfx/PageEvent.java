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

    private static final double howFar = .9; // Wow I suck with var names...
    private views.ViewSingleton view;
    private models.ModelSingleton model;
    private classes.ClearThread t;
    private TestController tc;
    private boolean hasReachedEnd = false;
    
    public PageEvent(TestController tc){
        view = views.ViewSingleton.getInstance();
        model = models.ModelSingleton.getInstance();
        t = classes.ClearThread.getInstance();
        this.tc = tc;
    }
    
    @Override
    public void handle(MouseEvent e) {
        if(e.getEventType().equals(MouseEvent.MOUSE_PRESSED)){ mousePressedEvent(e); }
        else if(e.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){ mouseDraggedEvent(e); }
        else{ mouseReleased(e); }
    }
    
    public void mousePressedEvent(MouseEvent e){
        view.startLine(e.getX(), e.getY());
        t.reset();
        if(model.isNewWord(e.getX(), e.getY())){
//            classes.Word w = new classes.Word(image);
//            model.addWord(w);
//            view.drawWord(w);
        }
    }
    
    public void mouseDraggedEvent(MouseEvent e){
        if(e.getX() > view.getWritingCanvas().widthProperty().doubleValue()*howFar){ hasReachedEnd = true; }
        model.addPoint(e.getX(), e.getY());
        view.updateLine(e.getX(), e.getY());
    }
    
    public void mouseReleased(MouseEvent e){
        // image = stuff
        if(hasReachedEnd){
            t.reset();
            hasReachedEnd = false;
        }
    }
}
