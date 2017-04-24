package gameUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Interactive implements GameMode {
	
	int credit;
	public void readCommand(String[] args){
		
	}
	
	public void play(){
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try{
	        String s = bufferRead.readLine();
	        System.out.println(s);
			}
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
		}
	}

}
