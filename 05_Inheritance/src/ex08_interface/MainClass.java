package ex08_interface;

public class MainClass {

	public static void main(String[] args) {

		Person person = new Student();
		
		person.eat();
		person.sleep();
		person.study();
		
		// 추상이 필요한 경우 대부분 인터페이스를 쓴다

	}

}
