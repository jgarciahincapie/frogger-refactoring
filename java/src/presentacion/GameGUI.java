package presentacion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.*;
import aplicacion.*;

public class GameGUI extends JPanel{

	private FroggerManager manager;

	//To Draw
	private Player player1, player2;
	private Collisionable[] collisionables;
	private Collisionable girl;

	//Thread
	private Hilo hilo;

	public GameGUI(int mode, BufferedImage p1Sprite, BufferedImage p2Sprite, String[] machines) {
		Assets.Start();
		manager = new FroggerManager(mode, p1Sprite, p2Sprite);
		if(mode == 3) manager.setMachine2(machines[1]);
		else if(mode == 4) {
			manager.setMachine1(machines[0]);
			manager.setMachine2(machines[1]);
		}
		manager.Start();
		toDraw();
		hilo = new Hilo(manager, this);
		hilo.start();
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		if(manager.isRunning()) {        	
			g.drawImage(Assets.street, 0, 330, 800, 150, null);
			//Sprites
			for(Collisionable col: collisionables) {
				g.drawImage(col.getSprite(), col.getX(), col.getY(), col.getWidth(), col.getHeight(), null);
			}

			//Score & Time & Lives
			g.setColor(Color.white);
			g.setFont(new Font("Serif", Font.BOLD, 30));
			//PLayer1
			g.drawString("Score P1: " + player1.getScore(), 10, 565);
			g.drawString("Lives P1: " + player1.getLives(), 200, 565);
			g.drawString("Ronda: " + (manager.getRonda() +1), 500, 595);
			g.setColor(Color.yellow);
			g.drawString("Time", 710, 565);
			g.setColor(Color.red);
			g.fillRect(700, 538, -300, 30);
			g.setColor(Color.green);
			g.fillRect(700, 538, -300 + manager.getTime(), 30);

			//Scenary
			g.drawImage(Assets.finalGrass, 0, -5, 800, 80, null);

			//Players
			g.drawImage(player1.getSprite(), player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight(), null);
			if(player2 != null) {
				g.drawImage(player2.getSprite(), player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight(), null);
				g.setColor(Color.green);
				g.drawString("Score P2: " + player2.getScore(), 10, 595);
				g.drawString("Lives P2: " + player2.getLives(), 200, 595);
			}
			girl = manager.getFrogirl();
			if(girl != null)
				g.drawImage(girl.getSprite(), girl.getX(), girl.getY(), girl.getWidth(), girl.getHeight(), null);
		}

		//Game over
		else {
			g.setColor(Color.white);
			g.setFont(new Font("Serif", Font.BOLD, 30));
			g.drawString("Juego Terminado", 300, 80);

			if(manager.getMode() == 1) {        		

				g.drawImage(player1.getSprite(), 350, 250, 100, 100, null);
				g.drawString("Score: " + player1.getScore(), 340, 420);

			}
			else {
				//Player1
				g.drawImage(player1.getSprite(), 150, 300, 100, 100, null);
				g.drawString("Score: " + player1.getScore(), 150, 420);
				//Player2
				g.drawImage(player2.getSprite(), 550, 300, 100, 100, null); 
				g.drawString("Score: " + player2.getScore(), 550, 420);   		
			}

			GameOver();
		}

		Toolkit.getDefaultToolkit().sync();
	}

	public void GameOver() {
		try {
			hilo.stop();
	         String data = "\n";
	         if(player2 != null)
					data = ("Fecha: " + new Date().toGMTString() +"\n" +"Modo: " + manager.getMode() + "\n" +"Score Player 1: " + player1.getScore() + "\n" + "Score Player 2:" + player2.getScore() + "\n");
				else
					data = ("Fecha: " + new Date().toGMTString() + "\n" + new Date().getDay()+ "/" + new Date().getYear() + "\n" +"Modo: " + manager.getMode() + "\n" +"Score Player 1: " + player1.getScore() + "\n");

	         File f1 = new File("../../ScoresReg.txt");
	         if(!f1.exists()) {
	            f1.createNewFile();
	         }

	         FileWriter fileWritter = new FileWriter(f1.getName(),true);
	         BufferedWriter bw = new BufferedWriter(fileWritter);
	         bw.write(data);
	         bw.close();
	      } catch(IOException e){
	    	  JOptionPane pane = new JOptionPane();
	    	  pane.showMessageDialog(null, "Ocurrio un error guardando los datos");
	      }
	}
	
	public void toDraw() {
		player1 = manager.getPlayerOne();
		player2 = manager.getPlayerTwo();
		collisionables = manager.getCollisionables();
	} 

	public void windowSettings(JFrame jFrame) {
		setBackground(Color.black);
		setLayout(null);
		jFrame.setTitle("Frogger Game");
		jFrame.setSize(800,640);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.add(this);
		jFrame.addKeyListener(new EventosKeyboard());
		jFrame.validate();
		jFrame.dispose();
		jFrame.setVisible(true);
	}






	//Getters && setters
	public FroggerManager getManager() {
		return manager;
	}

	public void setManager(FroggerManager manager) {
		this.manager = manager;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Collisionable[] getCollisionables() {
		return collisionables;
	}

	public void setCollisionables(Collisionable[] collisionables) {
		this.collisionables = collisionables;
	}


}
