package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Straight extends HandType {

	Straight(){
		name = "Straight";
		multiplier = 5;
	}
	
	static ArrayList<Card> isStraight(Hand hand){
		ArrayList<Card> tohold = new ArrayList<Card>();
		hand.sortRank();
		//Esta função está provavelmente mal
		
		for(int i=0; i<4; i++){
			
			if(i==3 && hand.getCard(4).getScore()==14 && hand.getCard(0).getScore()==2){
				for(int j=0;j<5;j++){
					tohold.add(hand.getCard(j));
				}
				return tohold;
			}
			if(hand.getCard(i).getScore()!=hand.getCard(i+1).getScore()-1)
				return null;
		}
		for(int j=0;j<5;j++){
			tohold.add(hand.getCard(j));
		}
		return tohold;
	}
	
}
