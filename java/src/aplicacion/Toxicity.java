package aplicacion;

import java.awt.image.BufferedImage;
import java.util.Random;

import presentacion.Assets;

public class Toxicity extends Collisionable implements PowerUp {
	
	private BufferedImage sprite;

	public Toxicity(int x, int y, int width, int height) {
		super("fly",x, y, width, height);
		sprite = Assets.flask;
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
			target.isToxic = true;
			target.setSprite(Assets.playerToxic);
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
