package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class FourOfAKind extends HandType {
	
	static ArrayList<Card> isFourOfAKind(Hand hand){
		
		hand.sortRank();
		ArrayList<Card> tohold = new ArrayList<Card>();
		
		for(int i=0; i<2; i++)
			if(hand.getCard(i).getScore()==hand.getCard(i+3).getScore()){
				for(int j=i;j<i+4;j++){
					tohold.add(hand.getCard(j));
				}
				return tohold;
			}		
		return null;
		
	}

}
