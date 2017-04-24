package videopoker;

public class FullHouse extends ThreeOfAKind {
	
	FullHouse(){
		name = "Full House";
		multiplier = 10;
	}
	
	
	static boolean isFullHouse(Hand hand){
		
		if(isThreeOfAKind(hand))
			
		
			// After knowing that there is a ToK, on a sorted hand by rank, there are two cases for a Full House:
			// 4D 4D 4C 5H 5D
			// 2D 2D 4C 4H 4D
			// So, we just need to check if the ranks of the 1st and 2nd or 4th and 5th card are equal 
			
			if(isPair(hand.getCard(0),hand.getCard(1)) || isPair(hand.getCard(3),hand.getCard(4)))
				return true;
		
		return false;
		
	}
	
}
