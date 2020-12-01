package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.security.sasl.SaslException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.GameSettings;

public class ChampSelection extends JPanel{

	private BufferedImage[] spritesPlayer;
	private GameGUI gameGUI;
	private JFrame instance;
	private int mode;
	//Seleccion de jugadores
	private int selectP1 = 0;
	private JLabel activeSpriteP1;
	private int selectP2 = 0;
	private JLabel activeSpriteP2;
	private JLabel playButton;

	public ChampSelection(JFrame jFrame, int mode) {
		this.mode = mode;
		spritesPlayer = new BufferedImage[] {Assets.playerNormal, Assets.playerToxic, Assets.playerErotic};
		activeSpriteP1 = new JLabel(new ImageIcon(spritesPlayer[selectP1]));
		activeSpriteP2 = new JLabel(new ImageIcon(spritesPlayer[selectP2]));
		playButton = new JLabel(new ImageIcon(Assets.playButton));
		instance = jFrame;
		setBackground(Color.black);
		setLayout(new GridLayout(2,1));
		setVisible(true);

		if(mode == 1) {
			mode1();
		}
		else if(mode == 2) {
			mode2();
		}
		else if(mode == 3) {

		}
		else if(mode == 4) {

		}
		else {
			System.out.println(mode);
		}
		instance.add(this);
	}

	public void mode1() {
		
		JLabel playButton = new JLabel(new ImageIcon(Assets.playButton));
		JPanel playerImg = new JPanel(new GridLayout(2,1));
		JLabel changePlayer = new JLabel(new ImageIcon(Assets.changeIcon));
		
		playerImg.setBackground(Color.black);
		
		//Paneles
		playerImg.add(activeSpriteP1);
		playerImg.add(changePlayer);
		add(playButton);
		add(playerImg);
		
		//Acciones
		playButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				GameGUI gameGUI = new GameGUI(1);
				gameGUI.windowSettings(instance);
				playerImg.setVisible(false);
				setVisible(false);
			}
		});
		changePlayer.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selectP1<=1) 					
					selectP1+=1;
				else
					selectP1 = 0;
				
				remove(playerImg);
				instance.repaint();
				activeSpriteP1 = new JLabel(new ImageIcon(spritesPlayer[selectP1]));
				playerImg.add(activeSpriteP1);
				add(playerImg);
			}
		});
	}
	
	public void mode2() {
		JLabel playButton = new JLabel(new ImageIcon(Assets.playButton));
		JPanel playerImg = new JPanel(new GridLayout(2,2));
		JLabel changePlayer1 = new JLabel(new ImageIcon(Assets.changeIcon));
		JLabel changePlayer2 = new JLabel(new ImageIcon(Assets.changeIcon));
		playerImg.setBackground(Color.black);
		
		//Paneles
		playerImg.add(activeSpriteP1);
		playerImg.add(activeSpriteP2);
		playerImg.add(changePlayer1);
		playerImg.add(changePlayer2);
		add(playButton);
		add(playerImg);
		
		//Acciones
				playButton.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						GameGUI gameGUI = new GameGUI(2);
						gameGUI.windowSettings(instance);
						playerImg.setVisible(false);
						setVisible(false);
					}
				});
		
	}
	
	public void mode3() {
		
	}
	
	public void mode4() {
	}
}
