package character;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
/**
 * 
 * @author Jordan Horacsek
 *
 */
//Thank you too https://www.baeldung.com/junit-5-test-order for
//help with ordering test methods.
public class TestCollisionInteractions {
	
	//private Character testCharacter;
	//private Enemy1 testEnemy1;
	//private Enemy2 testEnemy2;
	
	private BulletList characterBulletList;
	private BulletList enemyBulletList;
	
	@BeforeEach
	void setup() {
		new EnemyList();
		//testCharacter = new Character(0,0);
		//testEnemy1 = new Enemy1(0,100);
		//testEnemy2 = new Enemy2(0,200);
		characterBulletList = new BulletList();
		enemyBulletList = new BulletList();
		//EnemyList.push(testEnemy1);
		//EnemyList.push(testEnemy2);
	}
	
	
	@Test
	void characterAndEnemy1True() {
		
		Character testCharacter =  new Character(0,0);
		Enemy1 testEnemy = new Enemy1(0,0);
		
		EnemyList.push(testEnemy);
		testCharacter.update();
		
		EnemyList.remove(0);
		
		assertTrue(testCharacter.isHit());
	}
	
	@Test
	void characterAndEnemy1False() {
		
		Character testCharacter =  new Character(0,0);
		Enemy1 testEnemy = new Enemy1(100,0);
		
		EnemyList.push(testEnemy);
		testCharacter.update();
		
		EnemyList.remove(0);
		
		assertFalse(testCharacter.isHit());
	}

	
	@Test
	void characterAndEnemy2True() {
		
		Character testCharacter =  new Character(0,0);
		Enemy2 testEnemy = new Enemy2(0,0);
		
		EnemyList.push(testEnemy);
		testCharacter.update();
		
		EnemyList.remove(0);
		
		assertTrue(testCharacter.isHit());
	}
	
	@Test
	void characterAndEnemy2False() {
		
		Character testCharacter =  new Character(0,0);
		Enemy2 testEnemy = new Enemy2(100,0);
		
		EnemyList.push(testEnemy);
		testCharacter.update();
		
		EnemyList.remove(0);
		
		assertFalse(testCharacter.isHit());
	}
	
	
	@Test
	void characterAndEnemyBullet() {
		
		Character testCharacter = new Character(0,0);
		EnemyBullet testBullet = new EnemyBullet(Direction.DOWN,0,0,testCharacter);
		
		testBullet.checkPlayerCollision();
		testCharacter.update();
		
		assertTrue(testCharacter.isHit());
	}
	
	@Test
	void checkEnemyProjectileDestroyed() {
		
		Character testCharacter = new Character(0,0);
		EnemyBullet testBullet = new EnemyBullet(Direction.DOWN,0,0,testCharacter);
	
		testCharacter.update();
		
		//enemy bullets update method should return true if it's destroyed.
		assertTrue(testBullet.update());
	}

	@Test
	void enemy1AndCharacterBullet() {
		Enemy1 testEnemy = new Enemy1(0,0);
		CharacterBullet testBullet = new CharacterBullet(Direction.DOWN, 0, 0);
		
		EnemyList.push(testEnemy);
		testBullet.update();
		assertTrue(EnemyList.get(0).isHit());
		EnemyList.remove(0);
	}
	
	@Test
	void checkCharacterProjectileDestroyed1() {
		Enemy1 testEnemy = new Enemy1(0,0);
		CharacterBullet testBullet = new CharacterBullet(Direction.DOWN, 0, 0);
		
		EnemyList.push(testEnemy);
		assertTrue(testBullet.update());
		EnemyList.remove(0);
	}
	
	@Test
	void enemy2AndCharacterBullet() {
		Enemy2 testEnemy = new Enemy2(0,0);
		CharacterBullet testBullet = new CharacterBullet(Direction.DOWN, 0, 0);
		
		EnemyList.push(testEnemy);
		testBullet.update();
		assertTrue(EnemyList.get(0).isHit());
		EnemyList.remove(0);
	}
	
	@Test
	void checkCharacterProjectileDestroyed2() {
		Enemy2 testEnemy = new Enemy2(0,0);
		CharacterBullet testBullet = new CharacterBullet(Direction.DOWN, 0, 0);
		
		EnemyList.push(testEnemy);
		assertTrue(testBullet.update());
		EnemyList.remove(0);
	}

}
