package aplicacion;
import presentacion.GameGUI;

/**
 * Unico Thread en el que se ejecuta el juego activo
 */
public class Hilo extends Thread{
	
	public static Hilo instance;
    FroggerManager froggerManager;
    GameGUI gameGUI;

    private boolean playing;

    /**
     * Constructor de la clase
     * @param playingScript
     * @param canvas
     */
    public Hilo(FroggerManager playingScript, GameGUI canvas){
    	if(instance == null) instance = this;
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

	public static Hilo getInstance() {
		return instance;
	}

	public static void setInstance(Hilo instance) {
		Hilo.instance = instance;
	}
}
