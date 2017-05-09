package videopoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import deckofcards.*;

public class Hand {
	
	private LinkedList<Card> hand;
	
	/**
	 * Constructs an object of type Hand. Initializes a new empty object hand of type LinkedList of Cards
	 */
	
	Hand(){
		
		hand = new LinkedList<Card>();
		
	}
	
	/**
	 * This method sorts the linked list hand of the object Hand by rank. The lower rank gets the first position.
	 */
	
	public void sortRank(){
		
		Collections.sort(this.hand, new RankComparator());
		
	}
	
	/**
	 * This method sorts the linked list hand of the object Hand by suit. The suits don't show up in any specific order. Instead,
	 *  they just show up grouped.
	 */
	
	public void sortSuit(){
		
		Collections.sort(this.hand, new SuitComparator());
		
	}
	
	/**
	 * This method returns the object Card that is positioned on the index given by the parameter index of 
	 * the linked list hand
	 * 
	 * 
	 */
	
	public Card getCard(int index){
		
		return this.hand.get(index);
	}
	
	public Hand copyHand(){
		 
		 Hand hand = new Hand();
		 
		 for(int i=0; i<5; i++)
			 hand.addCard(this.getCard(i));
		 
		 return hand;
 
	 }
	 
	 public int[] getOriginalIndexes(ArrayList<Card> holdList){
		 
		 
		 int[] res = new int[holdList.size()];
		 int i=0;
		 
		 for(Card c : holdList){
			 res[i] = getIndex(c) + 1;
			 i++;
		 }
		 Arrays.sort(res);
		 return res;
		 
	 }
	
	 public int getIndex(Card card){
		 
		 return this.hand.indexOf(card);
		 
	 }
	 

	@Override
	public String toString() {
		return hand.get(0) + " " + hand.get(1) + " " + hand.get(2) + " " + hand.get(3) + " " + hand.get(4);
	}
		
	void addCard(Card card){
		this.hand.add(card);
	}
	
	
	public void addCard(int index, Card card){
		this.hand.add(index, card);
	}
	
	public Card removeCard(int index){
		
		return this.hand.remove(index);
		
	}
	
	boolean existsHand(){
		if(this.hand.isEmpty()==true)
			return false;
		return true;
	}
	
	

	
	
	
	
}