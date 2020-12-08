package aplicacion;

import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Carreta extends Collisionable implements Platform{
	
	private boolean left;
	private double currentSpeed;
	private BufferedImage sprite;

	public Carreta(boolean left, int x, int y, int width, int height, double speed) {
		super("bikerNoob", x, y, width, height);
		currentSpeed = speed;
		sprite = Assets.carreta;
	}

	@Override
	public void ActivateTrigger(Player target) {
		target.isRiding = true;
		target.isToxic = true;
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
	public BufferedImage getSprite() {
		return sprite;
	}
	
}
