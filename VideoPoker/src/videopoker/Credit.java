package videopoker;

public class Credit {
	
	private int actual_credit;
	private int initial_credit;
	
	Credit(int c){
		initial_credit = actual_credit = c;
	}
	
	void withdraw(int r){
		actual_credit = actual_credit - r;
	}
	
	void add(int a){
		actual_credit = actual_credit + a;
	}
	
	int getCredit(){
		return this.actual_credit;
	}
	
	int getInitialCredit(){
		return this.initial_credit;
	}
}
