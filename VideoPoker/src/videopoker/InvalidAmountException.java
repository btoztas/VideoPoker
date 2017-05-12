package videopoker;

public class InvalidAmountException extends Exception {
	
	/**
	 * Constructs an Exception to be thrown when one tries to bet more then he/she should
	 * 
	 */
	
	public InvalidAmountException(){
	     super("illegal amount");
	}

}
