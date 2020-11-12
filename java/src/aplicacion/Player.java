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
		if(getY() > 50 && getY() < 550 || getX() > 50 && getX() < 700){			
			if(EventosKeyboard.up)			
				this.y -= speed;
			else if(EventosKeyboard.down)
				this.y += speed;
			else if(EventosKeyboard.left)
				this.x -= speed;
			else if(EventosKeyboard.rigth)
				this.x += speed;
		}
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
