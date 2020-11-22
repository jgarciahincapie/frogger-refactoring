package presentacion;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.sun.istack.internal.FinalArrayList;

public class Assets {

	//Menu principal
	public static BufferedImage titleImg;
	public static BufferedImage playButton;
	public static BufferedImage pvpButton;
	public static BufferedImage pviaButton;
	public static BufferedImage iaviaButton;
	public static BufferedImage froggy;
	
	//Player
	public static BufferedImage playerNormal;
	public static BufferedImage playerDead;
	
	//Plataformas
	public static BufferedImage trunk;
	public static BufferedImage grass;
	public static BufferedImage finalGrass;
	public static BufferedImage stopPlace;
	
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
			
			//Game
			trunk = ImageIO.read(new File("Assets/Platforms/trunk.png"));
			grass = ImageIO.read(new File("Assets/Platforms/grass.png"));
			finalGrass = ImageIO.read(new File("Assets/Platforms/finalGrass.png"));
			stopPlace = ImageIO.read(new File("Assets/Platforms/stopPlace.png"));
			
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
			playerDead = ImageIO.read(new File("Assets/Players/frogX.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Ocurrio un error leyendo imagenes");
			System.exit(0);
		}
	}
}
