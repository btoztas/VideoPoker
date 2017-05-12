package gui;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import videopoker.Statistics;

import javax.swing.*;

import deckofcards.EmptyDeckEception;
import videopoker.InsufficientFundsException;
import videopoker.InvalidAmountException;
import videopoker.InvalidCardIndexException;
import videopoker.InvalidGameStateException;
import videopoker.PlayResult;
import videopoker.VideoPoker;
import videopoker107DB.VideoPokerType107DB;


public class GameWindow extends JPanel implements ActionListener{
	
	private JLayeredPane layeredPane;
	protected VideoPoker v; 
	
	protected JButton advice, hold, betUpButton, baralhoButton;
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
    JLabel text = new JLabel();
    JLabel winim = new JLabel();
    final ImageIcon back = new ImageIcon("otherim/backf.png");
    final ImageIcon not = new ImageIcon("cards/advice.png");
	protected JLabel[] notCard = new JLabel[5];
	protected JButton[] holdCardButton = new JButton[5];
	protected JButton[] bet = new JButton[5];
	protected int betAmount = 5;
	protected int credit = 0;
	protected boolean b = false;
	protected boolean d = false;
	protected JLabel[] coin = new JLabel[5];
	
    protected ImageIcon holdImage = new ImageIcon("otherim/hold0.png");
	private JLabel handdown;
	private JLabel textdeal;
	private JLabel handleft1;
	private JLabel handdown1;
	private JLabel handdown2;
	private JLabel textha;
	private JLabel texthold;
	private JButton tutorialButton;
	private int tut = 1;
	private JLabel textbet;
	private JLabel textperc;;
    
    public GameWindow(){
        
        JOptionPane box = new JOptionPane();
        
        box.setBounds(500,225,200,200);
        
        String s = (String)JOptionPane.showInputDialog(
                box,
                "Initial Credit:",
                "VideoPoker",
                JOptionPane.PLAIN_MESSAGE);
        if(s==null){
        	System.exit(0);
        }
        if (s.matches("[0-9]+") && s.length() > 0) {
        	credit = Integer.parseInt(s);
        }else{
        	System.exit(0);
        }
    		
    	 setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	 v = new VideoPoker(credit, new VideoPokerType107DB());
 	     
 	     String st = "Statistics";
 	     String stat = "<html>Hand<br>Jacks or Better<br>Two Pair<br>Three of a Kind<br>Straight<br>Flush<br>Full House<br>Four of a Kind<br>Straight Flush<br>Royal Flush<br>Other<br>Total<br>Credit</html>";
 	     Statistics statist = v.statistics();
 	     String statistics= "<html>Nb<br>";
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
 	     
 	     
         final ImageIcon bg = new ImageIcon("otherim/BG1.png");
         
         final ImageIcon adviceButton = new ImageIcon("otherim/advice.png");
         final ImageIcon betUp = new ImageIcon("otherim/betbut.png");
         final ImageIcon betBottom = new ImageIcon("otherim/betbot.png");
         final ImageIcon holdButton = new ImageIcon("otherim/hold.png");
         final ImageIcon coin1 = new ImageIcon("chips/5.png");
         final ImageIcon tutorial = new ImageIcon("otherim/tutorial.png");
         
         
        
         
         
         
         
         
         
         
         
         
         layeredPane = new JLayeredPane();
         
         for(int i =0 ; i<5 ;i++){
        	 coin[i] = new JLabel(new ImageIcon("chips/"+(i+1)+".png"));
        	 coin[i].setBounds(265, 485, coin1.getIconWidth(), coin1.getIconHeight());
        	 coin[i].setOpaque(false);
        	 coin[i].setVisible(false);
        	 layeredPane.add(coin[i]);
         }
         
         
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
         
         
         
         text = new JLabel(instr + v.credit());
         text.setBounds(130,460,400,100);
         text.setBackground(Color.white);
         text.setOpaque(false);
         text.setFont(new Font("Impact", Font.PLAIN, 25));
         layeredPane.add(text,new Integer(9));
         
         layeredPane.setPreferredSize(new Dimension(bg.getIconWidth(),bg.getIconHeight()));
         
         layeredPane.setLayout(null);
         
         Point origin = new Point(129, 200);
         JLabel label = new JLabel(bg);
         label.setOpaque(true);
         label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());
         layeredPane.add(label, new Integer(0));         
         

         baralhoButton = new JButton(back);
         baralhoButton.setBounds(870, origin.y-1, 135, 208);
         baralhoButton.setBackground(Color.black);
         baralhoButton.setOpaque(false);
         
         baralhoButton.setMnemonic(KeyEvent.VK_D);
         baralhoButton.setActionCommand("deal");
         baralhoButton.setToolTipText("Click the deck to deal");
         baralhoButton.setEnabled(true);
         baralhoButton.addActionListener(this);  
    
         
         
         
         layeredPane.add(baralhoButton, new Integer(6));
         
         
         
         betUpButton = new JButton(betUp);
         betUpButton.setActionCommand("bet");
         betUpButton.addActionListener(this);
         betUpButton.setOpaque(true);
         betUpButton.setBounds(397,468,110,45);
         layeredPane.add(betUpButton, new Integer(7));
         
         tutorialButton = new JButton(tutorial);
         tutorialButton.setActionCommand("tutorial");
         tutorialButton.addActionListener(this);
         tutorialButton.setOpaque(true);
         tutorialButton.setBounds(1030,100,200,20);
         layeredPane.add(tutorialButton, new Integer(7));
         
         JLabel betBottomButton = new JLabel(betBottom);
         betBottomButton.setVerticalAlignment(JLabel.TOP);
         betBottomButton.setHorizontalAlignment(JLabel.CENTER);
         betBottomButton.setOpaque(true);
         betBottomButton.setBounds(397, 512, 110, 43);
         layeredPane.add(betBottomButton, new Integer(8));
         
         for(int i =0; i<5;i++){
        	 bet[i]=new JButton();
        	 bet[i].setIcon(new ImageIcon("otherim/"+(i+1)+".png"));
        	 bet[i].setOpaque(true);
        	 bet[i].setBounds(398+(22*i),532,20,23);
        	 bet[i].setActionCommand("bet"+(i+1));
        	 bet[i].addActionListener(this);
        	 layeredPane.add(bet[i], new Integer(9));
         }
         
         
         
         
         
         advice = new JButton(adviceButton);
         advice.setMnemonic(KeyEvent.VK_A);
         advice.setActionCommand("advice");
         advice.setToolTipText("Click to get a hint");
         advice.setBounds(553,468,110,87);
         advice.addActionListener(this);
         advice.addMouseListener(new adviceMouseListener());
         
         layeredPane.add(advice, new Integer(7));
         
         hold = new JButton(holdButton);
         hold.setMnemonic(KeyEvent.VK_H);
         hold.setActionCommand("hold");         
         hold.setBounds(709,468,110,87);
         hold.addActionListener(this);
         layeredPane.add(hold, new Integer(8));
         
         
         for(int i=1;i<6;i++){
        	 hand[i-1] = createCard(holdImage,"backf",origin,i-1);
         }
         winim=new JLabel();
         winim.setIcon(new ImageIcon("otherim/royalflush.png"));
      	 winim.setBounds(200,50,800,100);
      	 winim.setVisible(false);
      	 layeredPane.add(winim, new Integer(100));
      	 
      	 handdown = new JLabel();
      	 handdown.setIcon(new ImageIcon("otherim/handdown.png"));
     	 handdown.setBounds(870,50,120,150);
     	 handdown.setVisible(false);
     	 handdown.setOpaque(false);
     	 layeredPane.add(handdown, new Integer(100));
     	 
     	 handdown1 = new JLabel();
     	 handdown1.setIcon(new ImageIcon("otherim/handdown.png"));
    	 handdown1.setBounds(710,50,120,150);
    	 handdown1.setVisible(false);
    	 handdown1.setOpaque(false);
    	 layeredPane.add(handdown1, new Integer(100));
      	 
    	 handdown2 = new JLabel();
      	 handdown2.setIcon(new ImageIcon("otherim/handdown.png"));
     	 handdown2.setBounds(100,50,120,150);
     	 handdown2.setVisible(false);
     	 handdown2.setOpaque(false);
     	 layeredPane.add(handdown2, new Integer(100));
     	 
     	 textdeal = new JLabel("YOU CAN DEAL");
     	 textdeal.setBounds(845,-14,200,100);
     	 textdeal.setBackground(Color.white);
     	 textdeal.setForeground(Color.LIGHT_GRAY);
     	 textdeal.setOpaque(false);
     	 textdeal.setVisible(false);
     	 textdeal.setFont(new Font("Impact", Font.PLAIN, 35));
     	 layeredPane.add(textdeal,new Integer(9));
     	 
     	 handleft1 = new JLabel();
     	 handleft1.setIcon(new ImageIcon("otherim/handleft.png"));
    	 handleft1.setBounds(870,430,150,150);
    	 handleft1.setVisible(true);
    	 handleft1.setOpaque(false);
    	 layeredPane.add(handleft1, new Integer(100));
     	 
    	 
    	 textbet = new JLabel("PLACE YOUR BET");
    	 textbet.setBounds(1020,450,300,100);
    	 textbet.setBackground(Color.white);
    	 textbet.setForeground(Color.LIGHT_GRAY);
    	 textbet.setOpaque(false);
    	 textbet.setVisible(true);
    	 textbet.setFont(new Font("Impact", Font.PLAIN, 35));
    	 layeredPane.add(textbet,new Integer(9));
    	 
   	 
	   	 textha = new JLabel("HOLD OR ADVICE");
	   	 textha.setBounds(1020,450,300,100);
	   	 textha.setBackground(Color.white);
	   	 textha.setForeground(Color.LIGHT_GRAY);
	   	 textha.setOpaque(false);
	   	 textha.setVisible(false);
	   	 textha.setFont(new Font("Impact", Font.PLAIN, 35));
	   	 layeredPane.add(textha,new Integer(9));
	   	 
	   	 texthold = new JLabel("CHOOSE THE CARDS YOU WISH TO HOLD");
	   	 texthold.setBounds(210,50,800,100);
	   	 texthold.setBackground(Color.white);
	   	 texthold.setForeground(Color.LIGHT_GRAY);
	   	 texthold.setOpaque(false);
	   	 texthold.setVisible(false);
	   	 texthold.setFont(new Font("Impact", Font.PLAIN, 35));
	   	 layeredPane.add(texthold,new Integer(9));
	   	 
	   	 textperc = new JLabel(statist.getPercentage());
	   	 textperc.setBounds(1123,413,140,60);
	   	 textperc.setBackground(Color.white);
	   	 textperc.setForeground(Color.gray);
	   	 textperc.setOpaque(false);
	   	 textperc.setVisible(true);
	   	 textperc.setFont(new Font("Impact", Font.PLAIN, 15));
	   	 layeredPane.add(textperc,new Integer(9));
	   	 
	   	 paintCoins(4);
      	 
         add(layeredPane);
         
         
       
    }
    
    public void paintCoins(int bet){

    	for(int i = 0 ; i<5 ; i++){
    		if(coin[i].isVisible()){
    			coin[i].setVisible(false);
					i=5;
				}
    	}
    	coin[bet].setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if ("deal".equals(e.getActionCommand())){
        	Point origin = new Point(129, 200);
        	String Hand;
			try {
				Hand = v.deal();
				d=true;
				advice.setEnabled(true);
				if(tut==1){
					handdown.setVisible(false);
		        	handdown1.setVisible(true);
		        	handdown2.setVisible(true);
		        	handleft1.setVisible(true);
		        	textdeal.setVisible(false);
		        	textha.setVisible(true);
		        	texthold.setVisible(true);
				}
				text.setText(instr + v.credit());
				b = true;
	          	 for (int i = 1; i <6; i++) {
	          		 int index = (i*2)+(i-3);
	          		 String cardName = Hand.substring(index,index+2);
	          		 layeredPane.remove(hand[i-1]);
	          		 hand[i-1] = createCard(holdImage,cardName,origin,i-1);
	          		 holdMouse = new holdMouseListener();
	          		 holdMouse.a=i-1;
	          		 holdMouse.holded=0;
	          		 hand[i-1].addMouseListener(holdMouse);
	                 layeredPane.add(hand[i-1], new Integer(i));
	                 cardsLayout[i-1] = (CardLayout) hand[i-1].getLayout();
	                 cardsLayout[i-1].show(hand[i-1], FRONT);
	                 origin.x += 137;
	          	 }
	          	 if(tut==0){
	          		 winim.setIcon(new ImageIcon("otherim/goodluck.png"));
	          		 winim.setVisible(true);
	          	 }
	          	 
			} catch (InvalidGameStateException e1) {
				
			} catch (InvalidAmountException e1) {
			} catch (InsufficientFundsException e1) {
			} catch (EmptyDeckEception e1) {
			}
        }else if("bet1".equals(e.getActionCommand())){
        	betAmount = 1;
        	paintCoins(0);
        }else if("bet2".equals(e.getActionCommand())){
        	betAmount = 2;
        	paintCoins(1);
        }else if("bet3".equals(e.getActionCommand())){
        	betAmount = 3;
        	paintCoins(2);
        }else if("bet4".equals(e.getActionCommand())){
        	betAmount = 4;
        	paintCoins(3);
        }else if("bet5".equals(e.getActionCommand())){
        	betAmount = 5;
        	paintCoins(4);
        }else if("bet".equals(e.getActionCommand())){
        	try {
				v.bet(betAmount);
				text.setText(instr + v.credit());
				if(tut==1){
					handdown.setVisible(true);
					textdeal.setVisible(true);
					handleft1.setVisible(false);
					textbet.setVisible(false);
				}
			} catch (InvalidAmountException e1) {
			} catch (InvalidGameStateException e1) {
			} catch (InsufficientFundsException e1) {
			}
        }else if("tutorial".equals(e.getActionCommand())){
        	tutorialButton.setVisible(false);
        	tut=0;
        	handdown.setVisible(false);
        	handdown1.setVisible(false);
        	handdown2.setVisible(false);
        	handleft1.setVisible(false);
        	textdeal.setVisible(false);
        	textbet.setVisible(false);
        	textha.setVisible(false);
        	texthold.setVisible(false);
        }else if("hold".equals(e.getActionCommand())){
        	
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
				advice.setEnabled(false);
            	d=false;
        		handdown.setVisible(false);
            	handdown1.setVisible(false);
            	handdown2.setVisible(false);
            	handleft1.setVisible(false);
            	textdeal.setVisible(false);
            	textbet.setVisible(false);
            	textha.setVisible(false);
            	texthold.setVisible(false);
            	tut=0;
            	tutorialButton.setVisible(false);
        		b = false;
				String Hand = p.getHand();
	          	baralhoButton.setEnabled(false);
	          	 for (int i = 1; i <6; i++) {
	          		 int index = (i*2)+(i-3);
	          		 String cardName = Hand.substring(index,index+2);
	          		 layeredPane.remove(hand[i-1]);
	          		 JLabel cardFront = new JLabel(new ImageIcon ("cards/"+cardName+".jpg"));
	          		 cardHolded[i-1] = new JLabel(new ImageIcon ("otherim/hold1.png"));
	            	 cardHolded[i-1].setOpaque(false);
	            	 cardHolded[i-1].setVisible(false);
	            	
	            	 holdCardButton[i-1] = new JButton(holdImage);
	            	 holdCardButton[i-1].setOpaque(false);
	            	 holdCardButton[i-1].setBounds(origin.x, origin.y, 135, 208);
	            	 holdCardButton[i-1].setVisible(false);
	            	 hand[i-1].add(holdCardButton[i-1]);
	             	 hand[i-1].add(cardHolded[i-1]);
	          		 hand[i-1].add(cardFront, FRONT);
	          		 hand[i-1].setName(cardName);
	          		 hand[i-1].setOpaque(false);
	          		 hand[i-1].setBounds(origin.x, origin.y, 135, 208);
	          		 hand[i-1].setVisible(true);
	          		 holdMouse = new holdMouseListener();
	          		 holdMouse.a=i-1;
	          		 holdMouse.holded=0;
	          		 hand[i-1].addMouseListener(holdMouse);
	                 layeredPane.add(hand[i-1], new Integer(i));
	                 cardsLayout[i-1] = (CardLayout) hand[i-1].getLayout();
	                 cardsLayout[i-1].show(hand[i-1], FRONT);
	                 origin.x += 137;
	          	 }
	          	 String win = p.getRes();
	          	 winim.setVisible(true);
	          	 if(win!=null){
		          	 if(win.equals("Royal Flush")){
			          	 winim.setIcon(new ImageIcon("otherim/royalflush.png"));
		          	 }
		          	 else if(win.equals("Straight Flush")){
			          	 winim.setIcon(new ImageIcon("otherim/straightflush.png"));
		          	 }
		          	 else if(win.equals("Four Aces")){
			          	 winim.setIcon(new ImageIcon("otherim/fouraces.png"));
		          	 }
		          	 else if(win.equals("Four 2-4")){
			          	 winim.setIcon(new ImageIcon("otherim/four2-4.png"));
		          	 }
		          	 else if(win.equals("Four 5-K")){
			          	 winim.setIcon(new ImageIcon("otherim/four5-K.png"));
		          	 }
		          	 else if(win.equals("Full House")){
			          	 winim.setIcon(new ImageIcon("otherim/fullhouse.png"));
		          	 }
		          	 else if(win.equals("Flush")){
			          	 winim.setIcon(new ImageIcon("otherim/flush.png"));
		          	 }
		          	 else if(win.equals("Straight")){
			          	 winim.setIcon(new ImageIcon("otherim/straight.png"));
		          	 }
		          	 else if(win.equals("Three of a Kind")){
			          	 winim.setIcon(new ImageIcon("otherim/threeofakind.png"));
		          	 }
		          	 else if(win.equals("Two Pair")){
			          	 winim.setIcon(new ImageIcon("otherim/twopair.png"));
		          	 }
		          	 else if(win.equals("Jacks or Better")){
			          	 winim.setIcon(new ImageIcon("otherim/jacksorbetter.png"));
		          	 }
	          	 }else{
		          	 winim.setIcon(new ImageIcon("otherim/lost.png"));
	          	 }
	          	 baralhoButton.setEnabled(true);
	        	 for(int i = 0; i<5 ; i++){
	        		 holdedCards[i]=false;
	         	 }
	          	 
			} catch (InvalidCardIndexException e1) {
				
			} catch (InvalidGameStateException e1) {
				
			} catch (EmptyDeckEception e1) {
				
			}
        	
        	Statistics statist = v.statistics();
        	String statistics= "<html>Nb<br>";
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
    	    textperc.setText(statist.getPercentage());
    	    
    	    text3.setText(statistics);
    	    text.setText(instr + v.credit());
        	
        }
        	
    }
    
    private JPanel createCard( ImageIcon holdImage, String front, Point origin, int i){
		
    	JPanel card = new JPanel(new CardLayout());
    	JLabel cardFront = new JLabel(new ImageIcon ("cards/"+front+".jpg"));
    	
    	cardHolded[i] = new JLabel(new ImageIcon ("otherim/hold1.png"));
    	cardHolded[i].setOpaque(false);
    	cardHolded[i].setVisible(false);
    	
    	holdCardButton[i] = new JButton(holdImage);
    	holdCardButton[i].setOpaque(false);
    	holdCardButton[i].setBounds(origin.x, origin.y, 135, 208);
    	holdCardButton[i].setVisible(true);
    	
    	
    	card.add(holdCardButton[i]);
    	card.add(cardHolded[i]);
    	card.add(cardFront, FRONT);
    	
    	card.setName(front);
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
		    	  if(d==true){
			    	  boolean[] choose = new boolean[5];
			    	  for(int i =0 ; i<5 ; i++)
			    		  choose[i] = false;
			    	  
			    	  try {
			    		if(v.advice()!=null){
							for(int i = 0; i<v.advice().length ; i++)
								  choose[v.advice()[i]-1]=true;
			    		}
					} catch (InvalidGameStateException e1) {
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
		      }
		      public void mouseReleased(MouseEvent e) {
		    	  if(d==true){
			    	  a--;
			    	  while(a>-1){
			    		  notCard[a].setVisible(false);
			    		  a--;
			    	  }
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
		    	  if(b == true){
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
	
	
	
	public static void main() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        
	}
}