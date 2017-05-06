package gameUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import videopoker.ResultHold;
import videopoker.Statistics;
import videopoker.VideoPoker;
import videopoker.VideoPokerType107DB;


public class Interactive implements GameMode {
	
	int credit;
	public void initGame(String[] args){
		credit = Integer.parseInt(args[1]);
	}
	
	public void play() {
		String s = "";
		VideoPoker v = new VideoPoker(credit, new VideoPokerType107DB());
		int amount=0;
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try{
	        s = bufferRead.readLine();
			}
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
			String[] tokens = s.split("\\s+\\,\\.");
			if(s.contains("b")){
				if(s.length()==1){
					v.bet(5);
					amount=5;
					System.out.println("player is betting 5");
				}else{
					v.bet(Integer.parseInt(tokens[2]));
					amount=Integer.parseInt(tokens[2]);
					System.out.println("player is betting " + tokens[2]);
				}
			}else if(s.contains("d")){
    			v.bet(amount);
				System.out.println(v.deal());
			}else if(s.contains("h")){
				int[] h = new int[(s.length()-1)/2];
				int i = 0;
				while(i<(tokens.length-1)){
					h[i]=Integer.parseInt(tokens[i+1]);
					i = i + 1;
				}
				ResultHold result = v.hold(h);
				System.out.println(result.getHand());
				if(result.getRes()!=null){
					System.out.println("Player wins with a " + result.getRes() + " and his credit is " + result.getCredit());
				}else{
					System.out.println("Player loses and his credit is "+ result.getCredit());
				}
			}else if(s.contains("$")){
				System.out.println("player's credit is " + v.credit());
			
			}else if(s.contains("s")){
				Statistics stat = v.statistics();
				stat.printStatistics();
				double percentage = (stat.getCredit()/credit)*100.0000;
				System.out.println("Credit            " + stat.getCredit() + " (" + percentage + "%)");
			}else if(s.contains("a")){
				int res [] = v.advice();
				if(res!=null){
					System.out.print("player should hold ");
					for(int i=0;i<res.length;i++){
						System.out.print(res[i]+" ");
					}
				}else{
					System.out.print("player should discard everything");
				}
			}
		}
	}

}
