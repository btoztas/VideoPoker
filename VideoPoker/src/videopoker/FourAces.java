package videopoker;

public class FourAces extends FourOfAKind{
	
	FourAces(){
		name = "Four Aces";
		multiplier = 160;
	}
	
	static boolean isFourAces(Hand hand){
		
		if(isFourOfAKind(hand))
			
			// Aces are the highest cards. 
			// If an hand is sorted by rank and we know that there is a FoK, we just need to check if the last card is an Ace.
			
			if(hand.getCard(1).getScore()==14)
				return true;
		
		return false;
		
	}
}
