package videopoker;

public interface VideoPokerType {
	
	/**
	 * This method allows user to implement its own way to evaluate a given hand according to the type
	 * of poker played
	 * @param hand		hand to be evaluated
	 * @return handtype		type of the hand being analyzed
	 */
	
	String evaluateHand(Hand hand);
	
	/**
	 * This method allows user to implement its own payout values according to the type of videopoker played. Given a
	 * hand type and a bet this method returns the correspondent payout
	 * @param handtype		type of the hand being analyzed
	 * @param bet			amount of money that the player is betting
	 * @return payout		payout resulting of the pair bet-handtype 
	 */
	
	int getPayout(String handtype, int bet);
	
	/**
	 * This method allows user to implement its own way of checking the best strategy to play a given hand. Returns 
	 * an array with the positions that are advised to hold
	 * @param hand			hand to be analyzed
	 * @return positions	array with the positions of the cards in the hand that are advised to hold	
	 */
	
	int[] getAdvice(Hand hand);
	
	/**
	 * This method allows user to initialize a statistics structure as he/she wishes. An object of 
	 * type Statistics is returned
	 * @return statistic		 object of type Statistics initialized
	 * @see videopoker.Statistics.java
	 */
	
	Statistics initStatistics();

}
