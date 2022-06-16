package character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyListUpdateTest {
	
	
	@BeforeEach
	void setup() {
		new EnemyList();
	}
	
	@Test
	void testUpdate() {
		Enemy enemy = new Enemy(0,0,"/src/main/resources/Enemy/Enemy1");
		Enemy enemy2 = new Enemy(10,10,"/src/main/resources/Enemy/Enemy1");

		EnemyList.push(enemy);
		EnemyList.push(enemy2);
		enemy.kill();
		EnemyList.update();
		int output = EnemyList.returnScore();
		assertEquals(25,output);
		while(!EnemyList.isEmpty())
			EnemyList.pop();
	}

	@Test
	void testIsEmpty() {
		Enemy1 enemy = new Enemy1(0,0);
		EnemyList.push(enemy);
		EnemyList.remove(0);
		int output = EnemyList.getElements();
		assertEquals(0,output);
	}
}
