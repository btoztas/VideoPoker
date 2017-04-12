package videopoker;

import deckofcards.*;

public class Table {
	
	Deck deck;
	Hand hand;
	

	Table(){
		
		deck = new Deck();
		hand = new Hand();
		
	}
	
	public void drawHand(){
		for(int i=0; i<5; i++){
		 	this.hand.addCard(this.deck.drawCard());
		}
	}
	
	public void shuffleDeck(){
		
		this.deck.shuffle();
	}
	
	public void switchCard(int index){
		
		this.deck.collectCard(this.hand.removeCard(index));
		this.hand.addCard(index, this.deck.drawCard());
		
	}

	@Override
	public String toString() {
		return "Table ["+ deck + "\n"+ hand + "]";
	}

	public static void main(String[] args) {
		
		Table table = new Table();
		Card card;
		card = new Card('Q', 'H', 6);
		table.hand.addCard(card);
		card = new Card('T', 'C', 7);
		table.hand.addCard(card);
		card = new Card('K', 'H', 2);
		table.hand.addCard(card);
		card = new Card('J', 'H', 11);
		table.hand.addCard(card);
		card = new Card('A', 'H', 11);
		table.hand.addCard(card);
		
		System.out.println(table.hand.evaluateHand());
		
		
		
	}
}