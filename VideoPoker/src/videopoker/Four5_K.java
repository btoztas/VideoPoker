package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Four5_K extends FourOfAKind{
	
	String name;
	int multiplier;	
	
	Four5_K(){
		name = "Four 5-K";
		multiplier = 50;
	}
	
	public int getMult(){
		return multiplier;
	}
	
	public String toString(){
		return name;
	}
	
	static ArrayList<Card> isFour5_K(Hand hand){
		
		ArrayList<Card> tohold = isFourOfAKind(hand);
		
		if(tohold!=null)
			if(tohold.get(0).getScore()>=5 && tohold.get(0).getScore()<=13)
				return tohold;
		
		return null;
		
	}
	
	
}
