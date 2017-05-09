package videopoker;

public class PlayResult {

	private String hand;
	private String res;
	private int credit;
	
	public void updateHand(String hand){
		this.hand=hand;
	}
	
	public void updateRes(String res){
		this.res=res;
	}
	
	public void updateCredit(int credit){
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
