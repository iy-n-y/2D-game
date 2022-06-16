package character;



import java.util.Random;

import map.Map;
import theGame.state.*;
import tile.Tile;

/**
 * The larger enemy that walks around in a circle and fires projectiles around.
 * @author Rohan B.
 *
 */
public class Enemy2 extends Enemy{
	private int movementUpdateTimer=0;
	private int fireCounter=0;
	private int fireAt;
	//The longest the enemy could possibly wait to fire is 2 seconds (120frames/60fps=2sec)
	private int maxFireTime=120;
	private Random rand;
	public Enemy2(int posX, int posY){
		super(posX, posY,"/src/main/resources/Enemy/Enemy2");
		speed=2;
		health=6;
		rand=new Random();
		fireAt=rand.nextInt(maxFireTime);
	}
	/**
	 * Updates the enemies basic movement. Uses it's own independent timer to determine when to update.
	 */
	public void updateBasicMovement() {
		movementUpdateTimer%=100;
		switch((int)movementUpdateTimer/25) {
			case 0:
				moveRight();
				break;
			case 1:
				moveDown();
				break;
			case 2:
				moveLeft();
				break;
			case 3:
				moveUp();
				break;
		}
		movementUpdateTimer++;
	}
	/**
	 * Adds a bullet to the enemyBulletList.
	 */
	public void EnemyShoot() {
		GameState.pushEnemyBullet(getDirection(), getX(), getY());
	}

	/**
	 * Contains all code that is updating at every tick.
	 */
	public void update() {
		moving=true;
		updateBasicMovement();
		if(fireCounter==fireAt) {
			EnemyShoot();
			fireCounter=0;
			fireAt=rand.nextInt(maxFireTime);
		}
		fireCounter++;
		return;
	}
	public int getX() {
		return super.getX()+15;
	}
	public int getWidth() {
		return super.getWidth()-30;
	}
	
	public int fireCount() {
		return fireCounter;
	}
	
	public int movementUpdateTimer() {
		return movementUpdateTimer;
	}
}
