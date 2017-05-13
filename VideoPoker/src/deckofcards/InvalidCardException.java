package deckofcards;

/**
 * 
 * Exception to be thrown when when one is trying to insert in the deck
 * a card that doesn't match any of the known ones
 *
 */

public class InvalidCardException extends Exception {
	
	/**
	 * Constructs an Exception to be thrown when when one is trying to insert in the deck
	 * a card that doesn't match any of the known ones
	 * 
	 */
	
	public InvalidCardException(String message){
		
		super(message);
		
	}

}
