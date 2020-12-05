package aplicacion;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import presentacion.Assets;

public class MachineBrave extends Player implements Machine{

	private String dirF;
	private double currentTime, timeToChoise = 0.02f;
	public MachineBrave(int x, int y, int player, BufferedImage sprite) {
		super(x, y, player, sprite);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String ChooseMove() {
		String[] optString = new String[] {"N", "L", "N", "R", "N"};
		return optString[new Random().nextInt(optString.length)];
	}

	@Override
	public void Move() {
		dirF = "";
		if(currentTime >= timeToChoise) {
			dirF = ChooseMove();
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					currentTime = 0;
					dirF = "";
				}
			};

			timer.schedule(task, 5);
		}
		else {			
			currentTime += 0.001;
		}

		String dir = dirF;
		if(dir == "N" && getY() > 50){
			super.score +=10;
			super.y -= speedY;
		}
		else if(dir == "S" && getY() < 450) {
			super.y += speedY;
		}
		else if(dir == "L" && getX() > 25) {
			super.x -= speedX;
		}
		else if(dir == "R" && getX() < 730) {
			super.x += speedX;
		}

		for(Collisionable i: FroggerManager.collisionables) {
			if(Collision(i.getCollider())) {			
				this.OnCollisionEnter(i);
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
		score -= score>0?100:0;
		resetPosition();
		isTrigger = false;		
	}
}
