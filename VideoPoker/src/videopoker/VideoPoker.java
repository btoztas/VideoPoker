package videopoker;

import deckofcards.Deck;

public class VideoPoker {
	
	Deck deck;
	Hand hand;
	Pot pot;
	Credit credit;
	Statistics stat;
	VideoPokerType type;
	
	public VideoPoker(int credit, VideoPokerType type){

		this.pot = new Pot();
		this.hand = new Hand();
		this.credit = new Credit(credit);
		this.deck = new Deck();
		this.type = type;
	}
	
	
	public int bet(int bet){
		
		// TODO: THROW EXCEPTION IF CREDIT NEGATIVE AND CHANGE METHOD TO VOID
		
		if(this.credit.getCredit()-bet<0){
			
			return 0;
			
		}else{
			
			this.credit.withdraw(bet);
			this.pot.add(bet);
			return 1;
			
		}
	}
	
	public int credit(){
		return this.credit.getCredit();
	}
	
	public void statistics(){
		
		double perc = (credit.getCredit()/1000.0000)*100.0000;
		this.stat.getStatistic();
		System.out.println("Credit            " + this.credit.getCredit() + " (" + perc + "%)");
		
	}
	
	public void hold(int[] indexes){
		
		// Hold input cards
		if(indexes!=null)
			for(int i=0; i<5; i++){
				
				boolean sw=true;
				for(int j=0; j<indexes.length; j++)
					if(i==(indexes[j]-1))
						sw = false;
				if(sw)
					this.switchCard(i);
			}
		
		// Get play result after hold
		String res = this.type.evaluateHand(this.hand);
		
		int payout = this.type.getPayout(res, this.pot.withdraw());
		
		
		
	}
	
	public int[] advice(){
		return type.getAdvice(hand);
	}
	
	public String deal(){
		
		this.collectHand();
		this.deck.shuffle();
		this.drawHand();
		return this.hand.toString();
		
	}
	
	private void drawHand(){
		
		for(int i=0; i<5; i++)
		 	this.hand.addCard(this.deck.drawCard());
		
	}
	
	private void collectHand(){
		
		if(this.hand.existsHand()==true)
			for(int i=0; i<5; i++)
				this.deck.collectCard(this.hand.removeCard(0));
			
	}
	
	private void switchCard(int index){
		
		deck.collectCard(this.hand.removeCard(index));
		hand.addCard(index, this.deck.drawCard());
		
	}
	
}
