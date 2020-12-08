package presentacion;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
	public static BufferedImage froGirl;
	public static BufferedImage playerSexy;
	
	//Plataformas
	public static BufferedImage trunk;
	public static BufferedImage grass;
	public static BufferedImage finalGrass;
	public static BufferedImage stopPlace;
	public static BufferedImage river;
	public static BufferedImage street;
	public static BufferedImage puddle;
	
	
	//Cars
	public static BufferedImage carYellow;
	public static BufferedImage carGreen;
	public static BufferedImage carBlue;
	public static BufferedImage truck1;
	public static BufferedImage truck2;
	public static BufferedImage bikePro;
	public static BufferedImage bikeNoob;
	public static BufferedImage carreta;
	
	//Animals
	public static BufferedImage turtleIdle;
	public static BufferedImage turtleInit;
	public static BufferedImage turtleMid;
	public static BufferedImage cocodrille;
	public static BufferedImage insect;
	public static BufferedImage snake;
	
	//PowerUps
	public static BufferedImage thunder;
	public static BufferedImage caparason;
	public static BufferedImage wings;
	public static BufferedImage flask;
	
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
			puddle = ImageIO.read(new File("Assets/Platforms/puddle.png"));
			
			//Cars
			carYellow = ImageIO.read(new File("Assets/Cars/carYellow.png"));
			carGreen = ImageIO.read(new File("Assets/Cars/carGreen.png"));
			carBlue = ImageIO.read(new File("Assets/Cars/carBlue.png"));
			truck1 = ImageIO.read(new File("Assets/Cars/truck1.png"));
			truck2 = ImageIO.read(new File("Assets/Cars/truck2.png"));
			bikePro = ImageIO.read(new File("Assets/Cars/bikerPro.png"));
			bikeNoob = ImageIO.read(new File("Assets/Cars/bikerNoob.png"));
			carreta = ImageIO.read(new File("Assets/Cars/carreta.png"));
			
			//Animals
			turtleIdle = ImageIO.read(new File("Assets/Animals/trutleErotic.png"));
			turtleMid= ImageIO.read(new File("Assets/Animals/turtleMid.png"));
			turtleInit = ImageIO.read(new File("Assets/Animals/turtleInit.png"));
			cocodrille = ImageIO.read(new File("Assets/Animals/cocodrille.png"));
			insect = ImageIO.read(new File("Assets/Animals/insect.png"));
			snake = ImageIO.read(new File("Assets/Animals/snake.png"));
			
			//Player
			playerNormal = ImageIO.read(new File("Assets/Players/frog0.png"));
			playerToxic = ImageIO.read(new File("Assets/Players/frogToxic.png"));
			playerErotic = ImageIO.read(new File("Assets/Players/frogUnique.png"));
			playerDead = ImageIO.read(new File("Assets/Players/frogX.png"));
			froggy = ImageIO.read(new File("Assets/Players/frogX.png"));
			froGirl= ImageIO.read(new File("Assets/Players/frogChica0.png"));
			playerSexy = ImageIO.read(new File("Assets/Players/frogSexy.png"));
			
			//PowerUPs
			thunder = ImageIO.read(new File("Assets/PowerUps/trueno.png"));
			caparason = ImageIO.read(new File("Assets/PowerUps/caparason.png"));
			wings = ImageIO.read(new File("Assets/PowerUps/wings.png"));
			flask = ImageIO.read(new File("Assets/PowerUps/flask.png"));
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error leyendo los recursos");
			System.exit(0);
		}
	}
}
