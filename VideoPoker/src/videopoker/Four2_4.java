package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Four2_4 extends FourOfAKind{
	
	String name;
	int multiplier;	
	
	Four2_4(){
		name = "Four 2-4";
		multiplier = 80;
	}
	
	public int getMult(){
		return multiplier;
	}
	
	public String toString(){
		return name;
	}
	
	static ArrayList<Card> isFour2_4(Hand hand){
		

		ArrayList<Card> tohold = isFourOfAKind(hand);
		
		if(tohold!=null)
			if(tohold.get(0).getScore()>=2 && tohold.get(0).getScore()<=4)
				return tohold;
		
		return null;
		
	}
}