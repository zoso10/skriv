/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.writing.box;

import javax.swing.SwingUtilities;
import classes.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tyler_Ewing
 */
public class Controller implements ActionListener{
    
    private Model model;
    private View view;
    
    public Controller(){
        model = new Model();
        view = new View();
        view.setVisible(true);
    }
    
    // Override for Button Listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(String.format("%s button pressed!!", e.getActionCommand()));
    }
    
    private void addButtonListeners(){
        view.addButtonListeners(this);
    }
    
    public static void launch(){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                Controller c = new Controller();
                c.addButtonListeners();
            }
        });
    }
    
    public static void main(String[] args){
        launch();
    }
}
