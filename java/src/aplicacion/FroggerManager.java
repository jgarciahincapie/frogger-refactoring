package aplicacion;

import presentacion.GameGUI;

public class FroggerManager {
	
	//Game
	Player singlePlayer;
	
	//Configuracion juego
	private int mode;
	private boolean running = true;
	private int score;
	
	//Sistema Update
	private Hilo thread;
	private GameGUI gameGUI;

	public FroggerManager(int mode,GameGUI gameGUI){
		singlePlayer = new Player();
		this.gameGUI = gameGUI;
		thread = new Hilo(this, gameGUI);
		thread.start();	
	}
	
	public void Update() {
		if(running) {
			gameGUI.toDraw(singlePlayer);
			//Movimiento jugador
			singlePlayer.Move();
		}
	}

}
