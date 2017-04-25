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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		result = prime * result + score;
		result = prime * result + suit;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (score != other.score)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "" + rank + suit;
	}	
}
