package presentacion;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import aplicacion.*;

public class GameGUI extends JFrame{
	
	private FroggerManager manager;
	private JPanel background = new JPanel();
	
	//To Draw
	private Player player1;
	private Trunk[] trunks;
	private Car[] cars;
	private StopPlace[] stopPlaces;
	private Turtle[] turtles;

	public GameGUI() {
		Assets.Start();
		manager = new FroggerManager(0, this);
		addKeyListener(new EventosKeyboard());
		windowSettings();
		setVisible(true);
	}
	
	
	private void preapreElementosGraficos() {
		
	}
	
	@Override
	public void paint(Graphics g) {		
		super.paintComponents(g);
		
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
		g.drawString("Score: " + manager.getScore(), 50, 585);
		g.setColor(Color.yellow);
		g.drawString("Time", 710, 585);
		g.setColor(Color.red);
		g.fillRect(700, 560, -300, 30);
		g.setColor(Color.green);
		g.fillRect(700, 560, -300 + manager.getTime(), 30);
		
		//Scenary
		g.drawImage(Assets.grass, 0, 500, 800, 50, null);
		g.drawImage(Assets.grass, 0, 300, 800, 50, null);
		g.drawImage(Assets.finalGrass, 0, 20, 800, 80, null);
	
		//Player
		g.drawImage(player1.getSprite(), player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight(), null);
		
		Toolkit.getDefaultToolkit().sync();
		validate();
	}
	
	public void toDraw(Player player1, Trunk[] trunks, Car[] cars, StopPlace[] stopPlaces, Turtle[] turtles) {
		this.player1 = player1; 
		this.trunks = trunks;
		this.cars = cars;
		this.stopPlaces = stopPlaces;
		this.turtles = turtles;
	} 
	
	private void windowSettings() {
		setTitle("Frogger Game");
		setSize(800,600);
		background.setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(background);
		setResizable(false);
	}

}
