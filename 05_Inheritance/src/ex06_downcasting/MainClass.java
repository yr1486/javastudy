package ex06_downcasting;

public class MainClass {
	
	public static void ex01() {
		

		// 복습
		// upcasting => 자식을 부모타입에 저장시킬 수 있는 것.
		// 부모 타입으로 저장되면 부모타입에 있는것만 호출할 수 있다!
		// Person person = new Student();
		// student에 있는 스터디 메소드를 부를 수 없음
		
		
		// 해결책은 => override
		// person에 스터디 호출만 해놔 // 호출과 사용은 별개
		
		// person.study();
		// 이제 부를 수 있음
		
		//--------------------------------------
		
		// Person person = new Student();
		// Student student = new Person(); // = person;
		// upcasting은 자동으로 진행되는데 downcasting은 자동으로 안됨
		
		
		Person person = new Student();
		Student student = (Student)person; // = person;
		// 먹고 자고 공부할수 있고 다 호출 가능
		// downcasting은 upcasting의 반대 + 강제변환해주는거
		student.eat();
		student.sleep();
		student.study();
		
		// upcasting은 메소드 호출에 문제가 있었음 => 부모가 가진것만 호출해서 자식에 메소드를 쓸수 없음
		// 해결책1. 부모에도 동일한 메소드(호출만)를 줘서 자식이 오버라이드 할 수있게 해준다
		// 해결책2. downcasting 을 쓰는 것 (강제 변환)
		
	}


	public static void ex02() {
		
		//Person
		Person person = new Person();
		
		// 잘못된 캐스팅
		Student student = (Student)person;
		

		// 잘못된 캐스팅은 컴파일 오류로 걸러지지 않는다
		student.eat();
		student.sleep();
		student.study(); // 오류 발생 부분
		
		
	}
	
	public static void ex03() {
		
		// 오류를 거를 수 있는 안전 장치
		
		// Person
		Person person = new Person(); //Person타입의 객체
		
		// Student 객체(=instance)가 맞다면 Student 타입으로 캐스팅하자
		if(person instanceof Student) { // person이 스튜던트 객체라면
			Student student = (Student)person;
			student.eat();
			student.sleep();
			student.study();
			
		
			// 이렇게 컴파일하면 아무것도 안뜨는데 (오류를 못잡아 내는?)
			// 맨위 Person person = new Person();
			// 을 아래처럼 바꾸면 실행됨
			// Person person = new Student();
			
			// 긴 문장을 하나로도 쓸 수 있다
			// 아래 두문장을
			// Student student = (Student)person;
			// student.eat();
			
			// 아래 한 문장으로도 사용 가능
			// ((Student)person).eat();
			
			person.eat();
			person.sleep();
			((Student)person).study();
			
			// 위 3문장과 같이 코드를 짤 수 있게끔 연습하기
			// 위에는 위치?가 어딘지 알수 없음
			
		}
		
		
		
	}
	
public static void main(String[] args) {
	ex03();
}

}
