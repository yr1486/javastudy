package ex07_abstract;

public class MainClass {

	public static void main(String[] args) {

		Person person = new Student();
		
		person.eat();
		person.sleep();
		person.study();
		
		// 현재 가장 안전한 코드라고 볼 수 있음
		// 상속 개념이 중요한 부분..............
		
	}

}
