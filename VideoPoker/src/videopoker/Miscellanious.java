package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Miscellanious extends HandType{

	static ArrayList<Card> isQJSuited(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==12 || hand.getCard(i).getScore()==11){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==11 || hand.getCard(j).getScore()==12){
						if(hand.getCard(j).getSuit()==hand.getCard(i).getSuit()){
							toHold.add(hand.getCard(j));
							toHold.add(hand.getCard(i));
							return toHold;
						}		
					}
				}
			}	
		}
		return null;
	}
	
	
static ArrayList<Card> is2SuitedHCard(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==12 || hand.getCard(i).getScore()==11 || hand.getCard(i).getScore()==13 || hand.getCard(i).getScore()==14){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==11 || hand.getCard(j).getScore()==12 || hand.getCard(j).getScore()==13 || hand.getCard(j).getScore()==14){
						if(hand.getCard(j).getSuit()==hand.getCard(i).getSuit()){
							toHold.add(hand.getCard(j));
							toHold.add(hand.getCard(i));
							return toHold;
						}		
					}
				}
			}	
		}
		return null;
	}
	
	
}
