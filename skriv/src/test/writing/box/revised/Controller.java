package test.writing.box.revised;

import classes.SmartPoint;
import classes.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controller implements ActionListener, MouseListener, MouseMotionListener{
    
    private Model model;
    private View view;
    
    public Controller(){
        model = new Model();
        view = new View();
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(String.format("%s button pressed", e.getActionCommand()));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // No need for functionality
    }

    @Override
    public void mousePressed(MouseEvent e) {
         if(e.isAltDown()){
             System.out.println("Strikethrough performed");
         } else if(e.isShiftDown()){
             System.out.println("Spread performed");
         } else{
             model.addPoint(new SmartPoint(e.getPoint(), false));
         }
   }

    @Override
    public void mouseReleased(MouseEvent e) {
        model.addPointDirect(new SmartPoint(e.getPoint(), true));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // No need for functionality
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // No need for functionality
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        model.addPointDirect(new SmartPoint(e.getPoint(), false));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // No need for functionality
    }
    
    public void addListeners(){
        view.addButtonListeners(this);
        view.addMouseListeners(this, this);
    }
    
    public static void launch(){
        Controller c = new Controller();
        c.addListeners();
    }
    
    
    public static void main(String[] args){
        launch();
    }
}