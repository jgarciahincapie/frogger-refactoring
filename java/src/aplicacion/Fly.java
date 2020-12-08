package aplicacion;

import java.awt.image.BufferedImage;
import java.util.Random;

import presentacion.Assets;

public class Fly extends Collisionable implements PowerUp {
	
	private BufferedImage sprite;

	public Fly(int x, int y, int width, int height) {
		super("fly",x, y, width, height);
		sprite = Assets.wings;
	}

	@Override
	public void ActivatePower() {
		setX(new Random().nextInt(750));
	}
	
	@Override
	public BufferedImage getSprite() {
		return sprite;
	}
	
	@Override
	public void setCurrentSpeed(int speed) {
	}

	@Override
	public void ActivateTrigger(Player target) {
		if(!isTrigger()) {
			ActivatePower();
			target.isFlying = true;
		}
	}
	
	@Override
	public double getcurrentSpeed() {
		return 0;
	}

}
