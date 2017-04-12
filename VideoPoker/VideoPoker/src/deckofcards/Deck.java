package deckofcards;

import java.util.ArrayList;

public class Deck {
	
	ArrayList<Card> deck = new ArrayList<Card>();
	private char[] suits = {'H', 'S', 'D', 'C'};
	private char[] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', 'D', 'J', 'Q', 'K', 'A'};
	
	
	
	Deck(){
		
		for (char suit : suits) {
			for(char rank: ranks){
				Card card = new Card(rank, suit);
				deck.add(card);
			}
		}	
	}
	
	
	
	
	
	
}
