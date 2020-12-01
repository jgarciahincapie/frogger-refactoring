package aplicacion;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import presentacion.GameGUI;

public class FroggerManager {

	//Game
	private Player playerOne;
	private Player playerTwo;
	public static Collisionable[] collisionables;

	//Configuracion juego
	private int mode;
	private boolean running;
	private int score;
	private int time;
	private int cont;
	private int lives;
	private boolean swiming;

	//Sistema Update
	private Hilo thread;
	private GameGUI gameGUI;

	public FroggerManager(int mode,GameGUI gameGUI){
		this.gameGUI = gameGUI;
		if(mode == 1)
			GameMode1();
		else if(mode == 2)
			GameMode2();
		Start();
	}
	
	private void GameMode1() {
		playerOne = new Player(380, 480, 1);
		playerTwo = null;
	}
	
	private void GameMode2() {
		playerOne = new Player(260, 480, 1);
		playerTwo = new Player(520, 480, 2);
		
	}

	//Instancia una unica vez
	private void Start() {
		//Instanciar todos los objetos
		collisionables = new Collisionable[] {
				//River
				new River(),
				//Stop places
				new StopPlace(30, 30), new StopPlace(200, 30), new StopPlace(370, 30), new StopPlace(540, 30), new StopPlace(710, 30),
				//Trunks
				//Largos inferiores
				new Trunk(false, 0, 130, 170, 50, 2), 
				new Trunk(false, -300, 130, 170, 50, 2), 
				new Trunk(false, -600, 130, 170, 50, 2),
				//Largos superiores
				new Trunk(true, 900, 80, 180, 50, 1), 
				new Trunk(true, 300, 80, 180, 50, 1), 
				new Trunk(true, 600, 80, 180, 50, 1),
				//Medianos
				new Trunk(false, -100, 230, 100, 50, 1), 
				new Trunk(false, -300, 230, 100, 50, 1), 
				new Trunk(false, -500, 230, 100, 50, 1), 
				//Pequeños
				new Trunk(false, -650, 230, 50, 50, 1), 
				new Trunk(false, -800, 230, 50, 50, 1),
				
				//Cars
				new Car(true, 800, 430, 1), 
				new Car(false, 0, 380, 1), 
				new Car(true, 800, 330, 1),
				
				//Turtles
				//Grupo 1
				new Turtle(true, 0, 180, 2),
				new Turtle(true, 50, 180, 2), 
				new Turtle(true, 100, 180, 2),
				//Grupo 2
				new Turtle(true, 300, 180, 2), 
				new Turtle(true, 350, 180, 2),
				//Grupo 3
				new Turtle(true, 550, 180, 2), 
				new Turtle(true, 600, 180, 2), 
				new Turtle(true, 650, 180, 2), 
				//Grupo 4
				new Turtle(true, 950, 180, 2), 
				new Turtle(true, 1000, 180, 2)
		};
		//Update
		thread = new Hilo(this, gameGUI);
		thread.start();
		lives = 5;
		score = 0;
		Reset(gameGUI);
	}
	

	

	public void Update() {
		if(running) {
			//Acutalizar posiciones de los elementos en el juego
			gameGUI.repaint();
			
			DecreseTime();

			//Movimiento jugadores
			playerOne.Move();
			if(playerTwo != null)
				playerTwo.Move();

			//Animals
			for(Collisionable tt: collisionables) {
				tt.autoMove();
			}
		}
	}
	
	private void Reset(GameGUI gameGUI) {
		//Objetos para dibujar
		playerOne.resetPosition();
		if(playerTwo != null)
			playerTwo.resetPosition();
		
		swiming = false;
		gameGUI.toDraw(playerOne, playerTwo, collisionables);

		//Variables
		this.gameGUI = gameGUI;
		running = true;
		cont = 0;
	}


	private boolean Collision(Rectangle2D col1, Rectangle2D col2) {
		if(col1.intersects(col2)) {
			return true;
		}
		return false;
	}

	private void LoseLive() {
		if(lives>=0) {
			lives--;
			Reset(gameGUI);
		}
		else {
			FinalGame();
		}
	}

	private void FinalGame() {
		System.out.println("El juego ha terminado, sos un mancaso");
	}

	private void DecreseTime() {
		if(cont <= 500) {
			cont+=1;
		}
		else {
			if(time <= 300) {
				time+=8;				
			}
			else {
				LoseLive();		
			}
			cont = 0;
		}
	}


	//GETTERS && SETTERS
	public int getMode() {
		return mode;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public String getScore() {
		return Integer.toString(score);
	}

	public void setScore(int score) {
		this.score = score;
	}
}
