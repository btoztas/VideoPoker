package videopoker;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Statistics {
	
	private Map<String, Integer> aMap;
	int credit;
	
	Statistics(String[] hands){
		
		aMap = new LinkedHashMap<String, Integer>();
		
		for(String h : hands)
			this.aMap.put(h, 0);
		
		this.aMap.put("Other", 0);
		this.aMap.put("Total", 0);
		
		
	}
	
	void updateCredit(int credit){
		this.credit=credit;
	}
	
	public int getCredit(){
		return this.credit;
	}
	
	abstract void addStatistics(String type);
	
	
	
	void putStatistic(String type){
		
		this.aMap.put(type, this.aMap.get(type)+1);
		
	}
	
	int getStatistic(String type){
		
		return this.aMap.get(type);
		
	}
	
	
	public void printStatistics(){
		int i = 0;
		int nspaces;
		
		System.out.println("Hand                 Nb");
		System.out.println("_________________________");
	
		for (Map.Entry<String, Integer> entry : this.aMap.entrySet()) {
			nspaces=21 - entry.getKey().length();
			if(i+1<aMap.keySet().size()){
				System.out.print(entry.getKey());
				for(int k=0;k<nspaces;k++){
					System.out.print(" ");
				}
				System.out.print(entry.getValue());
				System.out.print("\n");
			}
				i++;
		}
		System.out.println("_________________________");
		System.out.println("Total                " + this.aMap.get("Total"));
		System.out.println("_________________________");
		
	}
	
	
}
