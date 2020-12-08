package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import presentacion.Assets;

public class Turtle extends Collisionable implements Platform{
	
	private boolean left;
	private int x;
	private int y;
	private int width;
	private int height;
	private double currentSpeed;
	private BufferedImage sprite;
	private int contAnim;
	
	private boolean isTrigger = true;

	public Turtle(boolean left, int x, int y, double speed) {
		super("turtle", x, y, 50, 50);
		this.sprite = Assets.turtleInit;
		this.left = left;
		this.x = x;
		this.y = y;
		contAnim  = 0;
		width = 50;
		height = 50;
		this.currentSpeed = speed;
	}

	@Override
	public void autoMove() {
		if(contAnim < 1000) {			
			contAnim++;
			if(contAnim <= 500) {
				Hide();
			}
			else {
				Show();
			}
			
		}else {
			contAnim = 0;
		}
		
		if(x < -150 && left) {
			x  = 800;
		}
		else if (x > 800 && !left) {
			x = -150;
		}
		
		if(left) {
			x -= currentSpeed;
		}
		else {
			x += currentSpeed;
		}
	}
	
	@Override
	public void ActivateTrigger(Player target) {
		if(!isTrigger()){
			target.setX((int)getCollider().getCenterX() - target.getWidth()/2);
			target.setRiding(true);
		}
		else {
			target.setRiding(false);
			target.Dead();
		}
	}
	
	@Override
	public void setCurrentSpeed(int speed) {
		
	}
	
	@Override
	public double getcurrentSpeed() {
		return currentSpeed;
	}
	
	public void Hide() {
		Timer timer = new Timer();
		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				sprite = Assets.turtleMid;
				isTrigger = true;
				timer.cancel();
			}
		};


		timer.schedule(task1, 3000);
	}
	
	public void Show() {
		Timer timer = new Timer();
		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				sprite = Assets.turtleIdle;
				isTrigger = false;
				timer.cancel();
			}
		};
		
		timer.schedule(task1, 3000);
	}
	
	@Override
	public boolean isTrigger() {
		return isTrigger;
	}

	public void setTrigger(boolean isTrigger) {
		this.isTrigger = isTrigger;
	}

	@Override
	public Rectangle2D getCollider() {
		return new Rectangle2D.Double(x, y, width, height);	
	}

	@Override
	public BufferedImage getSprite() {
		return sprite;
	}
	
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
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

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
}
