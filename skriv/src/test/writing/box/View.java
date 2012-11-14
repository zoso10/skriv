package test.writing.box;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class View extends JFrame{
    
    public View(){
        super();
        init();
    }
    
    private void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
    }
}
