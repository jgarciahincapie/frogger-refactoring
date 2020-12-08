package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Frogirl extends Collisionable{
	
	private BufferedImage sprite;

	public Frogirl(int x, int y, int width, int height) {
		super("girl", x, y, width, height);
		sprite = null;
		isTrigger = true;
	}

	@Override
	public void ActivateTrigger(Player target) {
		if(isTrigger == false) {			
			setX(target.x);				
			setY(target.y);
		}
	}
	
	public void Show() {
		sprite = Assets.froGirl;
		isTrigger = false;
	}
	
	@Override
	public BufferedImage getSprite() {
		return sprite;
	}

	@Override
	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x-15,y+15,width+30,height+30);
	}
	
	
}
