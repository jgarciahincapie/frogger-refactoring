package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class Collisionable implements Platform{
	
	protected String tag;
	protected boolean isTrigger;
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Collisionable(String tag, int x, int y, int width, int height) {
		this.tag = tag;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isTrigger = false;
	}
	
	public abstract void ActivateTrigger(Player target);
	
	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x, y+5, width, height-10);
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isTrigger() {
		return isTrigger;
	}

	public void setTrigger(boolean isTrigger) {
		this.isTrigger = isTrigger;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void autoMove() {
		
	}

	@Override
	public BufferedImage getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
