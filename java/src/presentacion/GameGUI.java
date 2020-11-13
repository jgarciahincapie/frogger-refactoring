package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aplicacion.EventosKeyboard;
import aplicacion.EventosKeyboard;
import aplicacion.FroggerManager;
import aplicacion.Player;
import aplicacion.Trunk;

public class GameGUI extends JFrame{
	
	private FroggerManager manager;
	private JPanel background = new JPanel();
	//To Draw
	private Player player1;
	private Trunk[] trunks;
	

	public GameGUI() {
		manager = new FroggerManager(0, this);
		addKeyListener(new EventosKeyboard());
		windowSettings();
		setVisible(true);
	}
	
	
	private void preapreElementosGraficos(){		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//Player
		g.drawImage(player1.getSprite(), player1.getX(), player1.getY(), 50, 50, null);
		
		//Trunks
		for(Trunk trunk: trunks) {
			//Corregir tronquitos
			g.drawImage(trunk.getSprite(), trunk.getX(), trunk.getY(), 100, 50, null);
		}
		
		//Scorer
		g.setColor(Color.white);
		g.drawString("Score: 0", 350, 550);
		Toolkit.getDefaultToolkit().sync();
		validate();
	}
	
	public void toDraw(Player player1, Trunk[] trunks) {
		this.player1 = player1; 
		this.trunks = trunks;
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
