package practice05_Employee;

// 비정규직

// 설명 : 템포러리는 임플로이를 부모로 갖는 클래스고.
// 얘는 시급이라는 필드를 선언하고
// 똑같이 생성자안에서 초기화 해줬어


public class Temporary extends Employee {

	// 필드
	private int hourPay;    // 시급
	
	// 생성자
	public Temporary(int empNo, String name, int hourPay) {
		super(empNo, name);
		this.hourPay = hourPay;
	}

	// 얘도 값을 받고 돌려주는 게터세터 하고
	
	// 메소드
	public int getHourPay() {
		return hourPay;
	}

	public void setHourPay(int hourPay) {
		this.hourPay = hourPay;
	}

	// 정규직이랑 똑같이 부모 메소드 오버라이드 해줬어.
	// 이 알바클래스는 정규직 클래스랑 같으니까 설명이 더 필요없을거같고.
	//이제 회사클래스로 가서 정의 해볼게.
	
	@Override
	public void info() {
		super.info();  // Employee의 info 메소드 호출
		System.out.print("[시급:" + hourPay + "원]");
	}
	
	@Override
	public int getPay() {
		return hourPay * 200;  // 비정규직은 시급 * 근무시간이 월급이다. 편의상 근무시간은 모두 200시간으로 한다.
	}
	
}
