package videopoker;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Statistics {
	
	private Map<String, Integer> aMap;
	private int actual_credit;
	private int initial_credit;
	
	public Statistics(String[] hands){
		
		aMap = new LinkedHashMap<String, Integer>();
		
		for(String h : hands)
			this.aMap.put(h, 0);
		
		this.aMap.put("Other", 0);
		this.aMap.put("Total", 0);
		
		
	}
	
	public void putStatistic(String type){
		
		this.aMap.put(type, this.aMap.get(type)+1);
		
	}
	
	public int getStatistic(String type){
		
		return this.aMap.get(type);
		
	}
	
	public abstract void addStatistics(String type);
	
	
	void updateCredit(int credit){
		this.actual_credit=credit;
	}
	
	
	void setInitialCredit(int initial_credit){
		
		this.initial_credit = initial_credit;
		
	}
	
	
	public void printStatistics(){
		int i = 0;
		int nspaces;
		
		System.out.println("Hand                 Nb");
		System.out.println("---------------------------------");
	
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
		System.out.println("---------------------------------");
		System.out.println("Total                " + this.aMap.get("Total"));
		System.out.println("---------------------------------");
		double percentage = ((double)this.actual_credit/(double)this.initial_credit)*100.0;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		System.out.println("Credit            " + this.actual_credit + " (" + numberFormat.format(percentage) + "%)");
		
		
	}
	
	
}
