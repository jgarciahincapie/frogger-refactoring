package aplicacion;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Controla los input del usuario en el juego
 */
public class EventosKeyboard extends KeyAdapter{

    public static boolean esc;
    public static boolean space;
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean rigth;

    public static boolean upArrow;
    public static boolean downArrow;
    public static boolean leftArrow;
    public static boolean rigthArrow;


    /**
     * Constructor de la clase
     */
    public EventosKeyboard(){
        space = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	super.keyTyped(e);
    	int id = e.getKeyCode();
    	
    	if(id == KeyEvent.VK_W){
            up = true;
        }
        if(id == KeyEvent.VK_S){
            down = true;
        }
        if(id == KeyEvent.VK_A){
            left  = true;
        }
        if(id == KeyEvent.VK_D){
            rigth = true;
        }
    	
        //Pause Menu
        if(id == KeyEvent.VK_ESCAPE){
        	esc = true;
        }
        
        //Start
        if(id == KeyEvent.VK_SPACE){
        	space = true;
        }
    }

    /**
     * Permite detectar cuando el usuario suelte la tecla presionada
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e){
        int id = e.getKeyCode();

        //Player 1
        if(id == KeyEvent.VK_W){
            up = false;
        }
        if(id == KeyEvent.VK_S){
            down = false;
        }
        if(id == KeyEvent.VK_A){
            left  = false;
        }
        if(id == KeyEvent.VK_D){
            rigth = false;
        }

        //Player 2
        if(id == KeyEvent.VK_UP){
            upArrow = false;
        }
        if(id == KeyEvent.VK_DOWN){
            downArrow = false;
        }
        if(id == KeyEvent.VK_LEFT){
            leftArrow  = false;
        }
        if(id == KeyEvent.VK_RIGHT){
            rigthArrow = false;
        }
        if(id == KeyEvent.VK_RIGHT){
            esc = false;
        }

    }
}
