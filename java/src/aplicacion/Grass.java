package aplicacion;

import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Grass extends Collisionable{
	
	private BufferedImage sprite;

	public Grass(int x, int y, int width, int height) {
		super("grass", x, y, width, height);
		this.sprite = Assets.grass;
	}

	@Override
	public BufferedImage getSprite() {
		return this.sprite;
	}
	
}
