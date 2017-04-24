package videopoker;

public class Four2_4 extends FourOfAKind{
	
	Four2_4(){
		name = "Four 2-4";
		multiplier = 80;
	}
	
	
	static boolean isFour2_4(Hand hand){
		
		if(isFourOfAKind(hand))
			
			// After sorting by rank and knowing that there is FoK, an example hand could be: 3C 3S 3H 3D 4D or 2C 3S 3H 3D 3D
			// The second card will always be one which belongs to the FoK, so we only need to check that card's rank.
			
			if(hand.getCard(1).getScore()>=2 && hand.getCard(1).getScore()<=4)
				return true;
		
		return false;
		
	}
}