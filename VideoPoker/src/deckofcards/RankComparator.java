package deckofcards;

import java.util.Comparator;

public class RankComparator implements Comparator<Card> {

	
	@Override
    public int compare(Card a, Card b) {
        return a.score < b.score ? -1 : a.score == b.score ? 0 : 1;
    }
	
}
