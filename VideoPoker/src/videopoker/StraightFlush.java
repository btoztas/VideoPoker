package videopoker;

import java.util.ArrayList;
import java.util.Collections;

import deckofcards.Card;
import deckofcards.RankComparator;

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
	
	static ArrayList<Card> isNToStraightFlush(Hand hand, int n){
		
		ArrayList<Card> toHold = isNToFlush(hand, n);
		
		if(toHold!=null){
			
			Collections.sort(toHold, new RankComparator());
			
			if( toHold.get(n-1).getScore() - toHold.get(0).getScore()<=4 ){ 
				return toHold;
			}
			if(toHold.get(n-1).getScore()==14){
				if(toHold.get(0).getScore()<10){
					if(toHold.get(n-2).getScore()-1<=4){
						return toHold;
					}
				}else{
					if(14 - toHold.get(0).getScore()<=4){
						return toHold;
					}
				}
			}
			
		}
		return null;
	}
	
	
}
