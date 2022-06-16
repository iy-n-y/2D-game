package theGame.state;

import java.awt.*;

public abstract class State {

  private static State currentState = null;

  public  static void setState(State state){
    currentState =state;
  }
  public  static State getState(){
    return currentState;
  }
    public abstract  void upDate();

    public abstract void render(Graphics g);
	public abstract void restart();
}
