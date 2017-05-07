package gameUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import deckofcards.InvalidCardException;
import videopoker.*;
import videopoker107DB.VideoPokerType107DB;


public class Debug extends GameUI {
	
	private String cmd_file;
	private String card_file;
	
	public void initGame(String[] args){
		this.cmd_file = args[2];
		this.card_file = args[3];
		String read_file = "";
		try{
		read_file = new String(Files.readAllBytes(Paths.get(card_file)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try{
		this.videopoker = new VideoPoker(Integer.parseInt(args[1]), new VideoPokerType107DB(), read_file);
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
			bufferRead = new BufferedReader(new FileReader(cmd_file));
            String s = "";
    		if((s = bufferRead.readLine())!=null){
    			
    	        System.out.println(s);
    	        String[] tokens = s.split("\\s+");
    	        
    	        for(int m=0;m<tokens.length;){
    	        	//System.out.print(tokens[m]);
    	        	
	    			if(tokens[m].equals("b")){
    					if((int)tokens[m+1].charAt(0)>57 || (int)tokens[m+1].charAt(0)==36){
    						try{
    						videopoker.bet(5);
    						System.out.println("player is betting 5");
	    					}catch(InvalidGameStateException e){
	    						System.out.println("b: " + e.getMessage());
	    					}catch(InvalidAmountException e){
	    						System.out.println("b: " + e.getMessage());
	    					}
    						m=m+1;
    					}else{
    						try{
    						videopoker.bet(Integer.parseInt(tokens[m+1]));
    						System.out.println("player is betting " + Integer.parseInt(tokens[m+1]));
	    					}catch(InvalidGameStateException e){
	    						System.out.println("b: " + e.getMessage());
	    					}catch(InvalidAmountException e){
	    						System.out.println("b: " + e.getMessage());
	    					}
    						m=m+2;
    					}
	    			}else if(tokens[m].equals("d")){
	    				System.out.println("ola");
	    				try {
	    					System.out.println(videopoker.deal());
	    				} catch (InvalidGameStateException e){
	    					System.out.println("d: " + e.getMessage());
	    				} catch (InvalidAmountException e) {
	    					System.out.println("d: " + e.getMessage());
	    				}
	    				m=m+1;
	    			}else if(tokens[m].equals("h")){
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
    							h[i]=Integer.parseInt(tokens[m+i+1]);
    							count++;
    						}
    					}
    					int [] ho = new int[count];
    					for(int i=0;h[i]!=0;i++){
    						//System.out.print(i);
    						ho[i]=h[i];
    					}
    					PlayResult result = videopoker.hold(h);
    					System.out.println(result.getHand());
    					if(result.getRes()!=null){
    						System.out.println("Player wins with a " + result.getRes() + " and his credit is " + result.getCredit());
    					}else{
    						System.out.println("Player loses and his credit is "+ result.getCredit());
    					}
    					}catch (InvalidGameStateException e) {
    						System.out.println("h: " + e.getMessage());
    					} catch (InvalidCardIndexException e) {
    						System.out.println("h: " + e.getMessage());
    					}
    					m = m + count + 1; 
	    			}else if(tokens[m].equals("$")){
	    				System.out.println("player's credit is " + videopoker.credit());
	    				m=m+1;
	    			}else if(tokens[m].equals("s")){
	    				Statistics stat = videopoker.statistics();
	    				stat.printStatistics();
	    				m=m+1;
	    			}else if(tokens[m].equals("a")){
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
