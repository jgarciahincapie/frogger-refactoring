package aplicacion;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import presentacion.Assets;

public class MachineCaution extends Player implements Machine{	

	private double timeToChoise = 0.02f;
	private double currentTime;
	private String dirF = "";

	public MachineCaution(int x, int y, int player, BufferedImage sprite) {
		super(x, y, player, sprite);
	}

	@Override
	public String ChooseMove() {
		String[] optString = new String[] {"N", "N", "S", "N", "L", "N", "R", "N", "N"};
		return optString[new Random().nextInt(optString.length)];
	}

	@Override
	public void Move() {
		
		if(x<0 || x>750 || y<=40 || y> 600) {
			Dead();
		}
		
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
		
		collision.ActivateTrigger(this);
		
	}
	
	@Override
	public void makePoint(int bonus) {
		super.score +=50 + bonus;
		FroggerManager.getInstance().CheckWin();
		resetPosition();
	}

	@Override
	public void Dead() {
		sprite = Assets.playerDead;
		lives--;
		score -= score-100>0 ? 100 : score;
		resetPosition();
		isTrigger = false;
	}
}
