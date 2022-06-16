package character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import image.Image;

class EntityTest {
	private Entity testEntity;
	
	//For buffered image compare https://stackoverflow.com/questions/11006394/is-there-a-simple-way-to-compare-bufferedimage-instances
	
	@BeforeEach
	void setup() {
		//Initializes a new entity with the mainCharacter image.
		testEntity = new Entity(251,14,"/src/main/resources/character/mainCharacter");
	}
	
	/**
	 * Test initialization of allImages array and hit image.
	 * Should initialize the array allImages, with four distinct
	 * Animator objects, that all end with different postFix names.
	 * Should initialize one more object, whose path is image to
	 * a red variation of the image. initializeAllImages is automatically
	 * invoked in the constructor, so we don't need to call it.
	 * Also tests updateActiveImage()
	 */
	@Test
	void testImageInitializationDown() {
		//Sets direction down.
		testEntity.moveDown();
		assertEquals(testEntity.activeImage.getPath(),"/src/main/resources/character/mainCharacterDown.png");
	}
	@Test
	void testImageInitializationUp() {
		//Sets direction up.
		testEntity.moveUp();
		assertEquals(testEntity.activeImage.getPath(),"/src/main/resources/character/mainCharacterUp.png");
	}
	@Test
	void testImageInitializationLeft() {
		//Sets direction left.
		testEntity.moveLeft();
		assertEquals(testEntity.activeImage.getPath(),"/src/main/resources/character/mainCharacterLeft.png");
	}
	@Test
	void testImageInitializationRight() {
		//Sets direction right.
		testEntity.moveRight();
		assertEquals(testEntity.activeImage.getPath(),"/src/main/resources/character/mainCharacterRight.png");
	}
	
	/**
	 * Test one direction to confirm entity displays appropriate hit graphic
	 */
	@Test
	void testGetHitImage() {
		//Sets testEntities direction to DOWN
		testEntity.moveDown();
		testEntity.hit();
		
		Image actual = new Image(testEntity.getHitImage());
    	Image expected = new Image("/src/test/resources/redFrame.png");
    	
    	assertTrue(actual.equals(expected));
	}
	
	
	
	/**
	 * Should return the width of the specified image assigned to the entity
	 * divided by four (casted as an integer).
	 */
	@Test
	void testGetWidth() {
		assertEquals(testEntity.getWidth(),31);
	}
	
	/**
	 * Should return the height of the image assigned to the entity.
	 */
	@Test
	void testGetHeight() {
		assertEquals(testEntity.getHeight(),46);
	}
}
