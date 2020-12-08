package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import presentacion.Assets;

public class StopPlace extends Collisionable{
	
	private BufferedImage sprite;
	private boolean isTrigger, win;
	private String mode;
	private int contAnim;

	public StopPlace(int x, int y) {
		super("finalStop", x, y, 50, 50);
		sprite = Assets.stopPlace;
		mode = "win";
		isTrigger = false;
		win = false;
		contAnim = 0;
	}
	
	public void Animation() {
		if(!win) {			
			if(contAnim<500) {
				contAnim++;
			}
			else {
				ChoiseMode();
				contAnim = 0;
			}
		}
	}
	
	private void ChoiseMode() {
		String[] modes = new String[] {"win", "lose", "bonus", "win"};
		int value = new Random().nextInt(modes.length);
		mode = modes[value];
		if(modes[value] == "win")
			sprite = Assets.stopPlace;
		else if(modes[value] == "lose")
			sprite = Assets.cocodrille;
		else if(modes[value] == "bonus")
			sprite = Assets.insect;	
	}
	
	@Override
	public void ActivateTrigger(Player target) {
		if(!win) {			
			if(mode == "win")
				Win(target, 0);
			else if(mode == "lose")
				Lose(target);
			else if(mode == "bonus")
				Win(target, 150);
		}
	}
	
	public void Win(Player target, int bonus) {
		sprite = Assets.froggy;
		if(!isTrigger()) {
			if(target.isPregnant) {
				target.makePoint(bonus + 450);
				target.setPregnant(false);
			}
			else
				target.makePoint(bonus);
		}
		isTrigger = true;
		win = true;
	}
	
	public void Lose(Player target) {
		if(!isTrigger()) {
			if(!target.isToxic) {				
				target.Dead();
				setTrigger(false);
			}
			else {
				Win(target, 0);
			}
		}
	}

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
	
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite; 
		
	}

	@Override
	public void setCurrentSpeed(int speed) {		
	}
	
	@Override
	public double getcurrentSpeed() {
		return 0;
	}

}
