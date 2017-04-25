package videopoker;

public class RoyalFlush extends Flush{
	
	RoyalFlush(){
		name = "Royal Flush";
		multiplier = 250;
	}
	
	static boolean isRoyalFlush(Hand hand){
		
		if(isFlush(hand)){
			
			hand.sortRank();
			
			// On a sorted by rank hand, knowing there is a flush, we just need to check if the first card is a ten:
			// TS JS QS KS AS
			
			if(hand.getCard(0).getScore()==10)
				return true;
		}
		return false;
	}
	
	static int[] isNToRoyalFlush(Hand hand, int n){
		
		int res[] = isNToFlush(hand, n);
		
		if(res!=null){
			hand.sortRank();
			
			if(hand.getCard(0).getScore()==10)
				return true;
			
		}
		return res;
		
	}
}
