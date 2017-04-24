package videopoker;

public class TwoPair extends HandType {
	
	TwoPair(){
		name = "Two Pair";
		multiplier = 1;
	}
	
	static boolean isTwoPair(Hand hand){

		// On a sorted by rank hand, there are three cases we need to check to know if there is a two pair:
		// 4S 4C 5C AS AH
		// 2S 2C KC KS AH
		// 2S 4C 4C 5S 5H
		
		hand.sortRank();
		
		// First and second case
		if(isPair(hand.getCard(0), hand.getCard(1)))
			if(isPair(hand.getCard(2), hand.getCard(3)) ||
			   isPair(hand.getCard(3), hand.getCard(4)))
				return true;
		
		// Third case
		if(isPair(hand.getCard(1), hand.getCard(2)) &&
		   isPair(hand.getCard(3), hand.getCard(4)))
			return true;
		
		return false;
		
	}
}
