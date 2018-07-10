/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.taller.pkg2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class Ventana extends JFrame implements MouseInputListener {

    
    public Ventana() {
        super("Prueba de Ventana");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        this.setSize(1600, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void paint(Graphics g) {
        /*super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp1 = new GradientPaint(50.0f, 25.0f, Color.blue, 50.0f, 225.0f, Color.black);
        g2.setPaint(gp1);
        Rectangle2D r1 = new Rectangle2D.Float(25, 25, 200, 500);
        g2.fill(r1);
        GradientPaint gp2 = new GradientPaint(250.0f, 25.0f, Color.blue, 450.0f, 225.0f, Color.PINK);
        g2.setPaint(gp2);
        Rectangle2D r2 = new Rectangle2D.Float(250, 25, 200, 450);
        g2.fill(r2);
         */

        BufferedImage imagenCarta;
        Graphics2D g2 = (Graphics2D) g;

        Image carta1 = Toolkit.getDefaultToolkit().
                getImage("C:\\Users\\jlien\\OneDrive\\Cursos\\INET\\4 año\\Taller 2\\Cartas\\Cropped\\001.jpg");
        Image carta2 = Toolkit.getDefaultToolkit().
                getImage("C:\\Users\\jlien\\OneDrive\\Cursos\\INET\\4 año\\Taller 2\\Cartas\\Cropped\\002.jpg");

        
        g2.drawImage(carta1, 10, 10, this);
        g2.drawImage(carta2, 600, 10, this);
        
        //super.paint(g);
        
        Graphics2D g3 = (Graphics2D) g.create();
        g3.scale(0.5, 0.5);
        g3.drawImage(carta1, 300, 50, null);

        g3.scale(1.5, 1.5);
        //paintComponent(g3);
        //g3.drawImage(carta1, 300, 50, null);

    }


    
    @Override
    public void mouseClicked(MouseEvent e) {
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
