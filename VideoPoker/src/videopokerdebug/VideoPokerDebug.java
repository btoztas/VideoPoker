package videopokerdebug;

import deckofcards.Deck;
import deckofcards.InvalidCardException;
import videopoker.InvalidAmountException;
import videopoker.InvalidGameStateException;
import videopoker.VideoPoker;
import videopoker.VideoPokerType;

public class VideoPokerDebug extends VideoPoker {
	
	public VideoPokerDebug(int credit, VideoPokerType type, String deck) throws InvalidCardException{
		super(credit, type);
		String[] cards = deck.split("\\s");
		this.deck = new Deck(cards);
	}
	

	@Override
	public String deal() throws InvalidGameStateException, InvalidAmountException{
		
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