package tester;

import javax.swing.SwingUtilities;

public class Tester {
    public static void launch(){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                classes.View v = new classes.View();
                v.setVisible(true);
            }
        });
    }
    
    public static void main(String[] args){
        launch();
    }
}