package aplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.glass.ui.Timer;

import presentacion.GameGUI;

/**
 * Unico Thread en el que se ejecuta el juego activo
 */
public class Hilo extends Thread{

    FroggerManager froggerManager;
    GameGUI gameGUI;
    Timer timer;

    private boolean playing;

    /**
     * Constructor de la clase
     * @param playingScript
     * @param canvas
     */
    public Hilo(FroggerManager playingScript, GameGUI canvas){
        this.gameGUI = canvas;
        this.froggerManager = playingScript;
    }

    /**
     * Funcion que es llamada cada fps y donde se ejecuta la funcion update y paint (principales de las capas)
     */
    @Override
    public void run(){
       while(true) {
    	   try {
    		   sleep(10);		
		} catch (Exception e) {
		}
    	   froggerManager.Update();
    	   gameGUI.repaint();
       }
    }

    /**
     * Obtener el estado del Thread
     * @return
     */
    public boolean getRunning(){
        return this.playing;
    }

    /**
     * Controlar el estado del Thread
     * @param data
     */
    public void setPlaying(boolean data){
        this.playing = data;
    }
}
