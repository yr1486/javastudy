package ex08_this;

public class MainClass {

	public static void main(String[] args) {

		// User 객체 생성
		User user = new User("admin", "123456");
		System.out.println(user);
		
		
		// user에 저장된 값은 성성된 객체user 객체 의 참조값이다
		System.out.println(user);
		
		// user 객체의 this값 확인
		user.printThis();
		
		// user 객체의 필드값확인
		user.info();
	}
	

}
