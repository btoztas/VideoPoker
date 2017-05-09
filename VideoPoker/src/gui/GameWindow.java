package gui;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import deckofcards.EmptyDeckEception;
import videopoker.InsufficientFundsException;
import videopoker.InvalidAmountException;
import videopoker.InvalidGameStateException;
import videopoker.VideoPoker;
import videopoker107DB.VideoPokerType107DB;


public class GameWindow extends JPanel{
	
	private JLayeredPane layeredPane;
	private VideoPoker v; 
	

    final static String FRONT = "front";
    final static String BACK = "back";
    String instr = "teste";

    public GameWindow(){
    	
    	 setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

         v = new VideoPoker(1000, new VideoPokerType107DB());
 	     String state = "hold";
 	     
 	     //System.out.println("Hand : "Hand);
         
         final ImageIcon bg = new ImageIcon("fundo1.jpg");
         final ImageIcon back = new ImageIcon("backf.png");
         final ImageIcon adviceButton = new ImageIcon("advice.png");
         final ImageIcon betUp = new ImageIcon("betbut.png");
         final ImageIcon betBottom = new ImageIcon("betbot.png");
         final ImageIcon bet1 = new ImageIcon("1.png");
         final ImageIcon bet2 = new ImageIcon("2.png");
         final ImageIcon bet3 = new ImageIcon("3.png");
         final ImageIcon bet4 = new ImageIcon("4.png");
         final ImageIcon bet5 = new ImageIcon("5.png");
         final ImageIcon holdButton = new ImageIcon("hold.png");
         
         
         

         JLabel text = new JLabel(instr);
         layeredPane = new JLayeredPane();
         layeredPane.setPreferredSize(new Dimension(bg.getIconWidth(),bg.getIconHeight()));
         
         layeredPane.setLayout(null);
         
         Point origin = new Point(129, 200);
         JLabel label = new JLabel(bg);
         //label.setVerticalAlignment(JLabel.TOP);
         //label.setHorizontalAlignment(JLabel.LEFT);
         label.setOpaque(true);
         label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());
         layeredPane.add(label, new Integer(0));         
         

         JButton baralhoButton = new JButton(back);
         baralhoButton.setBounds(870, origin.y-1, 135, 208);
         baralhoButton.setBackground(Color.black);
         baralhoButton.setOpaque(false);
         //baralhoButton.setBorderPainted(false);
         
         baralhoButton.setMnemonic(KeyEvent.VK_D);
         baralhoButton.setActionCommand("deal");
         baralhoButton.setToolTipText("Click the deck to deal");
         baralhoButton.setEnabled(true);
         baralhoButton.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
            	 String Hand;
            	 try {
 					Hand = v.deal();
 					System.out.println(Hand);
 					for (int i = 1; i <6; i++) {
 	            		 int index = (i*2)+(i-3);
 	            		 String cardName = Hand.substring(index,index+2);
 	                     JPanel card = createCard(i,back,cardName,origin);
 	                     layeredPane.add(card, new Integer(i));
 	                     CardLayout cardLayout = (CardLayout) card.getLayout();
 	                     cardLayout.show(card, FRONT);
 	                     origin.x += 137;
 	            	 }
 				} catch (InvalidGameStateException e1){
 					System.out.println("d: " + e1.getMessage());
 				} catch (InvalidAmountException e1) {
 					System.out.println("d: " + e1.getMessage());
 				} catch (InsufficientFundsException e1) {
 					System.out.println("d: " + e1.getMessage());
 				} catch (EmptyDeckEception e1) {
 					System.out.println(e1.getMessage());
 					System.exit(-1);
 				}
             }
         });
         
         
         layeredPane.add(baralhoButton, new Integer(6));
         
         
         
         JButton betUpButton = new JButton(betUp);
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
         
         
         JButton advice = new JButton(adviceButton);
         advice.setVerticalAlignment(JButton.CENTER);
         advice.setHorizontalAlignment(JButton.CENTER);
         advice.setOpaque(true);
         advice.setBounds(553,468,110,87);
         layeredPane.add(advice, new Integer(7));
         
         JButton hold = new JButton(holdButton);
         hold.setVerticalAlignment(JButton.CENTER);
         hold.setHorizontalAlignment(JButton.CENTER);
         hold.setOpaque(true);
         hold.setBounds(709,468,110,87);
         layeredPane.add(hold, new Integer(8));
         
         text.setBounds(500,10,400,15);
         text.setBackground(Color.white);
         text.setOpaque(false);
         layeredPane.add(text,new Integer(9));
         
         add(layeredPane);
         
        /* while(true){
        	 
         }
         */
    }
	
   
    
    private JPanel createCard(int i, ImageIcon back, String front, Point origin){
		
    	JPanel card = new JPanel(new CardLayout());
    	JLabel cardFront = new JLabel(new ImageIcon ("cards/"+front+".jpg"));
    	JLabel cardBack = new JLabel(back);
    	
    	System.out.println("Card ="+front);
    	
    	card.add(cardFront, FRONT);
    	card.add(cardBack, BACK);
    	
    	
       // card.setVerticalAlignment(JLabel.TOP);
       // card.setHorizontalAlignment(JLabel.CENTER);
       // card.setOpaque(false);
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
