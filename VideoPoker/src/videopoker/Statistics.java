package videopoker;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Statistics {
	
	private Map<String, Integer> aMap;
	private int actual_credit;
	private int initial_credit;
	
	/**
	 * Constructs an object of type Statistics. Creates an Hash Map according to the given statistic types given by the 
	 * parameter hands. Additionally it creates two entries in the Hash Map with names "Other" and "Total"
	 */
	
	public Statistics(String[] hands){
		
		aMap = new LinkedHashMap<String, Integer>();
		
		for(String h : hands)
			this.aMap.put(h, 0);
		
		this.aMap.put("Other", 0);
		this.aMap.put("Total", 0);
		
		
	}
	
	/**
	 * This method increments by one the value of the entry in the Hash Map given by the parameter type
	 * @param type		type of statistics we wish to increment
	 */
	
	public void putStatistic(String type){
		
		this.aMap.put(type, this.aMap.get(type)+1);
		
	}
	
	/**
	 * This method returns the value contained in the entry given by the parameter type
	 * @param type		type of statistics we wish to get
	 */
	
	public int getStatistic(String type){
		
		return this.aMap.get(type);
		
	}
	
	/**
	 * This method makes it possible for the user to manipulate how to add a hand type result to the statistics
	 * @param type		type of hand
	 */
	
	public abstract void addStatistics(String type);
	
	
	/**
	 * This method updates the field actual_credit of this class with the value inside the object given in parameter credit
	 * @param credit		actual credit used to update the field
	 */
	
	void updateCredit(int credit){
		this.actual_credit=credit;
	}
	
	/**
	 * This method updates the field initial_credit of this class with the value inside the object given 
	 * in parameter initial_credit
	 * @param initial_credit		initial credit used to update the field
	 */
	
	void setInitialCredit(int initial_credit){
		
		this.initial_credit = initial_credit;
		
	}
	
	/**
	 * This method prints to the command line a structure with the statistics
	 */
	
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
