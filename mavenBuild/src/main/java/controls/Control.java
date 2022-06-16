package controls;

import java.awt.event.*;
import character.Direction;

/**
 * Pretty generic class that handles keyboard input.
 * @author Jordan Horacsek
 *
 */
public class Control implements KeyListener {

	private static boolean[] directions= {false,false,false,false};
	public static boolean spaceBar= false;
	
	public Control() {

	}
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			//... W
			case 87:
				directions[Direction.UP.ordinal()] = true;
				break;
			//... S
			case 83:
				directions[Direction.DOWN.ordinal()] = true;
				break;
			//When A is pressed
			case 65:
				directions[Direction.LEFT.ordinal()] = true;
				break;
			//... D
			case 68:	
				directions[Direction.RIGHT.ordinal()] = true;
				break;
			//Space bar (for shooting)
			case 32:
				spaceBar=true;
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			//... W
			case 87:
				directions[Direction.UP.ordinal()] = false;
				break;
			//... S
			case 83:
				directions[Direction.DOWN.ordinal()] = false;
				break;
			//When A is pressed
			case 65:
				directions[Direction.LEFT.ordinal()] = false;
				break;
			//... D
			case 68:	
				directions[Direction.RIGHT.ordinal()] = false;
				break;
			//Space bar (for shooting)
			case 32:
				spaceBar=false;
				break;
		}
	}
	
	public static boolean[] getDirection() {
		return directions;
	}

}
