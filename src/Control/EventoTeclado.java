package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventoTeclado extends KeyAdapter {

    public static boolean RIGHT = false;
    public static boolean LEFT = false;
    public static boolean UP = false;
    public static boolean DOWN = false;
    public static boolean SPACE = false;

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if (i == KeyEvent.VK_RIGHT) {
            RIGHT = true;
        }
        if (i == KeyEvent.VK_LEFT) {
            LEFT = true;
        }
        if (i == KeyEvent.VK_UP) {
            UP = true;
        }
        if (i == KeyEvent.VK_DOWN) {
            DOWN = true;
        }
        if(i == KeyEvent.VK_SPACE){
            SPACE = true;
        }
    }
    
//    @Override
//    public void keyTyped(KeyEvent e){
//        int i = e.getKeyCode();
//        
//    }

    @Override
    public void keyReleased(KeyEvent e){
        int i = e.getKeyCode();
        if(i == KeyEvent.VK_RIGHT){
            RIGHT = false;
        }
        if(i == KeyEvent.VK_LEFT){
            LEFT = false;
        }
        if(i == KeyEvent.VK_UP){
            UP = false;
        }
        if(i == KeyEvent.VK_DOWN){
            DOWN = false;
        }
        if(i == KeyEvent.VK_SPACE){
            SPACE = false;
        }
    }
}
