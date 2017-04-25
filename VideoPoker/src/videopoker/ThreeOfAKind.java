package videopoker;

public class ThreeOfAKind extends HandType {
	
	ThreeOfAKind(){
		name = "Three of a Kind";
		multiplier = 3;
	}
	
	
	static boolean isThreeOfAKind(Hand hand){
		
		// To understand this analysis check the following examples of a sorted by rank hand:
		// 4D 4D 4C 5H 6D
		// 2D 4D 4C 4H 4D
		// 2D 3D 4C 4H 4D
		// So, we just need to check if the ranks of the 1st and 3rd or 2nd and 4th or 3rd and 5th card are equal 	
		
		hand.sortRank();
		
		if( isPair(hand.getCard(0),hand.getCard(2)) ||
		    isPair(hand.getCard(1),hand.getCard(3)) ||
		    isPair(hand.getCard(2),hand.getCard(4))    )
			
			return true;
		
		return false;
	}
	
	static boolean isThreeOfAKindAces(Hand hand){
		
		// To understand this analysis check the following examples of a sorted by rank hand:
		// 4D 4D 4C 5H 6D
		// 2D 4D 4C 4H 4D
		// 2D 3D 4C 4H 4D
		// So, we just need to check if the ranks of the 1st and 3rd or 2nd and 4th or 3rd and 5th card are equal 	
		
		hand.sortRank();
		
		if( isPair(hand.getCard(0),hand.getCard(2)) ||
		    isPair(hand.getCard(1),hand.getCard(3)) ||
		    isPair(hand.getCard(2),hand.getCard(4))    )
			
			return true;
		
		return false;
	}
}
