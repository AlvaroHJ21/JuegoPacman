package Principal;

import InterfazGrafica.Ventana;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
