package videopoker;

/**
 * 
 * Class that contains int objects to store the credit in different states
 *
 */

public class Credit {
	
	private int actual_credit;
	private int initial_credit;
	
	/**
	 * Constructs an object of type Credit. Credit has 2 parameters: actual credit and initial credit. This constructor sets
	 * those 2 params with the given values:
	 * @param actual_credit		Initial Credit
	 * @param initial_credit	Initial Credit
	 */
	
	public Credit(int c){
		initial_credit = actual_credit = c;
	}
	
	/**
	 * This method withdraws a certain amount of money r from the available credit
	 * @param r		amount of money to withdraw from credit
	 */
	
	public void withdraw(int r){
		actual_credit = actual_credit - r;
	}
	
	/**
	 * This method adds a certain amount of money r to the available credit
	 * @param a		amount of money to add to credit
	 */
	
	public void add(int a){
		actual_credit = actual_credit + a;
	}
	
	/**
	 * This method returns the amount of available credit
	 * @return actual_credit	amount of money available at the moment	
	 */
	
	public int getCredit(){
		return this.actual_credit;
	}
	
	/**
	 * This method returns the amount of money that the user started the game with
	 * @return actual_credit	initial amount of money
	 */
	
	public int getInitialCredit(){
		return this.initial_credit;
	}
}
