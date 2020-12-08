package aplicacion;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public interface Platform {
	
	double speed = 1;
	
	public void autoMove();
	public Rectangle2D getCollider();
	public BufferedImage getSprite();
	public void setCurrentSpeed(int speed);
	public double getcurrentSpeed();
}
