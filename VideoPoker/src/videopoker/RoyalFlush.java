package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class RoyalFlush extends Flush{
	
	RoyalFlush(){
		name = "Royal Flush";
		multiplier = 250;
	}
	
	static ArrayList<Card> isRoyalFlush(Hand hand){
		
		if(isFlush(hand)!=null){
			ArrayList<Card> tohold = new ArrayList<Card>();
			hand.sortRank();
			
			// On a sorted by rank hand, knowing there is a flush, we just need to check if the first card is a ten:
			// TS JS QS KS AS
			
			if(hand.getCard(0).getScore()==10){
				for(int j=0;j<4;j++){
					tohold.add(hand.getCard(j));
				}
				return tohold;
			}
		}
		return null;
	}
	
	static ArrayList<Card> isNToRoyalFlush(Hand hand, int n){
		
		ArrayList<Card> toHold = isFlush(hand);
		if(toHold!=null){
			for(int i=5-n; i<5; i++)
				if(toHold.get(i).getScore()<10)
					return null;
			toHold.remove(0);
			return toHold;
		}
		
		
		toHold = isNToFlush(hand, n);
		
		if(toHold!=null){
			for(int i=0; i<n; i++)
				if(toHold.get(i).getScore()<10)
					return null;
		}
		return toHold;
		
	}
}
