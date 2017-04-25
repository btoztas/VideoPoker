package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Four2_4 extends FourOfAKind{
	
	Four2_4(){
		name = "Four 2-4";
		multiplier = 80;
	}
	
	
	static ArrayList<Card> isFour2_4(Hand hand){
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		if(isFourOfAKind(hand))
			
			// After sorting by rank and knowing that there is FoK, an example hand could be: 3C 3S 3H 3D 4D or 2C 3S 3H 3D 3D
			// The second card will always be one which belongs to the FoK, so we only need to check that card's rank.
			
			if(hand.getCard(1).getScore()>=2 && hand.getCard(1).getScore()<=4){
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
		
		return null;
		
	}
}