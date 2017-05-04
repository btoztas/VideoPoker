package videopoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import deckofcards.*;

public class Hand {
	
	LinkedList<Card> hand;
	
	Hand(){
		
		hand = new LinkedList<Card>();
		
	}
		
	void addCard(Card card){
		this.hand.add(card);
	}
	
	
	void addCard(int index, Card card){
		this.hand.add(index, card);
	}
	
	Card removeCard(int index){
		
		return this.hand.remove(index);
		
	}
	
	boolean existsHand(){
		if(this.hand.isEmpty()==true)
			return false;
		return true;
	}
	
	void sortRank(){
		
		Collections.sort(this.hand, new RankComparator());
		
	}
	
	void sortSuit(){
		
		Collections.sort(this.hand, new SuitComparator());
		
	}
	
	Card getCard(int index){
		
		return this.hand.get(index);
	}
	
	 private Hand copyHand(){
		 
		 Hand hand = new Hand();
		 
		 for(int i=0; i<5; i++)
			 hand.addCard(this.getCard(i));
		 
		 return hand;
 
	 }
	 
	 private int getIndex(Card card){
		 
		 return this.hand.indexOf(card);
		 
	 }
	 
	 private int[] getOriginalIndexes(ArrayList<Card> holdList){
		 
		 
		 int[] res = new int[holdList.size()];
		 int i=0;
		 
		 for(Card c : holdList){
			 res[i] = getIndex(c) + 1;
			 i++;
		 }
		 Arrays.sort(res);
		 return res;
		 
	 }
	
	 
	 
	 
	int[] getAdvice(){
		
		Hand playerHand = this.copyHand();
		
		ArrayList<Card> holdList;
		
	    ////System.out.println("TESTING RoyalFlush");
		holdList = RoyalFlush.isRoyalFlush(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING RoyalFlush");
			return getOriginalIndexes(holdList);
		}
	    		
		////System.out.println("TESTING FourOfAKind");
		holdList = FourOfAKind.isFourOfAKind(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING FourOfAKind");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING StraightFlush");
		holdList = StraightFlush.isStraightFlush(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING StraightFlush");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to RoyalFlush");
		holdList = RoyalFlush.isNToRoyalFlush(playerHand, 4);
		if(holdList!=null){
			//System.out.println("TESTING 4 to RoyalFlush");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Three Aces");
		holdList = ThreeOfAKind.isThreeOfAKindAces(playerHand); //Three Aces
		if(holdList!=null){
			//System.out.println("TESTING Three Aces");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING FullHouse");
		holdList = FullHouse.isFullHouse(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING FullHouse");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Flush");
		holdList = Flush.isFlush(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING Flush");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Straight");
		holdList = Straight.isStraight(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING Straight");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Three ofaKind Aces-low");
		holdList = ThreeOfAKind.isThreeOfAKind(playerHand); //Three Aces
		if(holdList!=null){
			//System.out.println("TESTING Three ofaKind Aces-low");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to StraightFlush");
		holdList = StraightFlush.isNToStraightFlush(playerHand, 4);
		if(holdList!=null){
			//System.out.println("TESTING 4 to StraightFlush");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING TwoPair");
		holdList = TwoPair.isTwoPair(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING TwoPair");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING JacksOrBetter");
		holdList = JacksOrBetter.isJacksOrBetter(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING JacksOrBetter");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to a Flush");
		holdList = Flush.isNToFlush(playerHand, 4);
		if(holdList!=null){
			//System.out.println("TESTING 4 to a Flush");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 3 to a RoyalFlush");
		holdList = RoyalFlush.isNToRoyalFlush(playerHand, 3);
		if(holdList!=null){
			//System.out.println("TESTING 3 to a RoyalFlush");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to Outside Straight");
		holdList = Straight.is4OutsideStraight(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Outside Straight");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING Low Pair");
		holdList = JacksOrBetter.isLowPair(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING Low Pair");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING AKQJ");
		holdList = Straight.isAKQJUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING AKQJ");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 3 to Straight Flush type 1");
		holdList = StraightFlush.isNToStraightFlushNType(playerHand, 3, 1);
		if(holdList!=null){
			//System.out.println("TESTING 3 to Straight Flush type 1");
			return getOriginalIndexes(holdList);
		}

		////System.out.println("TESTING 4 to Inside Straight 3 High Cards");
		holdList = Straight.is4InsideStraightNHighCards(playerHand, 3);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Inside Straight 3 High Cards");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING QJ Suited");
		holdList = Miscellanious.isQJSuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING QJ Suited");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 3 to a flush with 2 High Cards");
		holdList = Flush.isNToFlushNHighCards(playerHand, 3, 2);
		if(holdList!=null){
			//System.out.println("TESTING 3 to a flush with 2 High Cards");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 2 suited high cards");
		holdList = Miscellanious.is2SuitedHCard(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING 2 suited high cards");
			return getOriginalIndexes(holdList);
		}
		
		////System.out.println("TESTING 4 to Inside Straight 2 High Cards");
		holdList = Straight.is4InsideStraightNHighCards(playerHand, 2);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Inside Straight 2 High Cards");
			return getOriginalIndexes(holdList);
		}
		
		holdList = StraightFlush.isNToStraightFlushNType(playerHand, 3, 2);
		if(holdList!=null){
			//System.out.println("TESTING 3 to Straight Flush type 2");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Straight.is4InsideStraightNHighCards(playerHand, 1);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Inside Straight 1 High Cards");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Straight.isKQJUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING KQJ unsuited");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Miscellanious.isJTSuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING JT Suited");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Miscellanious.isQJUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING JQ Unsuited");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Flush.isNToFlushNHighCards(playerHand, 3, 1);
		if(holdList!=null){
			//System.out.println("TESTING 3 to a flush with 1 High Cards");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Miscellanious.isQTSuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING QT Suited");
			return getOriginalIndexes(holdList);
		}
		
		holdList = StraightFlush.isNToStraightFlushNType(playerHand, 3, 3);
		if(holdList!=null){
			//System.out.println("TESTING 3 to Straight Flush type 3");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Miscellanious.isKQUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING KQ Unsuited");
			return getOriginalIndexes(holdList);
		}
		holdList = Miscellanious.isKJUnsuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING KJ Unsuited");
			return getOriginalIndexes(holdList);
		}
		playerHand.sortRank();
		if(playerHand.getCard(4).getScore()==14){
			//System.out.println("TESTING Ace");
			holdList = new ArrayList<Card>();
			holdList.add(playerHand.getCard(4));
	        return getOriginalIndexes(holdList);
		}
		
		holdList = Miscellanious.isKTSuited(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING KT Suited");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Miscellanious.isJKQ(playerHand);
		if(holdList!=null){
			//System.out.println("TESTING K or Q or J");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Straight.is4InsideStraightNHighCards(playerHand, 0);
		if(holdList!=null){
			//System.out.println("TESTING 4 to Inside Straight no High Cards");
			return getOriginalIndexes(holdList);
		}
		
		holdList = Flush.isNToFlushNHighCards(playerHand, 3, 0);
		if(holdList!=null){
			//System.out.println("TESTING 3 to a flush with no High Cards");
			return getOriginalIndexes(holdList);
		}
		
        return null;
		
		
		
		
		
		// invocar metodos de teste sobre a playerHand
		
		//this.getOriginalIndexes(arraylist que cenas mandaram);
		
		
		// Funcoes vao retornar posiçoes em hand ordenada
		// Guardar hand original. Guardar posiçoes trocadas depois saber a ponte entre as duas
		
		
	}
	
	

	
	HandType evaluateHand(){
		
		if(RoyalFlush.isRoyalFlush(this)!=null)
			return new RoyalFlush();

		if(StraightFlush.isStraightFlush(this)!=null)
			return new StraightFlush();

		if(FourAces.isFourAces(this)!=null)
			return new FourAces();

		if(Four2_4.isFour2_4(this)!=null)
			return new Four2_4();
		
		if(Four5_K.isFour5_K(this)!=null)
			return new Four5_K();
		
		if(FullHouse.isFullHouse(this)!=null)
			return new FullHouse();
		
		if(Flush.isFlush(this)!=null)
			return new Flush();
		
		if(Straight.isStraight(this)!=null)
			return new Straight();
		
		if(ThreeOfAKind.isThreeOfAKind(this)!=null)
			return new ThreeOfAKind();
		
		if(TwoPair.isTwoPair(this)!=null)
			return new TwoPair();
		
		if(JacksOrBetter.isJacksOrBetter(this)!=null)
			return new JacksOrBetter();
		
		return null;
		
		
	}
	

	@Override
	public String toString() {
		return /*"player's hand " + */hand.get(0) + " " + hand.get(1) + " " + hand.get(2) + " " + hand.get(3) + " " + hand.get(4);
	}

	
	
	
	
}