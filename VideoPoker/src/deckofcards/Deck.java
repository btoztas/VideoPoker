package deckofcards;

import java.util.LinkedList;
import java.util.Collections;

public class Deck {
	
	/**
	 * 
	 * This class implements a standard 52 card deck, used in most casino games. It uses a Linked List to present the Deck
	 * in which the nodes are of Class cards.
	 * <br><b>Suits</b> Hearts, Spades, Diamonds, Clubs
	 * <table>
	 * <center>
	 * <tr><th>Rank</th><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>T</td><td>J</td><td>Q</td><td>K</td><td>A</td>
	 * <tr><th>Score</th><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td><td>12</td><td>13</td><td>14</td>
	 * </center>
	 * </table>
	 */
	
	LinkedList<Card> deck = new LinkedList<Card>();
	static private char[] suits  = {'H', 'S', 'D', 'C'};
	static private char[] ranks  = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
	static private int[]  scores = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	private int card_count;
	
	
	/**
	 * This constructor creates a default deck with 52 cards
	 */
	public Deck(){
		
		for(int i=0; i< suits.length; i++)
			for(int j=0; j<ranks.length; j++){
				
				deck.add(new Card(ranks[j], suits[i], scores[j]));
		
			}
		this.card_count = 52;
	}
	/**
	 * 
	 * This constructor creates a deck of cards with the given cards.
	 * <br> The cards must be given in an array of strings. As an example: AS 5S 8H - Ace of Spades, 5 of Spades and 8 of Hearts
	 * @param cards
	 * @throws InvalidCardException
	 */
	public Deck(String[] cards) throws InvalidCardException{
		
		int suit_index, rank_index;
		
		this.card_count=cards.length;
		
		for(int i=0; i<cards.length; i++){
			
			suit_index = -1;
			rank_index = -1;
			
			for(int j=0; j<ranks.length; j++){
				if(cards[i].charAt(0) == ranks[j]){
					rank_index = j;
					break;
				}
			}
			for(int j=0; j<suits.length; j++){
				if(cards[i].charAt(1) == suits[j]){
					suit_index = j;
					break;
				}
			}
			
			if(suit_index==-1 || rank_index==-1)
				throw new InvalidCardException("Invalid card " + cards[i]);
			
			deck.add(new Card(cards[i].charAt(0), cards[i].charAt(1), scores[rank_index]));
		}
	}
	
	/**
	 * This method returns the score value of a given rank
	 * @param rank 		rank to be evaluated
	 * @return score 	score corresponding to the given rank
	 */
	
	public int rankToScore(char rank){
		for(Card c: deck){
			if(rank==c.getRank()){
				return c.getScore();
			}
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}
	
	/**
	 * This method shuffles the deck randomly
	 */
	
	public void shuffle(){
		
		Collections.shuffle(deck);
		
	}
	
	/**	
	 * This method takes a card from the deck to draw it. This card is returned.
	 * @return card					card to be drawn
	 * @throws EmptyDeckEception	exception thrown when there are no more cards in the deck
	 */
	
	public Card drawCard() throws EmptyDeckEception{
		
		if(this.card_count==0)
			throw new EmptyDeckEception();
		this.card_count--;
		return this.deck.remove(0);
		
	}
	
	/**
	 * This method's purpose is to return a dealt card to the deck. This card is given in argument
	 * @param card 		card to be returned to the deck 
	 */
	
	public void collectCard(Card card){
		
		deck.add(card);
		this.card_count++;
	}
	
	
}
