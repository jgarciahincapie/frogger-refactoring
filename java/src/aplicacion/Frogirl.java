package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Frogirl extends Collisionable{

	private BufferedImage sprite;
	private boolean safe;
	private Player target;

	public Frogirl(int x, int y, int width, int height) {
		super("girl", x, y, width, height);
		sprite = null;
		safe = false;
		isTrigger = true;
	}

	@Override
	public void ActivateTrigger(Player target) {
		if(isTrigger == false) {
			target.setSprite(Assets.froGirl);
			target.setPregnant(true);
			sprite = null;
			isTrigger = true;
			safe = true;
		}
	}

	public void Show() {
		sprite = Assets.froGirl;
		isTrigger = false;
		safe = false;
	}

	@Override
	public BufferedImage getSprite() {
		return sprite;
	}

	@Override
	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x,y,width,height);
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	@Override
	public void setCurrentSpeed(int speed) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public double getcurrentSpeed() {
		return 0;
	}

	

}
