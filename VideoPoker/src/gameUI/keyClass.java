package gameUI;

import java.awt.event.*;

class keyClass implements KeyListener{

  public boolean[] keys = new boolean[600];

  public void keyPressed(KeyEvent e){
    keys[e.getKeyCode()] = true;
  }
 
  public void keyReleased(KeyEvent e){
    keys[e.getKeyCode()] = false;
  }

  public void keyTyped(KeyEvent e){}

}
