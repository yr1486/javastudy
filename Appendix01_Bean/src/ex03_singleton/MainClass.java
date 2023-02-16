package ex03_singleton;

public class MainClass {

	public static void main(String[] args) {

		// User 객체 가져오기
		
		User user1 = User.getInstance();
		User user2 = User.getInstance();
		
		// 같은 User인가?
		// 참조값이 같은가?
		System.out.println(user1 == user2); //true // User가 하나밖에 못나오고 하나밖에 없으니까 참조하는 값이 같은거임
		
		// ==> singleton하면 getInstance메소드가 연관검색어
		
		// 객체 새로 만드는 방법 3개 했음!!!
		// setter, constructor, singleton
		
	}

}
