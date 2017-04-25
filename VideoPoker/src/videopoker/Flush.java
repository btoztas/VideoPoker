package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Flush extends HandType {

	Flush(){
		name = "Flush";
		multiplier = 7;
	}
	
	static ArrayList<Card> isFlush(Hand hand){
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		hand.sortSuit();
		if(hand.getCard(0).getSuit() == hand.getCard(4).getSuit()){
			for(int j=0;j<5;j++){
				tohold.add(hand.getCard(j));
			}
			return tohold;
		}
		return null;
		
	}
	
	static int[] isNToFlush(Hand hand, int n){
		
		int[] res = new int[n];
		
		hand.sortSuit();
		
		for(int i=0; i<=5-n; i++)
			if(hand.getCard(i).getSuit() == hand.getCard(i+n-1).getSuit()){
				for(int j=i; j<i+n; j++)
					res[j-i] = j;
				return res;
			}
		return null;
		
	}
}
