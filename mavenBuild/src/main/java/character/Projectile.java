package character;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import image.Image;
import map.Map;
import tile.Tile;
/**
 * Extended by all projectiles, contains essential methods for projectiles.
 * @author Jordan Horacsek
 *
 */
public class Projectile {
	protected Direction direction;
	protected float posX;
	protected float posY;
	private float height;
	private float width;
	protected float speedY = 5.0f;
	protected float speedX = 5.0f;
	protected Image image;
	protected boolean isDestroyed=false;
	//Needs a method that destroys the projectile
	//Image should be declared in extension of Projectile i.e, playerProjectile and enemyProjectile.
	public Projectile(Direction direction, float initialX, float initialY, String imagePath) {
		this.direction = direction;
		this.image = new Image(imagePath);
		posX = initialX;
		posY = initialY;
		height = this.image.getImage().getHeight()-1;
		width = this.image.getImage().getWidth();

		switch(direction) {
			case UP:
				speedY=-speedY;
				speedX=0;
				break;
			case DOWN:
				speedY=+speedY;
				speedX=0;
				break;
			case LEFT:
				speedX=-speedX;
				speedY=0;
				break;
			case RIGHT:
				speedX=+speedX;
				speedY=0;
				break;
		}
	}
	public int getX() {
		//Change this in a diff method
		if(this.direction==Direction.DOWN || this.direction==Direction.UP )
			return (int)posX;
		else
			return (int)posX-10;
	}
	public int getY() {
		if(this.direction==Direction.DOWN || this.direction==Direction.UP )
			return (int)posY;
		else
			return (int)posY+10;
	}
	public int getWidth() {
		if(this.direction==Direction.DOWN || this.direction==Direction.UP )
			return (int)width;
		else
			return(int)height;
	}
	public int getHeight() {
		if(this.direction==Direction.DOWN || this.direction==Direction.UP )
			return (int)height;
		else
			return(int)width;
	}
	
	public boolean update() {
		return false;
	}
	
	public void render(Graphics g) {
		//Thanks to https://stackoverflow.com/questions/14124593/how-to-rotate-graphics-in-java for help with rotation!
		//Also I acknowledge that this is not a very clean way of doing this, I could have way more easily used four separate images, or just implemented this better.
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform old = g2d.getTransform();
		g2d.translate(width/2, height/2);
		float posX2= posX;
		float posY2= posY;
		switch(direction) {
			case UP:
				g2d.rotate(Math.toRadians(0));
				break;
			case DOWN:
				g2d.rotate(Math.toRadians(180));
				posY2 = -posY;
				posX2 = -posX;
				break;
			case LEFT:
				g2d.rotate(Math.toRadians(270));
				posX2 = -posY;
				posY2 = posX;
				break;
			case RIGHT:
				g2d.rotate(Math.toRadians(90));
				posX2 = posY;
				posY2 = -posX;
				break;
		}
		g2d.translate(-width/2, -height/2);
		g2d.drawImage(image.getImage(),(int)posX2,(int)posY2,null);
		g2d.setTransform(old);
		//Uncomment if you want hitbox for projectiles
		//g.drawRect(getX(), getY(), getWidth(), getHeight());
	}
	
	
}
