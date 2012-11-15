package test.writing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

public class Controller extends MouseAdapter implements MouseMotionListener {

    //Just gonna see what I can actually get something working
    /*
     * A minor bug when you draw on the right side then draw on the left side
     * it wants to draw a line from (-1,-1) and repeats this
     */
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
        view.addMouseDetection(this, this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isShiftDown()) {
            System.out.println("Strikethrough attempted.");
        } else if (e.isAltDown()) {
            System.out.println("Spread attempted.");
        } else {
            // Add point to "live" Word in Model
            model.addPoint(e.getPoint());
            // update View
            view.updateUI(model.getViewData());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Add point to "live" Word
        model.addPoint(new java.awt.Point(-1, -1));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //model.addPoint(e.getPoint());
        model.addDraggedPoint(e.getPoint());
        view.updateUI(model.getViewData());
    }

    private static void launch() {
        new Controller();
    }

    public static void main(String[] args) {
        launch();
    }
}
