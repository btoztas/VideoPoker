package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class FourAces extends FourOfAKind{
	
	FourAces(){
		name = "Four Aces";
		multiplier = 160;
	}
	
	static ArrayList<Card> isFourAces(Hand hand){
		
		ArrayList<Card> tohold = isFourOfAKind(hand);
		
		if(tohold!=null)
			if(tohold.get(0).getScore()==14)
				return tohold;
		
	
		return null;
		
	}
}
