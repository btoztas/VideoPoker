package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Four5_K extends FourOfAKind{
	
	Four5_K(){
		name = "Four 5-K";
		multiplier = 50;
	}
	
	static ArrayList<Card> isFour5_K(Hand hand){
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		if(isFourOfAKind(hand)){
			
			// After sorting by rank and knowing that there is FoK, an example hand could be: 5C 5S 5H 5D 6D or 2C 5S 5H 5D 5D
			// The second card will always be one which belongs to the FoK, so we only need to check that card's rank.
			
			if(hand.getCard(1).getScore()>=5 && hand.getCard(1).getScore()<=13){
				if(hand.getCard(0).getScore()==hand.getCard(3).getScore()){
					for(int j=0;j<4;j++){
						tohold.add(hand.getCard(j));
					}
				}else{
					for(int j=1;j<5;j++){
						tohold.add(hand.getCard(j));
					}
				}
				return tohold;
			}
		}
		return null;
		
	}
	
	
}
