package ex08_this;

public class User {

	/*
	 	this
	 	1. 현재 객체의 참조값
	 	2. 클래스 내부에서만 사용할 수 있다
	 	3. 사용 용도 : 클래스의 구성 요소(필드, 메소드)를 호출할 때 사용할 수 있다
	 		1) 필드 : this.필드
	 		2) 메소드 : this.메소드()
	 */
	
	// 필드
	String id;  // this.id
	String pw;  // this.pw
	
	// 생성자
	User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	// 메소드
	void printThis() {
		System.out.println(this);
		
		// 외부에서는 user라고 부르고 여기 내부에서는 this 라고 부른다
	}
	
	void info() {
		System.out.println("아이디 : " + id);
		System.out.println("아이디 : " + pw);
		
		// 매개변수하고 이름이 같을때만 쓴다
	}
	
}
