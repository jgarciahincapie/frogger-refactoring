package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import presentacion.Assets;

public class StopPlace extends Collisionable{
	
	private BufferedImage sprite;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean isTrigger;

	public StopPlace(int x, int y) {
		super("finalStop", x, y, 50, 50);
		sprite = Assets.stopPlace;
		this.x = x;
		this.y = y;
		width = 50;
		height = 50;
		isTrigger = false;
	}
	
	public void Win() {
		sprite = Assets.froggy;
		isTrigger = true;
	}
	
	public boolean isTrigger() {
		return isTrigger;
	}

	public void setTrigger(boolean isTrigger) {
		this.isTrigger = isTrigger;
	}

	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x, y, width, height);
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
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
	
	

}
