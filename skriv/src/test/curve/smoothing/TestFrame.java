package test.curve.smoothing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tyler_Ewing
 * This is my Test Frame for Bezier Smoothing of the handwriting
 */
public class TestFrame extends JFrame {

    private JPanel contentPanel = null;

    public TestFrame() {
        super();
        init();
    }

    private void init() {
        this.setSize(500, 500);
        this.setTitle("TestFrame for Bezier");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getContentPanel());
    }

    private JPanel getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new JPanel() {

                @Override
                public void paintComponent(Graphics g) {
                }
            };
            contentPanel.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseReleased(MouseEvent e) {
                }
            });
            contentPanel.addMouseMotionListener(new MouseMotionAdapter() {

                @Override
                public void mouseDragged(MouseEvent e) {
                }
            });
        }

        return contentPanel;
    }
}
