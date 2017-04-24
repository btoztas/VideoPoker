package videopoker;

public class Flush extends HandType {

	Flush(){
		name = "Flush";
		multiplier = 7;
	}
	
	static boolean isFlush(Hand hand){
		
		hand.sortSuit();
		if(hand.getCard(0).getSuit() == hand.getCard(4).getSuit())
			return true;
		return false;
		
	}
	
}
