package videopoker;

/**
 * 
 * Exception to be thrown when one tries to hold an invalid position
 *
 */

public class InvalidCardIndexException extends Exception {

	/**
	 * Constructs an Exception to be thrown when one tries to hold an invalid position
	 * 
	 */
	
	public InvalidCardIndexException(String message){
	     super(message);
	}
}
