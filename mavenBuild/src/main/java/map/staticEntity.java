package map;

import image.Image;

import java.awt.*;

public class staticEntity {
    protected int x,y;
    protected Image i;
    public staticEntity(int posX, int posY, String path) {
        x=posX;
        y=posY;
        this.i=new Image(path);
    }
    public int getX(){
    	return x;
    }
    public int getY() {
    	return y;
    }
    public int getWidth() {
    	return i.getImage().getWidth();
    }
    public int getHeight() {
    	return i.getImage().getHeight();
    }
    
    
    public void render(Graphics graphics)
    {
            graphics.drawImage(i.getImage(),x,y,60,80,null);
    }

}
