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
	
	boolean existsHand(){
		if(this.hand.isEmpty()==true)
			return false;
		return true;
	}
	
	void sortRank(){
		
		Collections.sort(this.hand, new RankComparator());
		
	}
	
	void sortSuit(){
		
		Collections.sort(this.hand, new SuitComparator());
		
	}
	
	Card getCard(int index){
		
		return this.hand.get(index);
	}
	
	
	int[] getAdvice(){
		
		// Funcoes vao retornar posiçoes em hand ordenada
		// Guardar hand original. Guardar posiçoes trocadas depois saber a ponte entre as duas
		
		
		return null;
	}
	
	

	
	HandType evaluateHand(){
		
		if(RoyalFlush.isRoyalFlush(this))
			return new RoyalFlush();

		if(StraightFlush.isStraightFlush(this))
			return new StraightFlush();

		if(FourAces.isFourAces(this))
			return new FourAces();

		if(Four2_4.isFour2_4(this))
			return new Four2_4();
		
		if(Four5_K.isFour5_K(this))
			return new Four5_K();
		
		if(FullHouse.isFullHouse(this))
			return new FullHouse();
		
		if(Flush.isFlush(this))
			return new Flush();
		
		if(Straight.isStraight(this))
			return new Straight();
		
		if(ThreeOfAKind.isThreeOfAKind(this))
			return new ThreeOfAKind();
		
		if(TwoPair.isTwoPair(this))
			return new TwoPair();
		
		if(JacksOrBetter.isJacksOrBetter(this))
			return new JacksOrBetter();
		
		return null;
		
		
	}
	

	@Override
	public String toString() {
		return "player's hand " + hand.get(0) + " " + hand.get(1) + " " + hand.get(2) + " " + hand.get(3) + " " + hand.get(4);
	}
	
	
	
}
