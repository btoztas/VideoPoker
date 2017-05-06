package gameUI;


import videopoker.Statistics;
import videopoker.VideoPoker;
import videopoker.VideoPokerType107DB;

public class Auto implements GameMode {
	
	int credit;
	int bet;
	int nbdeals;
	
	public void initGame(String[] args){
		credit = Integer.parseInt(args[1]);
		bet = Integer.parseInt(args[2]);
		nbdeals = Integer.parseInt(args[3]);
		if(bet>5){
			System.out.println("b: illegal ammount");
			System.exit(0);
		}
	}
	
	public void play(){
		int i = 0;
		VideoPoker v = new VideoPoker(credit, new VideoPokerType107DB());
		while(i<nbdeals){
			v.bet(bet);
			//System.out.println(v.deal());
			v.deal();
			int res [] = v.advice();
			if(res!=null){
				//System.out.print("player should hold ");
				for(int k=0;k<res.length;k++){
					//System.out.print(res[k]+" ");
				}
			}else{
				//System.out.print("player should discard everything");
			}
			//System.out.println();
			System.out.println(v.credit());
			v.hold(res);
			i++;
		}
		double perc = (v.credit()/credit)*100.0000;
		System.out.println(perc);
		
		/*int i = 0;
		while(i<1000){
			VideoPoker v = new VideoPoker(1000000);
			System.out.println(v.deal());
			v.hold(new int[0]);
			i++;
		}*/
		
		Statistics stat = v.statistics();
		stat.printStatistics();
		double percentage = (stat.getCredit()/credit)*100.0000;
		System.out.println("Credit            " + stat.getCredit() + " (" + percentage + "%)");
	}


}
