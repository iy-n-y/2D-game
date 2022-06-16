package character;

/**
 * Class that contains methods that are required for each enemy.
 * @author Rohan B.
 *
 */
public class Enemy extends Entity{
	
	protected int health=4;
	protected boolean isDead=false;
	protected Enemy(int posX, int posY, String imagePathPrefix) {
		super(posX, posY, imagePathPrefix);
	}
	/**
	 * Activates on collision.
	 */
	public void hit() {
		//Also this should be the code that turns the guy red
		super.hit();
		health--;
		if(health==0)
			kill();
		return;
	}
	/**
	 * Activates on death.
	 */
	public void kill() {
		isDead=true;
		return;
	}
	/**
	 * @return whether or not the enemy is alive.
	 */
	public boolean isDead() {
		return isDead;
	}
	public int health() {
		return health;
	}

}
