package deckofcards;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
	
	LinkedList<Card> deck = new LinkedList<Card>();
	static private char[] suits  = {'H', 'S', 'D', 'C'};
	static private char[] ranks  = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
	static private int[] scores = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	
	
	
	/**
	 * This constructor creates a default deck with 52 cards with the following values:
	 * <br>- Suits: Hearts, Spades, Diamonds, Clubs
	 * <table>
	 * <tr><th>Rank</th><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>T</td><td>J</td><td>Q</td><td>K</td><td>A</td>
	 * <tr><th>Score</th><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td><td>12</td><td>13</td><td>14</td>
	 * </table>
	 * 
	 * 
	 */
	public Deck(){
		
		for(int i=0; i< suits.length; i++)
			for(int j=0; j<ranks.length; j++){
				
				deck.add(new Card(ranks[j], suits[i], scores[j]));
		
			}
	}
	
	public Deck(String[] cards) throws InvalidCardException{
		
		int suit_index, rank_index;
		
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
	
	
	
	public void shuffle(){
		
		
		Collections.shuffle(deck);
		
		
	}
	public Card drawCard(){
		
		return this.deck.remove(0);	
		
	}
	
	public void collectCard(Card card){
		
		deck.add(card);
		
	}
	
	public static void main(String[] args) {
		
		String input = "AF AC 4C 2S";
		
		String[] cards = input.split("\\s+");
		
		Deck deck;
		
		try {
			deck = new Deck(cards);
			System.out.println(deck);
			
			deck.shuffle();
			System.out.println(deck);
			
			Card card = deck.drawCard();
			
			
			
			System.out.println(card);
			System.out.println(deck);
			card = deck.drawCard();
			System.out.println(card);
			System.out.println(deck);
			card = deck.drawCard();
			
			System.out.println(card);
			System.out.println(deck);
			
		} catch (InvalidCardException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
		
	}

	
	
}
