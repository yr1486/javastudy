package practice01;

//bankaccount = 설계도
//mainclass = 실행

public class BankAccount {
	
	// 필드
	
	private String accNo;
	private long balance;
	
	// 생성자
		//이름이 클래스와 같다
		//반환 타입이 없다
		//메소드의 일종이기 때문에 public 처리를 한다
	
	public BankAccount(String accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
		// this를써서 필드값과 매개값과 같은지
		
	}
	// 메소드 - 입금, 출금, 이체, 조회 진행 해보기.
	
	// 입금 (마이너스 입금 불가 처리하기)
	public void deposit(long money) { // 메소드는 퍼블릭 처리, 보이드는 반환 없음
		if(money <= 0 ) { // <= 0원은 입금되지 않으니까 같다고 표시하기
			return; // 메소드 종료. 오직 반환이 void인 경우에만 사용 가능
		}
		balance += money;
			
	}
	
	// 출금 (마이너스 출금과 잔액보다 큰 출금 불가 처리하기)
	public long withdrawal(long money) {
		if(money <= 0 || money > balance) {
			return 0; // 리턴 얼마라고 해서 값을 찍어줘야 한다, 모든 경우의 만들 수 있다 //실제로 출금되는 돈이 없다라는 뜻
		}
		balance -= money;
		return money; //요청한 머니가 그대로 반환되어야 한다
	}
	
	// 이체
	public void transfer(BankAccount other, long money) {
		// 1. 내 통장에서 money 출금 : this.withdrawal(money) //this는 이름 구분이 안될 때 쓰임 여기서 굳이 쓰일 필요는 없음
		// 2. 상대 통장에 실제로 내 통장에서 출금된 금액을 입금(money가 아님..!) : other.deposit(money)
		other.deposit(withdrawal(money));
	}
	
	// 조회
	public void inquiry() {
		System.out.println("계좌번호 : " + accNo);
		System.out.println("잔액 : " + balance + "원");
	}
	
	
	
}
