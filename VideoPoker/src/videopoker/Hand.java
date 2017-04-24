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
		
		if(hand.get(0).getScore() == hand.get(4).getScore() - 4 || (hand.get(0).getScore()==2 && hand.get(4).getScore()==14))
			return true;
		return false;
			
	}
	
	private boolean checkStraight(){
		
		
		for(int i=0; i<4; i++){
			if(i==3 && hand.get(4).getScore()==14 && hand.get(0).getScore()==2)
				return true;
			if(hand.get(i).getScore()!=hand.get(i+1).getScore()-1)
				return false;
		}
		return true;
	}
	
	private boolean checkPair(int index){
		
		for(int i=index; i<4; i++)
			if(hand.get(i).getScore()==hand.get(i+1).getScore())
				return true;
		return false;
		
	}
	

	
	HandType evaluateHand(){
		if(this.checkFlush()){
			this.sortRank();
			if(this.checkRoyalFlush())
				return new RoyalFlush();
			else if(this.checkStraightFlush())
				return new StraightFlush();
			else
				return new Flush();
		}
		this.sortRank();
		if(this.checkStraight())
			return new Straight();
		
		
		if(hand.get(0).getScore()==hand.get(3).getScore()){
			if(hand.get(0).getScore()==14)
				return new FourAces(); /*Four of a kind of aces */
			else if(hand.get(0).getScore()>4)
				return new Four5_K(); /*Four of a kind of 5 - K */
			else
				return new Four2_4(); /*Four of a kind of 2 - 4 */
		}else if(hand.get(0).getScore()==hand.get(2).getScore()){
			if(hand.get(3).getScore()==hand.get(4).getScore())
				return new FullHouse(); /*Full House*/
			else
				return new ThreeOfAKind();  /*Three of a Kind*/
		}else if(hand.get(0).getScore()==hand.get(1).getScore()){
			if(hand.get(2).getScore()==hand.get(4).getScore())
				return new FullHouse(); /*Full House*/
			else if(checkPair(2))
				return new TwoPair(); /* Two Pairs */
			else if(hand.get(0).getScore()>10)
				return new JacksOrBetter(); /* One Pair */
		}
		
		if(hand.get(1).getScore()==hand.get(4).getScore()){
			if(hand.get(1).getScore()==14)
				return new FourAces(); /*Four of a kind of aces */
			else if(hand.get(1).getScore()>4)
				return new Four5_K(); /*Four of a kind of 5 - K */
			else
				return new Four2_4(); /*Four of a kind of 2 - 4 */
		}else if(hand.get(1).getScore()==hand.get(3).getScore()){
			return new ThreeOfAKind(); /*Three of a Kind*/
		}else if(hand.get(1).getScore()==hand.get(2).getScore()){
			if(hand.get(3).getScore()==hand.get(4).getScore())
				return new TwoPair(); /* Two Pairs */
			else if(hand.get(1).getScore()>10)
				return new JacksOrBetter(); /* One Pair */
		}
		
		if(hand.get(2).getScore()==hand.get(4).getScore()){
			return new ThreeOfAKind(); /*Three of a Kind*/
		}else if(hand.get(2).getScore()==hand.get(3).getScore())
			if(hand.get(2).getScore()>10)
				return new JacksOrBetter(); /* One Pair */
		if(hand.get(3).getScore()==hand.get(4).getScore() && hand.get(3).getScore()>10)
			return new JacksOrBetter(); /*One Pair*/
		
		return null;
		
		
		
	}
	

	@Override
	public String toString() {
		return "" + hand;
	}
	
	
	
}
