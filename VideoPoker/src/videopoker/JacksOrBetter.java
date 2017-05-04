package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class JacksOrBetter extends HandType {
	
	String name;
	int multiplier;	
	
	JacksOrBetter(){
		name = "Jacks or Better";
		multiplier = 1;
	}
	
	public int getMult(){
		return multiplier;
	}
	
	public String toString(){
		return name;
	}
	
	static ArrayList<Card> isThereAPair(Hand hand){
		
		// Cases for Jacks or Better on a sorted by rank hand:
		// JS JC QC KH AS
		// 4S JC JC KH AS
		// 2S TC JC JH AS
		// 2S 9C TC JH JS
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		hand.sortRank();
		
		for(int i=0; i<4; i++)
			if(isPair(hand.getCard(i), hand.getCard(i+1))){
				for(int j=i; j<i+2; j++)
					toHold.add(hand.getCard(j));
				return toHold;
			}
			
		return null;
	}
	
	static ArrayList<Card> isJacksOrBetter(Hand hand){
		
		ArrayList<Card> toHold = isThereAPair(hand);
		if(toHold!=null)
			if(toHold.get(0).getScore()>10)
				return toHold;
		return null;
		
	}
	
	static ArrayList<Card> isLowPair(Hand hand){
		
		ArrayList<Card> tohold = isThereAPair(hand);
		if(tohold != null)
			if(tohold.get(0).getScore()<=10)
				return tohold;
		return null;
		
	}
	
	
}
