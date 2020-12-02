package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import com.sun.corba.se.pept.transport.ContactInfo;

import javafx.scene.shape.TriangleMesh;
import presentacion.Assets;

public class Player {
	
	private BufferedImage sprite, original;	
	private int x, posInicialX;
	private int y, posInicialY;
	private int width;
	private int height;
	private double speedY;
	private double speedX;
	private boolean isTrigger;
	private boolean isAlive;
	private boolean isRiding;
	private int player;
	private int score;
	private int lives;
	private int timeInGrass;

	public Player(int x, int y, int player, BufferedImage sprite) {
		posInicialX = x;
		posInicialY = y;
		this.x = x;
		this.y = y;
		speedX = 15;
		speedY = 50;
		width = 50;
		height = 50;
		lives = 7;
		score = 0;
		this.original = sprite;
		this.player = player;
		isTrigger = false;
		isAlive = true;
		isRiding = false;
		resetPosition();
	}
	
	public void Move() {
		if(player == 1) {			
			if(EventosKeyboard.up && getY() > 50){
				this.score +=10;
				this.y -= speedY;
				EventosKeyboard.up = false;
			}
			else if(EventosKeyboard.down && getY() < 450) {
				this.y += speedY;
				EventosKeyboard.down = false;
			}
			else if(EventosKeyboard.left && getX() > 25) {
				this.x -= speedX;
				EventosKeyboard.left = false;
			}
			else if(EventosKeyboard.rigth && getX() < 730) {
				this.x += speedX;
				EventosKeyboard.rigth = false;
			}
		}
		else if(player == 2) {
			if(EventosKeyboard.upArrow && getY() > 50){
				this.score +=10;
				this.y -= speedY;
				EventosKeyboard.upArrow = false;
			}
			else if(EventosKeyboard.downArrow && getY() < 450) {
				this.y += speedY;
				EventosKeyboard.downArrow = false;
			}
			else if(EventosKeyboard.leftArrow && getX() > 25) {
				this.x -= speedX;
				EventosKeyboard.leftArrow = false;
			}
			else if(EventosKeyboard.rigthArrow && getX() < 730) {
				this.x += speedX;
				EventosKeyboard.rigthArrow = false;
			}
		}
		
		for(Collisionable i: FroggerManager.collisionables) {
			if(Collision(i.getCollider())) {				
				OnCollisionEnter(i);
			}
		}
	}
	
	public void OnCollisionEnter(Collisionable collision) {
		
		if(collision.getTag() == "trunk" || collision.getTag() == "turtle") {
			setX((int)collision.getCollider().getCenterX() - getWidth()/2);
		}
		
		else if(collision.getTag() == "car") {
			Dead();
		}
				
		else if(collision.getTag() == "finalStop") {
			((StopPlace)collision).setSprite(Assets.froggy);
			if(!((StopPlace)collision).isTrigger())
				makePoint();
			((StopPlace)collision).setTrigger(true);
		}
		else if (collision.getTag() == "grass" && !isTrigger) {
			timeInGrass ++;
			if(timeInGrass >=1000) {
				Dead();
				timeInGrass = 0;
			}
		}
		//Power ups
		else if (collision.getTag() == "speedMax") {
			if(!((PowerUp)collision).isTrigger()) {
				setSpeedY(100);				
				((PowerUp)collision).ActivatePower();
			}
		}
	}
	
	public void resetPosition() {
		x = posInicialX;
		y = posInicialY;
		timeInGrass = 0;
		speedY = 50;
		isRiding = false;
		this.sprite = original;
	}

	private void makePoint() {
		this.score +=50;
		FroggerManager.getInstance().CheckWin();
		resetPosition();
	}
	
	public void Dead() {
		isTrigger = true;
		sprite = Assets.playerDead;
		lives--;
		try {
			Hilo.getInstance().join(1000);
			resetPosition();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private boolean Collision(Rectangle2D col1) {
		if(col1.intersects(getCollider())) {
			return true;
		}
		return false;
	}
	
	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x, y, width, height);
	}

	
	public boolean isRiding() {
		return isRiding;
	}

	public void setRiding(boolean isRiding) {
		this.isRiding = isRiding;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	public BufferedImage getSprite(){
		return this.sprite;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public boolean isTrigger() {
		return isTrigger;
	}

	public void setTrigger(boolean isTrigger) {
		this.isTrigger = isTrigger;
	}
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	

}
