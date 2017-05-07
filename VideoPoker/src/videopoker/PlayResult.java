package videopoker;

public class PlayResult {

	private String hand;
	private String res;
	private int credit;
	
	void updateHand(String hand){
		this.hand=hand;
	}
	
	void updateRes(String res){
		this.res=res;
	}
	
	void updateCredit(int credit){
		this.credit=credit;
	}
	
	public String getHand(){
		return this.hand;
	}
	
	public String getRes(){
		return this.res;
	}
	
	public int getCredit(){
		return this.credit;
	}
}
