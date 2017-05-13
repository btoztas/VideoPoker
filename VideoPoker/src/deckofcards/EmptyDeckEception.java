package deckofcards;

/**
 * 
 * Exception to be thrown when the deck has no more cards left on the deck
 *
 */

public class EmptyDeckEception extends Exception {
	
	/**
	 * Constructs an Exception to be thrown when the deck has no more cards left
	 * 
	 */
	
	public EmptyDeckEception(){
		
		super("Deck is empty");
		
	}

}
