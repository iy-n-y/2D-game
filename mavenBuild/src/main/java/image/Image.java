package image;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Add website that gave additional information...
public class Image {
	private String filePath;
	private BufferedImage image;
	private int equalityThreshold=1;
	
	public Image (String filePath){
		this.filePath = filePath;
		initImage();
	}
	public Image(BufferedImage image) {
		filePath = null;
		this.image = image;
	}
	public String getPath() {
		return filePath;
	}
	public void initImage() {
		try {
			image = ImageIO.read(new File("."+filePath));
		}catch(IOException e) {
			System.out.println("An image could not be found:"+filePath);
			e.printStackTrace();
			System.exit(1);
		}
	}
	//This method needs to be fixed clearly, but it will do for now...
	/**
	 * identify picture location
	 * @return the picture
	 */
	public BufferedImage getImage() {
		return image;
	}
	
	//This was the original code that was used...
    public static BufferedImage imageLoad(String path){
        try {
            return ImageIO.read(new File("."+path));
        } catch (IOException e) {
		System.out.println("An image could not be found:"+path);
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    public int getHeight() {
    	return image.getHeight();
    }
    
    public int getWidth() {
    	return image.getWidth();
    }
    
    /**
     * Evaluates the equality of two pixels. This is done so that an equality threshold
     * can be implemented. I.e., if two pixels have RGB values (215,122,49) and (215,122,50)
     * they are essentially equal in colour. This method is implemented because the getSubImage
     * function of the BufferedImage class can slightly modify RGB values.
     * @return True if two pixels are "equal", false otherwise.
     */
    private boolean evaluateEquality(Color colourOne, Color colourTwo) {
    	if( inRangeOfEqualityThreshold(colourOne.getRed(),colourTwo.getRed()) )
    		if( inRangeOfEqualityThreshold(colourOne.getGreen(),colourTwo.getGreen()) )
    			if( inRangeOfEqualityThreshold(colourOne.getBlue(),colourTwo.getBlue()) )
    				return true;
    	return false;
    }
    
    /**
     * Checks if two integer ranges are within the equality threshold of each other
     * @return Returns true if they are, false otherwise.
     */
    private boolean inRangeOfEqualityThreshold(int x, int y) {
    	if(x-equalityThreshold <= y && x+equalityThreshold >= y)
    		return true;
    	return false;
    }
    /**
     * Checks to see if two images are equal based on the pixels in the image.
     * Code courtesy of https://stackoverflow.com/questions/11006394/is-there-a-simple-way-to-compare-bufferedimage-instances
     * @return returns true if images are equal, false otherwise.
     */
    public boolean equals(Image image) {
    	if(this.getWidth() != image.getWidth() || this.getHeight() != image.getHeight())
    		return false;
    	BufferedImage imgOne = this.getImage();
    	BufferedImage imgTwo = image.getImage();
    	//Compares each pixel of both images, if they differ, then the images are not equal.
    	for(int x=0; x < this.getWidth(); x++)
    		for(int y=0; y < this.getHeight(); y++) {
    			if(!evaluateEquality(new Color(imgOne.getRGB(x, y)), new Color(imgTwo.getRGB(x, y))  ))
    				return false;
    		}
    	return true;
    }
}
