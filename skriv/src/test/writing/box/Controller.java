package test.writing.box;

import classes.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingUtilities;


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
        System.out.println(String.format("%s button pressed", e.getActionCommand()));
    }
    
    // Implementation for Mouse Listeners
    @Override
    public void mouseClicked(MouseEvent e) {
        // Probably won't have functionality
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Add Point and see if it's a new Word
        if(e.isShiftDown()){
            System.out.println("Strikethrough attempted.");
        } else if(e.isAltDown()){
            System.out.println("Spread attempted");
        } else{
            // Add poin to "live" Word in Model
            model.addPoint(e.getPoint());
            // update View
            view.updateUI(model.getViewData());
        }
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
