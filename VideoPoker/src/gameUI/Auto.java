package gameUI;

import videopoker.VideoPoker;

public class Auto implements GameMode {
	
	public void initGame(String[] args){
		
	}
	
	public void play(){
		int i = 0;
		VideoPoker v = new VideoPoker(1000000);
		while(i<100000){
			v.bet(5);
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
		double perc = (v.credit()/1000000.0000)*100.0000;
		System.out.println(perc);
		
		/*int i = 0;
		while(i<1000){
			VideoPoker v = new VideoPoker(1000000);
			System.out.println(v.deal());
			v.hold(new int[0]);
			i++;
		}*/
	}

}
