package videopoker;

public class Straight extends HandType {

	Straight(){
		name = "Straight";
		multiplier = 5;
	}
	
	static boolean isStraight(Hand hand){
		
		hand.sortRank();
		//Esta função está provavelmente mal
		
		for(int i=0; i<4; i++){
			
			if(i==3 && hand.getCard(4).getScore()==14 && hand.getCard(0).getScore()==2)
				return true;
			if(hand.getCard(i).getScore()!=hand.getCard(i+1).getScore()-1)
				return false;
		}
		
		return true;
	}
	
}
