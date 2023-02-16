package ex02_constructor;

public class MainClass {

	public static void main(String[] args) {

		// User 객체 생성
		User user = new User("admin", "123456");
		
		// 저장된 필드값 확인
		System.out.println(user);
		
	}

		// setter 와 constructor 중에 실제로는 setter를 많이 쓴다. 필요한 값만 만들면 되니까
	
		
}
