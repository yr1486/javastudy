package practice05_Employee;

// 정규직


public class Regular extends Employee {
	// 내설명 : 레귤러 클래스는 임플로이의 자식 클래스고 부모클래스의 필드와 메소드 이외에 정규직에만 필요한 정보들을 따로 필드. 메소드로 만들어 줄거야

	// 필드
	// 정규직이니까 월급을 줘야해서 저장할수있는 샐러리 필드 하나를 선언했고
	private int salary;  // 기본급

	// 생성자
	public Regular(int empNo, String name, int salary) { // 임플로이의 3가지 정보를 받아 초기화 해주는 생성자를 만들었고.
		super(empNo, name); // 내가 슈퍼에 대한 개념이 안잡혀서.. 일단 자식클래스에서는 부모클래스를 무조건 먼저 호출을 해줘야 생성할수 ? 있는데 여기서 부모클래스의 생성과 초기값을? 생성해줬어
		this.salary = salary; // 디스샐러리도 인트값인 샐러리 매개변수값을 받아서 레귤러 클래스 샐러리 필드를 초기화 해줬어.
	}
	
	// 메소드
	// 내설명: 그리고 이제 샐러리의 값을 저장하고 돌려줄 게터세터를 또한번 불러주고.
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	// 부모클래스에 있는 메소드를 오버라이딩해서 구현? 완성 해줬어. 부모클래스를 가지면 자식클래스에서 꼭 메소드를 완성 시켜줘야하니까.
	@Override
	public void info() {
		super.info();  // Employee의 info 메소드 호출
		System.out.print("[기본급:" + salary + "원]");
	}

	// 이것도 마찬가지로 부모클래스에서 완성되지 않은 메소드를. 정규와 비정규의 각 월급이 다르니. 여기서 가지고 갈 지역변수를 리턴해주는걸로 메소드를 완성해놨어.
	// 그다음 비정규직 클래스를 정의해볼게
	@Override
	public int getPay() {
		return salary;  // 정규직은 salary가 월급이다.
	}
	
}
