package videopoker107DB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import deckofcards.Card;
import deckofcards.RankComparator;
import videopoker.Hand;
import videopoker.Statistics;
import videopoker.VideoPokerType;

public class VideoPokerType107DB implements VideoPokerType {
	
	private List<Map<String, Integer>> payouts;
	
	
	public VideoPokerType107DB(){
		super();
		
		initPayouts();
		
	}
	
	private void initPayouts(){
		
		payouts = new ArrayList<Map<String, Integer>>();
		Map<String, Integer> BET1 = new HashMap<String, Integer>();
	    BET1.put("Royal Flush", 250);
		BET1.put("Straight Flush", 50);
		BET1.put("Four Aces", 160);
		BET1.put("Four 2-4", 80);
		BET1.put("Four 5-K", 50);
		BET1.put("Full House", 10);
		BET1.put("Flush", 7);
		BET1.put("Straight", 5);
		BET1.put("Three of a Kind", 3);
		BET1.put("Two Pair", 1);
		BET1.put("Jacks or Better", 1);
		payouts.add(BET1);
		Map<String, Integer> BET2 = new HashMap<String, Integer>();
	    BET2.put("Royal Flush", 500);
	    BET2.put("Straight Flush", 100);
	    BET2.put("Four Aces", 320);
	    BET2.put("Four 2-4", 160);
	    BET2.put("Four 5-K", 100);
	    BET2.put("Full House", 20);
	    BET2.put("Flush", 14);
	    BET2.put("Straight", 10);
	    BET2.put("Three of a Kind", 6);
	    BET2.put("Two Pair", 2);
	    BET2.put("Jacks or Better", 2);
		payouts.add(BET2);
	    Map<String, Integer> BET3 = new HashMap<String, Integer>();
	    BET3.put("Royal Flush", 750);
	    BET3.put("Straight Flush", 150);
	    BET3.put("Four Aces", 480);
	    BET3.put("Four 2-4", 240);
	    BET3.put("Four 5-K", 150);
	    BET3.put("Full House", 30);
	    BET3.put("Flush", 21);
	    BET3.put("Straight", 15);
	    BET3.put("Three of a Kind", 9);
	    BET3.put("Two Pair", 3);
	    BET3.put("Jacks or Better", 3);
		payouts.add(BET3);
	    Map<String, Integer> BET4 = new HashMap<String, Integer>();
	    BET4.put("Royal Flush", 1000);
	    BET4.put("Straight Flush", 200);
	    BET4.put("Four Aces", 640);
	    BET4.put("Four 2-4", 320);
	    BET4.put("Four 5-K", 200);
	    BET4.put("Full House", 40);
	    BET4.put("Flush", 28);
	    BET4.put("Straight", 20);
	    BET4.put("Three of a Kind", 12);
	    BET4.put("Two Pair", 4);
	    BET4.put("Jacks or Better", 4);
		payouts.add(BET4);
	    Map<String, Integer> BET5 = new HashMap<String, Integer>();
	    BET5.put("Royal Flush", 4000);
	    BET5.put("Straight Flush", 250);
	    BET5.put("Four Aces", 800);
	    BET5.put("Four 2-4", 400);
	    BET5.put("Four 5-K", 250);
	    BET5.put("Full House", 50);
	    BET5.put("Flush", 35);
	    BET5.put("Straight", 25);
	    BET5.put("Three of a Kind", 15);
	    BET5.put("Two Pair", 5);
	    BET5.put("Jacks or Better", 5);
		payouts.add(BET5);
	}
	

	@Override
	public int getPayout(String handtype, int bet) {
		if(handtype != null)
			return payouts.get(bet-1).get(handtype);
		return 0;
		
	}
	@Override
	public Statistics initStatistics() {
		
		String[] hands = {"Jacks or Better","Two Pair", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"};
		return new Statistics107DB(hands);
		
	}
	
	@Override
	public String evaluateHand(Hand hand){
		
		if(isRoyalFlush(hand)!=null)
			return "Royal Flush";

		if(isStraightFlush(hand)!=null)
			return "Straight Flush";

		if(isFourAces(hand)!=null)
			return "Four Aces";

		if(isFour2_4(hand)!=null)
			return "Four 2-4";
		
		if(isFour5_K(hand)!=null)
			return "Four 5-K";
		
		if(isFullHouse(hand)!=null)
			return "Full House";
		
		if(isFlush(hand)!=null)
			return "Flush";
		
		if(isStraight(hand)!=null)
			return "Straight";
		
		if(isThreeOfAKind(hand)!=null)
			return "Three of a Kind";
		
		if(isTwoPair(hand)!=null)
			return "Two Pair";
		
		if(isJacksOrBetter(hand)!=null)
			return "Jacks or Better";
		
		return null;
		
	}

	@Override
	public int[] getAdvice(Hand playerHand) {
		
		ArrayList<Card> holdList;
		Hand hand = playerHand.copyHand();
		
	    ////System.out.println("TESTING RoyalFlush");
		holdList = isRoyalFlush(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING RoyalFlush");
			return hand.getOriginalIndexes(holdList);
		}
	    		
		////System.out.println("TESTING FourOfAKind");
		holdList = isFourOfAKind(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING FourOfAKind");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING StraightFlush");
		holdList = isStraightFlush(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING StraightFlush");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to RoyalFlush");
		holdList = isNToRoyalFlush(playerHand, 4);
		if(holdList!=null){
			//System.out.println("TESTING 4 to RoyalFlush");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Three Aces");
		holdList = isThreeOfAKindAces(playerHand); //Three Aces
		if(holdList!=null){
			//System.out.println("TESTING Three Aces");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING FullHouse");
		holdList = isFullHouse(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING FullHouse");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Flush");
		holdList = isFlush(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING Flush");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Straight");
		holdList = isStraight(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING Straight");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Three ofaKind Aces-low");
		holdList = isThreeOfAKind(playerHand); //Three Aces
		if(holdList!=null){
			//System.out.println("TESTING Three ofaKind Aces-low");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to StraightFlush");
		holdList = isNToStraightFlush(playerHand, 4);
		if(holdList!=null){
			//System.out.println("TESTING 4 to StraightFlush");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING TwoPair");
		holdList = isTwoPair(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING TwoPair");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING JacksOrBetter");
		holdList = isJacksOrBetter(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING JacksOrBetter");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to a Flush");
		holdList = isNToFlush(playerHand, 4);
		if(holdList!=null){
			//System.out.println("TESTING 4 to a Flush");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 3 to a RoyalFlush");
		holdList = isNToRoyalFlush(playerHand, 3);
		if(holdList!=null){
			//System.out.println("TESTING 3 to a RoyalFlush");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to Outside Straight");
		holdList = is4OutsideStraight(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Outside Straight");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Low Pair");
		holdList = isLowPair(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING Low Pair");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING AKQJ");
		holdList = isAKQJUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING AKQJ");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 3 to Straight Flush type 1");
		holdList = isNToStraightFlushNType(playerHand, 3, 1);
		if(holdList!=null){
			//System.out.println("TESTING 3 to Straight Flush type 1");
			return hand.getOriginalIndexes(holdList);
		}

		////System.out.println("TESTING 4 to Inside Straight 3 High Cards");
		holdList = is4InsideStraightNHighCards(playerHand, 3);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Inside Straight 3 High Cards");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING QJ Suited");
		holdList = isQJSuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING QJ Suited");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 3 to a flush with 2 High Cards");
		holdList = isNToFlushNHighCards(playerHand, 3, 2);
		if(holdList!=null){
			//System.out.println("TESTING 3 to a flush with 2 High Cards");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 2 suited high cards");
		holdList = isTwoSuitedHCard(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING 2 suited high cards");
			return hand.getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to Inside Straight 2 High Cards");
		holdList = is4InsideStraightNHighCards(playerHand, 2);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Inside Straight 2 High Cards");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isNToStraightFlushNType(playerHand, 3, 2);
		if(holdList!=null){
			//System.out.println("TESTING 3 to Straight Flush type 2");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = is4InsideStraightNHighCards(playerHand, 1);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Inside Straight 1 High Cards");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isKQJUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING KQJ unsuited");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isJTSuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING JT Suited");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isQJUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING JQ Unsuited");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isNToFlushNHighCards(playerHand, 3, 1);
		if(holdList!=null){
			//System.out.println("TESTING 3 to a flush with 1 High Cards");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isQTSuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING QT Suited");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isNToStraightFlushNType(playerHand, 3, 3);
		if(holdList!=null){
			//System.out.println("TESTING 3 to Straight Flush type 3");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isKQUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING KQ Unsuited");
			return hand.getOriginalIndexes(holdList);
		}
		holdList = isKJUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING KJ Unsuited");
			return hand.getOriginalIndexes(holdList);
		}
		playerHand.sortRank();
		if(playerHand.getCard(4).getScore()==14){
			//System.out.println("TESTING Ace");
			holdList = new ArrayList<Card>();
			holdList.add(playerHand.getCard(4));
	        return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isKTSuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING KT Suited");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isJKQ(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING K or Q or J");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = is4InsideStraightNHighCards(playerHand, 0);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Inside Straight no High Cards");
			return hand.getOriginalIndexes(holdList);
		}
		
		holdList = isNToFlushNHighCards(playerHand, 3, 0);
		if(holdList!=null){
			//System.out.println("TESTING 3 to a flush with no High Cards");
			return hand.getOriginalIndexes(holdList);
		}
		
        return null;
        
	}

	
	

	// Implemented methods to evaluate parts of the strategy
	
	private boolean isPair(Card card1, Card card2){
			
			if(card1.getScore()==card2.getScore())
				return true;
			return false;
			
	}

	private ArrayList<Card> isTwoPair(Hand hand){

		// On a sorted by rank hand, there are three cases we need to check to know if there is a two pair:
		// 4S 4C 5C AS AH
		// 2S 2C KC KS AH
		// 2S 4C 4C 5S 5H
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		hand.sortRank();
		
		// First and second case
		if(isPair(hand.getCard(0), hand.getCard(1))){
			if(isPair(hand.getCard(2), hand.getCard(3))){
				for(int i=0;i<4;i++){
					tohold.add(hand.getCard(i));
				}
				return tohold;
			}
			if(isPair(hand.getCard(3), hand.getCard(4))){
				for(int i=0;i<2;i++){
					tohold.add(hand.getCard(i));
				}
				for(int i=3;i<5;i++){
					tohold.add(hand.getCard(i));
				}
				return tohold;
			}	
		}
		
		// Third case
		if(isPair(hand.getCard(1), hand.getCard(2)) &&
		   isPair(hand.getCard(3), hand.getCard(4))){
			for(int i=1;i<5;i++){
				tohold.add(hand.getCard(i));
			}
			return tohold;
		}
		return null;
		
		
		
	}

	private ArrayList<Card> isThreeOfAKind(Hand hand){
		
		// To understand this analysis check the following examples of a sorted by rank hand:
		// 4D 4D 4C 5H 6D
		// 2D 4D 4C 4H 4D
		// 2D 3D 4C 4H 4D
		// So, we just need to check if the ranks of the 1st and 3rd or 2nd and 4th or 3rd and 5th card are equal 	
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		hand.sortRank();
		
		for(int i=0; i<3; i++){
			if(isPair(hand.getCard(i),hand.getCard(i+2))){
				for(int j=i; j<i+3; j++)
					toHold.add(hand.getCard(j));
				return toHold;		
			}
		}
		return null;
	}
	
	private ArrayList<Card> isThreeOfAKindAces(Hand hand){
				
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		
		for(int i=0; i<3; i++){
			if(isPair(hand.getCard(i),hand.getCard(i+2)) && hand.getCard(i).getScore()==14){
				for(int j=i; j<i+3; j++)
					toHold.add(hand.getCard(j));
				return toHold;		
			}
		}
		return null;
	}
	
	private ArrayList<Card> isStraightFlush(Hand hand){
		
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
	
	private ArrayList<Card> isNToStraightFlush(Hand hand, int n){
		
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
	
	private ArrayList<Card> isNToStraightFlushNType(Hand hand, int n, int type){
		
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
						ngaps=2;
				}else if((toHold.get(5-n).getScore() - toHold.get(0).getScore())==4){
					ngaps=2;
				}
				if(type==1){
					if(toHold.get(5-n).getScore()==4 && toHold.get(0).getScore()==2)
						return null;
					if(toHold.get(5-n).getScore()==14){
						if(toHold.get(5-n).getScore() - toHold.get(0).getScore() == 2)
							ngaps=0;
						if(toHold.get(5-n).getScore() - toHold.get(0).getScore() == 12)
							return null;
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
					//type2
					if(toHold.get(5-n).getScore()==4 && toHold.get(0).getScore()==2)
						return toHold;
					if(toHold.get(5-n).getScore()==14){
						if(toHold.get(5-n-1).getScore() == 5)
							return toHold;
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
					if(ngaps==1){
						return toHold;
					}
					if(ngaps==2 && count==1){
						return toHold;
					}
				}
			}
		}
		return null;
	}
			
	private ArrayList<Card> isStraight(Hand hand){
		
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
	
	private ArrayList<Card> is4OutsideStraight(Hand hand){
		
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
		int k;
		for(k=0;k<4;k++){
			if(hand.getCard(k).getScore()!=hand.getCard(k+1).getScore()-1){
				if(hand.getCard(k).getScore()==hand.getCard(k+1).getScore()){
					//toHold.add(hand.getCard(k));
				}else{
					break;
				}
			}else{
				toHold.add(hand.getCard(k));
			}
		}
		if(k==4){
			toHold.add(hand.getCard(4));
			return toHold;
		}else{
			return null;
		}	
	}
	
	private ArrayList<Card> is4InsideStraight(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		
		if(hand.getCard(1).getScore() == hand.getCard(4).getScore()-4){
			for(int i=1; i<5; i++)
				toHold.add(hand.getCard(i));
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
				
			
			if(1 == hand.getCard(2).getScore()-4){
				for(int i=0; i<3; i++){
					toHold.add(hand.getCard(i));
				}
				toHold.add(hand.getCard(4));
				return toHold;
			}
		}
		
		return null;
		
		
	}

	private ArrayList<Card> is4InsideStraightNHighCards(Hand hand, int n){
		
		ArrayList<Card> toHold = is4InsideStraight(hand);

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
			
	private ArrayList<Card> isAKQJUnsuited(Hand hand){
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		if(hand.getCard(1).getScore()==11){
			for(int i=1;i<5;i++)
				toHold.add(hand.getCard(i));
			return toHold;
		}
		return null;
	}
	
	private ArrayList<Card> isKQJUnsuited(Hand hand){
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		if(hand.getCard(2).getScore()==11 && hand.getCard(4).getScore()==13){
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

	private ArrayList<Card> isRoyalFlush(Hand hand){
		
		if(isFlush(hand)!=null){
			ArrayList<Card> tohold = new ArrayList<Card>();
			hand.sortRank();
			
			// On a sorted by rank hand, knowing there is a flush, we just need to check if the first card is a ten:
			// TS JS QS KS AS
			
			if(hand.getCard(0).getScore()==10){
				for(int j=0;j<4;j++){
					tohold.add(hand.getCard(j));
				}
				return tohold;
			}
		}
		return null;
	}
	
	private ArrayList<Card> isNToRoyalFlush(Hand hand, int n){
		
		ArrayList<Card> toHold = isFlush(hand);
		if(toHold!=null){
			for(int i=5-n; i<5; i++)
				if(toHold.get(i).getScore()<10)
					return null;
			toHold.remove(0);
			return toHold;
		}
		
		
		toHold = isNToFlush(hand, n);
		
		if(toHold!=null){
			for(int i=0; i<n; i++)
				if(toHold.get(i).getScore()<10)
					return null;
		}
		return toHold;
		
	}

	private ArrayList<Card> isQJSuited(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==12 || hand.getCard(i).getScore()==11){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==11 || hand.getCard(j).getScore()==12){
						if(hand.getCard(j).getSuit()==hand.getCard(i).getSuit()){
							toHold.add(hand.getCard(j));
							toHold.add(hand.getCard(i));
							return toHold;
						}		
					}
				}
			}	
		}
		return null;
	}
	
	private ArrayList<Card> isJTSuited(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==11 || hand.getCard(i).getScore()==10){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==10 || hand.getCard(j).getScore()==11){
						if(hand.getCard(j).getSuit()==hand.getCard(i).getSuit()){
							toHold.add(hand.getCard(j));
							toHold.add(hand.getCard(i));
							return toHold;
						}		
					}
				}
			}	
		}
		return null;
	}
	
	private ArrayList<Card> isQTSuited(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==12 || hand.getCard(i).getScore()==10){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==10 || hand.getCard(j).getScore()==12){
						if(hand.getCard(j).getSuit()==hand.getCard(i).getSuit()){
							toHold.add(hand.getCard(j));
							toHold.add(hand.getCard(i));
							return toHold;
						}		
					}
				}
			}	
		}
		return null;
	}
	
	private ArrayList<Card> isKTSuited(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==13 || hand.getCard(i).getScore()==10){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==10 || hand.getCard(j).getScore()==13){
						if(hand.getCard(j).getSuit()==hand.getCard(i).getSuit()){
							toHold.add(hand.getCard(j));
							toHold.add(hand.getCard(i));
							return toHold;
						}		
					}
				}
			}	
		}
		return null;
	}
	
	private ArrayList<Card> isKQUnsuited(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();

		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==13 || hand.getCard(i).getScore()==12){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==13 || hand.getCard(j).getScore()==12){
						toHold.add(hand.getCard(j));
						toHold.add(hand.getCard(i));
						return toHold;	
					}
				}
			}	
		}
		return null;
	}
	
	private ArrayList<Card> isKJUnsuited(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==13 || hand.getCard(i).getScore()==11){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==13 || hand.getCard(j).getScore()==11){
						toHold.add(hand.getCard(j));
						toHold.add(hand.getCard(i));
						return toHold;	
					}
				}
			}	
		}
		return null;
	}
	
	private ArrayList<Card> isJKQ(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==11 || hand.getCard(i).getScore()==12 || hand.getCard(i).getScore()==13){
				toHold.add(hand.getCard(i));	
				return toHold;
			}	
		}
		return null;
	}
		
	private ArrayList<Card> isTwoSuitedHCard(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		for(int i=0; i<5; i++){
			if(hand.getCard(i).getScore()==12 || hand.getCard(i).getScore()==11 || hand.getCard(i).getScore()==13 || hand.getCard(i).getScore()==14){
				for(int j=i+1; j<5; j++){
					if(hand.getCard(j).getScore()==11 || hand.getCard(j).getScore()==12 || hand.getCard(j).getScore()==13 || hand.getCard(j).getScore()==14){
						if(hand.getCard(j).getSuit()==hand.getCard(i).getSuit()){
							toHold.add(hand.getCard(j));
							toHold.add(hand.getCard(i));
							return toHold;
						}		
					}
				}
			}	
		}
		return null;
	}
	
	private ArrayList<Card> isQJUnsuited(Hand hand){
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortRank();
		if(hand.getCard(4).getScore()==14){
			if(hand.getCard(2).getScore()==11 && hand.getCard(3).getScore()==12){
				for(int i=2;i<4;i++)
					toHold.add(hand.getCard(i));
				return toHold;
			}
		}else{
			if(hand.getCard(3).getScore()==11 && hand.getCard(4).getScore()==12){
				for(int i=3;i<5;i++)
					toHold.add(hand.getCard(i));
				return toHold;
			}
		}
		return null;
	}

	private ArrayList<Card> isThereAPair(Hand hand){
		
		// Cases for Jacks or Better on a sorted by rank hand:
		// JS JC QC KH AS
		// 4S JC JC KH AS
		// 2S TC JC JH AS
		// 2S 9C TC JH JS
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		hand.sortRank();
		
		for(int i=0; i<4; i++)
			if(isPair(hand.getCard(i), hand.getCard(i+1))){
				for(int j=i; j<i+2; j++)
					toHold.add(hand.getCard(j));
				return toHold;
			}
			
		return null;
	}
	
	private ArrayList<Card> isJacksOrBetter(Hand hand){
		
		ArrayList<Card> toHold = isThereAPair(hand);
		if(toHold!=null)
			if(toHold.get(0).getScore()>10)
				return toHold;
		return null;
		
	}
	
	private ArrayList<Card> isLowPair(Hand hand){
		
		ArrayList<Card> tohold = isThereAPair(hand);
		if(tohold != null)
			if(tohold.get(0).getScore()<=10)
				return tohold;
		return null;
		
	}
	
	private	ArrayList<Card> isFullHouse(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		ArrayList<Card> tokRes = isThreeOfAKind(hand);
		
		if(tokRes!=null){
			
			// After knowing that there is a ToK, on a sorted hand by rank, there are two cases for a Full House:
			// 4D 4D 4C 5H 5D
			// 2D 2D 4C 4H 4D
			// So, we just need to check if the ranks of the 1st and 2nd or 4th and 5th card are equal 
			
			if((isPair(hand.getCard(0),hand.getCard(1)) && !isPair(hand.getCard(0),tokRes.get(0))) || 
			   (isPair(hand.getCard(3),hand.getCard(4)) && !isPair(hand.getCard(3),tokRes.get(0)))){
				for(int j=0; j<5; j++)
					toHold.add(hand.getCard(j));
				return toHold;	
			}
		}
		
		return null;
		
	}

	private ArrayList<Card> isFourOfAKind(Hand hand){
		
		hand.sortRank();
		ArrayList<Card> tohold = new ArrayList<Card>();
		
		for(int i=0; i<2; i++)
			if(hand.getCard(i).getScore()==hand.getCard(i+3).getScore()){
				for(int j=i;j<i+4;j++){
					tohold.add(hand.getCard(j));
				}
				return tohold;
			}		
		return null;
		
	}
	
	private ArrayList<Card> isFourAces(Hand hand){
		
		ArrayList<Card> tohold = isFourOfAKind(hand);
		
		if(tohold!=null)
			if(tohold.get(0).getScore()==14)
				return tohold;
		
	
		return null;
		
	}

	private ArrayList<Card> isFour5_K(Hand hand){
		
		ArrayList<Card> tohold = isFourOfAKind(hand);
		
		if(tohold!=null)
			if(tohold.get(0).getScore()>=5 && tohold.get(0).getScore()<=13)
				return tohold;
		
		return null;
		
	}

	private ArrayList<Card> isFour2_4(Hand hand){
		

		ArrayList<Card> tohold = isFourOfAKind(hand);
		
		if(tohold!=null)
			if(tohold.get(0).getScore()>=2 && tohold.get(0).getScore()<=4)
				return tohold;
		
		return null;
		
	}
	
	private ArrayList<Card> isFlush(Hand hand){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		hand.sortSuit();
		if(hand.getCard(0).getSuit() == hand.getCard(4).getSuit()){
			for(int j=0;j<5;j++){
				toHold.add(hand.getCard(j));
			}
			return toHold;
		}
		return null;
		
	}
	
	private ArrayList<Card> isNToFlush(Hand hand, int n){
		
		ArrayList<Card> toHold = new ArrayList<Card>();
		
		hand.sortSuit();
		
		for(int i=0; i<=5-n; i++)
			if(hand.getCard(i).getSuit() == hand.getCard(i+n-1).getSuit()){
				for(int j=i; j<i+n; j++)
					toHold.add(hand.getCard(j));
				return toHold;
			}
		return null;
		
	}
	
	private ArrayList<Card> isNToFlushNHighCards(Hand hand, int n, int n1){
		
		ArrayList<Card> tohold = new ArrayList<Card>();
		
		tohold = isNToFlush(hand, n);
		int count = 0;
		if(tohold!=null){
			for(Card c : tohold){
				if(c.getScore()>10){
					count++;
				}
			}
		}
		if(count>=n1){
			return tohold;
		}
		return null;
		
		
	}

	
	

}
