package videopoker;

import deckofcards.*;

public class Table {
	
	Deck deck;
	Hand hand;
	Pot pot;
	Credit credit;
	

	Table(int c, Deck d){
		
		pot = new Pot();
		hand = new Hand();
		credit = new Credit(c);
		deck = d;
	}
	
	void addToPot(int bet){
		credit.redraw(bet);
		pot.inPot(bet);
	}
	
	void addCredit(int payout){
		credit.add(payout);
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
	
	void switchCard(int index){
		
		this.deck.collectCard(this.hand.removeCard(index));
		this.hand.addCard(index, this.deck.drawCard());
		
	}
	/**
	 * ola Eu sou O bruno
	 * 
	 * 
	 * @param indexes
	 */
	void holdCards(int[] indexes){
		
		
		for(int i=0; i<5; i++){
			boolean sw=true;
			for(int j=0; j<indexes.length; j++)
				if(i==(indexes[j]-1))
					sw = false;
			if(sw)
				this.switchCard(i);
		}
		System.out.println(this.hand);
		System.out.println(this.hand.evaluateHand());
		
	}
	
	String getHand(){
		return this.hand.toString();
	}

	@Override
	public String toString() {
		return "Table ["+ deck + "\n"+ hand + "]";
	}

	public static void main(String[] args) {
		
			Table table = new Table(1000, new Deck());
			table.shuffleDeck();
			table.hand.addCard(new Card('J', 'C', 11));
			table.hand.addCard(new Card('J', 'D', 11));
			table.hand.addCard(new Card('2', 'H', 2));
			table.hand.addCard(new Card('3', 'S', 3));
			table.hand.addCard(new Card('5', 'D', 5));
			System.out.println(table.hand);
			System.out.println(table.hand.evaluateHand());
			
			
			
	}
}