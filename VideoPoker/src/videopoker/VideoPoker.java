package videopoker;

import deckofcards.Deck;

public class VideoPoker {
	
	protected Pot pot;
	protected Deck deck;
	protected Hand hand;
	protected Credit credit;
	protected Statistics stat;
	protected VideoPokerType type;
	
	// GAME STATE CONTROL
	protected String gamestate;
	protected int lastbet;

	/**
	 * Constructs a new Video Poker, game of a given type, initiated with a credit amount.
	 * In order to construct a new Video Poker, the programmer must first implement a VideoPokerType.
	 * 
	 * @param credit   Credit amount to initiate the game with
	 * @param type   Video Poker type implemented
	 * 
	 */
	public VideoPoker(int credit, VideoPokerType type){

		this.pot = new Pot();
		this.hand = new Hand();
		this.credit = new Credit(credit);
		this.deck = new Deck();
		this.type = type;
		this.stat = this.type.initStatistics();
		this.stat.setInitialCredit(credit);
		this.gamestate = "IDLE";
	}
	
	public void bet(int bet) throws InvalidAmountException, InvalidGameStateException{
		
		
		if(!this.gamestate.equals("IDLE") && !this.gamestate.equals("HOLD") && !this.gamestate.equals("BET")){
			
			throw new InvalidGameStateException("can't bet right now");
		}
		
		
		if(this.credit.getCredit()-bet<0 || bet>5 || bet<=0){
			
			throw new InvalidAmountException();
			
		}
		
		if(this.gamestate.equals("BET"))
			this.credit.add(this.pot.withdraw());
		
		this.credit.withdraw(bet);
		this.pot.add(bet);
		this.gamestate = "BET";
		this.lastbet = bet;
			
	
	}
	
	public int credit(){
		
		return this.credit.getCredit();
	}
	
	public Statistics statistics(){
		
		this.stat.updateCredit(credit.getCredit());
		return this.stat;
		
	}
	
	public PlayResult hold(int[] indexes) throws InvalidCardIndexException, InvalidGameStateException{
		
		if(!this.gamestate.equals("DEAL"))
			throw new InvalidGameStateException("can't hold right now");
		
		// Hold input cards
		if(indexes!=null)
			for(int i=0; i<5; i++){
				
				boolean sw=true;
				for(int j=0; j < indexes.length; j++){
					if(indexes[j]>5)
						throw new InvalidCardIndexException("invalid card index " + indexes[j]);
					if(i==(indexes[j]-1))
						sw = false;
				}
				if(sw)
					this.switchCard(i);
			}
		
		PlayResult result = new PlayResult(); 
		
		result.updateHand(this.hand.toString());
		
		// Get play result after hold
		String res = this.type.evaluateHand(this.hand);
		result.updateRes(res);
		
		int payout = this.type.getPayout(res, this.pot.withdraw());
		
		this.credit.add(payout);

		this.stat.addStatistics(res);
		
		result.updateCredit(this.credit.getCredit());
		
		this.gamestate = "HOLD";
		return result;
		
		
	}
	
	public int[] advice() throws InvalidGameStateException{
		
		if(!this.gamestate.equals("DEAL"))
			throw new InvalidGameStateException("can't get advice right now");
		
		Hand playerHand = hand.copyHand();
		return type.getAdvice(playerHand);
		
	}
	
	public String deal() throws InvalidGameStateException, InvalidAmountException{
		
		if(!this.gamestate.equals("BET") && !this.gamestate.equals("HOLD"))
			
			throw new InvalidGameStateException("can't deal right now");
		
		if(this.gamestate.equals("HOLD"))
			this.bet(this.lastbet);
		
		
		this.collectHand();
		this.deck.shuffle();
		this.drawHand();
		
		this.gamestate = "DEAL";
		
		return this.hand.toString();
		
	}
	
	protected void drawHand(){
		
		for(int i=0; i<5; i++)
		 	this.hand.addCard(this.deck.drawCard());
		
	}
	
	protected void collectHand(){
		
		if(this.hand.existsHand()==true)
			for(int i=0; i<5; i++)
				this.deck.collectCard(this.hand.removeCard(0));
			
	}
	
	protected void switchCard(int index){
		
		deck.collectCard(this.hand.removeCard(index));
		hand.addCard(index, this.deck.drawCard());
		
	}
	
}
