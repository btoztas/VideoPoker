package gui;

import javax.swing.*;

import java.awt.*;

public class ImagePanel extends JPanel{
  public Color transparent=new Color(254,254,254);
  public ImageSet imgL = new ImageSet(); 

  public ImagePanel(){}

  //override paint method of panel
  public void paint(Graphics g){
  //draw the image

    //for(ImageLayer il : LayerList){
      for(ImgChar sp : imgL.imglist){
        if(sp.visible)g.drawImage(sp.img,sp.x,sp.y,transparent,this);
      }
    //}
  }
}
