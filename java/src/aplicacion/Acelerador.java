package aplicacion;
import java.awt.image.BufferedImage;
import java.util.Random;

import presentacion.Assets;

public class Acelerador extends Collisionable implements PowerUp{
	
	private BufferedImage sprite;

	public Acelerador(int x, int y, int width, int height) {
		super("speedMax", x, y, width, height);
		sprite = Assets.thunder;
	}

	@Override
	public void ActivatePower() {
		setX(new Random().nextInt(750));
	}
	
	@Override
	public BufferedImage getSprite() {
		return this.sprite;
	}

	@Override
	public void ActivateTrigger(Player target) {
		if(!isTrigger()) {
			target.setSpeedY(100);			
			ActivatePower();
		}
	}
	
	@Override
	public double getcurrentSpeed() {
		return 0;
	}

	@Override
	public void setCurrentSpeed(int speed) {
		
	}
}
