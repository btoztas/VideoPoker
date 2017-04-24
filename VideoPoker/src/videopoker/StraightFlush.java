package videopoker;

public class StraightFlush extends Flush{
	
	StraightFlush(){
		name = "Straight Flush";
		multiplier = 50;
	}
	
	
	static boolean isStraightFlush(Hand hand){
		
		
		if(isFlush(hand)){
			hand.sortRank();
			
			if( (hand.getCard(0).getScore() == hand.getCard(4).getScore() - 4) || 
			  ( (hand.getCard(0).getScore() == hand.getCard(3).getScore() - 3) && (hand.getCard(0).getScore()==2) && (hand.getCard(4).getScore()==14))) 
				return true;
		}
		return false;
	}
	
	
}
