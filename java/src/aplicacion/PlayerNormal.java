package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import presentacion.Assets;

public class PlayerNormal extends Player{
	
	public PlayerNormal(int x, int y, int player, BufferedImage sprite) {
		super(x, y, player, sprite);
	}

	@Override
	public void Move() {
		if(player == 1) {			
			if(EventosKeyboard.up && getY() > 50){
				this.score +=10;
				this.y -= speedY;
				EventosKeyboard.up = false;
			}
			else if(EventosKeyboard.down && getY() < 450) {
				this.y += speedY;
				EventosKeyboard.down = false;
			}
			else if(EventosKeyboard.left && getX() > 25) {
				this.x -= speedX;
				EventosKeyboard.left = false;
			}
			else if(EventosKeyboard.rigth && getX() < 730) {
				this.x += speedX;
				EventosKeyboard.rigth = false;
			}
		}
		else if(player == 2) {
			if(EventosKeyboard.upArrow && getY() > 50){
				this.score +=10;
				this.y -= speedY;
				EventosKeyboard.upArrow = false;
			}
			else if(EventosKeyboard.downArrow && getY() < 450) {
				this.y += speedY;
				EventosKeyboard.downArrow = false;
			}
			else if(EventosKeyboard.leftArrow && getX() > 25) {
				this.x -= speedX;
				EventosKeyboard.leftArrow = false;
			}
			else if(EventosKeyboard.rigthArrow && getX() < 730) {
				this.x += speedX;
				EventosKeyboard.rigthArrow = false;
			}
		}
		
		for(Collisionable i: FroggerManager.collisionables) {
			if(Collision(i.getCollider())) {				
				OnCollisionEnter(i);
			}
		}
	}
	
	@Override
	public void OnCollisionEnter(Collisionable collision) {
		if(collision.getTag() == "trunk") {
			isRiding = true;
			setX((int)collision.getCollider().getCenterX() - getWidth()/2);
		}
		
		else if(collision.getTag() == "turtle") {
			if(!collision.isTrigger()){
				isRiding = true;
				setX((int)collision.getCollider().getCenterX() - getWidth()/2);
			}
			else {
				isRiding = false;
			}
		}

		else if(collision.getTag() == "car" && ((Car)collision).isTrigger() == false) {
			if(isTrigger == false) {
				Dead();
			}
			else {
				((Car)collision).Destroy();
				isTrigger = false;
			}
		}

		else if(collision.getTag() == "finalStop") {
			((StopPlace)collision).setSprite(Assets.froggy);
			if(!((StopPlace)collision).isTrigger())
				makePoint();
			((StopPlace)collision).setTrigger(true);
		}
		else if (collision.getTag() == "grass" && isTrigger == false) {
			timeInGrass ++;
			if(timeInGrass >=1000) {
				Dead();
				timeInGrass = 0;
			}
		}
		//Power ups
		else if (collision.getTag() == "speedMax") {
			if(!((PowerUp)collision).isTrigger()) {
				setSpeedY(100);				
				((PowerUp)collision).ActivatePower();
			}
		}
		else if (collision.getTag() == "inmune") {
			if(!((PowerUp)collision).isTrigger()) {
				isTrigger = true;
				((PowerUp)collision).ActivatePower();
			}
		}
		//Falta implmentar la clase
		else if(collision.getTag() == "alas") {
			isFlying = true;
		}
		//Falta implementar la clase
		else if(collision.getTag() == "toxic") {
			isToxic = true;
		}
	}
	@Override
	public void makePoint() {
		super.score +=50;
		FroggerManager.getInstance().CheckWin();
		resetPosition();
	}

	@Override
	public void Dead() {
		sprite = Assets.playerDead;
		lives--;
		score -= 100;
		try {
			Hilo.getInstance().join(1000);
			resetPosition();
			isTrigger = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
