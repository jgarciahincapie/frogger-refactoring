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
	public static BufferedImage playerNormal;
	
	//Plataformas
	public static BufferedImage trunk;
	
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
			playerNormal = ImageIO.read(new File("Assets/Players/player.png"));
			trunk = ImageIO.read(new File("Assets/Platforms/trunk.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Ocurrio un error leyendo imagenes");
			System.exit(0);
		}
	}
}
