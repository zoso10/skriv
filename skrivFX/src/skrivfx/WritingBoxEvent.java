package skrivfx;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;


public class WritingBoxEvent implements EventHandler<MouseEvent>{

    private static final double howFar = .9; // Wow I suck with var names...
    private views.ViewSingleton view;
    private models.ModelSingleton model;
    private ToggleButton flag;
    private Label label;
    private classes.ClearThread t;
    private javafx.scene.image.Image image;
    private boolean hasReachedEnd = false;
    
    public WritingBoxEvent(ToggleButton flag, Label label){
        view = views.ViewSingleton.getInstance();
        model = models.ModelSingleton.getInstance();
        this.flag = flag;
        this.label = label;
        label.setText("Words: 0" );
        t = classes.ClearThread.getInstance();
        t.start();
    }
    
    public void commitWord(){
        if(image != null){
            label.setText("Words: " + (model.getWordCount()+1));
            classes.Word w = new classes.Word(image);
            model.addWord(w);
            view.drawWord(w);
            view.clearWritingCanvas();
            image = null;
        }
    }
    
    @Override
    public void handle(MouseEvent e) {
        if(model.getCurrentIndex() == -1 || !flag.isSelected()){ System.out.println("Cannot write!!"); }
        else if(e.getEventType().equals(MouseEvent.MOUSE_PRESSED)){ mousePressedEvent(e); }
        else if(e.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){ mouseDraggedEvent(e); }
        else{ mouseReleased(e); }
    }
    
    private void mousePressedEvent(MouseEvent e){
        view.startLine(e.getX(), e.getY());
        t.reset();
        if(isNewWord(e.getX(), e.getY()) && image != null){
            label.setText("Words: " + (model.getWordCount()+1));
            classes.Word w = new classes.Word(image);
            model.addWord(w);
            view.drawWord(w);
            System.out.println("New Word: " + model.getWordCount());
        }
    }
    
    private void mouseDraggedEvent(MouseEvent e){
        if(e.getX() > view.getWritingCanvas().widthProperty().doubleValue()*howFar){ hasReachedEnd = true; }
        model.addPoint(e.getX(), e.getY());
        view.updateLine(e.getX(), e.getY());
    }
    
    private void mouseReleased(MouseEvent e){
        image = view.getSnapshot(model.left(), model.top(), model.getWidth(), model.getHeight());
        view.endLine();
        if(hasReachedEnd){
            t.restart();
            hasReachedEnd = false;
        }
    }
    
    private boolean isNewWord(double x, double y){
        return (model.right() + model.getSpaceFactor() < x || model.left() - model.getSpaceFactor() > x);
    }
}
