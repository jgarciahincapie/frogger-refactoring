package aplicacion;

import presentacion.GameGUI;

public class FroggerManager {
	
	//Game
	Player playerOne;
	Trunk[] trunks;
	
	//Configuracion juego
	private int mode;
	private boolean running = false;
	private int score;
	
	//Sistema Update
	private Hilo thread;
	private GameGUI gameGUI;

	public FroggerManager(int mode,GameGUI gameGUI){
		//Instanciar todos los objetoss
		instances(gameGUI);
		thread.start();	
	}
	
	public void Update() {
		if(running) {
			//Acutalizar posiciones de los elementos en el juego
			gameGUI.toDraw(playerOne, trunks);
			
			//Movimiento jugador
			playerOne.Move();
			
			//Movimiento Troncos
			for(Trunk trunk: trunks) {
				trunk.autoMove(1);
			}
		}
	}
	
	private void instances(GameGUI gameGUI) {
		//Objetos dentro del juego
		playerOne = new Player();
		trunks = new Trunk[] {new Trunk(true, 800, 50, 1), new Trunk(false, 0, 100, 1), new Trunk(false, 0, 150, 1)};
		
		this.gameGUI = gameGUI;
		thread = new Hilo(this, gameGUI);
		running = true;
	}
}
