package gameUI;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;

public class gui{

public static int state=-1;
public static long time=0;

//Card images are 300x200 pixels, these values include a 5 pixel offset
public final static int CARD_WIDTH = 205; //Image size in pixels

public static int[] hand=new int[5];
public static int[] card=new int[5];
public static int[] suit=new int[5];
public static boolean held1=false;
public static boolean held2=false;
public static boolean held3=false;
public static boolean held4=false;
public static boolean held5=false;
public static boolean trigger=false;
public static boolean trigger1=false;
public static boolean trigger2=false;
public static boolean trigger3=false;
public static boolean trigger4=false;
public static boolean trigger5=false;
public static int cash=50;
public static int bet=0;
public static int b=0;

public static void main(String[] args) throws IOException{
  JFrame frame=new JFrame();
  ImagePanel panel=new ImagePanel();
  frame.getContentPane().add(panel);
  frame.setBackground(Color.WHITE);
  //deck Deck=new deck();
  
  
  JFrame frame2=new JFrame();

  frame2.setLayout(new FlowLayout());

  frame.setBounds(0,0,1535,760);
  frame2.setBounds(100,370,800,120);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  keyClass input=new keyClass();
  mouseClass mouse=new mouseClass();
  frame.addKeyListener(input);
  frame.addMouseListener(mouse);
  frame.setResizable(false);
  frame.setVisible(true);
  frame2.setVisible(true);

  JLabel currCash=new JLabel("Cash: "+cash);
  JLabel events = new JLabel("VideoPoker");

  anAction act1=new anAction(49, input.keys);
  anAction act2=new anAction(50, input.keys);
  anAction act3=new anAction(51, input.keys);
  anAction act4=new anAction(52, input.keys);
  anAction act5=new anAction(53, input.keys);
  anAction act6=new anAction(10, input.keys);
  anAction act7=new anAction(54, input.keys);
  anAction act8=new anAction(55, input.keys);
  anAction act9=new anAction(56, input.keys);

  JButton hold1=new JButton(act1);
  JButton hold2=new JButton(act2);
  JButton hold3=new JButton(act3);
  JButton hold4=new JButton(act4);
  JButton hold5=new JButton(act5);
  JButton hold6=new JButton(act6);
  JButton hold7=new JButton(act7);
  JButton hold8=new JButton(act8);
  JButton hold9=new JButton(act9);

  hold1.setText("bet  1");
  hold2.setText("bet  2");
  hold3.setText("bet  3");
  hold4.setText("bet  4");
  hold5.setText("bet  5");
  hold6.setText(" Draw ");
  hold7.setText(" Hold ");
  hold8.setText(" Advise ");
  hold9.setText(" Statistics ");
  currCash.setText("Cash: "+cash);
  
  frame2.add(currCash);
  frame2.add(hold1);
  frame2.add(hold2);
  frame2.add(hold3);
  frame2.add(hold4);
  frame2.add(hold5);
  frame2.add(hold6);
  frame2.add(hold7);
  frame2.add(hold8);
  frame2.add(hold9);
  frame2.add(events);

  
  for(int s=0; s<6; ++s){
    panel.imgL.imglist.add(new ImgChar());
  }
  
  
  panel.imgL.imglist.get(0).img = ImageIO.read(new File("cards/back1.png"));
    

  for(int s=0; s<5; ++s){  
    panel.imgL.imglist.get(s).img =panel.imgL.imglist.get(0).img;
    panel.imgL.imglist.get(s).x=5+(s*CARD_WIDTH);
    panel.imgL.imglist.get(s).y=5;
    panel.imgL.imglist.get(s).visible=true;
    
  }
  panel.imgL.imglist.get(5).img = ImageIO.read(new File("cards/coin.png"));
  panel.imgL.imglist.get(5).x=700;
  panel.imgL.imglist.get(5).y=500;
  panel.imgL.imglist.get(5).visible=true;
  frame.repaint(1, 0, 0, 1535,760);
}
}
