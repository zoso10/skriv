package classes;

import javafx.scene.canvas.GraphicsContext;


public class ClearThread extends Thread{
    
    private static final int STATE_RUN = 0, STATE_STOP = 2, STATE_WAIT = 3;
    private static final int MAX_WAIT = 800;
    private int _state;
    private int counter;
    private GraphicsContext gc;
    
    
    public ClearThread(GraphicsContext gc){
        this.gc = gc;
        counter = 0;
        _state = STATE_WAIT;
    }
    
    @Override
    public void run(){
        while(_state != STATE_STOP && counter < MAX_WAIT){
            //System.out.println("In loop");
            ++counter;
            try{
                Thread.sleep(1);
            } catch(InterruptedException exc){ System.out.println("Sleep interrupted"); }
        }
        gc.clearRect(0, 0, 768, 247);
        this.end();
    }
    
    public void kill(){
        _state = STATE_STOP;
    }
    
    public void end(){
        _state = STATE_STOP;
        try{
            this.interrupt();
            //this.join();
        } catch(Exception exc){ System.out.println("EFFED UP STOPPING"); }
    }
    
    public boolean isFinished(){
        return _state == STATE_STOP;
    }
    
    public boolean isRunning(){
        return (_state == STATE_RUN);
    }
}
