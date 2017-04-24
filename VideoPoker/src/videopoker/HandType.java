package videopoker;

public abstract class HandType {
	String name;
	int multiplier;
	
	int getMult(){
		return multiplier;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
