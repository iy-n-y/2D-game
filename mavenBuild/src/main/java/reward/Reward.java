package reward;

import java.awt.*;

import character.Entity;

public abstract class Reward {
	protected image.Image image;
	
    public abstract int update(Entity entity);
    public abstract void render(Graphics g);
    //public abstract int getX();
    //public abstract int getY();
    public int getWidth() {
    	return image.getImage().getWidth()-15;
    }
    public int getHeight() {
    	return image.getImage().getHeight();
    }
}
