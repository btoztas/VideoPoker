package videopoker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import deckofcards.*;

public class Table {
	
	Deck deck;
	Hand hand;
	Pot pot;
	Credit credit;
	Statistics stat;
	

	Table(int c, Deck d){
		
		pot = new Pot();
		hand = new Hand();
		credit = new Credit(c);
		deck = d;
		stat = new Statistics();
	}
	
	void addToPot(int bet){
		credit.redraw(bet);
		pot.inPot(bet);
	}
	
	void addCredit(int payout){
		credit.add(payout);
	}
	
	void redrawCredit(int bet){
		credit.redraw(bet);
	}
	
	int getCredit(){
		return credit.getCredit();
	}
	
	int rmvFromPot(){
		return pot.outPot();
	}
	
	void drawHand(){
		for(int i=0; i<5; i++){
		 	this.hand.addCard(this.deck.drawCard());
		}
	}
	
	void shuffleDeck(){
		
		this.deck.shuffle();
	}
	
	void collectHand(){
		if(this.hand.existsHand()==true){
			for(int i=0; i<5; i++){
				this.deck.collectCard(this.hand.removeCard(0));
			}
		}
	}
	
	void switchCard(int index){
		
		this.deck.collectCard(this.hand.removeCard(index));
		this.hand.addCard(index, this.deck.drawCard());
		
	}
	
	HandType holdCards(int[] indexes){
		
		if(indexes==null){
			indexes = new int[0];
		}
		for(int i=0; i<5; i++){
			boolean sw=true;
			for(int j=0; j<indexes.length; j++)
				if(i==(indexes[j]-1))
					sw = false;
			if(sw)
				this.switchCard(i);
		}
		
		//System.out.println(this.hand);
		if(this.hand.evaluateHand()==null){
			this.rmvFromPot();
			//System.out.println("player loses and his credit is " + this.getCredit());
			return null;
		}else{
			HandType eval = this.hand.evaluateHand();
			this.addCredit(eval.getMult()*this.rmvFromPot());
			//System.out.println("player wins with a " + this.hand.evaluateHand() + " and his credit is " + this.getCredit());
			return this.hand.evaluateHand();
		}
		
	}
	
	String getHand(){
		return this.hand.toString();
	}
	
	int rankToScore(char rank){
		return this.deck.rankToScore(rank);
	}

	@Override
	public String toString() {
		return "Table ["+ deck + "\n"+ hand + "]";
	}
	

	public static void main(String[] args) {
		
			Table table = new Table(1000, new Deck());
			table.shuffleDeck();
			
			/*table.hand.addCard(new Card('7', 'S', 7));
			table.hand.addCard(new Card('5', 'H', 5));
			table.hand.addCard(new Card('T', 'H', 10));
			table.hand.addCard(new Card('4', 'C', 4));
			table.hand.addCard(new Card('2', 'S', 2));*/
			try{
			    PrintWriter writer = new PrintWriter("C:\\Users\\Afonso\\Desktop\\resultrui.txt", "UTF-8");
			    //writer.println("The first line");
			    //writer.println("The second line");
				BufferedReader br = null;
		        try {
		            br = new BufferedReader(new FileReader("C:\\Users\\Afonso\\Desktop\\cardtestadvisor.txt"));
		            String line;
		            int i = 0;
		            while ((line = br.readLine()) != null) {
		            	writer.println("difficult hand " + (i+1));
		            	System.out.println("difficult hand " + (i+1));
		            	for(int j=0;j<15;j=j+3){
		            		table.hand.addCard(new Card(line.charAt(j), line.charAt(j+1), table.rankToScore(line.charAt(j))));
		            	}
		            	//writer.println(table.hand);
		            	int[] res = table.hand.getAdvice();
		            	int l=1;
		    			if(res!=null){
		    				for(int k : res){
		    					writer.print(k);
		    					if(l!=res.length){
		    						writer.print(" ");
		    					}
		    					l++;
		    				}
		    				writer.println("");
		    			}else{
		    				writer.println("Discard everything");
		    			}
		    			table.collectHand();
		                //System.out.println(line);
		                i++;
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                if (br != null) {
		                    br.close();
		                }
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		        writer.close();
			} catch (IOException e) {
				   // do something
				}
			
			
			
	}
}