/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tyler
 */
public class ContainsTest {
    
    static java.awt.Rectangle r = new java.awt.Rectangle(100,100,200,350);
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                javax.swing.JFrame f = new javax.swing.JFrame(){
                    @Override
                    public void paint(java.awt.Graphics g){
                        g.drawRect(100, 100, 200, 350);
                    }
                };
                f.setSize(500, 500);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                f.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e){
                        mousePressedYo(e);
                    }
                });
            }
        });
    }
    
    public static void mousePressedYo(java.awt.event.MouseEvent e){
        if(r.contains(e.getPoint())){
            System.out.println("contains point");
        }
        else{
            System.out.println("does not contain point");
        }
    }
}