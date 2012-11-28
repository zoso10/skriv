package classes;

import SwingGUI.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class View extends javax.swing.JFrame {

    public View() {
        initComponents();
        ArrowButton.setUI(new VerticalButtonUI(270));
        OpenButton.setUI(new VerticalButtonUI(270));
        SaveButton.setUI(new VerticalButtonUI(270));
        CloseButton.setUI(new VerticalButtonUI(270));
    }

                             
    private void initComponents() {

        margin = new javax.swing.JPanel();
        ArrowButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        OpenButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        page = new javax.swing.JPanel();
        miniMap = new javax.swing.JPanel();
        toolBar = new javax.swing.JPanel();
        PenButton = new javax.swing.JButton();
        SelectButton = new javax.swing.JButton();
        InsertButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        writingArea = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(768, 1024));
        setResizable(false);
        getContentPane().setLayout(null);

        margin.setBackground(new java.awt.Color(255, 204, 255));
        margin.setMaximumSize(new java.awt.Dimension(58, 717));
        margin.setMinimumSize(new java.awt.Dimension(58, 717));
        margin.setPreferredSize(new java.awt.Dimension(58, 717));
        margin.setLayout(new javax.swing.BoxLayout(margin, javax.swing.BoxLayout.Y_AXIS));

        ArrowButton.setText("^");
        margin.add(ArrowButton);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu");
        margin.add(jLabel1);

        OpenButton.setText("Open");
        margin.add(OpenButton);

        SaveButton.setText("Save");
        margin.add(SaveButton);

        CloseButton.setText("Close");
        margin.add(CloseButton);

        getContentPane().add(margin);
        margin.setBounds(0, 0, 58, 717);

        page.setBackground(new java.awt.Color(255, 255, 204));
        page.setMinimumSize(new java.awt.Dimension(556, 717));
        page.setPreferredSize(new java.awt.Dimension(556, 717));
        page.setLayout(null);
        getContentPane().add(page);
        page.setBounds(58, 0, 556, 717);

        miniMap.setBackground(new java.awt.Color(255, 204, 204));
        miniMap.setMaximumSize(new java.awt.Dimension(154, 717));
        miniMap.setMinimumSize(new java.awt.Dimension(154, 717));
        miniMap.setPreferredSize(new java.awt.Dimension(154, 717));
        miniMap.setLayout(null);
        getContentPane().add(miniMap);
        miniMap.setBounds(614, 0, 154, 717);

        toolBar.setBackground(new java.awt.Color(204, 255, 204));
        toolBar.setMaximumSize(new java.awt.Dimension(768, 51));
        toolBar.setMinimumSize(new java.awt.Dimension(768, 51));
        toolBar.setPreferredSize(new java.awt.Dimension(768, 51));
        toolBar.setLayout(new javax.swing.BoxLayout(toolBar, javax.swing.BoxLayout.LINE_AXIS));

        PenButton.setText("Pen");
        PenButton.setFocusable(false);
        PenButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PenButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(PenButton);

        SelectButton.setText("Select");
        SelectButton.setFocusable(false);
        SelectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SelectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(SelectButton);

        InsertButton.setText("Insert");
        InsertButton.setFocusable(false);
        InsertButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InsertButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(InsertButton);

        DeleteButton.setText("Delete");
        toolBar.add(DeleteButton);

        getContentPane().add(toolBar);
        toolBar.setBounds(0, 718, 768, 51);

        // Just debugging some stuff
        jScrollPane1.setBackground(java.awt.Color.ORANGE);
        
        
        writingArea.setBackground(new java.awt.Color(204, 204, 255));
        writingArea.setMaximumSize(new java.awt.Dimension(768, 256));
        writingArea.setMinimumSize(new java.awt.Dimension(768, 256));
        writingArea.setPreferredSize(new java.awt.Dimension(768, 256));
        // I don't think the writing area needs to have a scrollPane
        //writingArea.setLayout(new java.awt.BorderLayout());
        //writingArea.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(writingArea);
        writingArea.setBounds(0, 768, 768, 256);

        pack();
    }                                                                   

    public void addButtonListeners(java.awt.event.ActionListener al){
        // Wish these buttons were in an array, it would be less typing :(
        // This is gonna need to be changed when buttons are added or removed
        ArrowButton.addActionListener(al);
        ArrowButton.setActionCommand("arrow");
        CloseButton.addActionListener(al);
        CloseButton.setActionCommand("close");
        DeleteButton.addActionListener(al);
        DeleteButton.setActionCommand("delete");
        InsertButton.addActionListener(al);
        InsertButton.setActionCommand("insert");
        OpenButton.addActionListener(al);
        OpenButton.setActionCommand("open");
        PenButton.addActionListener(al);
        PenButton.setActionCommand("pen");
        SaveButton.addActionListener(al);
        SaveButton.setActionCommand("save");
        SelectButton.addActionListener(al);
        SelectButton.setActionCommand("select");
    }
    
    public void addMouseListeners(java.awt.event.MouseListener ml, java.awt.event.MouseMotionListener mml){
        writingArea.addMouseListener(ml);
        writingArea.addMouseMotionListener(mml);
    }
    
    public void updateUI(ArrayList<Word> words){
        // This is gonna look strange since we need to draw in two different spots
//        Graphics g = page.getGraphics();
//        // Draw all the words!!
//        for(Word w : words){
//            w.drawWord(g);
//        }
        Graphics g2 = writingArea.getGraphics();
        // For testing
        //g2.clearRect(0, 0, writingArea.getWidth(), writingArea.getHeight());
        for(Word w : words){
            w.drawWord(g2);
        }
    }
    
    public void updateWritingBoxUI(classes.revised.WordUntranslated liveWord){
        Graphics g = writingArea.getGraphics();
        java.awt.Rectangle r = liveWord.getBoundingBox();
        //g.clearRect(r.x, r.y, r.width, r.height);
        g.setColor(new java.awt.Color(204,204,255));
        g.fillRect(r.x, r.y, r.width, r.height);
        g.setColor(java.awt.Color.BLACK);
        liveWord.draw(g);
    }
    
                    
    private javax.swing.JButton ArrowButton;
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton InsertButton;
    private javax.swing.JButton OpenButton;
    private javax.swing.JButton PenButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SelectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel margin;
    private javax.swing.JPanel miniMap;
    private javax.swing.JPanel page;
    private javax.swing.JPanel toolBar;
    private javax.swing.JPanel writingArea;                 
}
