package ex08_this;

public class MainClass {

	public static void main(String[] args) {

		// User 객체 생성
		User user = new User("admin", "123456");
//		System.out.println(user); //ex08_this.User@26f0a63f
		// user에 저장된 값은 성성된 객체user 객체의 참조값이다
		
		
		// user 객체의 this값 확인
		user.printThis(); //ex08_this.User@26f0a63f
		
		// user 객체의 필드값확인
		user.info();
		//아이디 : admin
		//아이디 : 123456
		
	}
	

}
