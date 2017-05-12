package videopoker;

import deckofcards.Deck;
import deckofcards.EmptyDeckEception;

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
	 * Constructs a new Video Poker game, of a given type, initiated with a credit amount.
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
	
	/**
	 * With this method, you can place a bet on VideoPoker, with a given credit. 
	 * <br>Bets can be only between 1 and 5 credits.
	 * 
	 * @param bet	Bet to be places
	 * @throws InvalidAmountException	Thrown when the amount to bet is greater than 5 or lesser than 1 credits
	 * @throws InvalidGameStateException	Thrown when the game state doesn't allow a bet
	 * @throws InsufficientFundsException	Thrown when the amount to bet exceed the credit funds
	 */
	public void bet(int bet) throws InvalidAmountException, InvalidGameStateException, InsufficientFundsException{
		
		
		if(!this.gamestate.equals("IDLE") && !this.gamestate.equals("HOLD") && !this.gamestate.equals("BET")){
			
			throw new InvalidGameStateException("can't bet right now");
		}
		
		
		if(bet>5 || bet<=0){
			
			throw new InvalidAmountException();
			
		}
		
		if(credit.getCredit()-bet<0)
			throw new InsufficientFundsException();
		
		
		if(this.gamestate.equals("BET"))
			this.credit.add(this.pot.withdraw());
		
		this.credit.withdraw(bet);
		this.pot.add(bet);
		this.gamestate = "BET";
		this.lastbet = bet;
			
	
	}
	/**
	 * Returns the actual credit the player has
	 * 
	 * 
	 * @return	credit
	 */
	public int credit(){
		
		return this.credit.getCredit();
	}
	
	/**
	 * Returns an object of type statistics with the game statistics.
	 * 
	 * @return Object of type Statistics
	 * @see videopoker.Statistics.java
	 */
	public Statistics statistics(){
		
		this.stat.updateCredit(credit.getCredit());
		return this.stat;
		
	}

	/**
	 * 
	 * This method changes the cards on the indexes given in the parameter indexes with the cards on the top
	 * of the deck
	 * @param indexes 
	 * @return result 		hand and type of hand that result from holding
	 * @throws InvalidCardIndexException
	 * @throws InvalidGameStateException
	 * @see videopoker.PlayReusult.java
	 */
	
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
	
	/**
	 * 
	 * this method gets the indexes of the cards that are advised to hold and returns them. 
	 * @return indexes 		indexes advised to hold
	 * @throws InvalidGameStateException
	 */
	
	public int[] advice() throws InvalidGameStateException{
		
		if(!this.gamestate.equals("DEAL"))
			throw new InvalidGameStateException("can't get advice right now");
		
		Hand playerHand = hand.copyHand();
		return type.getAdvice(playerHand);
		
	}
	
	/**
	 * 
	 * this method gets the first five cards from the deck and returns them in the shape of a string
	 * 
	 * @return hand		hand that was dealt and is to be shown
	 * @throws InvalidGameStateException
	 * @throws InvalidAmountException
	 * @throws InsufficientFundsException
	 * @throws EmptyDeckEception
	 */
	
	public String deal() throws InvalidGameStateException, InvalidAmountException, InsufficientFundsException, EmptyDeckEception{
		
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
	
	/**
	 * this method adds the first five cards to the hand
	 * @throws EmptyDeckEception
	 */
	
	protected void drawHand() throws EmptyDeckEception{
		
		for(int i=0; i<5; i++)
			this.hand.addCard(this.deck.drawCard());
		
	}
	
	/**
	 * 
	 * this method gives to the deck the cards from the hand
	 * 
	 */
	
	protected void collectHand(){
		
		if(this.hand.existsHand()==true)
			for(int i=0; i<5; i++)
				this.deck.collectCard(this.hand.removeCard(0));
			
	}
	
	/**
	 * this method gives the card in the index given by the parameter index to the deck and substitutes it with the first
	 * card of the deck
	 * @param index		index of the card to switch
	 */
	
	protected void switchCard(int index){
		
		deck.collectCard(this.hand.removeCard(index));
		try {
			hand.addCard(index, this.deck.drawCard());
		} catch (EmptyDeckEception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
