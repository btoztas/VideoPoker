package deckofcards;

public class Card {
	
	char rank;
	char suit;


	Card(char rank, char suit){
		
		this.rank = rank;
		this.suit = suit;
	}


	public char getRank() {
		return rank;
	}


	public char getSuit() {
		return suit;
	}

}
