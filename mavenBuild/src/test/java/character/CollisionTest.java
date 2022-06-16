package character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CollisionTest {
	
	private int testBoundX1;
	private int testBoundY1;
	private int testBoundX2;
	private int testBoundY2;
	
	
	/**
	 * 
	 */
	@BeforeEach
	void setup() {
		//Define bounds
		testBoundX1 = 1;
		testBoundY1 = 1;
		testBoundX2 = 3;
		testBoundY2 = 3;
		new Collision();
	}
	
	/**
	 * Test if a point is actually in a rectangle defined by bounds initialized in setup
	 */
	@Test 
	void isPointInRect() {
		int pX=2;
		int pY=2;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertTrue(test);
	}
	
	@Test
	void isPxOutOfRectLeft() {
		int pX=0;
		int pY=2;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertFalse(test);
	}
	
	@Test
	void isPxOutOfRectRight() {
		int pX=4;
		int pY=2;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertFalse(test);
	}
	
	@Test
	void isPyOutOfRectUp() {
		int pX=2;
		int pY=0;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertFalse(test);
	}
	
	@Test
	void isPyOutOfRectDown() {
		int pX=2;
		int pY=4;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertFalse(test);
	}
	
	/*
	 * Character Height,Width: 46,21
	 * Enemy2 Height,Width: 71,21
	 */
	private int cW=21;
	private int cH=46;
	private int eW=21;
	private int eH=71;
	@Test
	void isCollidingEntityConditionOne() {
		Enemy2 enemy = new Enemy2(0,0);
		Character character = new Character(eW/2,eH/2);
		boolean test = Collision.isColliding(character, enemy);
		assertTrue(test);
	}
	
	@Test
	void isCollidingEntityConditionTwo() {
		Character character = new Character(0,0);
		Enemy2 enemy = new Enemy2(cW/2,cH/2);
		boolean test = Collision.isColliding(character, enemy);
		assertTrue(test);
	}
	
	@Test
	void isCollidingEntityConditionThree() {
		Enemy2 enemy = new Enemy2(0,cH/2);
		Character character = new Character(eW/2,0);
		boolean test = Collision.isColliding(character, enemy);
		assertTrue(test);
	}
	
	@Test
	void isCollidingEntityConditionFour() {
		Character character = new Character(0,eH/2);
		Enemy2 enemy = new Enemy2(cW/2,0);
		boolean test = Collision.isColliding(character, enemy);
		assertTrue(test);
	}
	
	@Test
	void isNotCollidingEntity() {
		Character character = new Character(0,0);
		Enemy2 enemy = new Enemy2(cW*2,cH*2);
		boolean test = Collision.isColliding(character, enemy);
		assertFalse(test);
	}
}
