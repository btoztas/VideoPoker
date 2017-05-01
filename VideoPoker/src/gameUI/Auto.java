package gameUI;

import videopoker.VideoPoker;

public class Auto implements GameMode {
	
	public void initGame(String[] args){
		
	}
	
	public void play(){
		int i = 0;
		VideoPoker v = new VideoPoker(1000);
		while(i<10){
			v.bet(5);
			System.out.println(v.deal());
			int res [] = v.advice();
			if(res!=null){
				System.out.print("player should hold ");
				for(int k=0;k<res.length;k++){
					System.out.print(res[k]+" ");
				}
			}else{
				System.out.print("player should discard everything");
			}
			System.out.println();
			v.hold(res);
			i++;
		}
		double perc = (v.credit()/1000.0000)*100.0000;
		System.out.println(perc);
	}

}
