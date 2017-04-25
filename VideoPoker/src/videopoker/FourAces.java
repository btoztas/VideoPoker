package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class FourAces extends FourOfAKind{
	
	FourAces(){
		name = "Four Aces";
		multiplier = 160;
	}
	
	static ArrayList<Card> isFourAces(Hand hand){
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		if(isFourOfAKind(hand))
			
			// Aces are the highest cards. 
			// If an hand is sorted by rank and we know that there is a FoK, we just need to check if the last card is an Ace.
			
			if(hand.getCard(1).getScore()==14){
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
