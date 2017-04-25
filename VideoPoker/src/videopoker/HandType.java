package videopoker;

import deckofcards.Card;

public abstract class HandType {
	String name;
	int multiplier;
	
	int getMult(){
		return multiplier;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	static boolean isPair(Card card1, Card card2){
		
		if(card1.getRank()==card2.getRank())
			return true;
		return false;
		
	}
	
	
}
