package character;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Can be viewed as an ADT for managing the updating, rendering, and destruction of bullets (Projectiles more specifically).
 * (Also just wanted to note, I acknowledge that I recognize calling this class "BulletList" as opposed to "ProjectileList"
 *  was a bad move on my part).
 * @author Jordan Horacsek
 */
public class BulletList {
	private ArrayList<Projectile> bulletList;
	private int elements=0;
	public BulletList() {
		bulletList=new ArrayList<Projectile>();
	}
	/**
	 * Adds a bullet to the list.
	 * @param bullet
	 */
	public void push(Projectile bullet) {
		bulletList.add(bullet);
		elements++;
		return;
	}
	/**
	 * @return If 0 elements are in the list returns false, otherwise, it returns true.
	 */
	public boolean isEmpty() {
		if (elements==0)
			return true;
		return false;
	}

	/**
	 * Does nothing if empty or if index is larger than the last index.
	 * @param index Index of the element to be removed.
	 */
	public void remove(int index) {
		if (isEmpty() || index >= elements) {
			return;
		}else {
			elements--;
			bulletList.remove(index);
		}
		return;
	}
	/**
	 * Updates logic of all bullets in the list.
	 */
	public void update() {
		//Updates all the bullets in the list
		for(int i=0; i<elements;i++)
			if(bulletList.get(i).update())
				remove(i);
		
	}
	/**
	 * Renders each bullet in the list.
	 * @param g 
	 */
	public void render(Graphics g) {
		//Renders all the bullets in the list
		for(int i=0; i<elements;i++)
			bulletList.get(i).render(g);
	}
	
	
}
