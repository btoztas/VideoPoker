package videopoker;

public class Pot {
	
	private int value;
	
	Pot(){
		value = 0;
	}
	
	void add(int bet){
		value = bet;
	}
	int withdraw(){
		int out = value;
		value = 0;
		return out;
	}
}
