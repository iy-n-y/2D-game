package ImageTest;

import image.Image;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImageTest {
    Image imageTest=new Image("/src/test/resources/wall.png");
    /*
    check the Image can be correctly crate.
     */
    @Test
    public void ImageLoadingTest(){

       Assertions.assertNotNull(imageTest);
    }
    /*
    check the getter can return.
     */
    @Test
    public void getImageTest(){

        Assertions.assertNotNull(imageTest.getImage());
    }
    
    /**
     * Tests Image.equals() with two different images that should be identical
     */
    @Test
    public void ImageEqualityEqual() {
    	Image testImageOne = new Image("/src/test/resources/wall.png");
    	Image testImageTwo = new Image("/src/test/resources/IdenticalWall.png");
    	
    	assertTrue(testImageOne.equals(testImageTwo));
    }
    /**
     * Tests Image.equals() with two different images that are different sizes
     */
    @Test
    public void ImageEqualityDifferentSize() {
    	Image testImageOne = new Image("/src/test/resources/wall.png");
    	Image testImageTwo = new Image("/src/test/resources/WallDifferentSize.png");
    	
    	assertFalse(testImageOne.equals(testImageTwo));
    }
    /**
     * Tests Image.equals() with two different images (that are the same size)
     * but slightly different.
     */
    @Test
    public void ImageEqaulitySlightlyChanged() {
    	Image testImageOne = new Image("/src/test/resources/wall.png");
    	Image testImageTwo = new Image("/src/test/resources/WallSlightlyModified.png");
    	
    	assertFalse(testImageOne.equals(testImageTwo));
    }

}
