package videopoker;

public class InsufficientFundsException extends Exception {
	
	public InsufficientFundsException(){
	     super("Insufficient credit");
	}

}
