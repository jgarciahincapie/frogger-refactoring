package aplicacion;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import presentacion.Assets;

public class FroggerManager {

	//Instancias
	public static FroggerManager instance;

	//Game
	private Player playerOne;
	private Player playerTwo;
	private String machine1, machine2;
	private Collisionable frogirl;
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
	
	public FroggerManager(int mode, BufferedImage p1Sprite, BufferedImage p2Sprite){
		if(instance == null) instance = this;

		this.mode = mode;
		this.p1Sprite = p1Sprite;
		this.p2Sprite = p2Sprite;		
		ronda = 0;
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
		//Machine 2
		if(machine2 == "Irreflexiva")
			playerTwo = new MachineIrreflexive(520, 480, 2, p2Sprite);
		else if(machine2 == "Temeraria")
			playerTwo = new MachineBrave(520, 480, 2, p2Sprite);
		else if(machine2 == "Precavida")
			playerTwo = new MachineCaution(520, 480, 2, p2Sprite);
	}
	
	private void GameMode4() {
		//Machine 1
		if(machine1 == "Irreflexiva")
			playerOne = new MachineIrreflexive(260, 480, 1, p1Sprite);
		else if(machine1 == "Temeraria")
			playerOne = new MachineBrave(260, 480, 1, p1Sprite);
		else if(machine1 == "Precavida")
			playerOne = new MachineCaution(260, 480, 1, p1Sprite);
		
		//Machine 2
		if(machine2 == "Irreflexiva")
			playerTwo = new MachineIrreflexive(520, 480, 2, p2Sprite);
		else if(machine2 == "Temeraria")
			playerTwo = new MachineBrave(520, 480, 2, p2Sprite);
		else if(machine2 == "Precavida")
			playerTwo = new MachineCaution(520, 480, 2, p2Sprite);
	}

	//Instancia una unica vez
	public void Start() {

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
				new Trunk(false, 0, 175, 170, 50, 2 + ronda), 
				new Trunk(false, -300, 175, 170, 50, 2 + ronda), 
				new Trunk(false, -600, 175, 170, 50, 2 + ronda),
				//Largos superiores
				new Trunk(true, 900, 75, 170, 50, 1 + ronda), 
				new Trunk(true, 300, 75, 170, 50, 1 + ronda), 
				new Trunk(true, 600, 75, 170, 50, 1 + ronda),
				//Medianos
				new Trunk(false, -100, 225, 100, 50, 1 + ronda), 
				new Trunk(false, -300, 225, 100, 50, 1 + ronda), 
				new Trunk(false, -500, 225, 100, 50, 1 + ronda), 
				//Pequeños
				new Trunk(false, -650, 225, 50, 50, 1 + ronda), 
				new Trunk(false, -800, 225, 50, 50, 1 + ronda),

				//Cars
				//Inferiores
				new MotorCycle(false, -600, 430, 80, 50, 1 + ronda),
				new Car(false, -750, 430, 1 + ronda), 
				new MotorCycle(false, 900, 430, 80, 50, 1 + ronda), 
				//Medios
				new Biker(false, -350, 380, 80, 50, 2 + ronda),
				new Car(false, -600, 380, 2 + ronda), 
				new Car(false, 0, 380, 2 + ronda),
				//Superiores
				new MotorCycle(false, -300, 330, 80, 50, 3 + ronda),
				new Car(false, -600, 330, 3 + ronda), 
				new Carreta(false, -900, 330, 80, 50, 3 + ronda),

				//Grupo 1
				new Turtle(true, 0, 125, 2 + ronda),
				new Turtle(true, 50, 125, 2 + ronda), 
				new Turtle(true, 100, 125, 2 + ronda),
				//Grupo 2
				new Turtle(true, 300, 125, 2 + ronda), 
				new Turtle(true, 350, 125, 2 + ronda),
				//Grupo 3
				new Turtle(true, 550, 125, 2 + ronda), 
				new Turtle(true, 600, 125, 2 + ronda), 
				new Turtle(true, 650, 125, 2 + ronda), 
				//Grupo 4
				new Turtle(true, 950, 125, 2 + ronda), 
				new Turtle(true, 1000, 125, 2 + ronda),

				//Power Ups
				new Acelerador(new Random().nextInt(750), 480, 50, 50),
				new Acelerador(new Random().nextInt(750), 155, 50, 50),
				new Inmunidad(new Random().nextInt(750), 480, 50, 50),
				new Fly(new Random().nextInt(750), 280, 50, 50),
				new Toxicity(new Random().nextInt(750), 115, 50, 50),
				new Puddle(new Random().nextInt(750), 280, 50, 50),
				new Puddle(new Random().nextInt(750), 280, 50, 50),
				
				//Girl
				new Frogirl(380, 280, 50, 50)
		};
		
		if(mode == 1)
			GameMode1();
		else if(mode == 2)
			GameMode2();
		else if(mode == 3)
			GameMode3();
		else if(mode == 4)
			GameMode4();
		
		//Update
		Reset();
	}

	public void Update() {
		if(running) {

			//Time
			DecreseTime();
			//frogirl
			if(time>=16 && !((Frogirl)frogirl).isSafe()) {		
				((Frogirl)frogirl).Show();
			}
			
			//MovePlayers
			playerOne.Move();
			playerOne.CheckWater();
			if(playerTwo != null) {					
				//Lives System
				if(playerTwo.getLives() <= 0)
					running = false;
				else {
					playerTwo.Move();
					playerTwo.CheckWater();
				}
			}
						
			//Lives
			if(playerOne.getLives() <= 0) {
				running = false;
			}
			

			//Plataformas
			for(Collisionable tt: collisionables) {
				tt.autoMove(); 
				if(tt instanceof StopPlace && !cantPlaces.contains(tt) && ((StopPlace)tt).isTrigger()) {
					cantPlaces.add((StopPlace)tt);
				}
				contStopPlaces = cantPlaces.size();
				
				//Animaciones
				if(tt instanceof StopPlace)
					((StopPlace)tt).Animation();
			}
		}
	}

	private void Reset() {
		//ChecWin
		cantPlaces = new ArrayList<StopPlace>();
		contStopPlaces = 0;

		//Objetos para dibujar
		playerOne.resetPosition();
		frogirl = collisionables[collisionables.length -1];
		if(playerTwo != null)
			playerTwo.resetPosition();

		//Variables
		running = true;
		cont = 0;
		frogirl = collisionables[collisionables.length -1];
	}

	private void nextRound() {

		for(Collisionable i: collisionables) {
			if(i instanceof Platform) ((Platform)i).setCurrentSpeed((int)((Platform)i).getcurrentSpeed() + ronda);
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
				running = false;	
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
			running = false;
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

	public Collisionable getFrogirl() {
		return frogirl;
	}

	public void setFrogirl(Collisionable frogirl) {
		this.frogirl = frogirl;
	}
	
	public String getMachine1() {
		return machine1;
	}

	public void setMachine1(String machine1) {
		this.machine1 = machine1;
	}

	public String getMachine2() {
		return machine2;
	}

	public void setMachine2(String machine2) {
		this.machine2 = machine2;
	}

}
