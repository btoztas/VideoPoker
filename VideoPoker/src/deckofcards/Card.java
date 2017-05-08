package deckofcards;


public class Card{
	
	char rank;
	char suit;
	int score;
	
	/**
	 * Constructs a card. A card has 3 params: rank, suit and rank. This constructor sets
	 * those 3 params with the given values:
	 * @param rank		Rank to set the card with
	 * @param suit		Suit to set the card with
	 * @param score		Suit to set the card with
	 */

	Card(char rank, char suit, int score){
		
		this.rank = rank;
		this.suit = suit;
		this.score = score;
		
	}
	
	
	/**
	 * This method evaluates a card and returns it's score value
	 * @return score	Score value of a card
	 */

	public int getScore() {
		return score;
	}

	/**
	 * This method sets the score of a card to a given score
	 * @param score		Score to set the card with
	 */
	void setScore(int score) {
		this.score = score;
	}

	/**
	 * This method evaluates a card and returns it's rank value
	 * @return rank		Rank value of the card
	 */
	public char getRank() {
		return rank;
	}

	/**
	 * This method evaluates a card and returns it's suit
	 * @return suit 	Suit of the card
	 */
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
