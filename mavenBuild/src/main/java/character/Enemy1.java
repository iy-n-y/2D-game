package character;


import map.Map;
import theGame.state.*;
import tile.Tile;

/**
 * First enemy, moves from wall to wall, tiny wolf.
 * @author Rohan B.
 *
 */
public class Enemy1 extends Enemy{
	private boolean swapDir = false;
			
		public Enemy1(int posX, int posY){
			super(posX, posY,"/src/main/resources/Enemy/Enemy1");
		}
		
		/**
		 * Where all code for the enemy is updated.
		 */
		public void update() {
			moving=true;
			//checks if the next tile is a wall
			if (Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+1.45)).isSolid() || Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+0.4)).isSolid()) {
				swapDir = !swapDir;		
			}
			if (swapDir) {
				moveUp();
				return;
			}else {
				moveDown();
				return;
			}
		}
		public int getX() {
			return super.getX()+15;
		}
		public int getWidth() {
			return super.getWidth()-30;
		}
}
			
	
			
			
			
			
			
			
			
			
			
			
		
			




