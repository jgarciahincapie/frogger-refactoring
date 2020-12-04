package aplicacion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

import presentacion.Assets;
import presentacion.ChampSelection;
import presentacion.FroggerGUI;
import presentacion.GameGUI;

public class FroggerManagertTest {
	
	FroggerGUI frogguerGUI;
	ChampSelection champSelection;
	GameGUI gameGui;
	
	@Before
	public void crearJuego() {
		frogguerGUI = new FroggerGUI();
	}

	@Test
	public void deberiaCrearUnNuevoJuego() {
		assertFalse(frogguerGUI == null);
	}
	
	@Test
	public void deberiaEjecutarLaPantallaDeSeleccionDeJugador() {
		champSelection = frogguerGUI.AbrirSeleccionChamps(1);
		assertTrue(champSelection != null);
	}
	
	@Test
	public void deberiaCrearLaPantallaDelJuegoConUnJugador() {
		gameGui = new GameGUI(1, Assets.playerToxic, null);
		assertTrue(gameGui != null);
	}
	
	@Test
	public void deberiaCrearLaPantallaDelJuegoConDosJugadores() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		assertTrue(gameGui != null);
	}
	
	@Test
	public void deberiaInstanciarUnNuevoJugadorAlIniciarElJuegoEnModo1() {
		gameGui = new GameGUI(1, Assets.playerToxic, null);
		Player player = gameGui.getPlayer1();
		assertTrue(player != null);
	}
	
	@Test
	public void deberiaInstanciarDosNuevosJugadoresAlIniciarElJuegoEnModo2() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Player player = gameGui.getPlayer1();
		Player player2 = gameGui.getPlayer2();
		assertTrue(player != null && player2 != null);
	}
	
	@Test
	public void elJuegoDeberiaPreapararLosElementosGraficosParaMostrarEnPantalla() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Collisionable[] itemsCollisionables = gameGui.getCollisionables();
		assertTrue(itemsCollisionables.length >0);
	}
	
	@Test
	public void elJugadorDeberiaMoverseHaciaElNorte() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Player player = gameGui.getPlayer1();
		int lastY = player.getY();
		EventosKeyboard.up = true;
		player.Move();
		int nextY = player.getY();
		
		assertFalse(lastY == nextY);
	}
	
	@Test
	public void elJugadorDeberiaMoverseHaciaElSur() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Player player = gameGui.getPlayer1();
		player.setY(400);
		int lastY = player.getY();
		EventosKeyboard.down = true;
		player.Move();
		int nextY = player.getY();
		
		assertFalse(lastY == nextY);
	}
	
	@Test
	public void elJugadorDeberiaMoverseHaciaElEste() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Player player = gameGui.getPlayer1();
		int lastX = player.getX();
		EventosKeyboard.rigth = true;
		player.Move();
		int nextX = player.getX();
		
		assertFalse(lastX == nextX);
	}
	
	@Test
	public void elJugadorDeberiaMoverseHaciaElOeste() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Player player = gameGui.getPlayer1();
		int lastX = player.getX();
		EventosKeyboard.left = true;
		player.Move();
		int nextX = player.getX();
		
		assertFalse(lastX == nextX);
	}
	
	@Test
	public void elJugadorDeberiaMorir() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Player player = gameGui.getPlayer1();
		int lives = player.getLives();
		player.Dead();
		int nextLives = player.getLives();
		
		assertFalse(lives == nextLives);
	}
	
	@Test
	public void elJugadorDeberiaReiniciarSuPosicionEnX() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Player player = gameGui.getPlayer1();
		int lastX = player.getX();
		EventosKeyboard.left = true;
		player.Move();
		EventosKeyboard.left = false;
		player.resetPosition();
		int nextX = player.getX();
		
		assertTrue(lastX == nextX);
	}
	
	@Test
	public void elJugadorDeberiaReiniciarSuPosicionEnY() {
		gameGui = new GameGUI(2, Assets.playerToxic, Assets.playerErotic);
		Player player = gameGui.getPlayer1();
		int lastY = player.getY();
		EventosKeyboard.left = true;
		player.Move();
		EventosKeyboard.left = false;
		player.resetPosition();
		int nextY = player.getY();
		
		assertTrue(lastY == nextY);
	}

}
