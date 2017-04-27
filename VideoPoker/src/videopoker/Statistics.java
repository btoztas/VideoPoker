package videopoker;

public class Statistics {
	
	int[] statistic;
	public enum HAND_TYPE {
		
		 JACKSORBETTER(0), TWOPAIR(1), THREEOFAKIND(2), STRAIGHT(3), FLUSH(4), FULLHOUSE(5), FOUROFAKIND(6), STRAIGHTFLUSH(7), ROYALFULSH(8), OTHER(9);

	    private int value;
	    
	    private HAND_TYPE(int value){
	        this.value = value;
	    }
	    private int getValue(){
	    	return this.value;
	    }
	    
	}
	
	
	Statistics(){
		
		statistic = new int[HAND_TYPE.values().length];
		
	}
	public void addStatistic(HAND_TYPE type){
		
		this.statistic[type.getValue()]++;
		
		
	}
	public int getStatistic(HAND_TYPE type){
		
		return this.statistic[type.getValue()];
		
		
	}
	
	
	
}
