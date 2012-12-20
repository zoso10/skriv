package skrivfx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class PageEvent implements EventHandler<Event>{

    
    private views.ViewSingleton view;
    private models.ModelSingleton model;
    private TestController tc;
    private double beginX, beginY, endX, endY;
    public PageEvent(TestController tc){
        this.tc = tc;
        view = views.ViewSingleton.getInstance();
        model = models.ModelSingleton.getInstance();
    }
    
    @Override
    public void handle(Event e) {        
         if (e.getEventType() == MouseEvent.MOUSE_PRESSED){
             mousePressed((MouseEvent)e);
         }
         if (e.getEventType() == MouseEvent.MOUSE_RELEASED){
             mouseReleased((MouseEvent)e);
         } 
    }
    
    // We need clever ways of identifying what the user is doing
    public void mousePressed(MouseEvent e){
        if(e.isShiftDown()){
            beginX = e.getX();
            beginY = e.getY();
        }
    }

    private void mouseReleased(MouseEvent e) {
        if(e.isShiftDown()){
            endX = e.getX();
            endY = e.getY();
            
            java.util.List<classes.Word> words = model.getWords();
            for(classes.Word w : words){
                // Check x-coords
                if(endX < w.getX()+w.getWidth() && w.getX()> beginX && Math.abs(w.getY()-endY) < 25){
                    System.out.println("Word should be removed");
                    model.deleteWord(w);
                    view.eraseWord(w);
                    break;
                }
            }
            
        }
        else if (tc.getHighlightButton().isSelected()){
            endX = e.getX();
            endY = e.getY();
            
            java.util.List<classes.Word> words = model.getWords();
            for(classes.Word w : words){
                // Check x-coords
                if(endX < w.getX()+w.getWidth() && w.getX()> beginX && Math.abs(w.getY()-endY) < 25){
                    System.out.println("Word should be highlighted");
                    view.highlightWord(w);
                    break;
                }
            }
        }
    } 
}