package videopoker;

import java.util.ArrayList;

import deckofcards.Card;

public class Straight extends HandType {

	Straight(){
		name = "Straight";
		multiplier = 5;
	}
	
	static ArrayList<Card> isStraight(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		//Esta função está provavelmente mal
		
		for(int i=0; i<4; i++){
			
			if(i==3 && hand.getCard(4).getScore()==14 && hand.getCard(0).getScore()==2){
				for(int j=0;j<5;j++){
					toHold.add(hand.getCard(j));
				}
				return toHold;
			}
			if(hand.getCard(i).getScore()!=hand.getCard(i+1).getScore()-1)
				return null;
		}
		for(int j=0;j<5;j++){
			toHold.add(hand.getCard(j));
		}
		return toHold;
	}
	
	static ArrayList<Card> is4OutsideStraight(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		
		for(int i=0; i<2; i++){
			int j;
			for(j=i; j<i+3; j++){
				if(hand.getCard(j).getScore()!=hand.getCard(j+1).getScore()-1){
					break;
				}
			}
			if(hand.getCard(i+3).getScore()!=14 && j == i+3){
				for(int w=i;w<i+4;w++)
					toHold.add(hand.getCard(w));
				return toHold;
			}
		}
		return null;
		
		
	}
	
	static ArrayList<Card> is4InsideStraight(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		
		if(hand.getCard(1).getScore() == hand.getCard(4).getScore()-4){
			for(int i=1; i<5; i++)
				toHold.add(hand.getCard(i));
			return toHold;
		}
		
		// There may be two equal cards in the middle
		if(hand.getCard(0).getScore() == hand.getCard(4).getScore()-4){
			for(int i=0; i<5; i++){
				if(hand.getCard(i).getScore()!=toHold.get(i-1).getScore())
					toHold.add(hand.getCard(i));
			}
			return toHold;
		}
		
		if(hand.getCard(0).getScore() == hand.getCard(3).getScore()-4){
			for(int i=0; i<4; i++)
				toHold.add(hand.getCard(i));
			return toHold;
		}
		if(hand.getCard(4).getScore()==14){
			if(hand.getCard(1).getScore()==11){
				for(int i=1; i<5; i++)
					toHold.add(hand.getCard(i));
				return toHold;
			}
				
				
				
				
				
			if(hand.getCard(0).getScore() == hand.getCard(3).getScore()-4){
				for(int i=1; i<5; i++)
					toHold.add(hand.getCard(i));
				return toHold;
			}
			
			// There may be two equal cards in the middle
			if(1 == hand.getCard(3).getScore()-4){
				for(int i=1; i<5; i++){
					if(hand.getCard(i).getScore()!=toHold.get(i-1).getScore())
						toHold.add(hand.getCard(i));
				}
				return toHold;
			}
			
			if(1 == hand.getCard(2).getScore()-4){
				for(int i=1; i<5; i++)
					toHold.add(hand.getCard(i));
				return toHold;
			}
		}
		
		return null;
		
		
	}

	static ArrayList<Card> is4InsideStraightNHighCards(Hand hand, int n){
		
		ArrayList<Card> toHold = is4InsideStraight(hand);
		//System.out.print(toHold);

		if(toHold!=null){
			//System.out.print("vou contar ");
			int count=0;
			
			for(Card c : toHold)
				if(c.getScore()>10)
					count++;
			//System.out.println(count);
			if(count == n)
				return toHold;
			
		}
		return null;
	}
		
	
	static ArrayList<Card> isAKQJUnsuited(Hand hand){
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		if(hand.getCard(1).getScore()==11){
			for(int i=1;i<5;i++)
				toHold.add(hand.getCard(i));
			return toHold;
		}
		return null;
	}
	
	static ArrayList<Card> isKQJUnsuited(Hand hand){
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		if(hand.getCard(2).getScore()==11 && hand.getCard(2).getScore()==13){
			for(int i=2;i<5;i++)
				toHold.add(hand.getCard(i));
			return toHold;
		}else if(hand.getCard(1).getScore()==11){
			for(int i=1;i<4;i++)
				toHold.add(hand.getCard(i));
			return toHold;
		}
		return null;
	}
	
	static ArrayList<Card> isQJUnsuited(Hand hand){
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		if(hand.getCard(4).getScore()==14){
			if(hand.getCard(2).getScore()==11 && hand.getCard(2).getScore()==12){
				for(int i=2;i<4;i++)
					toHold.add(hand.getCard(i));
				return toHold;
			}
		}else{
			if(hand.getCard(3).getScore()==11 && hand.getCard(2).getScore()==12){
				for(int i=3;i<5;i++)
					toHold.add(hand.getCard(i));
				return toHold;
			}
		}
		return null;
	}
	
	
	
}
