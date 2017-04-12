package deckofcards;


public class Card{
	
	char rank;
	char suit;
	int score;


	public Card(char rank, char suit, int score){
		
		this.rank = rank;
		this.suit = suit;
		this.score = score;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public char getRank() {
		return rank;
	}


	public char getSuit() {
		return suit;
	}


	@Override
	public String toString() {
		return "" + rank + suit;
	}	
}
