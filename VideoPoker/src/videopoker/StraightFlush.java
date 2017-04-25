package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class StraightFlush extends Flush{
	
	StraightFlush(){
		name = "Straight Flush";
		multiplier = 50;
	}
	
	
	static ArrayList<Card> isStraightFlush(Hand hand){
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		if(isFlush(hand)!=null){
			hand.sortRank();
			
			if( (hand.getCard(0).getScore() == hand.getCard(4).getScore() - 4) || 
			  ( (hand.getCard(0).getScore() == hand.getCard(3).getScore() - 3) && (hand.getCard(0).getScore()==2) && (hand.getCard(4).getScore()==14))){ 
				for(int j=0;j<4;j++){
					tohold.add(hand.getCard(j));
				}
				return tohold;
			}
		}
		return null;
	}
	
	
}
