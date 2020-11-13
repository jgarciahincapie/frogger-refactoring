package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.glass.events.MouseEvent;
import com.sun.xml.internal.ws.api.server.Container;
import com.sun.xml.internal.ws.wsdl.ActionBasedOperationSignature;

import javafx.scene.layout.Border;

public class FroggerGUI extends JFrame{
	
	private JPanel container = new JPanel(new BorderLayout());
	private JLabel title = new JLabel("FROGGER");
	private JLabel[] froggys;
	private JLabel[] buttons;
	
	public static void main(String[] args) {
		FroggerGUI froggerGUI = new FroggerGUI();
	}

	public FroggerGUI() {
		Assets.Start();
		
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
	
	private void setUpButtons() {
				
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
				GameGUI gameGUI = new GameGUI();
			}
		});
		//2 jugadores
	}
}