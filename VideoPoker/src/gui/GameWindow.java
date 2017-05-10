package gui;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import videopoker.Statistics;

import javax.swing.*;

import deckofcards.EmptyDeckEception;
import videopoker.InsufficientFundsException;
import videopoker.InvalidAmountException;
import videopoker.InvalidCardIndexException;
import videopoker.InvalidGameStateException;
import videopoker.PlayResult;
import videopoker.Statistics;
//import gameUI.teste.CustomMouseListener;
import videopoker.VideoPoker;
import videopoker107DB.VideoPokerType107DB;


public class GameWindow extends JPanel implements ActionListener{
	
	private JLayeredPane layeredPane;
	protected VideoPoker v; 
	
	protected JButton advice, hold, betUpButton, baralhoButton;
	//protected Vector<JPanel> hand = new Vector<JPanel>(); 
	//protected Vector<CardLayout> cardsLayout = new Vector<CardLayout>();
	protected JPanel[] hand = new JPanel[5];
	protected JLabel[] cardHolded = new JLabel[5];
	protected JPanel moving = new JPanel();
	protected CardLayout[] cardsLayout = new CardLayout[5];
	protected holdMouseListener holdMouse = new holdMouseListener();
	protected boolean[] holdedCards = new boolean[5];
    final static String FRONT = "front";
    final static String BACK = "back";
    final static int NOTCARD =20;
    protected JLabel text3 = new JLabel();
    String instr = "Credit: ";
    final ImageIcon back = new ImageIcon("backf.png");
    final ImageIcon not = new ImageIcon("cards/advice.png");
	protected JLabel[] notCard = new JLabel[5];
	protected JButton[] holdCardButton = new JButton[5];

    protected ImageIcon holdImage = new ImageIcon("hold0.png");
    
    public GameWindow(){
    	/*final ImageIcon bg = new ImageIcon("fundo1.jpg");
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(bg.getIconWidth(),bg.getIconHeight()));
        layeredPane.setLayout(null);
        JLabel label = new JLabel(bg);
        label.setOpaque(true);
        label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());
        layeredPane.add(label, new Integer(0));*/
        
        JOptionPane box = new JOptionPane();
        
        box.setBounds(500,225,200,200);
        
        String s = (String)JOptionPane.showInputDialog(
                box,
                "Initial Credit:",
                "VideoPoker",
                JOptionPane.PLAIN_MESSAGE);
        
        /*layeredPane.add(box, 0);
        add(layeredPane);*/
    	
    		
    	 setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	 v = new VideoPoker(1000, new VideoPokerType107DB());
    	 Vector<JPanel> card = new Vector<JPanel>(); 
 	     String state = "hold";
 	     
 	     String st = "Statistics";
 	     String stat = "<html>Hand<br>Jacks or Better<br>Two Pair<br>Three of a Kind<br>Straight<br>Flush<br>Full House<br>Four of a Kind<br>Straight Flush<br>Royal Flush<br>Other<br>Total<br>Credit</html>";
 	     Statistics statist = v.statistics();
 	     String statistics= "<html>Nb<br>";
 	     System.out.println(statist.getStatistic("Jacks or Better"));
 	     statistics = statistics + statist.getStatistic("Jacks or Better") + "<br>";
 	     statistics = statistics + statist.getStatistic("Two Pair") + "<br>";
 	     statistics = statistics + statist.getStatistic("Three of a Kind") + "<br>";
 	     statistics = statistics + statist.getStatistic("Straight") + "<br>";
 	     statistics = statistics + statist.getStatistic("Flush") + "<br>";
 	     statistics = statistics + statist.getStatistic("Full House") + "<br>";
 	     statistics = statistics + statist.getStatistic("Four of a Kind") + "<br>";
 	     statistics = statistics + statist.getStatistic("Straight Flush") + "<br>";
 	     statistics = statistics + statist.getStatistic("Royal Flush") + "<br>";
 	     statistics = statistics + statist.getStatistic("Other") + "<br>";
 	     statistics = statistics + statist.getStatistic("Total") + "</html>";
 	     
 	     
         final ImageIcon bg = new ImageIcon("BG1.png");
         
         final ImageIcon adviceButton = new ImageIcon("advice.png");
         final ImageIcon betUp = new ImageIcon("betbut.png");
         final ImageIcon betBottom = new ImageIcon("betbot.png");
         final ImageIcon bet1 = new ImageIcon("1.png");
         final ImageIcon bet2 = new ImageIcon("2.png");
         final ImageIcon bet3 = new ImageIcon("3.png");
         final ImageIcon bet4 = new ImageIcon("4.png");
         final ImageIcon bet5 = new ImageIcon("5.png");
         final ImageIcon holdButton = new ImageIcon("hold.png");
         final ImageIcon not = new ImageIcon("cards/advice.png");
         //final ImageIcon holdImage = new ImageIcon("hold0.png");
         
         
        
         
         
         
         
         
         
         
         
         
         layeredPane = new JLayeredPane();
         
         JLabel text1 = new JLabel(st);
         text1.setBounds(1070,120+32,200,50);
         text1.setBackground(Color.white);
         text1.setOpaque(false);
         text1.setForeground(Color.gray);
         text1.setFont(new Font("Impact", Font.PLAIN, 23));
         layeredPane.add(text1);
         
         
         JLabel text2 = new JLabel(stat);
         text2.setBounds(1070,-70+120+32-10,600,500);
         text2.setBackground(Color.white);
         text2.setForeground(Color.gray);
         text2.setOpaque(false);
         text2.setFont(new Font("Impact", Font.PLAIN, 15));
         layeredPane.add(text2);
         
         text3 = new JLabel(statistics);
         text3.setBounds(1200,-79+120-10+32,600,500);
         text3.setBackground(Color.white);
         text3.setForeground(Color.gray);
         text3.setOpaque(false);
         text3.setFont(new Font("Impact", Font.PLAIN, 15));
         layeredPane.add(text3);
         
         
         
         JLabel text = new JLabel(instr + Integer.parseInt(s));
         text.setBounds(460,10,400,100);
         text.setBackground(Color.white);
         text.setOpaque(false);
         text.setFont(new Font("Impact", Font.PLAIN, 40));
         layeredPane.add(text,new Integer(9));
         
         layeredPane.setPreferredSize(new Dimension(bg.getIconWidth(),bg.getIconHeight()));
         
         layeredPane.setLayout(null);
         
         Point origin = new Point(129, 200);
         JLabel label = new JLabel(bg);
         //label.setVerticalAlignment(JLabel.TOP);
         //label.setHorizontalAlignment(JLabel.LEFT);
         label.setOpaque(true);
         label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());
         layeredPane.add(label, new Integer(0));         
         

         baralhoButton = new JButton(back);
         //baralhoButton.setIcon(back);
         baralhoButton.setBounds(870, origin.y-1, 135, 208);
         baralhoButton.setBackground(Color.black);
         baralhoButton.setOpaque(false);
         //baralhoButton.setBorderPainted(false);
         
         baralhoButton.setMnemonic(KeyEvent.VK_D);
         baralhoButton.setActionCommand("deal");
         baralhoButton.setToolTipText("Click the deck to deal");
         baralhoButton.setEnabled(true);
         baralhoButton.addActionListener(this);  
    
         
         
         
         layeredPane.add(baralhoButton, new Integer(6));
         
         
         
         betUpButton = new JButton(betUp);
         betUpButton.setVerticalAlignment(JButton.CENTER);
         betUpButton.setHorizontalAlignment(JButton.CENTER);
         betUpButton.setOpaque(true);
         betUpButton.setBounds(397,468,110,45);
         layeredPane.add(betUpButton, new Integer(7));
         
         JLabel betBottomButton = new JLabel(betBottom);
         betBottomButton.setVerticalAlignment(JLabel.TOP);
         betBottomButton.setHorizontalAlignment(JLabel.CENTER);
         betBottomButton.setOpaque(true);
         betBottomButton.setBounds(397, 512, 110, 43);
         layeredPane.add(betBottomButton, new Integer(8));
         
         JButton betone = new JButton(bet1);
         betone.setVerticalAlignment(JButton.CENTER);
         betone.setHorizontalAlignment(JButton.CENTER);
         betone.setOpaque(true);
         betone.setBounds(398,532,20,23);
         layeredPane.add(betone, new Integer(9));
         
         JButton bettwo = new JButton(bet2);
         bettwo.setVerticalAlignment(JButton.CENTER);
         bettwo.setHorizontalAlignment(JButton.CENTER);
         bettwo.setOpaque(true);
         bettwo.setBounds(420,532,21,23);
         layeredPane.add(bettwo, new Integer(10));
         
         
         JButton betthree = new JButton(bet3);
         betthree.setVerticalAlignment(JButton.CENTER);
         betthree.setHorizontalAlignment(JButton.CENTER);
         betthree.setOpaque(true);
         betthree.setBounds(443,532,20,23);
         layeredPane.add(betthree, new Integer(9));
         
         JButton betfour = new JButton(bet4);
         betfour.setVerticalAlignment(JButton.CENTER);
         betfour.setHorizontalAlignment(JButton.CENTER);
         betfour.setOpaque(true);
         betfour.setBounds(465,532,20,23);
         layeredPane.add(betfour, new Integer(9));
         
         JButton betfive = new JButton(bet5);
         betfive.setVerticalAlignment(JButton.CENTER);
         betfive.setHorizontalAlignment(JButton.CENTER);
         betfive.setOpaque(true);
         betfive.setBounds(487,532,20,23);
         layeredPane.add(betfive, new Integer(9));
         
         
         advice = new JButton(adviceButton);
         advice.setMnemonic(KeyEvent.VK_A);
         advice.setActionCommand("advice");
         advice.setToolTipText("Click to get a hint");
         //baralhoButton.setEnabled(true);
         //advice.setVerticalAlignment(JButton.CENTER);
        // advice.setHorizontalAlignment(JButton.CENTER);
        // advice.setOpaque(true);
         advice.setBounds(553,468,110,87);
         advice.addActionListener(this);
         advice.addMouseListener(new adviceMouseListener());
         
         layeredPane.add(advice, new Integer(7));
         
         hold = new JButton(holdButton);
        // hold.setVerticalAlignment(JButton.CENTER);
         //hold.setHorizontalAlignment(JButton.CENTER);
         //hold.setOpaque(true);
         hold.setMnemonic(KeyEvent.VK_H);
         hold.setActionCommand("hold");         
         hold.setBounds(709,468,110,87);
         hold.addActionListener(this);
         layeredPane.add(hold, new Integer(8));
         
         
         for(int i=1;i<6;i++){
        	 hand[i-1] = createCard(holdImage,"backf",origin,i-1);
         }
         add(layeredPane);
         
         
       
    }
    
    public void actionPerformed(ActionEvent e) {
        if ("deal".equals(e.getActionCommand())){
        	Point origin = new Point(129, 200);
        	try {
				v.bet(5);
			} catch (InvalidAmountException e2) {
				// TODO Auto-generated catch block
			} catch (InvalidGameStateException e2) {
				// TODO Auto-generated catch block
			} catch (InsufficientFundsException e2) {
				// TODO Auto-generated catch block
			}
        	String Hand;
        	System.out.println("ola");
			try {
				Hand = v.deal();
				System.out.println(Hand);
	          	baralhoButton.setEnabled(false);
	          	//hand = new Vector<JPanel>(); 
	          	 for (int i = 1; i <6; i++) {
	          		 int index = (i*2)+(i-3);
	          		 String cardName = Hand.substring(index,index+2);
	          		 int k = 0;
	          		 layeredPane.remove(hand[i-1]);
	          		 hand[i-1] = createCard(holdImage,cardName,origin,i-1);
	          		 /*while(k<137){
	          			moving = createCard(back,"backf.png",origin,i-1);
	          			layeredPane.add(moving, 0);
	          			//cardsLayout[i-1] = (CardLayout) hand[i-1].getLayout();
		                //cardsLayout[i-1].show(hand[i-1], FRONT);
	          			origin.x += 1;
	          			try {
							Thread.sleep(3);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	          			k++;
	          		 }*/
	          		 holdMouse = new holdMouseListener();
	          		 holdMouse.a=i-1;
	          		 holdMouse.holded=0;
	          		 hand[i-1].addMouseListener(holdMouse);
	                 layeredPane.add(hand[i-1], new Integer(i));
	                 cardsLayout[i-1] = (CardLayout) hand[i-1].getLayout();
	                 cardsLayout[i-1].show(hand[i-1], FRONT);
	                 origin.x += 137;
	          	 }
			} catch (InvalidGameStateException e1) {
				// TODO Auto-generated catch block
				
			} catch (InvalidAmountException e1) {
				// TODO Auto-generated catch block
			} catch (InsufficientFundsException e1) {
				// TODO Auto-generated catch block
			} catch (EmptyDeckEception e1) {
				// TODO Auto-generated catch block
			}
        }else if("hold".equals(e.getActionCommand())){
        	advice.setEnabled(false);
        	int j=0;
        	int count=0;
        	for(int i = 0; i<5 ; i++){
        		if(holdedCards[i]){
        			count++;
        		}
        	}
        	int[] toHold = new int[count];
        	for(int i = 0; i<5 ; i++){
        		if(holdedCards[i]){
        			toHold[j]=i+1;
        			j++;
        		}
        	}
        	Point origin = new Point(129, 200);
        	PlayResult p;
        	try {
				p = v.hold(toHold);
				String Hand = p.getHand();
				System.out.println(Hand);
	          	baralhoButton.setEnabled(false);
	          	//hand = new Vector<JPanel>(); 
	          	 for (int i = 1; i <6; i++) {
	          		 int index = (i*2)+(i-3);
	          		 String cardName = Hand.substring(index,index+2);
	          		 int k = 0;
	          		 layeredPane.remove(hand[i-1]);
	          		 JLabel cardFront = new JLabel(new ImageIcon ("cards/"+cardName+".jpg"));
	          		 cardHolded[i-1] = new JLabel(new ImageIcon ("hold1.png"));
	            	 cardHolded[i-1].setOpaque(false);
	            	 cardHolded[i-1].setVisible(false);
	            	
	            	 holdCardButton[i-1] = new JButton(holdImage);
	            	 holdCardButton[i-1].setOpaque(false);
	            	 holdCardButton[i-1].setBounds(origin.x, origin.y, 135, 208);
	            	 holdCardButton[i-1].setVisible(true);
	            	 hand[i-1].add(holdCardButton[i-1]);
	             	 hand[i-1].add(cardHolded[i-1]);
	          		 hand[i-1].add(cardFront, FRONT);// = createCard(holdImage,cardName,origin,i-1);
	          		 hand[i-1].setName(cardName);
	          		 hand[i-1].setOpaque(false);
	          		 hand[i-1].setBounds(origin.x, origin.y, 135, 208);
	          		 hand[i-1].setVisible(true);
	          		 /*while(k<137){
	          			moving = createCard(back,"backf.png",origin,i-1);
	          			layeredPane.add(moving, 0);
	          			//cardsLayout[i-1] = (CardLayout) hand[i-1].getLayout();
		                //cardsLayout[i-1].show(hand[i-1], FRONT);
	          			origin.x += 1;
	          			try {
							Thread.sleep(3);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	          			k++;
	          		 }*/
	          		 holdMouse = new holdMouseListener();
	          		 holdMouse.a=i-1;
	          		 holdMouse.holded=0;
	          		 hand[i-1].addMouseListener(holdMouse);
	                 layeredPane.add(hand[i-1], new Integer(i));
	                 cardsLayout[i-1] = (CardLayout) hand[i-1].getLayout();
	                 cardsLayout[i-1].show(hand[i-1], FRONT);
	                 origin.x += 137;
	          	 }
			} catch (InvalidCardIndexException e1) {
				
			} catch (InvalidGameStateException e1) {
				
			}
        	baralhoButton.setEnabled(true);
        	for(int i = 0; i<5 ; i++){
        		holdedCards[i]=false;
        	}
        	
        	Statistics statist = v.statistics();
        	String statistics= "<html>Nb<br>";
    	    System.out.println(statist.getStatistic("Jacks or Better"));
    	    statistics = statistics + statist.getStatistic("Jacks or Better") + "<br>";
    	    statistics = statistics + statist.getStatistic("Two Pair") + "<br>";
    	    statistics = statistics + statist.getStatistic("Three of a Kind") + "<br>";
    	    statistics = statistics + statist.getStatistic("Straight") + "<br>";
    	    statistics = statistics + statist.getStatistic("Flush") + "<br>";
    	    statistics = statistics + statist.getStatistic("Full House") + "<br>";
    	    statistics = statistics + statist.getStatistic("Four of a Kind") + "<br>";
    	    statistics = statistics + statist.getStatistic("Straight Flush") + "<br>";
    	    statistics = statistics + statist.getStatistic("Royal Flush") + "<br>";
    	    statistics = statistics + statist.getStatistic("Other") + "<br>";
    	    statistics = statistics + statist.getStatistic("Total") + "</html>";
    	    
    	    //JLabel text3 = new JLabel(statistics);
    	    text3.setText(statistics);
            //layeredPane.add(text3);
        	
        }
        	
    }
    
    private JPanel createCard( ImageIcon holdImage, String front, Point origin, int i){
		
    	JPanel card = new JPanel(new CardLayout());
    	JLabel cardFront = new JLabel(new ImageIcon ("cards/"+front+".jpg"));
    	
    	cardHolded[i] = new JLabel(new ImageIcon ("hold1.png"));
    	cardHolded[i].setOpaque(false);
    	cardHolded[i].setVisible(false);
    	
    	holdCardButton[i] = new JButton(holdImage);
    	holdCardButton[i].setOpaque(false);
    	holdCardButton[i].setBounds(origin.x, origin.y, 135, 208);
    	holdCardButton[i].setVisible(true);
    	
    	System.out.println("Card ="+front);
    	
    	card.add(holdCardButton[i]);
    	card.add(cardHolded[i]);
    	card.add(cardFront, FRONT);
    	
    	card.setName(front);
    	
       // card.setVerticalAlignment(JLabel.TOP);
       // card.setHorizontalAlignment(JLabel.CENTER);
    	card.setOpaque(false);
        card.setBounds(origin.x, origin.y, 135, 208);
        
        return card;
	
	}
    
	private static void createAndShowGUI(){
		
		JFrame frame = new JFrame("Video Poker");		
		
		JComponent newContentPane = new GameWindow();
        newContentPane.setOpaque(false); 
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
		
	
	}
	
	  public class adviceMouseListener implements MouseListener {
		  protected int a;
		      public void mouseClicked(MouseEvent e) {
		      }
		      public void mousePressed(MouseEvent e) {    	  
		    	
		    	  boolean[] choose = new boolean[5];
		    	  for(int i =0 ; i<5 ; i++)
		    		  choose[i] = false;
		    	  
		    	  try {
					for(int i = 0; i<v.advice().length ; i++)
						  choose[v.advice()[i]-1]=true;
				} catch (InvalidGameStateException e1) {
					// TODO Auto-generated catch block
				}
		    	  
		    	  a = 0 ;
		    	  for(int i = 0; i<5; i++){
		    		  if(!choose[i]){
		    			  notCard[a] = new JLabel(not);
		    			  notCard[a].setOpaque(false);
		    			  notCard[a].setBounds(hand[i].getBounds());
		    			  layeredPane.add(notCard[a], new Integer(11+i));
		    			  a++;
		    		  }
		    	  } 	
		      }
		      public void mouseReleased(MouseEvent e) {
		    	  System.out.println(a);
		    	  a--;
		    	  while(a>-1){
		    		  notCard[a].setVisible(false);
		    		  a--;
		    	  }
		      }
		      public void mouseEntered(MouseEvent e) {
		    	 
		      }
		      public void mouseExited(MouseEvent e) {
		    	  
		      }
		   }
	  public class holdMouseListener implements MouseListener {
		  protected int a;
		  protected int holded ;
		      public void mouseClicked(MouseEvent e) {
		    	  
		      }
		      public void mousePressed(MouseEvent e) {    	  
		    	
		      }
		      public void mouseReleased(MouseEvent e) {
		    	  holded++;
		    	  if(!(holded%2==0)){
		    		  cardHolded[a].setOpaque(false);
			    	  cardHolded[a].setVisible(true);
			    	  holdedCards[a]=true;
		    	  }else{
		    		  cardHolded[a].setVisible(false);
		    		  holdedCards[a]=false;
		    	  }
		      }
		      public void mouseEntered(MouseEvent e) {
		    	
		    	/*  if(!holdCardButton[a].isVisible()){
		    		  holdCardButton[a].setVisible(true);
		    		  holdCardButton[a].setOpaque(false);
		    	  }
		    	  	
		    	  		*/
		    	  
		      }
		      public void mouseExited(MouseEvent e) {
		    	/*  
		    	  for(int i=0 ; i<5 ;i++){		    		  
		    		  if(i==a)
		    			  holdCardButton[a].setVisible(false); 
		    	  }*/
		    	 
		      }
		   }
	public int checkCardByPoint(Point point){
		
		int card = 5;
		
		if(point.getY()>192 && point.getY()<415){
			if(point.getX()<260 && point.getX()>120)
				card=0;
			else if(point.getX()<400 && point.getX()>260)
				card=1;
			else if(point.getX()<540 && point.getX()>400)
				card= 2;
			else if(point.getX()<680 & point.getX()>540)
				card= 3;
			else if(point.getX()<820 && point.getX()>680)
				card= 4;
		}
		return card;
		
	}
	
	
	
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        
	}
}