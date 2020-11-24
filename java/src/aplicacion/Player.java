package aplicacion;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Player {
	
	private BufferedImage sprite;	
	private int x;
	private int y;
	private int width;
	private int height;
	private double speedY;
	private double speedX;
	private boolean isTrigger;
	private boolean isAlive;
	private boolean isRiding;

	public Player() {
		x = 380;
		y = 500;
		speedX = 15;
		speedY = 50;
		width = 50;
		height = 50;
		isTrigger = false;
		isAlive = true;
		isRiding = false;
		sprite = Assets.playerNormal;
	}
	
	public void Move() {		
		if(EventosKeyboard.up && getY() > 50){
			this.y -= speedY;
			EventosKeyboard.up = false;
		}
		else if(EventosKeyboard.down && getY() < 500) {
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
	
	public void Dead() {
		isTrigger = true;
		sprite = Assets.playerDead;
	}
	
	public void OnCollisionEnter(Collisionable collision) {
		if(collision.getTag() == "trunk" || collision.getTag() == "turtle") {
			setX((int)collision.getCollider().getCenterX() - getWidth()/2);
		}
		
		if(collision.getTag() == "car") {
			Dead();
		}
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

}
