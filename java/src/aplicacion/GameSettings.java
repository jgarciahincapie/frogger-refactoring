package aplicacion;

import java.awt.image.BufferedImage;

public class GameSettings {

	public static int mode;
	public static BufferedImage player1;
	public static BufferedImage player2;
	public static String machine1, machine2;

	public static int lives = 7;
	public static int dificultad = 0;
	
	public static GameSettings instance;
	
	public GameSettings() {
		if(instance == null) {
			instance = this;
		}
	}
	
	public static GameSettings getInstance() {
		return instance;
	}

	public static int getMode() {
		return mode;
	}

	public static void setMode(int mode) {
		GameSettings.mode = mode;
	}

	public static BufferedImage getPlayer1() {
		return player1;
	}

	public static void setPlayer1(BufferedImage player1) {
		GameSettings.player1 = player1;
	}

	public static BufferedImage getPlayer2() {
		return player2;
	}

	public static void setPlayer2(BufferedImage player2) {
		GameSettings.player2 = player2;
	}

	public static int getLives() {
		return lives;
	}

	public static void setLives(int lives) {
		GameSettings.lives = lives;
	}

	public static int getDificultad() {
		return dificultad;
	}

	public static void setDificultad(int dificultad) {
		GameSettings.dificultad = dificultad;
	}

	public static void setInstance(GameSettings instance) {
		GameSettings.instance = instance;
	}
	
	public static String getMachine1() {
		return machine1;
	}
	
	public static void setMachine1(String machine1) {
		GameSettings.machine1 = machine1;
	}
	
	public static String getMachine2() {
		return machine2;
	}
	
	public static void setMachine2(String machine2) {
		GameSettings.machine2 = machine2;
	}
}
