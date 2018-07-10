package pruebas.taller.pkg2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MiPanel extends JPanel implements MouseInputListener {

    private Ventana2 miVentana = null;
    private BufferedImage bi = null, rotated = null, bi2 = null;
    private int x;
    private int y;
    private boolean preview = true;

    public MiPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    public MiPanel(BufferedImage bi, int x, int y, Ventana2 miVentana) {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.miVentana = miVentana;
        this.bi = bi;
        this.bi2 = bi;
        this.x = x;
        this.y = y;
    }

    public MiPanel(String ruta, int x, int y, Ventana2 miVentana, boolean rotar) {
        addMouseListener(this);
        addMouseMotionListener(this);
        setDoubleBuffered(true);
        this.miVentana = miVentana;
        cargarImagen(ruta);
        this.x = x;
        this.y = y;
        if (rotar) {
            bi = rotarImagen(bi, 90.0);
            this.x = y;
            this.y = x;
        }

    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(bi.getHeight(), bi.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(Math.PI * 2, bi.getWidth() / 2, bi.getHeight() / 2);
        g2.drawImage(bi, 0, 0, x, y, null);
        if (rotated != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            int x = (getWidth() - rotated.getWidth()) / 2;
            int y = (getHeight() - rotated.getHeight()) / 2;
            g2d.drawImage(rotated, x, y, this);
            g2d.dispose();
        }
    }

    public BufferedImage cargarImagen(String ruta) {

        try {
            File archivo = new File(ruta);
            bi = ImageIO.read(archivo);
            bi2 = bi;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        bi = null;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (preview) {
            miVentana.previewCard(this);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //miVentana.previewCard(null);
    }

    public BufferedImage getBi() {

        return bi;
    }

    public void setBi(BufferedImage bi) {
        this.bi = bi;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public BufferedImage rotarImagen(BufferedImage img, double angulo) {

        double rads = Math.toRadians(angulo);
        int w = img.getWidth();
        int h = img.getHeight();

        BufferedImage rotated = new BufferedImage(h, w, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((h - w) / 2, (w - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, this);
        g2d.dispose();

        return rotated;
    }

    public int getPosX() {
        return this.x;
    }

    public int getPosY() {
        return this.y;
    }

    public BufferedImage getBi2() {
        return bi2;
    }

    public boolean isPreview() {
        return preview;
    }

    public void setPreview(boolean preview) {
        this.preview = preview;
    }
}
