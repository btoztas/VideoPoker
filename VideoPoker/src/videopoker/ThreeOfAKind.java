package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class ThreeOfAKind extends HandType {
	
	ThreeOfAKind(){
		name = "Three of a Kind";
		multiplier = 3;
	}
	
	
	static ArrayList<Card> isThreeOfAKind(Hand hand){
		
		// To understand this analysis check the following examples of a sorted by rank hand:
		// 4D 4D 4C 5H 6D
		// 2D 4D 4C 4H 4D
		// 2D 3D 4C 4H 4D
		// So, we just need to check if the ranks of the 1st and 3rd or 2nd and 4th or 3rd and 5th card are equal 	
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		hand.sortRank();
		
		for(int i=0; i<3; i++){
			if(isPair(hand.getCard(i),hand.getCard(i+2))){
				for(int j=i; j<i+3; j++)
					toHold.add(hand.getCard(j));
				return toHold;		
			}
		}
		return null;
	}
	
	static ArrayList<Card> isThreeOfAKindAces(Hand hand){
				
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		
		for(int i=0; i<3; i++){
			if(isPair(hand.getCard(i),hand.getCard(i+2)) && hand.getCard(i).getRank()==14){
				for(int j=i; j<i+3; j++)
					toHold.add(hand.getCard(j));
				return toHold;		
			}
		}
		return null;
	}
}
