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
	 * This method returns the object Card card that is positioned on the index given by the parameter index of 
	 * the linked list hand
	 * @param index		index in the Linked List of the Card we wish to get
	 * @return card		the card in the index given in parameter
	 */
	
	public Card getCard(int index){
		
		return this.hand.get(index);
	}
	
	/**
	 * This method returns an object Hand hand with a copy of the original hand in order to able us to
	 * manipulate it without shuffling the order of the cards in the original hand
	 * @return hand		copy of the original hand
	 */
	
	public Hand copyHand(){
		 
		 Hand hand = new Hand();
		 
		 for(int i=0; i<5; i++)
			 hand.addCard(this.getCard(i));
		 
		 return hand;
 
	 }
	 
	 /**
	 * This method iterates through the list getting the indexes in the original hand of the cards that will be
	 * advised to hold and puts them in the array res. After sorting this array, the method returns it.
	 * @param holdList		list with cards that are advised to hold
	 * @return res			array with the positions of those cards on the original hand, sorted
	 */
	
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
	 
	 /**
	  * This method returns the index index in the original hand of the card given as argument
	  * @param card			Card object we wish to know the index
	  * @return index		index of that card	
	  */
	
	 public int getIndex(Card card){
		 
		 return this.hand.indexOf(card);
		 
	 }
	 
	 
	 
	/**
	 * This method iterates through the hand and creates a visual description of the object Hand
	 * @return handstring		string with the visual description of the hand
	 */
	 
	@Override
	public String toString() {
		return hand.get(0) + " " + hand.get(1) + " " + hand.get(2) + " " + hand.get(3) + " " + hand.get(4);
	}
	
	/**
	 * This method adds the Card object given by the parameter card to the Linked List hand
	 * @param card		Card to be added to the hand
	 */
		
	void addCard(Card card){
		this.hand.add(card);
	}
	
	/**
	 * This method adds the Card object given by the parameter card to the Linked List hand in a specific position index
	 * @param index		index with the position to add the card
	 * @param card		Card to be added to the hand
	 */
	
	void addCard(int index, Card card){
		this.hand.add(index, card);
	}
	
	/**
	 * This method removes an object Card from the Linked List hand that is in the position given by the parameter index
	 * @param index		position of the card we wish to extract from the hand
	 */
	
	Card removeCard(int index){
		
		return this.hand.remove(index);
		
	}
	
	/**
	 * This method verifies if the hand is empty or not
	 * @param ver		boolean with the result of the verification
	 */
	
	boolean existsHand(){
		if(this.hand.isEmpty()==true)
			return false;
		return true;
	}
	
}