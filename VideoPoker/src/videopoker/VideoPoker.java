package videopoker;

import deckofcards.Deck;

public class VideoPoker {
	
	private Deck deck;
	private Hand hand;
	private Pot pot;
	private Credit credit;
	private Statistics stat;
	private VideoPokerType type;
	private String GAMESTATE;

	
	public VideoPoker(int credit, VideoPokerType type){

		this.pot = new Pot();
		this.hand = new Hand();
		this.credit = new Credit(credit);
		this.deck = new Deck();
		this.type = type;
		this.stat = this.type.initStatistics();
		this.GAMESTATE = "IDLE";
	}
	
	
	public void bet(int bet) throws InvalidAmountException, InvalidGameStateException{
		
		// TODO: THROW EXCEPTION IF CREDIT NEGATIVE AND CHANGE METHOD TO VOID
		
		if(this.GAMESTATE != "IDLE" || this.GAMESTATE != "HOLD"){
			
			throw new InvalidGameStateException();
		}
		
		if(this.credit.getCredit()-bet<0 || bet>5 || bet<0){
			
			throw new InvalidAmountException();
			
		}else{
			
			this.credit.withdraw(bet);
			this.pot.add(bet);
			this.GAMESTATE = "BET";
			
		}
	}
	
	public int credit(){
		
		return this.credit.getCredit();
	}
	
	public Statistics statistics(){
		
		
		this.stat.updateCredit(credit.getCredit());
		return this.stat;
		
		/*
		*/
	}
	
	public ResultHold hold(int[] indexes) throws InvalidCardIndexException, InvalidGameStateException{
		
		if(this.GAMESTATE != "DEAL")
			throw new InvalidGameStateException();
		
		// Hold input cards
		if(indexes!=null)
			for(int i=0; i<5; i++){
				
				boolean sw=true;
				for(int j=0; j<indexes.length; j++){
					if(indexes[j]>5)
						throw new InvalidCardIndexException();
					if(i==(indexes[j]-1))
						sw = false;
				}
				if(sw)
					this.switchCard(i);
			}
		
		ResultHold result = new ResultHold(); 
		
		result.updateHand(this.hand.toString());
		
		// Get play result after hold
		String res = this.type.evaluateHand(this.hand);
		result.updateRes(res);
		
		int payout = this.type.getPayout(res, this.pot.withdraw());
		
		this.credit.add(payout);

		this.stat.addStatistics(res);
		
		result.updateCredit(this.credit.getCredit());
		/*if(res!=null)
			result.updateRes("Player wins with a " + res + " and his credit is " + this.credit.getCredit());
		
		else{
			
			result.updateRes("Player loses and his credit is "+ this.credit.getCredit());
	
		}*/
		
		this.GAMESTATE = "HOLD";
		return result;
		
		
	}
	
	public int[] advice() throws InvalidGameStateException{
		
		if(this.GAMESTATE != "DEAL")
			throw new InvalidGameStateException();
		
		return type.getAdvice(hand);
		
	}
	
	public String deal() throws InvalidGameStateException{
		
		if(this.GAMESTATE != "BET")
			throw new InvalidGameStateException();
		
		this.collectHand();
		this.deck.shuffle();
		this.drawHand();
		
		this.GAMESTATE = "DEAL";
		
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
