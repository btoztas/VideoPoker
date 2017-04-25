package gameUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import videopoker.VideoPoker;


public class Interactive implements GameMode {
	
	int credit;
	public void initGame(String[] args){
		
	}
	
	public void play() {
		String s = "";
		String state = "hold";
		VideoPoker v = new VideoPoker(1000);
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try{
	        s = bufferRead.readLine();
	        //System.out.println(s);
			}
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
			if(s.contains("b")){
				if(state=="deal"){
					System.out.println("can't bet right now. You must choose the cards to hold");
				}else if(state=="bet"){
					System.out.println("can't bet right now. You must deal");
				}else{
					if(s.length()==1){
						v.bet(5);
						System.out.println("player is betting 5");
						state = "bet";
					}else{
						v.bet(Character.getNumericValue(s.charAt(2)));
						System.out.println("player is betting " + s.charAt(2));
						state = "bet";
					}
				}
			}else if(s.contains("d")){
				if(state=="bet"){
					System.out.println(v.deal());
					state = "deal";
				}else if(state=="deal"){
					System.out.println("can't deal right now. You must choose the cards to hold");
				}else{
					System.out.println("can't deal right now. You must choose the ammount to bet first");
				}
			}else if(s.contains("h ")){
				if(state=="hold"){
					System.out.println("can't hold right now. You must choose the ammount to bet");
				}else if(state=="bet"){
					System.out.println("can't hold right now. You must deal first");
				}else{
					int[] h = new int[(s.length()-1)/2];
					int i = 2;
					int j = 0;
					while(i<s.length()){
						h[j]=Character.getNumericValue(s.charAt(i));
						i = i + 2;
						j++;
					}
					v.hold(h);
					state = "hold";
				}
			}else if(s.contains("$")){
				System.out.println("player's credit is " + v.credit());
			}
		}
	}

}
