package character;

import map.Map;
import tile.Tile;
/**
 * The projectile specific to the main character.
 * @author Jordan Horacsek
 *
 */
public class CharacterBullet extends Projectile{
	public CharacterBullet(Direction direction, float initialX, float initialY) {
		super(direction,initialX,initialY,"/src/main/resources/character/fireball.png");
	}
	/**
	 * Checks if the projectile is currently colliding with an enemy.
	 */
	public void checkEnemyCollision() {
		for(int i=0; i < EnemyList.getElements(); i++) {
			if(Collision.isColliding(this,EnemyList.get(i))) {
				//This would be like where the enemy loses health
				EnemyList.get(i).hit();
				isDestroyed=true;
				//Also should destroy the bullet
				//Also this should be moved to the playerbullet class
			}
		}
		return;
	}
	/**
	 * Where bullet logic is updated.
	 */
	public boolean update() {
		//Might need to be moved to bottom of list
		checkEnemyCollision();
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
		
		return isDestroyed;
	}

}
