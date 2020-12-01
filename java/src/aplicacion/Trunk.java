package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Trunk extends Collisionable implements Platform{
	
	private boolean left;
	private int x;
	private int y;
	private int width;
	private int height;
	private double currentSpeed;
	private BufferedImage sprite;
	
	private boolean isTrigger = false;

	public Trunk(boolean left, int x, int y, int width, int height,double speed) {
		super("trunk", x, y, width, 50);
		this.sprite = Assets.trunk;
		this.left = left;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.currentSpeed = speed;
	}

	@Override
	public void autoMove() {
		
		if(x < -150 && left) {
			x  = 800;
		}
		else if (x > 800 && !left) {
			x = -150;
		}
		
		if(left) {
			x -= currentSpeed;
		}
		else {
			x += currentSpeed;
		}
	}
	
	@Override
	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x, y, width, height);	
	}

	@Override
	public BufferedImage getSprite() {
		return sprite;
	}
	
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
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

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
}
