
package Clases;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Bloque {
    private int x;
    private int y;
    public static int ANCHO = 64;
    public static int ALTO = 64;
    
    public Bloque(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void pintar(Graphics g, JPanel p){
        g.setColor(Color.blue);
        g.fillRect(x, y, ANCHO, ALTO);
        g.setColor(Color.black);
        g.drawRect(x, y, ANCHO, ALTO);
    }
}
