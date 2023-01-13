package ex06_default_constructor;

public class User {
	
	// * 생성자를 만들지 않으면 '디폴트 생성자'가 사용된다 ==> 눈에 보이지 않지만 사용되고 있음
	// 생성자를 하나라도 만들면 더이상 디폴트 생성자는 자동으로 만들어져서 생성되지 않는다
	
//	User() {
//		
//	}
//	
//	위가 자바가 만든 생성자의 모습
	
	User() { // 직접 만들어 보자
		System.out.println("우리의 첫 생성자"); //MainClass에서 User user = new User(); ==> 사용됨(new "User"부분
	}
	// 필드
	String id;
	String pw;
	
	// 메소드
	void info() { //void라서 반환값이 없고 () 인수가 없는 식
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 :" + pw);
	}
}
