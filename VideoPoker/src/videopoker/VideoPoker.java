package videopoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	public String deal(){
		table.shuffleDeck();
		table.drawHand();
		return table.getHand();
	}
	
	public static void main(String[] args) {
		String s = "";
		VideoPoker v = new VideoPoker(1000);
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try{
	        s = bufferRead.readLine();
	        System.out.println(s);
			}
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
			if(s.contains("b ")){
				v.bet(s.charAt(0));
			}else if(s.contains("d")){
				System.out.println(v.deal());
			}else if(s.contains("h ")){
				int[] h = new int[(s.length()-1)/2];
				System.out.println(s.length());
				int i = 2;
				int j = 0;
				while(i<s.length()){
					h[j]=Character.getNumericValue(s.charAt(i));
					//System.out.println(s.charAt(i));
					i = i + 2;
					j++;
				}
				
				for(int l = 0; l<h.length; l++){
					System.out.println(h[l]);
				}
				//System.out.println(h);
				v.hold(h);
			}else if(s.contains("$")){
				System.out.println(v.credit());
			}
		}
	}
}
