package videopoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import deckofcards.*;

public class Hand {
	
	LinkedList<Card> hand;
	
	Hand(){
		
		hand = new LinkedList<Card>();
		
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
	
	 private Hand copyHand(){
		 
		 Hand hand = new Hand();
		 
		 for(int i=0; i<5; i++)
			 hand.addCard(this.getCard(i));
		 
		 return hand;
 
	 }
	 
	 private int getIndex(Card card){
		 
		 return this.hand.indexOf(card);
		 
	 }
	 
	 private int[] getOriginalIndexes(ArrayList<Card> holdList){
		 
		 
		 int[] res = new int[holdList.size()];
		 int i=0;
		 
		 for(Card c : holdList){
			 res[i] = this.hand.indexOf(c);
			 i++;
		 }
		 return res;
		 
	 }
	
	 
	 
	 
	int[] getAdvice(){
		
		Hand playerHand = this.copyHand();
		
		// invocar metodos de teste sobre a playerHand
		
		//this.getOriginalIndexes(arraylist que cenas mandaram);
		
		
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
		
		if(FullHouse.isFullHouse(this)!=null)
			return new FullHouse();
		
		if(Flush.isFlush(this))
			return new Flush();
		
		if(Straight.isStraight(this))
			return new Straight();
		
		if(ThreeOfAKind.isThreeOfAKind(this)!=null)
			return new ThreeOfAKind();
		
		if(TwoPair.isTwoPair(this)!=null)
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