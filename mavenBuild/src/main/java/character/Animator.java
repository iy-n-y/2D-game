package character;


import java.awt.image.BufferedImage;

/**
 * Class for creating animated images from one picture with multiple frames (4 specifically)
 * @author Jordan Horacsek
 */

import image.Image;

public class Animator {
	private Image animatedImage;
	private int height;
	private int width;
	
	private int counter=0;
	private int subCounter=0;
	public Animator(String filepath) {
		animatedImage = new Image(filepath);
		height = animatedImage.getImage().getHeight();
		width = animatedImage.getImage().getWidth();
	}
	/**
	 * @return returns the image path
	 */
	public String getPath() {
		return animatedImage.getPath();
	}
	/**
	 * @return returns width of the image size divided by four.
	 */
	public float getWidth() {
		return width/4;
	}
	/**
	 * @return returns the height of the image.
	 */
	public float getHeight() {
		return height;
	}
	
	/**
	 * Returns an image based on tick
	 * @param isMoving if the entity is moving then continue the animation.
	 * @return returns the next frame, the same frame, or a static frame of the animation, depending on the tick.
	 */
	public BufferedImage getImage(boolean isMoving) {
		//This a little trick, so that the image doesn't update too quickly.
		//Basically the image doesn't update until the subcounter reaches ten.		
		if(isMoving) {
			subCounter++;
			if (subCounter >= 10){
				counter = (counter+1)%4;
				subCounter=0;
			}
		}
		return animatedImage.getImage().getSubimage((width/4)*counter,0,(int)(width/4),height);
	}
}
