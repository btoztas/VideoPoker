package videopoker;

public class Pot {
	
	private int value;
	
	/**
	 * Constructs an object of type Pot. Initializes the object value with 0
	 */
	
	public Pot(){
		value = 0;
	}
	

	/**
	 * This method adds to the pot the value of the bet given by the parameter bet
	 * @param bet		amount to add to the pot
	 */
	
	public void add(int bet){
		value = bet;
	}
	
	/**
	 * This method withdraws from the pot the value present in it and returns it
	 * @param out		amount of money that was in the pot
	 */
	
	public int withdraw(){
		int out = value;
		value = 0;
		return out;
	}
}
