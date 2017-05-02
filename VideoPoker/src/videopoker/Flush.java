package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Flush extends HandType {

	String name;
	int multiplier;	
	
	Flush(){
		name = "Flush";
		multiplier = 7;
	}
	
	public int getMult(){
		return multiplier;
	}
	
	public String toString(){
		return name;
	}
	
	static ArrayList<Card> isFlush(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortSuit();
		if(hand.getCard(0).getSuit() == hand.getCard(4).getSuit()){
			for(int j=0;j<5;j++){
				toHold.add(hand.getCard(j));
			}
			return toHold;
		}
		return null;
		
	}
	
	static ArrayList<Card> isNToFlush(Hand hand, int n){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		hand.sortSuit();
		
		for(int i=0; i<=5-n; i++)
			if(hand.getCard(i).getSuit() == hand.getCard(i+n-1).getSuit()){
				for(int j=i; j<i+n; j++)
					toHold.add(hand.getCard(j));
				return toHold;
			}
		return null;
		
	}
	
	static ArrayList<Card> isNToFlushNHighCards(Hand hand, int n, int n1){
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		
		tohold = isNToFlush(hand, n);
		int count = 0;
		if(tohold!=null){
			for(Card c : tohold){
				if(c.getScore()>10){
					count++;
				}
			}
		}
		if(count>=n1){
			return tohold;
		}
		return null;
		
		
	}
	
}
