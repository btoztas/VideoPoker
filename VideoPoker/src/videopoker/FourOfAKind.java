package videopoker;

public class FourOfAKind extends HandType {
	
	static boolean isFourOfAKind(Hand hand){
		
		hand.sortRank();
		
		if(hand.getCard(0).getScore()==hand.getCard(3).getScore() || hand.getCard(1).getScore()==hand.getCard(4).getScore())
			return true;
		return false;
		
	}

}
