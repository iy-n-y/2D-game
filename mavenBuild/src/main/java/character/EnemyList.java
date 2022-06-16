package character;

import java.awt.Graphics;
import java.util.ArrayList;
/**
 * Can be thought of as an ADT that manages all the enemies in the game.
 * @author Jordan Horacsek.
 *
 */
public class EnemyList {
	private static ArrayList<Enemy> enemyList;
	private static  int elements=0;
	private static int returnScore=0;
	
	public EnemyList() {
		enemyList=new ArrayList<Enemy>();
	}
	
	public static void push(Enemy enemy) {
		enemyList.add(enemy);
		elements++;
		return;
	}
	public static boolean isEmpty() {
		if (elements==0)
			return true;
		return false;
	}
	public static Enemy get(int index) {
		return enemyList.get(index);
	}
	
	public static void pop() {
		if (isEmpty()) {
			return;
		}else {
			elements--;
			enemyList.remove(elements);
		}
		return;
	}

	public static void remove(int index) {
		if (isEmpty() || index >= elements) {
			return;
		}else {
			elements--;
			//enemyList.get(index).kill();
			enemyList.remove(index);
		}
		return;
	}
	public static void update() {
		for(int i=0; i<elements;i++) {
			enemyList.get(i).update();
			if(enemyList.get(i).isDead()) {
				remove(i);
				returnScore+=25;
			}
		}	
	}
	public static int getReturnScoreForUpdate() {
		int tempScore=returnScore;
		returnScore=0;
		return tempScore;
	}
	public static int returnScore() {
		return returnScore;	
	}
	public static int getElements() {
		return elements;
	}
	
	public static void render(Graphics g) {
		//FOR ALL BULLETS IN LIST RENDER
		for(int i=0; i<elements;i++)
			enemyList.get(i).render(g);
	}
	

}
