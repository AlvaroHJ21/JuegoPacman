
package InterfazGrafica;

import Control.EventoTeclado;
import Control.GraphicsEngine;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    private Tablero tablero;
    
    public Ventana(){
        setTitle("Pacman");
        setSize(800,600);
        setLocationRelativeTo(null);
//        setResizable(false);
        
        tablero = new Tablero();
        add(tablero);
        
        addKeyListener(new EventoTeclado());
        new GraphicsEngine(tablero).start();
    }
}
