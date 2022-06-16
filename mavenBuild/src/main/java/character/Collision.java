package character;

import map.staticEntity;
import reward.Reward;

/**
 * A collection of methods that handle collisions between entities, projectiles, and staticEntities.
 * (In the future all methods in this class would be combined into one singular method).
 * @author Jordan Horacsek
 */
public class Collision {
	/**
	 * Checks if a point is in a squares bounds.
	 * @param pX
	 * @param pY
	 * @param boundX1
	 * @param boundY1
	 * @param boundX2
	 * @param boundY2
	 * @return
	 */
	public static boolean isPointInSquare(int pX, int pY, int boundX1, int boundY1, int boundX2, int boundY2 ) {
			if(boundX1 <= pX && pX <= boundX2) {
				//These might need to be reversed.
				//System.out.println("hit 1");
			//	return true;
				if(boundY2 >= pY && pY >= boundY1) {
					return true;
				}
			}
		return false;
	}
	/**
	 * Handles collisions between entities
	 * @param entityOne
	 * @param entityTwo
	 * @return
	 */
	public static boolean isColliding(Entity entityOne, Entity entityTwo){
		int p[]=new int[4];
		p[0] = entityOne.getX();
		p[1] = entityOne.getY();
		p[2] = p[0]+entityOne.getWidth();
		p[3] = p[1]+entityOne.getHeight();

		int boundX1 = entityTwo.getX();					//q[0]
		int boundY1 = entityTwo.getY();					//q[1]
		int boundX2 = boundX1+entityTwo.getWidth();		//q[2]
		int boundY2 = boundY1+entityTwo.getHeight();	//q[3]

		if(isPointInSquare(p[0],p[1],boundX1,boundY1,boundX2,boundY2))
			return true;
		if(isPointInSquare(p[2],p[3],boundX1,boundY1,boundX2,boundY2))
			return true;
		if(isPointInSquare(boundX2,boundY1,p[0],p[1],p[2],p[3]))
			return true;
		if(isPointInSquare(boundX1,boundY2,p[0],p[1],p[2],p[3]))
			return true;
		
		return false;
	}
	/**
	 * Handles collisions between projectiles and entities
	 * @param projectile
	 * @param entity
	 * @return
	 */
	public static boolean isColliding(Projectile projectile, Entity entity) {
		int p[]=new int[4];
		p[0] = projectile.getX();
		p[1] = projectile.getY();
		p[2] = p[0]+projectile.getWidth();
		p[3] = p[1]+projectile.getHeight();

		int boundX1 = entity.getX();
		int boundY1 = entity.getY();
		int boundX2 = boundX1+entity.getWidth();
		int boundY2 = boundY1+entity.getHeight();

		if(isPointInSquare(p[0],p[1],boundX1,boundY1,boundX2,boundY2))
			return true;
		if(isPointInSquare(p[2],p[3],boundX1,boundY1,boundX2,boundY2))
			return true;
		if(isPointInSquare(boundX2,boundY1,p[0],p[1],p[2],p[3]))
			return true;
		if(isPointInSquare(boundX1,boundY2,p[0],p[1],p[2],p[3]))
			return true;
		
		return false;
	}
	/**
	 * Handles collisions between rewards and entities.
	 * @param pX
	 * @param pY
	 * @param reward
	 * @param entity
	 * @return
	 */
	public static boolean isColliding(int pX, int pY, Reward reward, Entity entity) {
		int p[]=new int[4];
		p[0] = pX;
		p[1] = pY;
		p[2] = p[0]+reward.getWidth();
		p[3] = p[1]+reward.getHeight();

		int boundX1 = entity.getX();
		int boundY1 = entity.getY();
		int boundX2 = boundX1+entity.getWidth();
		int boundY2 = boundY1+entity.getHeight();

		if(isPointInSquare(p[0],p[1],boundX1,boundY1,boundX2,boundY2))
			return true;
		if(isPointInSquare(p[2],p[3],boundX1,boundY1,boundX2,boundY2))
			return true;
		if(isPointInSquare(boundX2,boundY1,p[0],p[1],p[2],p[3]))
			return true;
		if(isPointInSquare(boundX1,boundY2,p[0],p[1],p[2],p[3]))
			return true;
		
		return false;
	}
	public static boolean isColliding(Entity entityOne, staticEntity entityTwo){
		int p[]=new int[4];
		p[0] = entityOne.getX();
		p[1] = entityOne.getY();
		p[2] = p[0]+entityOne.getWidth();
		p[3] = p[1]+entityOne.getHeight();

		int boundX1 = entityTwo.getX();
		int boundY1 = entityTwo.getY();
		int boundX2 = boundX1+entityTwo.getWidth();
		int boundY2 = boundY1+entityTwo.getHeight();

		if(isPointInSquare(p[0],p[1],boundX1,boundY1,boundX2,boundY2))
			return true;
		if(isPointInSquare(p[2],p[3],boundX1,boundY1,boundX2,boundY2))
			return true;
		if(isPointInSquare(boundX2,boundY1,p[0],p[1],p[2],p[3]))
			return true;
		if(isPointInSquare(boundX1,boundY2,p[0],p[1],p[2],p[3]))
			return true;
		
		return false;
	}
}
