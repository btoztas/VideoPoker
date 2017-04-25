package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Four2_4 extends FourOfAKind{
	
	Four2_4(){
		name = "Four 2-4";
		multiplier = 80;
	}
	
	
	static ArrayList<Card> isFour2_4(Hand hand){
		

		ArrayList<Card> tohold = isFourOfAKind(hand);
		
		if(tohold!=null)
			if(tohold.get(0).getScore()>=2 && tohold.get(0).getScore()<=4)
				return tohold;
		
		return null;
		
	}
}