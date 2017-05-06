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
		String state = "hold";
		VideoPoker v = new VideoPoker(credit, new VideoPokerType107DB());
		int amount=0;
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
				if(state=="deal" || state=="advise"){
					System.out.println("can't bet right now. You must choose the cards to hold");
				}else if(state=="bet"){
					System.out.println("can't bet right now. You must deal");
				}else{
					int b;
					if(s.length()==1){
						b = v.bet(5);
						amount=5;
						if(b==1){
							System.out.println("player is betting 5");
							state = "bet";
						}else{
							System.out.println("insuficient funds");
						}
					}else{
						if(s.length() > 3 || Character.getNumericValue(s.charAt(2)) > 5){
							System.out.println("illegal amount");
						}else{
							b = v.bet(Character.getNumericValue(s.charAt(2)));
							amount=Character.getNumericValue(s.charAt(2));
							if(b==1){
								System.out.println("player is betting " + s.charAt(2));
								state = "bet";
							}else{
								System.out.println("insuficient funds");
							}
						}
					}
				}
			}else if(s.contains("d")){
				if(state=="bet"){
					System.out.println(v.deal());
					state = "deal";
				}else if(state=="deal" || state=="advise"){
					System.out.println("can't deal right now. You must choose the cards to hold");
				}else{
					if(amount!=0){
    					int b = v.bet(amount);
						if(b==1){
							System.out.println("player is betting " + amount);
							System.out.println(v.deal());
							state = "deal";
						}else{
							System.out.println("b: insuficient funds");
						}
					}else{
						System.out.println("can't deal right now. You must choose the amount to bet first");
					}
				}
			}else if(s.contains("h")){
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
					ResultHold result = v.hold(h);
					System.out.println(result.getHand());
					if(result.getRes()!=null){
						System.out.println("Player wins with a " + result.getRes() + " and his credit is " + result.getCredit());
					}else{
						System.out.println("Player loses and his credit is "+ result.getCredit());
					}
					state = "hold";
				}
			}else if(s.contains("$")){
				System.out.println("player's credit is " + v.credit());
			
			}else if(s.contains("s")){
				Statistics stat = v.statistics();
				stat.printStatistics();
				double percentage = (stat.getCredit()/credit)*100.0000;
				System.out.println("Credit            " + stat.getCredit() + " (" + percentage + "%)");
			}else if(s.contains("a")){
				if(state=="deal"){
					int res [] = v.advice();
					if(res!=null){
						System.out.print("player should hold ");
						for(int i=0;i<res.length;i++){
							System.out.print(res[i]+" ");
						}
					}else{
						System.out.print("player should discard everything");
					}
					state="advise";
				}else if(state=="bet"){
					System.out.println("can't advise right now. You must deal first");
				}else if(state=="hold"){
					System.out.println("can't advise right now. You must choose the ammount to bet");
				}else{
					System.out.println("can't advise right now. You must choose the cards to hold");
				}
			}
		}
	}

}
