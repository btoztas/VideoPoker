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
	/**
	 * ola Eu sou O bruno
	 * 
	 * 
	 * @param indexes
	 */
	public void holdCards(int[] indexes){
		
		
		for(int i=0; i<5; i++){
			boolean sw=true;
			for(int j=0; j<indexes.length; j++)
				if(i==(indexes[j]-1))
					sw = false;
			if(sw)
				this.switchCard(i);
		}
	}

	@Override
	public String toString() {
		return "Table ["+ deck + "\n"+ hand + "]";
	}

	public static void main(String[] args) {
		
			Table table = new Table();
			table.shuffleDeck();
			table.drawHand();
			System.out.println(table.hand);
			int[] hold = {1,2,3};
			table.holdCards(hold);
			System.out.println(table.hand);
			int[] hold2 = {2};
			table.holdCards(hold2);
			System.out.println(table.hand);
			int[] hold3 = {5,3};
			table.holdCards(hold3);
			System.out.println(table.hand);
			System.out.println(table.hand.evaluateHand());
		
	}
}