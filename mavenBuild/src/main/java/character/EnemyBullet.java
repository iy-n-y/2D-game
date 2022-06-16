package character;

import map.Map;
import tile.Tile;
/**
 * Class that creates the enmy bullet.
 * @author Rohan B.
 *
 */
public class EnemyBullet extends Projectile{
	private Entity toBeHit;
	public EnemyBullet(Direction direction, float initialX, float initialY, Entity toBeHit) {
		super(direction,initialX,initialY,"/src/main/resources/Enemy/enemyBullet.png");
		this.toBeHit=toBeHit;
	}
	public void checkPlayerCollision() {
		if(Collision.isColliding(this,toBeHit)) {
			//This would be like where the enemy loses health
			toBeHit.hit();
			isDestroyed=true;
			//Also should destroy the bullet
			//Also this should be moved to the playerbullet class
		}
		return;
	}
	public boolean update() {
		//Might need to be moved to bottom of list
		checkPlayerCollision();
		if(isDestroyed)
			return true;
		if(Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+1)).isSolid()) {
			isDestroyed=true;
		}
		if(Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+1.45)).isSolid()) {
			isDestroyed=true;
		}
		if(Map.getTile((int)((posX/Tile.TILEWIDTH)+0.25),(int)((posY/Tile.TILEHIGHT)+1.125)).isSolid()) {
			isDestroyed=true;
		}
		if(Map.getTile((int)((int)((posX/Tile.TILEWIDTH)+0.5)+0.3),(int)((posY/Tile.TILEHIGHT)+1.125)).isSolid()) {
			isDestroyed=true;
		}
		
		posY += speedY;
		posX += speedX;
		
		//System.out.println(isDestroyed);
		return isDestroyed;
	}
}
