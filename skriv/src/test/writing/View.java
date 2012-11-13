package test.writing;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import classes.Word;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class View extends JFrame{
    
    private JPanel contentPanel = null;
    
    public View(){
        super();
        init();
    }
    
    private void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new java.awt.Dimension(500,500));
        this.setContentPane(contentPanel);
        this.pack();
        this.setVisible(true);
    }
    
    public void addMouseDetection(MouseListener m, MouseMotionListener mm){
        contentPanel.addMouseListener(m);
        contentPanel.addMouseMotionListener(mm);
    }
    
    public void updateUI(List<Word> words){
        Graphics g = contentPanel.getGraphics();
        // Gonna need to be smarter than that!!
        for(Word w : words){
            w.drawWord(g);
        }
    }
}
