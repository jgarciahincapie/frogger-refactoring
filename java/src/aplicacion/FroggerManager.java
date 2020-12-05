package aplicacion;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.PrimitiveIterator.OfDouble;

import presentacion.Assets;
import presentacion.GameGUI;

public class FroggerManager {

	//Instancias
	public static FroggerManager instance;

	//Game
	private Player playerOne;
	private Player playerTwo;
	public static Collisionable[] collisionables;

	//Configuracion juego
	private int mode;
	private boolean running;
	private int time;
	private int cont;
	private int contStopPlaces;
	private ArrayList<StopPlace> cantPlaces;
	public static int ronda;
	private BufferedImage p1Sprite;
	private BufferedImage p2Sprite;

	//Sistema Update
	private Hilo thread;

	public FroggerManager(int mode, BufferedImage p1Sprite, BufferedImage p2Sprite){
		if(instance == null) instance = this;

		this.mode = mode;
		this.p1Sprite = p1Sprite;
		this.p2Sprite = p2Sprite;		
		ronda = 0;
		System.out.println(mode);
		if(mode == 1)
			GameMode1();
		else if(mode == 2)
			GameMode2();
		else if(mode == 3)
			GameMode3();
		else if(mode == 4)
			GameMode4();
		Start();
	}

	private void GameMode1() {
		playerOne = new PlayerNormal(380, 480, 1, p1Sprite);
		playerTwo = null;
	}

	private void GameMode2() {
		playerOne = new PlayerNormal(260, 480, 1, p1Sprite);
		playerTwo = new PlayerNormal(520, 480, 2, p2Sprite);	
	}
	
	private void GameMode3() {
		playerOne = new PlayerNormal(260, 480, 1, p1Sprite);
		playerTwo = new MachineIrreflexive(520, 480, 2, p2Sprite);
	}
	
	private void GameMode4() {
		playerOne = new MachineIrreflexive(260, 480, 1, p1Sprite);
		playerTwo = new MachineIrreflexive(520, 480, 2, p2Sprite);
	}

	//Instancia una unica vez
	private void Start() {

		//Instanciar todos los objetos
		collisionables = new Collisionable[] {
				//River
				new River(),
				//Grass
				new Grass(0, 480, 800, 50),
				new Grass(0, 280, 800, 50),
				//Stop places
				new StopPlace(30, 30), new StopPlace(200, 30), new StopPlace(370, 30), new StopPlace(540, 30), new StopPlace(710, 30),
				//Trunks
				//Largos inferiores
				new Trunk(false, 0, 130, 170, 50, 2 + ronda), 
				new Trunk(false, -300, 130, 170, 50, 2 + ronda), 
				new Trunk(false, -600, 130, 170, 50, 2 + ronda),
				//Largos superiores
				new Trunk(true, 900, 70, 180, 50, 1 + ronda), 
				new Trunk(true, 300, 70, 180, 50, 1 + ronda), 
				new Trunk(true, 600, 70, 180, 50, 1 + ronda),
				//Medianos
				new Trunk(false, -100, 235, 100, 50, 1 + ronda), 
				new Trunk(false, -300, 235, 100, 50, 1 + ronda), 
				new Trunk(false, -500, 235, 100, 50, 1 + ronda), 
				//Pequeños
				new Trunk(false, -650, 235, 50, 50, 1 + ronda), 
				new Trunk(false, -800, 235, 50, 50, 1 + ronda),

				//Cars
				//Inferiores
				new Car(false, 600, 430, 1 + ronda), 
				new Car(false, -750, 430, 1 + ronda), 
				new Car(false, 900, 430, 1 + ronda),
				//Medios
				new Car(false, -600, 380, 2 + ronda), 
				new Car(false, -350, 380, 2 + ronda), 
				new Car(false, 0, 380, 2 + ronda),
				//Superiores
				new Car(false, 600, 330, 3 + ronda), 
				new Car(false, -600, 330, 3 + ronda), 
				new Car(false, 900, 330, 3 + ronda),


				//Turtles
				//Grupo 1
				new Turtle(true, 0, 180, 2 + ronda),
				new Turtle(true, 50, 180, 2 + ronda), 
				new Turtle(true, 100, 180, 2 + ronda),
				//Grupo 2
				new Turtle(true, 300, 180, 2 + ronda), 
				new Turtle(true, 350, 180, 2 + ronda),
				//Grupo 3
				new Turtle(true, 550, 180, 2 + ronda), 
				new Turtle(true, 600, 180, 2 + ronda), 
				new Turtle(true, 650, 180, 2 + ronda), 
				//Grupo 4
				new Turtle(true, 950, 180, 2 + ronda), 
				new Turtle(true, 1000, 180, 2 + ronda),

				//Power Ups
				new Acelerador(new Random().nextInt(750), 430, 50, 50),
				new Inmunidad(new Random().nextInt(750), 400, 50, 50)
		};

		//Update
		Reset();
	}

	public void Update() {
		if(running) {

			//Time
			DecreseTime();
			
			//MovePlayers
			playerOne.Move();
			if(playerTwo != null) playerTwo.Move();

			//Plataformas
			for(Collisionable tt: collisionables) {
				tt.autoMove(); 
				if(tt instanceof StopPlace && !cantPlaces.contains(tt) && ((StopPlace)tt).isTrigger()) {
					cantPlaces.add((StopPlace)tt);
				}
				contStopPlaces = cantPlaces.size();
			}
		}
	}

	private void Reset() {
		//ChecWin
		cantPlaces = new ArrayList<StopPlace>();
		contStopPlaces = 0;

		//Objetos para dibujar
		playerOne.resetPosition();
		if(playerTwo != null)
			playerTwo.resetPosition();

		//Variables
		running = true;
		cont = 0;
	}

	private void nextRound() {

		for(Collisionable i: collisionables) {
			if(i instanceof Car) ((Car)i).setCurrentSpeed(((Car) i).getCurrentSpeed() + ronda);
			if(i instanceof Turtle) ((Turtle)i).setCurrentSpeed(((Turtle) i).getCurrentSpeed() + ronda);
			if(i instanceof Trunk) ((Trunk)i).setCurrentSpeed(((Trunk) i).getCurrentSpeed() + ronda);
		}

		Reset();
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
				time = 0;	
			}
			cont = 0;
		}
	}

	public void CheckWin() {
		if(ronda<=5) {
			if(contStopPlaces == 4) {
				ronda++;
				nextRound();
				for(Collisionable tt: collisionables) {
					if(tt instanceof StopPlace) {
						((StopPlace)tt).setSprite(Assets.stopPlace);
						((StopPlace)tt).setTrigger(false);
					}
				}
			}
		}
		else {
			System.out.print("Juego terminado");
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

	public static int getRonda() {
		return ronda;
	}

	public static void setRonda(int newRonda) {
		ronda = newRonda;
	}

	public static FroggerManager getInstance() {
		return instance;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public static Collisionable[] getCollisionables() {
		return collisionables;
	}

	public static void setCollisionables(Collisionable[] collisionables) {
		FroggerManager.collisionables = collisionables;
	}



}
