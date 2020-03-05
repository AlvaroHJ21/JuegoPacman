package Clases;

import Control.EventoTeclado;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player implements Runnable {

    private int x;
    private int y;
    private int dx = 1;
    private int dy = 1;
    private final int ANCHO = 64;
    private final int ALTO = 64;
    private final int SALTO = 200;
    private Image imagen;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        imagen = new ImageIcon(getClass().getResource("/Recursos/Sprites/Pacman/Right/pacman_0.png")).getImage();
    }

    public void pintar(Graphics2D g, JPanel p) {
        g.drawImage(imagen, x, y, ANCHO, ALTO, p);

    }
    
    public Rectangle2D getShaper(){
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void mover(Rectangle limites) {
        if (EventoTeclado.RIGHT && x <= limites.getMaxX() - ANCHO) {
            x += dx;
        }
        if (EventoTeclado.LEFT && x >= 0) {
            x -= dx;
        }
        if (EventoTeclado.UP && y >= 0) {
            y -= dy;
        }
        if (EventoTeclado.DOWN && y <= limites.getMaxY() - ALTO) {
            y += dy;
        }
        if (EventoTeclado.SPACE) {
            saltar();
            EventoTeclado.SPACE = false; //investigar
        }
    }
    
    

    public void saltar() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < SALTO; i++) {
                    y--;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for (int i = 0; i < SALTO; i++) {
                    y++;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t.start();
    }

    public void pintarSpritesRight() {
        for (int i = 0; i <= 3; i++) {
            imagen = new ImageIcon(getClass().getResource("/Recursos/Sprites/Pacman/Right/pacman_" + i + ".png")).getImage();
            try {
                Thread.sleep(60);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void pintarSpritesLeft() {
        for (int i = 0; i <= 3; i++) {
            imagen = new ImageIcon(getClass().getResource("/Recursos/Sprites/Pacman/Left/pacman_" + i + ".png")).getImage();
            try {
                Thread.sleep(60);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void pintarSpritesUp() {
        for (int i = 0; i <= 3; i++) {
            imagen = new ImageIcon(getClass().getResource("/Recursos/Sprites/Pacman/Up/pacman_" + i + ".png")).getImage();
            try {
                Thread.sleep(60);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void pintarSpritesDown() {
        for (int i = 0; i <= 3; i++) {
            imagen = new ImageIcon(getClass().getResource("/Recursos/Sprites/Pacman/Down/pacman_" + i + ".png")).getImage();
            try {
                Thread.sleep(60);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void iniciarAnimacion() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("segundo hilo");
        while (true) {
            if (EventoTeclado.RIGHT) {
                pintarSpritesRight();
            }
            if (EventoTeclado.LEFT) {
                pintarSpritesLeft();
            }
            if (EventoTeclado.UP) {
                pintarSpritesUp();
            }
            if (EventoTeclado.DOWN) {
                pintarSpritesDown();
            }
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
