package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import presentacion.Assets;

public abstract class Player {

	protected BufferedImage sprite, original;	
	protected int x, y, posInicialX, posInicialY, width, height;
	protected double speedX, speedY;
	protected boolean isTrigger, isAlive, isRiding, isFlying, isToxic;
	protected int player, score, lives, timeInGrass;

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
		isFlying = false;
		resetPosition();
	}

	public abstract void Move();

	public abstract void OnCollisionEnter(Collisionable collision);

	public void resetPosition() {
		x = posInicialX;
		y = posInicialY;
		timeInGrass = 0;
		speedY = 50;
		isRiding = false;
		isFlying = false;
		this.sprite = original;
	}

	public abstract void makePoint();
	public abstract void Dead();

	public boolean Collision(Rectangle2D col1) {
		if(col1.intersects(getCollider())) {
			return true;
		}
		return false;
	}

	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x, y+10, width, height-20);
	}


	//Getters && Setters
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
