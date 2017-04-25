package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class TwoPair extends HandType {
	
	TwoPair(){
		name = "Two Pair";
		multiplier = 1;
	}
	
	static ArrayList<Card> isTwoPair(Hand hand){

		// On a sorted by rank hand, there are three cases we need to check to know if there is a two pair:
		// 4S 4C 5C AS AH
		// 2S 2C KC KS AH
		// 2S 4C 4C 5S 5H
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		hand.sortRank();
		
		// First and second case
		if(isPair(hand.getCard(0), hand.getCard(1))){
			if(isPair(hand.getCard(2), hand.getCard(3))){
				for(int i=0;i<4;i++){
					tohold.add(hand.getCard(i));
				}
				return tohold;
			}
			if(isPair(hand.getCard(3), hand.getCard(4))){
				for(int i=0;i<2;i++){
					tohold.add(hand.getCard(i));
				}
				for(int i=3;i<5;i++){
					tohold.add(hand.getCard(i));
				}
				return tohold;
			}	
		}
		
		// Third case
		if(isPair(hand.getCard(1), hand.getCard(2)) &&
		   isPair(hand.getCard(3), hand.getCard(4))){
			for(int i=1;i<5;i++){
				tohold.add(hand.getCard(i));
			}
			return tohold;
		}
		return null;
		
		
		
	}
}
