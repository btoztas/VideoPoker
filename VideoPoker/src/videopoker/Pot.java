package videopoker;

public class Pot {
	int value;
	
	Pot(){
		value = 0;
	}
	
	void inPot(int bet){
		value = bet;
	}
	int outPot(){
		int out = value;
		value = 0;
		return out;
	}
}
