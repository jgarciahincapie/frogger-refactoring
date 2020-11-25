package presentacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import aplicacion.*;

public class GameGUI extends JPanel{
	
	private FroggerManager manager;
	
	//To Draw
	private Player player1;
	private Trunk[] trunks;
	private Car[] cars;
	private StopPlace[] stopPlaces;
	private Turtle[] turtles;
	private River river;

	public GameGUI() {
		Assets.Start();
		manager = new FroggerManager(0, this);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
        super.paintComponent(g);
		//River && Street
		g.drawImage(river.getSprite(), river.getX(), river.getY(), river.getWidth(), river.getHeight(), null);
		g.drawImage(Assets.street, 0, 330, 800, 150, null);
		
		//Trunks
		for(Trunk trunk: trunks) {
			g.drawImage(trunk.getSprite(), trunk.getX(), trunk.getY(), trunk.getWidth(), trunk.getHeight(), null);
		}
		
		//Trunks
		for(Car car: cars) {
			g.drawImage(car.getSprite(), car.getX(), car.getY(), car.getWidth(), car.getHeight(), null);
		}
		
		//StopPLaces
		for(StopPlace sp: stopPlaces) {
			g.drawImage(sp.getSprite(), sp.getX(), sp.getY(), sp.getWidth(), sp.getHeight(), null);
		}
		
		for(Turtle tt: turtles) {
			g.drawImage(tt.getSprite(), tt.getX(), tt.getY(), tt.getWidth(), tt.getHeight(), null);
		}
		//Score & Time
		g.setColor(Color.white);
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.drawString("Score: " + manager.getScore(), 50, 565);
		g.setColor(Color.yellow);
		g.drawString("Time", 710, 565);
		g.setColor(Color.red);
		g.fillRect(700, 538, -300, 30);
		g.setColor(Color.green);
		g.fillRect(700, 538, -300 + manager.getTime(), 30);
		
		//Scenary
		g.drawImage(Assets.grass, 0, 480, 800, 50, null);
		g.drawImage(Assets.grass, 0, 280, 800, 50, null);
		g.drawImage(Assets.finalGrass, 0, -5, 800, 80, null);
	
		//Player
		g.drawImage(player1.getSprite(), player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight(), null);
		
		Toolkit.getDefaultToolkit().sync();
		
	}
	
	public void toDraw(Player player1, Trunk[] trunks, Car[] cars, StopPlace[] stopPlaces, Turtle[] turtles, River river) {
		this.player1 = player1; 
		this.trunks = trunks;
		this.cars = cars;
		this.stopPlaces = stopPlaces;
		this.turtles = turtles;
		this.river = river;
	} 
	
	public void windowSettings(JFrame jFrame) {
		setBackground(Color.black);
		setLayout(null);
		jFrame.setTitle("Frogger Game");
		jFrame.setSize(800,600);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.add(this);
		jFrame.addKeyListener(new EventosKeyboard());
		jFrame.validate();
		jFrame.dispose();
        jFrame.setVisible(true);
	}

}
