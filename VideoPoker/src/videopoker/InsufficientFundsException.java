package videopoker;

/**
 * 
 * Exception to be thrown when there are less funds then the bet
 *
 */

public class InsufficientFundsException extends Exception {
	
	/**
	 * Constructs an Exception to be thrown when there are less funds then the bet
	 * 
	 */
	
	public InsufficientFundsException(){
	     super("Insufficient credit");
	}

}
