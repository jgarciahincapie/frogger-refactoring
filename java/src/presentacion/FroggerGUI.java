package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import aplicacion.GameSettings;

public class FroggerGUI extends JFrame{
	
	private JPanel container = new JPanel(new BorderLayout());
	private JLabel title = new JLabel("FROGGER");
	private JLabel[] froggys;
	private JLabel[] buttons;
	private JFrame instance;
	
	public static void main(String[] args) {
		FroggerGUI froggerGUI = new FroggerGUI();
	}

	public FroggerGUI() {
		Assets.Start();
		instance = this;
		//JFrame
		setName("Frogger ");
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Container Jpanel
		froggys = new JLabel[] {new JLabel(new ImageIcon(Assets.froggy)), new JLabel(new ImageIcon(Assets.froggy)), new JLabel(new ImageIcon(Assets.froggy))};
		buttons = new JLabel[]{new JLabel(new ImageIcon(Assets.playButton)), new JLabel(new ImageIcon(Assets.pvpButton)), new JLabel(new ImageIcon(Assets.pviaButton)), new JLabel(new ImageIcon(Assets.iaviaButton))};
		elementosMenuPrincipal();
		
		//Settings
		actionsButtons();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void elementosMenuPrincipal() {
		container.setBackground(Color.black);
		setUpTitle();
		
		//Buttons
		JPanel buttonsPanel = new JPanel(new GridLayout(3, 1));
		buttonsPanel.setBackground(Color.black);
		for(JLabel label: buttons) {
			buttonsPanel.add(label);
		}
		container.add(buttonsPanel);
		
		//Decoracion
		for(JLabel label: froggys) {
			label.setPreferredSize(new Dimension(50,50));
			buttonsPanel.add(label);
		}
		container.add(froggys[2], BorderLayout.SOUTH);
		
		add(container);
	}
	
	private void setUpTitle() {
		title = new JLabel(new ImageIcon(Assets.titleImg));
		container.add(title, BorderLayout.NORTH);
	}
	
	private void actionsButtons() {
		
		//1 jugador
		buttons[0].addMouseListener(new MouseListener() {

			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				ChampSelection champSelection = new ChampSelection(instance, 1);
				GameSettings gs = new GameSettings();
				gs.setMode(1);
				container.setVisible(false);
			}
		});
		//2 jugadores
		buttons[1].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				ChampSelection champSelection = new ChampSelection(instance, 2);
				GameSettings gs = new GameSettings();
				gs.setMode(2);
				container.setVisible(false);
			}
		});
		//pvIA
		buttons[2].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				ChampSelection champSelection = new ChampSelection(instance,3);
				GameSettings gs = new GameSettings();
				gs.setMode(3);
				container.setVisible(false);
			}
		});
		//IavIA
		buttons[3].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				ChampSelection champSelection = new ChampSelection(instance,4);
				GameSettings gs = new GameSettings();
				gs.setMode(4);
				container.setVisible(false);
			}
		});
	}
}