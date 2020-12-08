package aplicacion;

import java.awt.image.BufferedImage;

import presentacion.Assets;

public class MotorCycle extends Collisionable implements Platform{
	
	private boolean left;
	private double currentSpeed;
	private BufferedImage sprite;

	public MotorCycle(boolean left, int x, int y, int width, int height, double speed) {
		super("bikerPro", x, y, width, height);
		currentSpeed = speed;
		sprite = Assets.bikePro;
	}

	@Override
	public void ActivateTrigger(Player target) {
		target.setY(target.getY() - 100);
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
