package videopoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import deckofcards.*;

public class Hand {
	
	private LinkedList<Card> hand;
	
	Hand(){
		
		hand = new LinkedList<Card>();
		
	}
	
	public void sortRank(){
		
		Collections.sort(this.hand, new RankComparator());
		
	}
	
	public void sortSuit(){
		
		Collections.sort(this.hand, new SuitComparator());
		
	}
	
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
	
	

	
	
	
	
}