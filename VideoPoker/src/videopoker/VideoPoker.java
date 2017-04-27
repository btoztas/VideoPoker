package videopoker;

import deckofcards.Deck;

public class VideoPoker {
	Table table;
	
	public VideoPoker(int credit){

		table = new Table(credit, new Deck());
	}
	
	public void bet(int b){
		table.addToPot(b);
	}
	
	public int credit(){
		return table.getCredit();
	}
	
	public String hold(int[] cards){
		table.holdCards(cards);
		return table.getHand();
	}
	
	public int[] advice(){
		return table.hand.getAdvice();
	}
	
	public String deal(){
		table.collectHand();
		table.shuffleDeck();
		table.drawHand();
		return table.getHand();
	}
}
