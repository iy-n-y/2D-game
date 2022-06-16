package character;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import controls.Control;
import theGame.main.Game;
import theGame.state.*;
import map.Map;
import tile.Tile;

/**
 * Main character of the game.
 * @author Jordan Horacsek
 *
 */
public class Character extends Entity{
	private boolean canShoot=false;
	private int counter=0;
	private int cooldown=30;
	private int score=100;
	private int colX=(int)((posX/Tile.TILEWIDTH)+0.5);
	private int colY=(int)((posY/Tile.TILEHIGHT)+1);
	
	public Character(int posX, int posY){
		super(posX, posY,"/src/main/resources/character/mainCharacter");
	}
	/**
	 * Activates when player is hit, either by a projectile or collision from an enemy.
	 * Decreases the score and activates the super hit from entity.
	 */
	public void hit() {
		super.hit();
		if(hitCounter==0)
			decreaseScore(25);
	}
	
	/**
	 * Checks for any collisions with enemies.
	 */
	public void checkEnemyCollision() {
		//System.out.println(EnemyList.get(0).getY());
		for(int i=0; i < EnemyList.getElements(); i++) {
			if(Collision.isColliding(this,EnemyList.get(i))) {
				hit();
			}
		}
		return;
	}
	/**
	 * Increases the players score
	 * @param score Amount the score increases.
	 */
	public void increaseScore(int score) {
		this.score+=score;
	}
	/**
	 * Decreasese the players score
	 * @param score Amount the score decreases.
	 */
	public void decreaseScore(int score) {
		this.score-=score;
	}
	public int getScore() {
		return score;
	}
	/**
	 * Adds a bullet to the character bullet queue.
	 */
	public void shoot() {
		GameState.pushCharacterBullet(getDirection(), posX, posY);
		canShoot=false;
	}
	/**
	 * All logic that needs to be updated for the character is in this method.
	 */
	public void update() {
		checkEnemyCollision();
		colX=(int)((posX/Tile.TILEWIDTH)+0.75);
		colY=(int)((posY/Tile.TILEHIGHT)+1);
		//And timer is ready
		//System.out.println(Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+1)).getId());
		//Map.getTile((int)posX,(int)posY);
		//x*Tile.TILEWIDTH,y*Tile.TILEHIGHT
		//System.out.println((int)((posX/Tile.TILEWIDTH)+0.5)+" "+(int)((posY/Tile.TILEHIGHT)+1));
		if(counter > cooldown) {
			counter = 0;
			canShoot = true;
		}
		if (canShoot==false)
			counter++;
		if(Control.spaceBar && canShoot) {
			shoot();
		}
		moving=true;
		if(Control.getDirection()[Direction.UP.ordinal()]==true) {
			//Handles basic collision...
			if(!Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+1)).isSolid()) {
				moveUp();
			}
			return;
		}
		else if(Control.getDirection()[Direction.DOWN.ordinal()]==true) {
			//Handles basic collision...
			if(!Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+1.45)).isSolid()) {
				moveDown();
			}
			return;
		}
		else if(Control.getDirection()[Direction.LEFT.ordinal()]==true) {
			//Handles basic collision for the left
			if(!Map.getTile((int)((posX/Tile.TILEWIDTH)+0.25),(int)((posY/Tile.TILEHIGHT)+1.125)).isSolid()) {
				moveLeft();
			}
			return;
		}
		else if(Control.getDirection()[Direction.RIGHT.ordinal()]==true) {
			//Handles basic collision for the right
			if(!Map.getTile((int)(colX+0.3),(int)((posY/Tile.TILEHIGHT)+1.125)).isSolid()) {
				moveRight();
			}
			return;
		} 
		stopMoving();
		return;
			
	}
	public int getX() {
		return super.getX()+5;
	}
	public int getWidth() {
		return super.getWidth()-10;
	}
	/**
	 * Renders the character.
	 */
	public void render(Graphics g) {
		super.render(g);
		

	}
	
}
