package gameUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import videopoker.*;
import videopoker107DB.VideoPokerType107DB;


public class Debug extends GameUI {
	
	private String cmd_file;
	private String card_file;
	
	public void initGame(String[] args){
		this.cmd_file = args[2];
		this.card_file = args[3];
		this.videopoker = new VideoPoker(Integer.parseInt(args[1]), new VideoPokerType107DB());
	}
	
	public void play(){
		BufferedReader bufferRead = null;
		
		try {
			bufferRead = new BufferedReader(new FileReader(cmd_file));
            String s = "";
            int amount=0;
    		if((s = bufferRead.readLine())!=null){
    			
    	        System.out.println(s);
    	        
    	        for(int m=0;m<s.length();m++){
    	        	
    	        	Character ch = s.charAt(m);
	    			if(ch=='b'){
	    					int b;
	    					if((int)s.charAt(m+2)>57 || (int)s.charAt(m+2)==36){
	    						b = videopoker.bet(5);
	    						amount=5;
	    						if(b==1){
	    							System.out.println("player is betting 5");
	    							state = "bet";
	    						}else{
	    							System.out.println("b: insuficient funds");
	    						}
	    						m=m+1;
	    					}else{
	    						int count=0;
	    						for(int n = m+3; (int)s.charAt(n)<54 && (int)s.charAt(n)!=36; n++){
	    							count++;
	    						}
	    						if(count==1){
	    							if(Character.getNumericValue(s.charAt(m+2)) > 5){
	    								System.out.println("b: illegal amount");
	    							}else{
		    							b = videopoker.bet(Character.getNumericValue(s.charAt(m+2)));
		    							amount = Character.getNumericValue(s.charAt(m+2));
		    							if(b==1){
		    								System.out.println("player is betting " + s.charAt(m+2));
				    						state = "bet";
		    							}else{
		    								System.out.println("b: insuficient funds");
		    							}
	    							}
		    						m=m+3;
	    						}else{
		    						System.out.println("b: illegal amount");
		    						m=m+2+count;
	    						}
	    					}
	    			}else if(ch=='d'){
	    				if(state=="bet"){
	    					System.out.println(v.deal());
	    					state = "deal";
	    				}else if(state=="deal" || state=="advise"){
	    					System.out.println("can't deal right now. You must choose the cards to hold");
	    				}else{
	    					if(amount!=0){
		    					int b = videopoker.bet(amount);
	    						if(b==1){
	    							System.out.println("player is betting " + amount);
	    							System.out.println(videopoker.deal());
	    							state = "deal";
	    						}else{
	    							System.out.println("b: insuficient funds");
	    						}
	    					}else{
	    						System.out.println("can't deal right now. You must choose the amount to bet first");
	    					}
	    				}
	    				m=m+1;
	    			}else if(ch=='h'){
	    				if(state=="hold"){
	    					System.out.println("can't hold right now. You must choose the ammount to bet");
	    				}else if(state=="bet"){
	    					System.out.println("can't hold right now. You must deal first");
	    				}else{
	    					int h[] = new int[5];
	    					for(int i=0;i<5;i++){
	    						h[i]=0;
	    					}
	    					int count=0;
	    					if((int)s.charAt(m+2)<54 && (int)s.charAt(m+2)!=36){
	    						h[0] = Character.getNumericValue(s.charAt(m+2));
	    						//System.out.println(Character.getNumericValue(s.charAt(m+2)));
	    						if((int)s.charAt(m+4)<54 && (int)s.charAt(m+4)!=36){
	    							h[1] = Character.getNumericValue(s.charAt(m+4));
	    							if((int)s.charAt(m+6)<54 && (int)s.charAt(m+6)!=36){
	    								h[2] = Character.getNumericValue(s.charAt(m+6));
	    								if((int)s.charAt(m+8)<54 && (int)s.charAt(m+8)!=36){
	    									h[3] = Character.getNumericValue(s.charAt(m+8));
	    									if((int)s.charAt(m+10)<54 && (int)s.charAt(m+10)!=36){
	    										h[4] = Character.getNumericValue(s.charAt(m+10));
	    										count++;
	    										m=m+2;
	    									}
	    									count++;
	    									m=m+2;
	    								}
	    								count++;
	    								m=m+2;
	    							}
	    							count++;
	    							m=m+2;
	    						}
	    						count++;
	    						m=m+3;
	    					}
	    					int [] ho = new int[count];
	    					for(int i=0;h[i]!=0;i++){
	    						//System.out.print(i);
	    						ho[i]=h[i];
	    					}
	    					ResultHold result = videopoker.hold(h);
	    					System.out.println(result.getHand());
	    					if(result.getRes()!=null){
	    						System.out.println("Player wins with a " + result.getRes() + " and his credit is " + result.getCredit());
	    					}else{
	    						System.out.println("Player loses and his credit is "+ result.getCredit());
	    					}
	    					state = "hold";
	    				}
	    			}else if(ch=='$'){
	    				System.out.println("player's credit is " + videopoker.credit());
	    				m=m+1;
	    			}else if(ch=='s'){
	    				Statistics stat = videopoker.statistics();
	    				stat.printStatistics();
	    				double percentage = (stat.getCredit()/credit)*100.0000;
	    				System.out.println("Credit            " + stat.getCredit() + " (" + percentage + "%)");
	    				m=m+1;
	    			}else if(ch=='a'){
	    				if(state=="deal"){
	    					int res [] = videopoker.advice();
	    					if(res!=null){
	    						System.out.print("player should hold ");
	    						for(int i=0;i<res.length;i++){
	    							System.out.print(res[i]+" ");
	    						}
	    						System.out.println();
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
	    				m=m+1;
	    			}
    	        }
    		}
		} catch (IOException e) {
			
            e.printStackTrace();
            
        } finally {
        	
            try {
                if (bufferRead != null) {
                	bufferRead.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
	}

}
