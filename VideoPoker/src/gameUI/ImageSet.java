package gameUI;

import java.awt.*;
import java.util.*;

class ImageSet{
  public ArrayList<ImgChar> imglist=new ArrayList<ImgChar>(); 
  
  public ArrayList<ImgChar> getList(){return imglist;}
  
  public void addsprite(ImgChar s){
    imglist.add(s);
  }
  
  public void addsprite(int x, int y, Image img, boolean visible){
	ImgChar sp=new ImgChar();
    sp.x=x;
    sp.y=y;
    sp.img=img;
    sp.visible=visible;
  }

}
