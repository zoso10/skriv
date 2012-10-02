package test.curve.smoothing;

import javax.swing.SwingUtilities;

/**
 *
 * @author Tyler_Ewing
 * I'll use this little guy to run all the tests
 * Everything is going to have a frame so I'll use SwingUtilites' invokeLater to run it in a separate thread
 */
public class Tester {
    
    private static void launch(){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                
            }
        });
    }
    
    public static void main(String[] args){
        launch();
    }
}
