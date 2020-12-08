package aplicacion;

import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Grass extends Collisionable{
	
	private BufferedImage sprite;
	private int time;

	public Grass(int x, int y, int width, int height) {
		super("grass", x, y, width, height);
		this.sprite = Assets.grass;
		time = 0;
	}

	@Override
	public BufferedImage getSprite() {
		return this.sprite;
	}

	@Override
	public void ActivateTrigger(Player target) {
		if(target.isTrigger()) {
			time++;
			if(time >=1000) {
				target.Dead();
				time= 0;
			}
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
