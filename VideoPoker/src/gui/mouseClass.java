package gui;

import java.awt.event.*;

class mouseClass implements MouseListener{
  public boolean held=false;
  public boolean clicked=false;
  public int x=0;
  public int y=0;
  
  public void mouseReleased(MouseEvent e){
    held=false;
    clicked=false;
  }
  
  public void mousePressed(MouseEvent e){
    if(held){clicked=false; return;}
    else{
      held=true;
      clicked=true;
      x=e.getX();
      y=e.getY();
    }
  }
  
  public void mouseEntered(MouseEvent e){}
  public void mouseClicked(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  
}