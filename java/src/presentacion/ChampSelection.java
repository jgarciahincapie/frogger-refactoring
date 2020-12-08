package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
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
	private String[] machines;
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
		spritesPlayer = new BufferedImage[] {Assets.playerNormal, Assets.playerSexy, Assets.playerErotic};
		machines = new String[] {"Irreflexiva", "Temeraria", "Precavida"};
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
			mode3();
		}
		else if(mode == 4) {
			mode4();
		}
		else {
			System.out.println(mode);
		}
		instance.add(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("Serif", Font.BOLD, 30));
	
		if(mode == 1) {
			g.drawImage(spritesPlayer[selectP1], 350, 250, 100, 100, null);
		}
		else if(mode == 2){
			g.drawImage(spritesPlayer[selectP1], 200, 250, 100, 100, null);
			g.drawImage(spritesPlayer[selectP2], 450, 250, 100, 100, null);
			
		}
		else if(mode == 3) {
			g.drawImage(spritesPlayer[selectP1], 200, 250, 100, 100, null);
			g.drawImage(spritesPlayer[selectP2], 450, 250, 100, 100, null);
			//Machines
			g.drawString(machines[selectP2], 450, 240);
		}
		else if(mode == 4) {
			g.drawImage(spritesPlayer[selectP1], 200, 250, 100, 100, null);
			g.drawImage(spritesPlayer[selectP2], 450, 250, 100, 100, null);
			//Machines
			g.drawString(machines[selectP1], 200, 240);
			g.drawString(machines[selectP2], 450, 240);
		}
	}

	public void mode1() {
		
		JLabel playButton = new JLabel(new ImageIcon(Assets.playButton));
		JLabel changePlayer = new JLabel(new ImageIcon(Assets.changeIcon));
		add(playButton);
		add(changePlayer);
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
				JugarModo1(1, selectP1);
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
				
				repaint();
			}
		});
	}
	
	public void mode2() {
		JLabel playButton = new JLabel(new ImageIcon(Assets.playButton));
		JLabel changePlayer1 = new JLabel(new ImageIcon(Assets.changeIcon));
		JLabel changePlayer2 = new JLabel(new ImageIcon(Assets.changeIcon));
		JPanel titleJPanel = new JPanel(new BorderLayout());
		titleJPanel.setOpaque(false);
		JPanel buttosJPanel = new JPanel(new GridLayout(1,2));
		buttosJPanel.setOpaque(false);
		setBackground(Color.black);
		setLayout(new GridLayout(2,1));
		titleJPanel.add(playButton);
		buttosJPanel.add(changePlayer1);
		buttosJPanel.add(changePlayer2);
		add(titleJPanel);
		add(buttosJPanel);
		
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
						JugarModo2(2, selectP1, selectP2);
					}
				});

		changePlayer1.addMouseListener(new MouseListener() {
			
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
				
				repaint();
				
			}
		});
		changePlayer2.addMouseListener(new MouseListener() {
			
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
				if(selectP2<=1) 					
					selectP2+=1;
				else
					selectP2 = 0;
				
				repaint();
				
			}
		});
	}
	
	public void mode3() {
		JLabel playButton = new JLabel(new ImageIcon(Assets.playButton));
		JLabel changePlayer1 = new JLabel(new ImageIcon(Assets.changeIcon));
		JLabel changePlayer2 = new JLabel(new ImageIcon(Assets.changeIcon));
		JPanel titleJPanel = new JPanel(new BorderLayout());
		titleJPanel.setOpaque(false);
		JPanel buttosJPanel = new JPanel(new GridLayout(1,2));
		buttosJPanel.setOpaque(false);
		setBackground(Color.black);
		setLayout(new GridLayout(2,1));
		titleJPanel.add(playButton);
		buttosJPanel.add(changePlayer1);
		buttosJPanel.add(changePlayer2);
		add(titleJPanel);
		add(buttosJPanel);
		
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
						JugarModo2(3, selectP1, selectP2);
					}
				});

		changePlayer1.addMouseListener(new MouseListener() {
			
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
				
				repaint();
				
			}
		});
		changePlayer2.addMouseListener(new MouseListener() {
			
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
				if(selectP2<=1) 					
					selectP2+=1;
				else
					selectP2 = 0;
				
				repaint();
				
			}
		});
	}
	
	public void mode4() {
		
		JLabel playButton = new JLabel(new ImageIcon(Assets.playButton));
		JLabel changePlayer1 = new JLabel(new ImageIcon(Assets.changeIcon));
		JLabel changePlayer2 = new JLabel(new ImageIcon(Assets.changeIcon));
		JPanel titleJPanel = new JPanel(new BorderLayout());
		titleJPanel.setOpaque(false);
		JPanel buttosJPanel = new JPanel(new GridLayout(1,2));
		buttosJPanel.setOpaque(false);
		setBackground(Color.black);
		setLayout(new GridLayout(2,1));
		titleJPanel.add(playButton);
		buttosJPanel.add(changePlayer1);
		buttosJPanel.add(changePlayer2);
		add(titleJPanel);
		add(buttosJPanel);
		
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
						JugarModo2(4, selectP1, selectP2);
					}
				});

		changePlayer1.addMouseListener(new MouseListener() {
			
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
				
				repaint();
				
			}
		});
		changePlayer2.addMouseListener(new MouseListener() {
			
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
				if(selectP2<=1) 					
					selectP2+=1;
				else
					selectP2 = 0;
				
				repaint();
				
			}
		});
	}
	
	
	public GameGUI JugarModo1(int mode, int selectP1) {
		GameGUI gameGUI = new GameGUI(mode, spritesPlayer[selectP1], null, null);
		gameGUI.windowSettings(instance);
		setVisible(false);
		return gameGUI;
	}
	
	public GameGUI JugarModo2(int mode, int selectP1, int selectP2) {
		GameGUI gameGUI = new GameGUI(mode, spritesPlayer[selectP1], spritesPlayer[selectP2], new String[] {machines[selectP1], machines[selectP2]});
		gameGUI.windowSettings(instance);
		setVisible(false);
		return gameGUI;
	}
}
