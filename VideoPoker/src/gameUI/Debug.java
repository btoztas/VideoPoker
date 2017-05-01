package gameUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import videopoker.VideoPoker;


public class Debug implements GameMode {
	
	public void initGame(String[] args){
		
	}
	
	public void play(){
		BufferedReader bufferRead = null;
		try {
			bufferRead = new BufferedReader(new FileReader("C:\\Users\\Afonso\\Desktop\\debugtest.txt"));
            String s = "";
    		String state = "hold";
    		VideoPoker v = new VideoPoker(1000);
    		if((s = bufferRead.readLine())!=null){
    	        System.out.println(s);
    	        for(int m=0;m<s.length();m++){
    	        	Character ch = s.charAt(m);
	    			if(ch=='b'){
	    				if(state=="deal" || state=="advise"){
	    					System.out.println("can't bet right now. You must choose the cards to hold");
	    				}else if(state=="bet"){
	    					System.out.println("can't bet right now. You must deal");
	    				}else{
	    					if((int)s.charAt(m+2)>54 || (int)s.charAt(m+8)==36){
	    						v.bet(5);
	    						System.out.println("player is betting 5");
	    						state = "bet";
	    						m=m+1;
	    					}else{
	    						int count=0;
	    						for(int n = m+3; (int)s.charAt(n)<54 && (int)s.charAt(n)!=36; n++){
	    							count++;
	    						}
	    						if(count==0){
	    							v.bet(Character.getNumericValue(s.charAt(m+2)));
		    						System.out.println("player is betting " + s.charAt(m+2));
		    						state = "bet";
		    						m=m+3;
	    						}else{
		    						System.out.println("b: illegal amount");
		    						m=m+2+count;
	    						}
	    					}
	    				}
	    			}else if(ch=='d'){
	    				if(state=="bet"){
	    					System.out.println(v.deal());
	    					state = "deal";
	    				}else if(state=="deal" || state=="advise"){
	    					System.out.println("can't deal right now. You must choose the cards to hold");
	    				}else{
	    					System.out.println("can't deal right now. You must choose the ammount to bet first");
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
	    					v.hold(h);
	    					state = "hold";
	    				}
	    			}else if(ch=='$'){
	    				System.out.println("player's credit is " + v.credit());
	    				m=m+1;
	    			}else if(ch=='s'){
	    				v.statistics();
	    				m=m+1;
	    			}else if(ch=='a'){
	    				if(state=="deal"){
	    					int res [] = v.advice();
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
