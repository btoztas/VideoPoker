package deckofcards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	ArrayList<Card> deck = new ArrayList<Card>();
	private char[] suits = {'H', 'S', 'D', 'C'};
	private char[] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', 'D', 'J', 'Q', 'K', 'A'};
	
	
	
	Deck(){
		
		for (char suit : suits) 
			for(char rank: ranks){
				Card card = new Card(rank, suit);
				deck.add(card);
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
		
		Card card = this.deck.get(0);
		this.deck.remove(0);
		return card;
		
		
	}
	
	public static void main(String[] args) {
		
		
		Deck deck = new Deck();
		
		System.out.println(deck);
		
		deck.shuffle();
		
		System.out.println(deck);
		
		
		
	}

	
	
}
