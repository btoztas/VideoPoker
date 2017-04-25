package deckofcards;

import java.util.LinkedList;
import java.util.Collections;

public class Deck {
	
	LinkedList<Card> deck = new LinkedList<Card>();
	private char[] suits = {'H', 'S', 'D', 'C'};
	private char[] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
	
	
	
	public Deck(){
		
		for(int i=0; i< suits.length; i++)
			for(int j=0; j<ranks.length; j++){
				
				deck.add(new Card(ranks[j], suits[i], j+2));
		
			}
	}
	
	
	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}
	
	
	
	public void shuffle(){
		
		
		Collections.shuffle(deck);
		
		
	}
	public Card drawCard(){
		
		return this.deck.remove(0);	
		
	}
	
	public void collectCard(Card card){
		
		deck.add(card);
		
	}
	
	public static void main(String[] args) {
		
		
		Deck deck = new Deck();
		System.out.println(deck);
		
		deck.shuffle();
		System.out.println(deck);
		
		Card card = deck.drawCard();
		
		
		
		System.out.println(card);
		System.out.println(deck);
		card = deck.drawCard();
		System.out.println(card);
		System.out.println(deck);
		card = deck.drawCard();
		
		System.out.println(card);
		System.out.println(deck);
		
		
		
	}

	
	
}
