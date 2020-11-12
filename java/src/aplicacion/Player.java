package aplicacion;

import java.awt.image.BufferedImage;

import presentacion.Assets;

public class Player {
	
	private BufferedImage sprite;	
	private int x = 380;
	private int y = 500;
	private double speed = 1;

	public Player() {
		sprite = Assets.playerNormal;
	}
	
	public void Move() {		
		if(EventosKeyboard.up && getY() > 25)			
			this.y -= speed;
		else if(EventosKeyboard.down && getY() < 500)
			this.y += speed;
		else if(EventosKeyboard.left && getX() > 25)
			this.x -= speed;
		else if(EventosKeyboard.rigth && getX() < 730)
			this.x += speed;
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

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	public BufferedImage getSprite(){
		return this.sprite;
	}

}
