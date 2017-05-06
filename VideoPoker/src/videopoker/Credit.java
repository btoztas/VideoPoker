package videopoker;

public class Credit {
	
	int credit;
	
	Credit(int c){
		credit = c;
	}
	
	void withdraw(int r){
		credit = credit - r;
	}
	
	void add(int a){
		credit = credit + a;
	}
	
	int getCredit(){
		return this.credit;
	}
}
