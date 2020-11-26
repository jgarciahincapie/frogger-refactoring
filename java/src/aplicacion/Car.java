package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import presentacion.Assets;

public class Car extends Collisionable implements Platform{
	
	private BufferedImage sprite;
	private int width;
	private int height;
	private int x;
	private int y;
	private boolean left;
	private double currentSpeed;
	
	public Car(boolean left, int x, int y, double speed) {
		super("car", x, y, 80, 50);
		this.left = left;
		this.x = x;
		this.y = y;
		this.currentSpeed = speed;
		width = 80;
		height = 50;
		BufferedImage[] pos = new BufferedImage[] {Assets.carBlue, Assets.carGreen, Assets.carYellow, Assets.truck1, Assets.truck2};
		sprite = pos[new Random().nextInt(pos.length)];
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
