package classes;

import javafx.scene.canvas.GraphicsContext;


public class ClearThread extends Thread{
    
    private static final int STATE_RUN = 2, STATE_PAUSE = 3, STATE_STOP = 5;
    private static final int MAX_WAIT = 300;
    private int _state;
    private int counter;
    private GraphicsContext gc;
    
    
    // This needs cleaned up
    public ClearThread(GraphicsContext gc){
        this.gc = gc;
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
            gc.clearRect(0, 0, 768, 247);
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
