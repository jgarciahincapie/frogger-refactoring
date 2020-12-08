package aplicacion;

import java.awt.image.BufferedImage;
import java.util.Random;

import presentacion.Assets;

public class Puddle extends Collisionable implements PowerUp{
	
	private BufferedImage sprite;

	public Puddle(int x, int y, int width, int height) {
		super("puddle", x, y, width, height);
		sprite = Assets.puddle;
	}

	@Override
	public void ActivateTrigger(Player target) {
		if(!isTrigger) {
			target.setX(target.getX() + 60);
			ActivatePower();
		}
	}
	
	@Override
	public BufferedImage getSprite() {
		return sprite;
	}

	@Override
	public void ActivatePower() {
		setX(new Random().nextInt(750));
		
	}
}
