package aplicacion;

import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Biker extends Collisionable implements Platform{
	
	private boolean left;
	private double currentSpeed;
	private BufferedImage sprite;

	public Biker(boolean left, int x, int y, int width, int height, double speed) {
		super("bikerNoob", x, y, width, height);
		currentSpeed = speed;
		sprite = Assets.bikeNoob;
	}

	@Override
	public void ActivateTrigger(Player target) {
		target.isRiding = true;
		target.setX((int)getCollider().getCenterX() - target.getWidth()/2);
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
	public void setCurrentSpeed(int speed) {
		currentSpeed = speed;
	}
	
	@Override
	public double getcurrentSpeed() {
		return currentSpeed;
	}
	
	@Override
	public BufferedImage getSprite() {
		return sprite;
	}
	
}
