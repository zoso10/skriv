package classes;

import javafx.scene.canvas.GraphicsContext;


public class ClearThread extends Thread{
    
    private static final int STATE_RUN = 0, STATE_STOP = 2, STATE_WAIT = 3, STATE_RESET = 4;
    private static final int MAX_WAIT = 800;
    private int _state;
    private int counter;
    private GraphicsContext gc;
    
    
    public ClearThread(GraphicsContext gc){
        this.gc = gc;
        counter = 0;
        _state = STATE_RESET;
    }
  
    @Override
    public void run(){
        try{
            Thread.sleep(MAX_WAIT);
        } catch(Exception e){ System.out.println("Sleep disturbed"); }
        gc.clearRect(0,0,768,247);
        end();
    }
    
    private void end(){
        try{
            this.join();
        } catch(Exception e){ System.out.println("Thread killed"); }
    }
    
//    @Override
//    public void run(){
//        // We want this Thread to run as long as the program does
//        while(true){
//            while(counter < 500){
//                if(_state == STATE_RESET){
//                    // Reset Thread
//                    reset();
//                }
//                try{
//                    Thread.sleep(1);
//                } catch(Exception e){ System.out.println("Sleep disturbed"); }
//                
//            }
//            // Clear Canvas here!!!
//            gc.clearRect(0, 0, 768, 247);
//            // Thread resets itself and waits
//            reset();
//        }
//    }
//    
//    public void reset(){
//        counter = 0;
//        _state = STATE_RESET;
//        synchronized(this){
//            try{
//                this.wait();
//            } catch(Exception e){ System.out.println("Waiting interrupted"); }
//        }
//    }
//    
//    public void restart(){
//        _state = STATE_RUN;
//        synchronized(this){
//            this.notify();
//        }
//    }
//    
//    public boolean isRunning(){
//        return _state == STATE_RUN;
//    }
}
