package aplicacion;
import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Acelerador extends Collisionable implements PowerUp{
	
	private BufferedImage sprite;

	public Acelerador(int x, int y, int width, int height) {
		super("speedMax", x, y, width, height);
		sprite = Assets.thunder;
	}

	@Override
	public void ActivatePower() {
		super.setTrigger(true);
		sprite = null;
	}
	
	@Override
	public BufferedImage getSprite() {
		return this.sprite;
	}
}
