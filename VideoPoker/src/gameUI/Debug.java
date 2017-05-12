package gameUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import deckofcards.EmptyDeckEception;
import deckofcards.InvalidCardException;
import videopoker.*;
import videopoker107DB.VideoPokerType107DB;
import videopokerdebug.VideoPokerDebug;


public class Debug extends GameUI {
	
	private String cmd_file;
	private String card_file;
	
	public void initGame(String[] args){
		this.cmd_file = args[2];
		this.card_file = args[3];
		String cards = "";
		try{
			cards = new String(Files.readAllBytes(Paths.get(card_file)));
		}
		catch (IOException e) {
			System.out.println("Invalid card file");
			System.exit(0);
		}
		try{
			
			this.videopoker = new VideoPokerDebug(Integer.parseInt(args[1]), new VideoPokerType107DB(), cards);
			
		}catch(NumberFormatException e){
			
			System.out.println("Invalid credit");
			System.exit(0);
			
		}catch(InvalidCardException e){
			
			System.out.println(e.getMessage());
			System.exit(0);
			
		}
	}
	
	public void play(){
		BufferedReader bufferRead = null;
		
		try {
			try{
				bufferRead = new BufferedReader(new FileReader(cmd_file));
			}catch(FileNotFoundException e){
				System.out.println("Invalid command file");
				System.exit(0);
			}
            String s = "";
    		if((s = new String(Files.readAllBytes(Paths.get(cmd_file))))!=null){
    			
    	        String[] tokens = s.split("\\s+|\\s*\\,\\s*");
    	        
    	        for(int m=0; m<tokens.length;){
    	        	//System.out.print(tokens[m]);
    	        	
	    			if(tokens[m].equals("b")){
	    				try{
	    					if((int)tokens[m+1].charAt(0)>57 || (int)tokens[m+1].charAt(0)==36){
	    						System.out.println("-cmd " + tokens[m]);
	    						try{
		    						videopoker.bet(5);
		    						System.out.println("player is betting 5");
		    					}catch(InvalidGameStateException e){
		    						System.out.println("b: " + e.getMessage());
		    					}catch(InvalidAmountException e){
		    						System.out.println("b: " + e.getMessage());
		    					} catch (InsufficientFundsException e) {
		    						System.out.println("b: " + e.getMessage());
								}
	    						m=m+1;
	    					}else{
	    						System.out.println("-cmd " + tokens[m] + " " + tokens[m+1]);
	    						try{
	    							videopoker.bet(Integer.parseInt(tokens[m+1]));
	    							System.out.println("player is betting " + Integer.parseInt(tokens[m+1]));
		    					}catch(InvalidGameStateException e){
		    						System.out.println("b: " + e.getMessage());
		    					}catch(InvalidAmountException e){
		    						System.out.println("b: " + e.getMessage());
		    					}catch(NumberFormatException e){
		    						System.out.println("b: Invalid credit");
		    					} catch (InsufficientFundsException e) {
		    						System.out.println("b: " + e.getMessage());
								}
	    						m=m+2;
	    					}
	    				}catch(ArrayIndexOutOfBoundsException e){
    						
    					}
	    			}else if(tokens[m].equals("d")){
	    				System.out.println("-cmd " + tokens[m]);
	    				try {
	    					System.out.println("player's hand " + videopoker.deal());
	    				} catch (InvalidGameStateException e){
	    					System.out.println("d: " + e.getMessage());
	    				} catch (InvalidAmountException e) {
	    					System.out.println("d: " + e.getMessage());
	    				} catch (InsufficientFundsException e) {
	    					System.out.println("d: " + e.getMessage());
						} catch (EmptyDeckEception e) {
							System.out.println(e.getMessage());
							System.exit(-1);
						}
	    				m=m+1;
	    			}else if(tokens[m].equals("h")){
	    				System.out.print("-cmd " + tokens[m]);
    					int h[] = new int[5];
    					for(int i=0;i<5;i++){
    						h[i]=0;
    					}
    					int count=0;
    					try{
	    					for(int i=0;i<5;i++){
	    						if((int)tokens[m+i+1].charAt(0)>57 || (int)tokens[m+i+1].charAt(0)==36){
	    							i=5;
	    						}else{
	    							System.out.print(" " + tokens[m+i+1]);
	    							try{
		    							h[i]=Integer.parseInt(tokens[m+i+1]);
		    							count++;
		    						}catch(NumberFormatException e){
		    							System.out.println("Invalid credit");
		    							System.exit(-1);
		    						}
	    						}
	    					}
    					}catch(ArrayIndexOutOfBoundsException e){
    						
    					}	
    					System.out.println();
    					try{
    						
	    					int [] ho = new int[count];
	    					
	    					for(int i=0;h[i]!=0;i++){
	    						//System.out.print(i);
	    						ho[i]=h[i];
	    					}
	    					
	    					PlayResult result = videopoker.hold(h);
	    					System.out.println("player's hand " + result.getHand());
	    					if(result.getRes()!=null){
	    						System.out.println("player wins with a " + result.getRes() + " and his credit is " + result.getCredit());
	    					}else{
	    						System.out.println("player loses and his credit is "+ result.getCredit());
	    					}
	    					
    					}catch (InvalidGameStateException e) {
    						System.out.println("h: " + e.getMessage());
    					} catch (InvalidCardIndexException e) {
    						System.out.println("h: " + e.getMessage());
    					}
    					if(videopoker.credit()==0){
    						System.out.println("no more credit");
    						System.exit(-1);
    					}
    					m = m + count + 1;
	    			}else if(tokens[m].equals("$")){
	    				System.out.println("-cmd " + tokens[m]);
	    				System.out.println("player's credit is " + videopoker.credit());
	    				m=m+1;
	    			}else if(tokens[m].equals("s")){
	    				System.out.println("-cmd " + tokens[m]);
	    				Statistics stat = videopoker.statistics();
	    				stat.printStatistics();
	    				m=m+1;
	    			}else if(tokens[m].equals("a")){
	    				System.out.println("-cmd " + tokens[m]);
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
