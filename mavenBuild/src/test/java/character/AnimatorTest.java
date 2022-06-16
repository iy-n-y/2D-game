package character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import image.Image;

class AnimatorTest {
	
	@Test
	void testAnimationFrame0() {
		Animator testAnim = new Animator("/src/main/resources/character/mainCharacterDown.png");
		Image actualImage = new Image(testAnim.getImage(false));
		Image expectedImage = new Image("/src/test/resources/Frame0.png");
		assertTrue(actualImage.equals(expectedImage));
	}
	
	@Test
	void testAnimationFrame1() {
		Animator testAnim = new Animator("/src/main/resources/character/mainCharacterDown.png");
		//Artificially sets the test animation to the second frame
		for(int i=0; i < 11; i++)
			testAnim.getImage(true);
		Image actualImage = new Image(testAnim.getImage(false));
		Image expectedImage = new Image("/src/test/resources/Frame1.png");
		assertTrue(actualImage.equals(expectedImage));
	}
	
	@Test
	void testAnimationFrame2() {
		Animator testAnim = new Animator("/src/main/resources/character/mainCharacterDown.png");
		//Artificially sets the test animation to the third frame
		for(int i=0; i < 21; i++)
			testAnim.getImage(true);
		Image actualImage = new Image(testAnim.getImage(false));
		Image expectedImage = new Image("/src/test/resources/Frame2.png");
		assertTrue(actualImage.equals(expectedImage));
	}
	
	@Test
	void testAnimationFrame3() {
		Animator testAnim = new Animator("/src/main/resources/character/mainCharacterDown.png");
		//Artificially sets the test animation to the fourth frame
		for(int i=0; i < 31; i++)
			testAnim.getImage(true);
		Image actualImage = new Image(testAnim.getImage(false));
		Image expectedImage = new Image("/src/test/resources/Frame3.png");
		assertTrue(actualImage.equals(expectedImage));
	}

}
