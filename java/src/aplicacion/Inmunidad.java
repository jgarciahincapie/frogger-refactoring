package aplicacion;

import java.awt.image.BufferedImage;
import java.util.Random;

import presentacion.Assets;

public class Inmunidad extends Collisionable implements PowerUp {
	
	private BufferedImage sprite;

	public Inmunidad(int x, int y, int width, int height) {
		super("inmune",x, y, width, height);
		sprite = Assets.caparason;
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
	public void ActivateTrigger(Player target) {
		if(!isTrigger()) {
			ActivatePower();
			target.isTrigger = true;
		}
		
	}
	
	@Override
	public void setCurrentSpeed(int speed) {
	}
	
	@Override
	public double getcurrentSpeed() {
		return 0;
	}

}
