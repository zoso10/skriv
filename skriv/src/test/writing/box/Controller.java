/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.writing.box;

import javax.swing.SwingUtilities;
import classes.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Tyler_Ewing
 */
public class Controller implements ActionListener, MouseListener, MouseMotionListener{
    
    private Model model;
    private View view;
    
    public Controller(){
        model = new Model();
        view = new View();
        view.setVisible(true);
    }
    
    // IMplementation for Button Listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(String.format("%s button pressed!!", e.getActionCommand()));
    }
    
    // Implementation for Mouse Listeners
    @Override
    public void mouseClicked(MouseEvent e) {
        // Probably won't have functionality
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Add Point and see if it's a new Word
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Add Point to denote the pen has been lifted
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Probably won't have functionality
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Probably won't have functionality
    }

    // Implementation for Mouse Motion Listener
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    private void addButtonListeners(){
        view.addButtonListeners(this);
    }
    
    
    // Launch the application
    public static void launch(){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                Controller c = new Controller();
                c.addButtonListeners();
            }
        });
    }
    
    // MAIN
    public static void main(String[] args){
        launch();
    }
}
