package ex01_setter;

public class MainClass {

	public static void main(String[] args) {

		// 웹개발에서는 bean을 객체라고 함
		
		// User 객체(Bean) 생성
		
		User user = new User(); // 디폴트값 만들어주기
		
		// setter를 이용한 필드값 저장
		user.setId("admin");
		user.setPw("123456");
		
		// 필드값 확인 ==> 정상적으로 값이 확인이 되는지 확인하기!!!
		System.out.println(user); // 1. 출력값 입력하고, 유저클래스로 돌아가서 소스 > 제너레이트 toString해서 오버라이드 불러오기, 그다음에 출력이 될수 있는거임
		
	}

}
