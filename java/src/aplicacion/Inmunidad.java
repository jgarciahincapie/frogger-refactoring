package aplicacion;

import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Inmunidad extends Collisionable implements PowerUp {
	
	private BufferedImage sprite;

	public Inmunidad(int x, int y, int width, int height) {
		super("inmune",x, y, width, height);
		sprite = Assets.caparason;
	}

	@Override
	public void ActivatePower() {
		super.setTrigger(true);
		sprite = null;
		
	}
	
	@Override
	public BufferedImage getSprite() {
		return sprite;
	}

}
