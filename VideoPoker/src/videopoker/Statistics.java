package videopoker;

import java.util.LinkedHashMap;
import java.util.Map;

public class Statistics {
	
	Map<String, Integer> aMap;
	
	
	Statistics(){
		
		aMap = new LinkedHashMap<String, Integer>();
		this.aMap.put("Jacks or Better", 0);
		this.aMap.put("Two Pair", 0);
		this.aMap.put("Three of a Kind", 0);
		this.aMap.put("Straight", 0);
		this.aMap.put("Flush", 0);
		this.aMap.put("Full House", 0);
		this.aMap.put("Four of a Kind", 0);
		this.aMap.put("Straight Flush", 0);
		this.aMap.put("Royal Flush", 0);
		this.aMap.put("Other", 0);
		this.aMap.put("Total", 0);
		
		
	}
	void addStatistic(String type){
		if(type.contains("Four")){
			this.aMap.put("Four of a Kind", this.aMap.get("Four of a Kind") + 1);
		}else{
			this.aMap.put(type, this.aMap.get(type)+1);
		}
		
	}
	void getStatistic(){
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
