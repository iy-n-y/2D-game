package character;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import image.Image;

/**
 * Basically extended by anything that moves.
 * @author jorda
 *
 */
public class Entity {
	
	/**
	 * Position variables are declared as discrete values as stated in the project specifications.
	 * (Didn't necessarily say they needed to be discrete, but it's implied)
	 */
	protected float posX;
	protected float posY;
	protected String imagePathPrefix;
	protected Direction directionFacing;
	//This is probably just temporary, there is definitely a better way to do it...
	protected boolean[] directionMoving;
	
	//Each enemy should be initialized with a set of four images one for each direction.
	//Also for the sake of simplicity, one the prefix of the image name is required.
	protected Animator activeImage;
	protected Animator[] allImages= {null,null,null,null};
	protected Image hitImage;
	
	//protected float speed=1;
	protected float speed=3;
	protected boolean moving=false;
	
	protected boolean isHit=false;
	protected int hitCounter=0;
	
	/**
	 * 
	 * @param posX Initial X position
	 * @param posY Initial Y position
	 * @param imagePathPrefix This is the initial path to the image prefix, for example, in the character folder there are four images, each one indicating a direction. They all start with the same name, "/res/character/mainCharacter"
	 */
	protected Entity(int posX, int posY, String imagePathPrefix){
		this.posX = posX;
		this.posY = posY;
		this.imagePathPrefix = imagePathPrefix;
		
		initializeAllImages();
		setDirection(Direction.DOWN);
	}
	
	/**
	 * @return Direction the entity is currently facing.
	 */
	public Direction getDirection() {
		return directionFacing;
	}
	
	/**
	 * @param direction Sets direction entity should face.
	 */
	private void setDirection(Direction direction) {
		directionFacing = direction;
		updateActiveImage();
		return;
	}
	
	private boolean swap=false;
	/**
	 * @return Flashes a red image when the entity is hit.
	 */
	protected BufferedImage getHitImage() {
		hitCounter++;
		if(hitCounter > 20) {
			hitCounter=0;
			isHit=false;
		}
		if(hitCounter%8==0) {
			swap=!swap;
		}
		if(swap)
			return activeImage.getImage(moving);
		int locHeight = hitImage.getImage().getHeight();
		int locWidth = hitImage.getImage().getWidth()/4;
		switch(getDirection()) {
			case UP:
				return hitImage.getImage().getSubimage((locWidth*0), 0, locWidth, locHeight);
			case DOWN:
				return hitImage.getImage().getSubimage((locWidth*1), 0, locWidth, locHeight);
			case LEFT:
				return hitImage.getImage().getSubimage((locWidth*2), 0, locWidth, locHeight);
			case RIGHT:
				return hitImage.getImage().getSubimage((locWidth*3), 0, locWidth, locHeight);
		}
		
		return null;
		
	}
	/**
	 * Initializes all the images used by the entity.
	 */
	private void initializeAllImages() {
		//Just so happens the postfix are added in the same direction the enum is ordered.
		//This is obviously not a coincidence. hehe
		String[] postFix = {"Up","Down","Left","Right"};
		for(int i = 0; i < 4; i++) {
			allImages[i] = new Animator(imagePathPrefix+postFix[i]+".png");
		}
		hitImage=new Image(imagePathPrefix+"Red.png");
		return;
	}
	
	
	//updates image, should be called after direction is changed
	private void updateActiveImage() {
		//This essentially changes the active image to the image that corresponds to the direction the entity is facing.
		//If you're wondering why this works, it's because the ordinal of the values in the enum are in the same order
		//that the allImages array is initialized in.
		//System.out.println(directionFacing.ordinal());
		activeImage = allImages[directionFacing.ordinal()];
		return;
	}
	
	//Moves entity up and changes its direction
	public void moveUp() {
		this.posY-=this.speed;
		setDirection(Direction.UP);
		return;
	}
	//Moves entity down and changes its direction
	public void moveDown() {
		this.posY+=this.speed;
		setDirection(Direction.DOWN);
		return;
	}
	//Moves entity right and changes its direction
	public void moveRight() {
		this.posX+=this.speed;
		setDirection(Direction.RIGHT);
		return;
	}
	//Moves entity left and changes its direction
	public void moveLeft() {
		this.posX-=this.speed;
		setDirection(Direction.LEFT);
		return;
	}
	//Other directions for diagonal movement
	//Honestly these don't really need to be implemented if you don't have textures for diagonal movement
	//so just remove them later. But maybe actually keep them for shooting bullets or something.
	public void moveRightUp() {
		this.posY -=(this.speed/2);
		this.posX +=(this.speed/2);
		setDirection(Direction.DOWN);
		return;
	}
	public void moveRightDown() {
		this.posY +=(this.speed/2);
		this.posX +=(this.speed/2);
		setDirection(Direction.DOWN);
		return;
	}
	public void moveLeftUp() {
		this.posY -=(this.speed/2);
		this.posX -=(this.speed/2);		
		setDirection(Direction.DOWN);
		return;
	}
	public void moveLeftDown() {
		this.posY +=(this.speed/2);
		this.posX -=(this.speed/2);
		setDirection(Direction.DOWN);
		return;
	}
	
	public int getX() {
		return (int)posX;
	}
	public int getY() {
		return (int)posY;
	}
	
	//These methods need to be fixed
	public int getWidth() {
		return (int)activeImage.getWidth();
	}
	public int getHeight() {
		return (int)activeImage.getHeight();
	}
	public void shoot() {
		
	}
	public void stopMoving() {
		moving = false;
	}
	public boolean isMoving() {
		return moving;
	}
	public boolean isHit() {
		return isHit;
	}
	public void hit() {
		isHit=true;
		return;
	}
	/*
	public Image getImage() {
		return activeImage;
	}*/
	/**
	 * Where all entity logic is updated
	 */
	public void update() {
		
	}
	
	//The size of the image should probably be variable...
	/**
	 * Handles rendering entity.
	 * @param g
	 */
    public void render(Graphics g){
    	if(!isHit)
    		g.drawImage(activeImage.getImage(moving),(int)posX,(int)posY,null);
    	else
    		g.drawImage(getHitImage(),(int)posX,(int)posY,null);
    	
    	//Uncomment line bellow if you want hitboxes for the entities
    	//g.drawRect(getX(), getY(), getWidth(), getHeight());
   
    }
	
	
}
