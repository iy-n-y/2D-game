package character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyListTest {
	@BeforeEach
	void setup() {
		new EnemyList();
	}
	
	@Test
	void testPush() {
		Enemy1 enemy1 = new Enemy1(0,0);
		new EnemyList();
		EnemyList.push(enemy1);
		int output = EnemyList.getElements();
		assertEquals(1,output);
		EnemyList.remove(0);
	}
}
