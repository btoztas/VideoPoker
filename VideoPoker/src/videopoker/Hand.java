package videopoker;

import java.util.ArrayList;
import java.util.Collections;

import deckofcards.*;

public class Hand {
	
	ArrayList<Card> hand;
	
	Hand(){
		
		hand = new ArrayList<Card>();
		
	}
		
	void addCard(Card card){
		this.hand.add(card);
	}
	
	void addCard(int index, Card card){
		this.hand.add(index, card);
	}
	
	Card removeCard(int index){
		
		return this.hand.remove(index);
		
	}
	
	
	private void sortRank(){
		
		Collections.sort(this.hand, new RankComparator());
		
	}
	
	private void sortSuit(){
		
		Collections.sort(this.hand, new SuitComparator());
		
	}
	
	private boolean checkFlush(){
		
		this.sortSuit();
		if(hand.get(0).getSuit() == hand.get(4).getSuit())
			return true;
		return false;
	}
	
	private boolean checkRoyalFlush(){
		
		if(hand.get(0).getScore()==10)
			return true;
		return false;
	}
	
	private boolean checkStraightFlush(){
		
		if(hand.get(0).getScore() == hand.get(4).getScore() - 4)
			return true;
		return false;
			
	}
	
	private boolean checkStraight(){
		
		
		for(int i=0; i<4; i++)
			if(hand.get(i).getScore()!=hand.get(i+1).getScore()-1)
				return false;
		
		return true;
	}
	
	private boolean checkPair(int index){
		
		for(int i=index; i<4; i++)
			if(hand.get(i).getScore()==hand.get(i+1).getScore())
				return true;
		return false;
		
	}
	

	
	public int evaluateHand(){
		if(this.checkFlush()){
			this.sortRank();
			System.out.println(this);
			if(this.checkRoyalFlush())
				return 250;
			else if(this.checkStraightFlush())
				return 50;
			else
				return 7;
		}
		this.sortRank();
		System.out.println(this);
		if(this.checkStraight())
			return 5;
		
		
		System.out.println(this);
		
		if(hand.get(0).getScore()==hand.get(3).getScore()){
			if(hand.get(0).getScore()==14)
				return 160; /*Four of a kind of aces */
			else if(hand.get(0).getScore()>4)
				return 50; /*Four of a kind of 5 - K */
			else
				return 80; /*Four of a kind of 2 - 4 */
		}else if(hand.get(0).getScore()==hand.get(2).getScore()){
			if(hand.get(3).getScore()==hand.get(4).getScore())
				return 10; /*Full House*/
			else
				return 3;  /*Three of a Kind*/
		}else if(hand.get(0).getScore()==hand.get(1).getScore()){
			if(hand.get(2).getScore()==hand.get(4).getScore())
				return 10; /*Full House*/
			else if(checkPair(2))
				return 1; /* Two Pairs */
			else if(hand.get(0).getScore()>10)
				return 1; /* One Pair */
		}
		
		if(hand.get(1).getScore()==hand.get(4).getScore()){
			if(hand.get(1).getScore()==14)
				return 160; /*Four of a kind of aces */
			else if(hand.get(1).getScore()>4)
				return 50; /*Four of a kind of 5 - K */
			else
				return 80; /*Four of a kind of 2 - 4 */
		}else if(hand.get(1).getScore()==hand.get(3).getScore()){
				return 3; /*Three of a Kind*/
		}else if(hand.get(1).getScore()==hand.get(2).getScore()){
			if(hand.get(3).getScore()==hand.get(4).getScore())
				return 1; /* Two Pairs */
			else if(hand.get(1).getScore()>10)
				return 1; /* One Pair */
		}
		
		if(hand.get(2).getScore()==hand.get(4).getScore()){
			return 3; /*Three of a Kind*/
		}else if(hand.get(2).getScore()==hand.get(3).getScore())
			if(hand.get(2).getScore()>10)
				return 1; /* One Pair */
		if(hand.get(3).getScore()==hand.get(4).getScore() && hand.get(3).getScore()>10)
			return 1; /*One Pair*/
		
		return 0;
		
		
		
	}
	

	@Override
	public String toString() {
		return "Hand [hand=" + hand + "]";
	}
	
	
	
}
