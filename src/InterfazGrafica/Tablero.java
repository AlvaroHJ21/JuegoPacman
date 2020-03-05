
package InterfazGrafica;

import Clases.Enemigo;
import Clases.Mapa;
import Clases.Player;
import Control.GraphicsEngine;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Tablero extends JPanel {
    private Player player;
    private Enemigo enemigo;
    
    public Tablero(){
        initComponent();
    }
    
    public void initComponent(){
        player = new Player(0,500);
        player.iniciarAnimacion();
        enemigo = new Enemigo(0, 0);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pintarComponentes(g);
    }
    
    public void pintarComponentes(Graphics g){
        player.pintar((Graphics2D)g, this);
        actualizar();
        enemigo.pintar((Graphics2D) g);
        actualizar();
    }
    
    public void colision(){
        if(enemigo.getShaper().intersects(player.getShaper())){
            GraphicsEngine.colision = true;
        }
    }
    
    public void actualizar(){
        player.mover(this.getBounds());
        enemigo.mover(this.getBounds());
        colision();
    }
}
