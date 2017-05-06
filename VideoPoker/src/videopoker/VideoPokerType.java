package videopoker;

public interface VideoPokerType {

	String evaluateHand(Hand hand);
	int getPayout(String handtype, int bet);
	int[] getAdvice(Hand hand);
	Statistics initStatistics();

}
