package videopoker;

import deckofcards.Card;

public abstract class HandType {
	
	abstract int getMult();
	
	@Override
	abstract public String toString();
	
	static boolean isPair(Card card1, Card card2){
		
		if(card1.getScore()==card2.getScore())
			return true;
		return false;
		
	}
}
