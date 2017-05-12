package videopokerdebug;

import deckofcards.Deck;
import deckofcards.EmptyDeckEception;
import deckofcards.InvalidCardException;
import videopoker.InsufficientFundsException;
import videopoker.InvalidAmountException;
import videopoker.InvalidGameStateException;
import videopoker.VideoPoker;
import videopoker.VideoPokerType;

public class VideoPokerDebug extends VideoPoker {
	
	/**
	 * Construction of a Video Poker game of type Debug. This redefinition is necessary because we can't shuffle the deck
	 * @param credit   Credit amount to initiate the game with
	 * @param type     Video Poker type implemented
	 * @param deck	   deck of card to use in the game
	 * @throws InvalidCardException
	 */
	
	public VideoPokerDebug(int credit, VideoPokerType type, String deck) throws InvalidCardException{
		super(credit, type);
		String[] cards = deck.split("\\s+");
		this.deck = new Deck(cards);
	}
	
	@Override
	public String deal() throws InvalidGameStateException, InvalidAmountException, InsufficientFundsException, EmptyDeckEception{
		
		if(!this.gamestate.equals("BET") && !this.gamestate.equals("HOLD"))
			
			throw new InvalidGameStateException("can't deal right now");
		
		if(this.gamestate.equals("HOLD"))
			this.bet(this.lastbet);
		
		
		this.collectHand();
		this.drawHand();
		
		this.gamestate = "DEAL";
		
		return this.hand.toString();
		
	}
	
}