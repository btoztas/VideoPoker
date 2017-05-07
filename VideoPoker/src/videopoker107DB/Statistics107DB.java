package videopoker107DB;

import videopoker.Statistics;

public class Statistics107DB extends Statistics {

	public Statistics107DB(String[] hands) {
		
		super(hands);
		
	}

	@Override
	public void addStatistics(String type){ 
		
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
