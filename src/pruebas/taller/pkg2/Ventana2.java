/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.taller.pkg2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author jlien
 */
public class Ventana2 extends JFrame implements MouseInputListener {
    
    private MiPanel preview = null;
    private int posx, posy;
    private JLayeredPane contenedor = null;
    
    public Ventana2() {
        super("Invizimals");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/icono.jpg"));
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        
        contenedor = new JLayeredPane();
        contenedor.setSize(1366, 768);
        contenedor.setLocation(0, 0);
        
        addMouseListener(this);
        addMouseMotionListener(this);
        
        MiPanel invizimalActivoOponente = new MiPanel("imagenes/Reverso.png", 90, 125, this, false);
        invizimalActivoOponente.setLocation(new Point(295, 215));
        invizimalActivoOponente.setSize(invizimalActivoOponente.getPosX(), invizimalActivoOponente.getPosY());
        invizimalActivoOponente.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        
        contenedor.add(invizimalActivoOponente, 0);
        
        MiPanel invizimalActivoJugador = new MiPanel("imagenes/001.jpg", 90, 125, this, false);
        invizimalActivoJugador.setLocation(new Point(295, 380));
        invizimalActivoJugador.setSize(invizimalActivoJugador.getPosX(), invizimalActivoJugador.getPosY());
        invizimalActivoJugador.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        
        contenedor.add(invizimalActivoJugador, 1);
        
        MiPanel bancaOponente[] = new MiPanel[3];
        posx = 190;
        posy = 60;
        
        for (int i = 0; i < 3; i++) {
            bancaOponente[i] = new MiPanel("imagenes/Reverso.png", 90, 125, this, false);
            bancaOponente[i].setLocation(new Point(posx, posy));
            bancaOponente[i].setSize(bancaOponente[i].getPosX(), bancaOponente[i].getPosY());
            posx += 105;
            bancaOponente[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
            
            contenedor.add(bancaOponente[i], 2 + i);
        }
        
        MiPanel bancaJugador[] = new MiPanel[3];
        posx = 190;
        posy = 535;
        
        for (int i = 0; i < 3; i++) {
            bancaJugador[i] = new MiPanel("imagenes/Reverso.png", 90, 125, this, false);
            bancaJugador[i].setLocation(new Point(posx, posy));
            bancaJugador[i].setSize(bancaJugador[i].getPosX(), bancaJugador[i].getPosY());
            posx += 105;
            bancaJugador[i].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            contenedor.add(bancaJugador[i], 5 + i);
        }
        
        MiPanel mazoOponente = new MiPanel("imagenes/Reverso.png", 90, 125, this, true);
        mazoOponente.setLocation(new Point(35, 60));
        mazoOponente.setSize(125, 90);
        mazoOponente.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        
        contenedor.add(mazoOponente, 8);
        
        MiPanel cemOp = new MiPanel("imagenes/Reverso.png", 90, 125, this, true);
        cemOp.setLocation(new Point(35, 195));
        cemOp.setSize(125, 90);
        cemOp.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        
        contenedor.add(cemOp, 9);
        
        MiPanel cemJug = new MiPanel("imagenes/Reverso.png", 90, 125, this, true);
        cemJug.setLocation(new Point(35, 445));
        cemJug.setSize(125, 90);
        cemJug.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        
        contenedor.add(cemJug, 10);
        
        MiPanel mazoJugador = new MiPanel("imagenes/Reverso.png", 90, 125, this, true);
        mazoJugador.setLocation(new Point(35, 570));
        mazoJugador.setSize(125, 90);
        mazoJugador.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        
        contenedor.add(mazoJugador, 11);
        
        MiPanel escudosJugador[] = new MiPanel[3];
        posx = 520;
        posy = 60;
        
        for (int i = 0; i < 3; i++) {
            escudosJugador[i] = new MiPanel("imagenes/Reverso.png", 90, 125, this, true);
            escudosJugador[i].setLocation(new Point(posx, posy));
            escudosJugador[i].setSize(escudosJugador[i].getPosX(), escudosJugador[i].getPosY());
            posy += 95;
            escudosJugador[i].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
            contenedor.add(escudosJugador[i], 12 + i);
        }
        
        MiPanel escudosOponente[] = new MiPanel[3];
        posx = 520;
        posy = 380;
        
        for (int i = 0; i < 3; i++) {
            escudosOponente[i] = new MiPanel("imagenes/Reverso.png", 90, 125, this, true);
            escudosOponente[i].setLocation(new Point(posx, posy));
            escudosOponente[i].setSize(escudosOponente[i].getPosX(), escudosOponente[i].getPosY());
            posy += 95;
            escudosOponente[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
            
            contenedor.add(escudosOponente[i], 15 + i);
        }
        
        MiPanel habitat = new MiPanel("imagenes/Reverso.png", 90, 125, this, true);
        habitat.setLocation(new Point(125, 315));
        habitat.setSize(125, 90);
        habitat.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        
        contenedor.add(habitat, 18);
        
        MiPanel cazadoraOponente = new MiPanel("imagenes/Reverso.png", 90, 125, this, false);
        cazadoraOponente.setLocation(new Point(400, 215));
        cazadoraOponente.setSize(90, 125);
        cazadoraOponente.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        
        contenedor.add(cazadoraOponente, 19);
        
        MiPanel cazadoraJugador = new MiPanel("imagenes/Reverso.png", 90, 125, this, false);
        cazadoraJugador.setLocation(new Point(400, 380));
        cazadoraJugador.setSize(90, 125);
        cazadoraJugador.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        
        contenedor.add(cazadoraJugador, 20);
        
        posx = 725;
        posy = 20;
        MiPanel ap1[] = new MiPanel[12];
        for (int i = 0; i < 12; i++) {
            ap1[i] = new MiPanel("imagenes/Reverso.png", 90, 125, this, false);
            ap1[i].setLocation(new Point(posx, posy));
            ap1[i].setSize(ap1[i].getPosX(), ap1[i].getPosY());
            posx += 100;
            if (i == 5) {
                posx = 725;
                posy = 575;
            }
            contenedor.add(ap1[i], 21 + i);
        }
        
        JPanel fondo = new JPanel();
        fondo.setLocation(20, 20);
        fondo.setSize(640, 680);
        Color c = new Color(72, 201, 176, 85);
        fondo.setBackground(c);
        
        contenedor.add(fondo, 30);
        cargarFondo();

        //contenedor.revalidate();
        this.add(contenedor);
        this.setVisible(true);
        
    }
    
    public void previewCard(MiPanel panel) {
        if (preview == null) {
            preview = new MiPanel(panel.getBi2(), 200, 300, this);
            preview.setLocation(new Point(725, 200));
            preview.setSize(200, 300);
            preview.setPreview(false);
            contenedor.add(preview, 0);
            this.repaint();
        } else {
            preview.setBi(panel.getBi2());
            this.repaint();
        }
        
    }
    
    public void cargarFondo() {
        MiPanel bg = new MiPanel("imagenes/bg2.jpg", this.getWidth(), this.getHeight(), this, false);
        bg.setSize(this.getWidth(), this.getHeight());
        bg.setLocation(0, 0);
        bg.setPreview(false);
        contenedor.add(bg, 40);
        this.repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
