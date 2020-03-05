package Clases;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Enemigo {

    private int x;
    private int y;
    private int dx = 1;
    private int dy = 1;
    private final int ANCHO = 64;
    private final int ALTO = 64;
    private boolean colision = false;

    public Enemigo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void pintar(Graphics2D g) {
        g.setColor(Color.red);
        g.fillOval(x, y, ANCHO, ALTO);
        g.setColor(Color.black);
        g.drawOval(x, y, ANCHO, ALTO);
    }
    
    public Ellipse2D getShaper(){
        return new Ellipse2D.Double(x, y, ANCHO, ALTO);
    }

    public void mover(Rectangle limites) {
        this.x += dx;
        this.y += dy;
        if (x == limites.getMaxX() - ANCHO) {
            dx = -dx;
        }
        if (x == 0) {
            dx = -dx;
        }
        if (y == limites.getMaxY() - ALTO) {
            dy = -dy;
        }
        if (y == 0) {
            dy = -dy;
        }
    }

}
