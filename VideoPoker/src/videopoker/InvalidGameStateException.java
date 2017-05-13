package videopoker;

/**
 * 
 * Exception to be thrown when the command can't be executed in a certain state
 *
 */

public class InvalidGameStateException extends Exception {
	
	/**
	 * Constructs an Exception to be thrown when the command can't be executed in a certain state
	 * 
	 */
	
	public InvalidGameStateException(String message){
	     super(message);
	}

}
