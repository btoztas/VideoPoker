package videopoker;

public class Four5_K extends FourOfAKind{
	
	Four5_K(){
		name = "Four 5-K";
		multiplier = 50;
	}
	
	static boolean isFour5_K(Hand hand){
		
		if(isFourOfAKind(hand))
			
			// After sorting by rank and knowing that there is FoK, an example hand could be: 5C 5S 5H 5D 6D or 2C 5S 5H 5D 5D
			// The second card will always be one which belongs to the FoK, so we only need to check that card's rank.
			
			if(hand.getCard(1).getScore()>=5 && hand.getCard(1).getScore()<=13)
				return true;
		
		return false;
		
	}
	
	
}
