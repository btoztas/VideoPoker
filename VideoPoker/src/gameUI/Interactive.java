package gameUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import videopoker.InvalidAmountException;
import videopoker.InvalidCardIndexException;
import videopoker.InvalidGameStateException;
import videopoker.PlayResult;
import videopoker.Statistics;
import videopoker.VideoPoker;
import videopoker107DB.VideoPokerType107DB;


public class Interactive extends GameUI {
	
	public void initGame(String[] args){
		
		try{
			this.videopoker = new VideoPoker(Integer.parseInt(args[1]), new VideoPokerType107DB());
		}catch(NumberFormatException e){
			System.out.println("Invalid credit");
			System.exit(-1);
		}
	}
	
	public void play() {
		String s = "";
		
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			try{
				s = bufferRead.readLine();
			}
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
			
			String[] tokens = s.split("\\s+");
			
			
			if(tokens[0].equals("b")){
				if(tokens.length==1){
					try{
						videopoker.bet(5);
						System.out.println("player is betting 5");
					}catch(InvalidGameStateException e){
						System.out.println("b: " + e.getMessage());
					}catch(InvalidAmountException e){
						System.out.println("b: " + e.getMessage());
					}
				}else{
					try{
						videopoker.bet(Integer.parseInt(tokens[1]));
						System.out.println("player is betting " + tokens[1]);
					}catch(InvalidGameStateException e){
						System.out.println("b: " + e.getMessage());
					}catch(InvalidAmountException e){
						System.out.println("b: " + e.getMessage());
					}
				}
				
			}else if(tokens[0].equals("d")){
				try {
					System.out.println(videopoker.deal());
				} catch (InvalidGameStateException e){
					System.out.println("d: " + e.getMessage());
				} catch (InvalidAmountException e) {
					System.out.println("d: " + e.getMessage());
				}
				
			}else if(tokens[0].equals("h")){
				int[] h = new int[tokens.length-1];
				
				for(int i=1; i<tokens.length; i++)
					h[i-1]=Integer.parseInt(tokens[i]);
				
				PlayResult result;
				
				try {
					
					result = videopoker.hold(h);
					System.out.println(result.getHand());
					if(result.getRes()!=null){
						System.out.println("player wins with a " + result.getRes() + " and his credit is " + result.getCredit());
					}else{
						System.out.println("player loses and his credit is "+ result.getCredit());
					}
					
				} catch (InvalidGameStateException e) {
					System.out.println("h: " + e.getMessage());
				} catch (InvalidCardIndexException e) {
					System.out.println("h: " + e.getMessage());
				}
				
				
				
			}else if(tokens[0].equals("$")){
				System.out.println("player's credit is " + videopoker.credit());
			
			}else if(tokens[0].equals("s")){
								
				Statistics stat = videopoker.statistics();
				stat.printStatistics();
				
			}else if(tokens[0].equals("a")){
				
				try {
					int res [] = videopoker.advice();
					if(res!=null){
						System.out.print("player should hold ");
						for(int i=0;i<res.length;i++){
							System.out.print(res[i]+" ");
						}
						System.out.println("");
					}else{
						System.out.println("player should discard everything");
					}
				} catch (InvalidGameStateException e) {
					System.out.println("a: " + e.getMessage());
				}
				
			}else{
				System.out.println(tokens[0]+": invalid option");
			}
		
		}
	}
	
}
