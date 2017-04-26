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
		if(this.hand.evaluateHand()==null){
			this.rmvFromPot();
			System.out.println("player loses and his credit is " + this.getCredit());
		}else{
			HandType eval = this.hand.evaluateHand();
			this.addCredit(eval.getMult()*this.rmvFromPot());
			System.out.println("player wins with a " + this.hand.evaluateHand() + " and his credit is " + this.getCredit());
		}
		
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
			
			table.hand.addCard(new Card('2', 'C', 2));
			table.hand.addCard(new Card('T', 'H', 10));
			table.hand.addCard(new Card('Q', 'S', 12));
			table.hand.addCard(new Card('4', 'D', 4));
			table.hand.addCard(new Card('J', 'S', 11));
			System.out.println(table.hand);
			System.out.print("Advice ");
			for(int i : table.hand.getAdvice())
				System.out.print(i+" ");
			System.out.println();
			
			
			
	}
}