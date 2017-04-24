package videopoker;

public class JacksOrBetter extends HandType {
	
	JacksOrBetter(){
		name = "Jacks or Better";
		multiplier = 1;
	}
	
	static boolean isJacksOrBetter(Hand hand){
		
		// Cases for Jacks or Better on a sorted by rank hand:
		// JS JC QC KH AS
		// 4S JC JC KH AS
		// 2S TC JC JH AS
		// 2S 9C TC JH JS
		
		hand.sortRank();
		
		if( (isPair(hand.getCard(0), hand.getCard(1)) && hand.getCard(0).getScore()>=11) || 
		    (isPair(hand.getCard(1), hand.getCard(2)) && hand.getCard(1).getScore()>=11) ||
		    (isPair(hand.getCard(2), hand.getCard(3)) && hand.getCard(2).getScore()>=11) || 
		    (isPair(hand.getCard(3), hand.getCard(4)) && hand.getCard(3).getScore()>=11))
			return true;
		
		return false;
	}
	
	
}
