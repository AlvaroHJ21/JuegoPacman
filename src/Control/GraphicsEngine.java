
package Control;

import InterfazGrafica.Tablero;
import InterfazGrafica.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GraphicsEngine extends Thread {
    private Tablero tablero;
    public static boolean colision = false;

    public GraphicsEngine(Tablero tablero) {
        this.tablero = tablero;
    }
    
    @Override
    public void run(){
        while(!colision){
            tablero.repaint();
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {
                Logger.getLogger(GraphicsEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(null, "Perdiste, CRACK");
    }
}
