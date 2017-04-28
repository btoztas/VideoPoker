package videopoker;

import java.util.ArrayList;
import java.util.Collections;

import deckofcards.Card;
import deckofcards.RankComparator;

public class StraightFlush extends Flush{
	
	StraightFlush(){
		name = "Straight Flush";
		multiplier = 50;
	}
	
	
	static ArrayList<Card> isStraightFlush(Hand hand){
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		if(isFlush(hand)!=null){
			hand.sortRank();
			
			if( (hand.getCard(0).getScore() == hand.getCard(4).getScore() - 4) || 
			  ( (hand.getCard(0).getScore() == hand.getCard(3).getScore() - 3) && (hand.getCard(0).getScore()==2) && (hand.getCard(4).getScore()==14))){ 
				for(int j=0;j<5;j++){
					tohold.add(hand.getCard(j));
				}
				return tohold;
			}
		}
		return null;
	}
	
	static ArrayList<Card> isNToStraightFlush(Hand hand, int n){
		
		ArrayList<Card> toHold = isNToFlush(hand, n);
		
		if(toHold!=null){
			
			Collections.sort(toHold, new RankComparator());
			
			if( toHold.get(n-1).getScore() - toHold.get(0).getScore()<=4 ){ 
				return toHold;
			}
			if(toHold.get(n-1).getScore()==14){
				if(toHold.get(0).getScore()<10){
					if(toHold.get(n-2).getScore()-1<=4){
						return toHold;
					}
				}else{
					if(14 - toHold.get(0).getScore()<=4){
						return toHold;
					}
				}
			}
			
		}
		return null;
	}
	
	static ArrayList<Card> isNToStraightFlushNType(Hand hand, int n, int type){
		
		ArrayList<Card> toHold = isNToStraightFlush(hand, n);
		int count = 0;
		if(toHold!=null){
			if(type==3){
				for(Card c : toHold){
					if(c.getScore()>10)
						return null;
				}
				if((toHold.get(5-n).getScore() - toHold.get(0).getScore())==4){
					return toHold;
				}
				
			}else{
				int ngaps=1;
				if(toHold.get(5-n).getScore()==14){
					if(toHold.get(5-n-1).getScore()==5 || toHold.get(0).getScore()==10)
						return null;
				}else if((toHold.get(5-n).getScore() - toHold.get(0).getScore())==4){
					ngaps=2;
				}
				if(type==1){
					if(toHold.get(5-n).getScore()==14){
						if(toHold.get(5-n).getScore() - toHold.get(0).getScore() == 2|| toHold.get(5-n).getScore() - toHold.get(0).getScore() == 12)
							ngaps=0;
					}else{
						if((toHold.get(5-n).getScore() - toHold.get(0).getScore())==2){
							ngaps=0;
						}
					}
					count = 0;
					for(Card c : toHold){
						if(c.getScore()>10)
							count++;
					}
					//System.out.println("count = " + count + " ngaps = " + ngaps);
					if(count>=ngaps){
						return toHold;
					}
				}else{
					//type 2
				}
			}
		}
		return null;
	}
			
	
	
}
