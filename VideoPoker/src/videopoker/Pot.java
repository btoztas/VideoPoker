package videopoker;

public class Pot {
	
	private int value;
	
	Pot(){
		value = 0;
	}
	
	public void add(int bet){
		value = bet;
	}
	public int withdraw(){
		int out = value;
		value = 0;
		return out;
	}
}
