package videopoker;

/**
 * 
 * auxiliary class to store the information needed to present to the user after an hold
 *
 */

public class PlayResult {

	private String hand;
	private String res;
	private int credit;
	

	/**
	 * This method updates its own object of type Hand with the given object hand
	 * @param hand		object used to update the field hand
	 */
	
	public void updateHand(String hand){
		this.hand=hand;
	}
	
	/**
	 * This method updates its own object of type String with the given object res
	 * @param res		object used to update the field res
	 */
	
	public void updateRes(String res){
		this.res=res;
	}
	
	/**
	 * This method updates its own object of type Credit with the given object credit
	 * @param credit		object used to update the field credit
	 */
	
	public void updateCredit(int credit){
		this.credit=credit;
	}
	
	/**
	 * This method returns the object hand present inside the object PlayResult
	 * @return hand		object with the hand to get
	 */
	
	public String getHand(){
		return this.hand;
	}
	
	/**
	 * This method returns the object res present inside the object PlayResult
	 * @return res		object with the result to get
	 */
	
	public String getRes(){
		return this.res;
	}
	
	/**
	 * This method returns the object credit present inside the object PlayResult
	 * @return credit		object with the credit to get
	 */
	
	public int getCredit(){
		return this.credit;
	}
}
