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
	
	public void statistics(){
		//System.out.println(table.stat.getStatistic());
		double perc = (table.getCredit()/1000.0000)*100.0000;
		System.out.println("Hand                 Nb");
		System.out.println("_________________________");
		table.stat.getStatistic();
		System.out.println("_________________________");
		System.out.println("Total                " + table.stat.aMap.get("Total"));
		System.out.println("_________________________");
		System.out.println("Credit            " + table.getCredit() + " (" + perc + "%)");
	}
	
	public void hold(int[] cards){
		HandType h = table.holdCards(cards);
		if(h==null){
			table.stat.aMap.put("Other", table.stat.aMap.get("Other") + 1);
			table.stat.aMap.put("Total", table.stat.aMap.get("Total") + 1);
			//System.out.println("player loses and his credit is " + table.getCredit());
		}else{
			table.stat.addStatistic(h);
			table.stat.aMap.put("Total", table.stat.aMap.get("Total") + 1);
			//System.out.println("player wins with a " + h + " and his credit is " + table.getCredit());
		}
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
