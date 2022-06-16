package character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Enemy2Test {

	@Test
	void testUpdate() {
		Enemy2 enemy = new Enemy2(0,0);
		enemy.update();
		int output = enemy.fireCount();
		assertEquals(1,output);
	}
	
	@Test
	void testUpdateBasicMovement() {
		Enemy2 enemy = new Enemy2(0,0);
		enemy.update();
		int output = enemy.movementUpdateTimer();
		assertEquals(1,output);
	}

}
