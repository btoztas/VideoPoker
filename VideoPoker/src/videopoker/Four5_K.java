package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Four5_K extends FourOfAKind{
	
	Four5_K(){
		name = "Four 5-K";
		multiplier = 50;
	}
	
	static ArrayList<Card> isFour5_K(Hand hand){
		
		ArrayList<Card> tohold = isFourOfAKind(hand);
		
		if(tohold!=null)
			if(tohold.get(0).getScore()>=5 && tohold.get(0).getScore()<=13)
				return tohold;
		
		return null;
		
	}
	
	
}
