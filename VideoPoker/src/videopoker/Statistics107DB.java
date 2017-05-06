package videopoker;

public class Statistics107DB extends Statistics {

	Statistics107DB(String[] hands) {
		
		super(hands);
		
	}

	@Override
	void addStatistics(String type){ 
		
		if(type == null){
			this.putStatistic("Other");
		}else if(type.contains("Four")){
			this.putStatistic("Four of a Kind");
		}else{
			this.putStatistic(type);
		}
		this.putStatistic("Total");
	
	}


	

}
