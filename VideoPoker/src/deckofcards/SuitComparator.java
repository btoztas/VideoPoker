package deckofcards;

import java.util.Comparator;

/**
 * 
 * 
 * Compares two cards according to its suit
 *
 */

public class SuitComparator implements Comparator<Card> {
	
	
    @Override
    public int compare(Card a, Card b) {
    	 return a.suit < b.suit ? -1 : a.suit == b.suit ? 0 : 1;
    }

	
}