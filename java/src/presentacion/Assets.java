package presentacion;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Assets {

	//Menu principal
	public static BufferedImage titleImg;
	public static BufferedImage playButton;
	public static BufferedImage pvpButton;
	public static BufferedImage pviaButton;
	public static BufferedImage iaviaButton;
	public static BufferedImage froggy;
	public static BufferedImage changeIcon;
	
	//Player
	public static BufferedImage playerNormal;
	public static BufferedImage playerDead;
	public static BufferedImage playerToxic;
	public static BufferedImage playerErotic;
	
	//Plataformas
	public static BufferedImage trunk;
	public static BufferedImage grass;
	public static BufferedImage finalGrass;
	public static BufferedImage stopPlace;
	public static BufferedImage river;
	public static BufferedImage street;
	
	//Cars
	public static BufferedImage carYellow;
	public static BufferedImage carGreen;
	public static BufferedImage carBlue;
	public static BufferedImage truck1;
	public static BufferedImage truck2;
	
	//Animals
	public static BufferedImage turtleIdle;
	
	public static void Start(){
		try {
			//UI
			titleImg = ImageIO.read(new File("Assets/UI/Frogger-Logo.png"));
			froggy = ImageIO.read(new File("Assets/UI/Froggy.png"));
			playButton = ImageIO.read(new File("Assets/UI/jugar.png"));
			pvpButton = ImageIO.read(new File("Assets/UI/pvp.png"));
			pviaButton = ImageIO.read(new File("Assets/UI/pvia.png"));
			iaviaButton = ImageIO.read(new File("Assets/UI/iavia.png"));
			changeIcon = ImageIO.read(new File("Assets/UI/exchange.png"));
			
			//Game
			trunk = ImageIO.read(new File("Assets/Platforms/trunk.png"));
			grass = ImageIO.read(new File("Assets/Platforms/grass.png"));
			finalGrass = ImageIO.read(new File("Assets/Platforms/finalGrass.png"));
			stopPlace = ImageIO.read(new File("Assets/Platforms/stopPlace.png"));
			river = ImageIO.read(new File("Assets/UI/river.png"));
			street = ImageIO.read(new File("Assets/Platforms/carretera.png"));
			
			//Cars
			carYellow = ImageIO.read(new File("Assets/Cars/carYellow.png"));
			carGreen = ImageIO.read(new File("Assets/Cars/carGreen.png"));
			carBlue = ImageIO.read(new File("Assets/Cars/carBlue.png"));
			truck1 = ImageIO.read(new File("Assets/Cars/truck1.png"));
			truck2 = ImageIO.read(new File("Assets/Cars/truck2.png"));
			
			//Animals
			turtleIdle = ImageIO.read(new File("Assets/Animals/trutleErotic.png"));
			
			//Player
			playerNormal = ImageIO.read(new File("Assets/Players/frog0.png"));
			playerToxic = ImageIO.read(new File("Assets/Players/frogToxic.png"));
			playerErotic = ImageIO.read(new File("Assets/Players/frogUnique.png"));
			playerDead = ImageIO.read(new File("Assets/Players/frogX.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Ocurrio un error leyendo imagenes");
			System.exit(0);
		}
	}
}
