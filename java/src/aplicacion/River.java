package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import presentacion.Assets;

public class River extends Collisionable{
	
	private BufferedImage sprite;
	private boolean isTrigger;
	private int x;
	private int y;
	private int width;
	private int height;

	public River() {
		super("river", 0, 0, 800, 280);
		sprite = Assets.river;
		x = 0;
		y = 0;
		width = 800;
		height = 280;
	}
	
	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x, y, width, height-30);		
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
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
	
	


}
