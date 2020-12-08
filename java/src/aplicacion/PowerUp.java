package aplicacion;

import java.util.Random;

public interface PowerUp {
	
	public static int x = 0;
	
	public boolean isTrigger();
	public void ActivatePower();
	
	public default void Anim(Collisionable target) {
		target.setX(new Random().nextInt(750));		
	}
}
