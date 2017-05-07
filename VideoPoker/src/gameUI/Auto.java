package gameUI;


import videopoker.InvalidAmountException;
import videopoker.InvalidCardIndexException;
import videopoker.InvalidGameStateException;
import videopoker.PlayResult;
import videopoker.Statistics;
import videopoker.VideoPoker;
import videopoker107DB.VideoPokerType107DB;

public class Auto extends GameUI {
	
	private int bet;
	private int nbdeals;
	
	public void initGame(String[] args){
		

		this.videopoker = new VideoPoker(Integer.parseInt(args[1]), new VideoPokerType107DB());
		bet = Integer.parseInt(args[2]);
		nbdeals = Integer.parseInt(args[3]);
	}
	
	public void play(){
		
		
		
		for(int i = 0; i<nbdeals; i++){
			
			try {
				
				videopoker.bet(bet);
				
			} catch (InvalidAmountException e) {
	
				System.out.println("b: "+ e.getMessage());
				System.exit(-1);
				
			} catch (InvalidGameStateException e) {
				
				System.out.println(e.getMessage());
				System.exit(-1);
			
			}
			
			try {
				
				System.out.println(videopoker.deal());
				
			} catch (InvalidGameStateException e){
				
				System.out.println("d: " + e.getMessage());
				System.exit(-1);
				
			} catch (InvalidAmountException e) {
				
				System.out.println("d: " + e.getMessage());
				System.exit(-1);
				
			}
			int[] res = null;
			
			try {
				
				res = videopoker.advice();
				if(res!=null){
					System.out.print("player should hold ");
					for(int j=0;j<res.length;j++){
						System.out.print(res[j]+" ");
					}
					System.out.println("");
					
				}else{
					
					System.out.println("player should discard everything");
					
				}
				
			} catch (InvalidGameStateException e) {
				System.out.println("a: " + e.getMessage());
				System.exit(-1);
			}
			
			try {
				
				PlayResult result = videopoker.hold(res);
				System.out.println(result.getHand());
				if(result.getRes()!=null){
					System.out.println("player wins with a " + result.getRes() + " and his credit is " + result.getCredit());
				}else{
					System.out.println("player loses and his credit is "+ result.getCredit());
				}
				
			} catch (InvalidGameStateException e) {
				
				System.out.println("h: " + e.getMessage());
				System.exit(-1);
			} catch (InvalidCardIndexException e) {
				
				System.out.println("h: " + e.getMessage());
				System.exit(-1);
			}
			
		}
		
		Statistics stat = videopoker.statistics();
		stat.printStatistics();
	}


}
