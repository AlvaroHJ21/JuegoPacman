package Clases;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Mapa {

    private ArrayList<Bloque> bloques;

    public Mapa() {
        bloques = new ArrayList<Bloque>();
    }

    public void pintar(Graphics g, JPanel p) {
        int[][] mapa = getMapa();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (mapa[i][j] == 1) {
                    Bloque b = new Bloque(j * Bloque.ANCHO, i * Bloque.ALTO);
                    bloques.add(b);
                    b.pintar(g, p);
                }
            }
        }
    }

    public static int[][] getMapa() {
        int mapa[][]
                = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        return mapa;
    }
}
