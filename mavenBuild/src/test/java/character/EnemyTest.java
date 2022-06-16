package character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnemyTest {

	@Test
	void testKill() {
		Enemy enemy = new Enemy(0,0,"/src/main/resources/Enemy/Enemy1");
		enemy.kill();
		boolean output = enemy.isDead();
		boolean expected = true;
		assertEquals(true,expected);
		
	}

	@Test
	void testHit() {
		Enemy enemy = new Enemy(0,0,"/src/main/resources/Enemy/Enemy1");
		 enemy.hit();
		 int health = enemy.health();
		assertEquals(3,health);
		
	}
}
