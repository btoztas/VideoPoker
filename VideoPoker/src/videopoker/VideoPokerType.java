package videopoker;

interface VideoPokerType {

	String evaluateHand(Hand hand);
	int getPayout(String handtype, int bet);
	int[] getAdvice(Hand hand);

}
