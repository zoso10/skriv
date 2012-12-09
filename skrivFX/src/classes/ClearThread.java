package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import skrivfx.TestController;


public class ClearThread extends Thread{
    
    private static final int STATE_RUN = 2, STATE_PAUSE = 3, STATE_STOP = 5;
    private static final int MAX_WAIT = 300;
    private int _state;
    private int counter;
    private model.ModelImage model;
    private view.ViewImage view;
    
    
    // This needs cleaned up
    public ClearThread(model.ModelImage model, view.ViewImage view){
        this.model = model;
        this.view = view;
        counter = 0;
        _state = STATE_PAUSE;
    }
  
    @Override
    public void run(){
        while(_state != STATE_STOP){
            while(counter < MAX_WAIT){
                if(_state == STATE_PAUSE){
                    synchronized(this){
                        try{ this.wait();}
                        catch(Exception e){ System.out.println("Wait Failed"); }
                    }
                }
                if(_state == STATE_STOP){ break; }
                
                try{ Thread.sleep(1); } 
                catch(Exception e){ System.out.println("Sleep disrupted"); }
                ++counter;
            }
            if(_state == STATE_STOP){ break; }
            System.out.println("Clearing Writing Box");
//            javafx.scene.image.Image image = view.getSnapshot(model.left(), model.top(), model.getWidth(), model.getHeight());
//            WordImage w = new WordImage(image);
//            model.addWord(w);
//            view.drawWord(w);
            view.getWritingCanvas().getGraphicsContext2D().clearRect(0, 0, 768, 247);
            reset();
        }
    }
    
    public void reset(){
        counter = 0;
        _state = STATE_PAUSE;
    }
    
    public void restart(){
        counter = 0;
        _state = STATE_RUN;
        synchronized(this){ this.notify(); }
    }
    
    public void kill(){
        _state = STATE_STOP;
        synchronized(this){ this.notify(); }
    }
}
