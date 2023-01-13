package practice01;

public class MainClass {

	public static void main(String[] args) {

		BankAccount myAcc = new BankAccount("010-1111-1111", 50_000);
		BankAccount yourAcc = new BankAccount("010-1111------------------0ㅐㅐㅐㅐㅐㅐ"
				+ "-+"
				+ "`-1111", 100_000);
		
		myAcc.transfer(yourAcc,100_000); // 5만원보내기하면 성공함
		
		myAcc.inquiry();
		yourAcc.inquiry();
	}

}
