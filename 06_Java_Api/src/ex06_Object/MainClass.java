package ex06_Object;

public class MainClass {

	/*
	 	java.lang.Object 클래스 ==> 자바랭들은 임폴트를 하지 않는다.
	 	
	 	1. 모든 클래스의 최상위 슈퍼 클래스이다 == 모두의 부모 클래스
	 	2. 별도의 슈퍼 클래스를 명시하지 않는 경우 Object 클래스가 슈퍼 클래스이다
	 		extends 써져 있지 않는 클래스는 모두 Object 클래스 
	 		여러개의 서로 다른 객체들을(스튜던트, 알바) 하나로 저장하기 위한(펄슨) ==> 상속
	 	3. 모든 것을 저장할 수 있는 만능 타입이다
	 		==> int 도 오고, double도 오고 다 올수 있는 기능이라는 뜻
	 	4. Object 타입으로 저장된 객체는 Object 클래스의 메소드만 호출할 수 있으므로
	 		다시 원래 객체의 타입으로 캐스팅해서 사용해야 한다
	 		
			오브젝트에 메소드를 만들수없음
			다운캐스팅해서 쓸수밖에 없음
	 */
	
	/*
	 	Object 클래스의 주요 메소드
	 	1. equals : 
	 		1) 동등 비교할 때 사용하는 메소드
	 		2) 동등 비교하는 객체들의 '참조값'을 비교함 ==> 내용(=값)이 아니라 참조값(=주소) 비교!! (객체의 값을 비교하지 못함)
	 		3) 객체의 내용(=값)으로 동등 비교를 수행하기 위해서는 다시 만드는 수밖에 없음 ==> equals 메소드를 '오버라이드'(=다시만든다) 해야 한다 ==> 중요!! 객체비교는 이퀄스 오버라이드 해야해
	 		
	 	2. toString :	
	 		1) 문자열로 변환할 때 사용하는 메소드
	 		
	 		2) "객체이름 + @ + 참조값" 형식으로 변환함
	 		3) 원하는 형식으로 변경하려면 toString으로 Override 해야함 ==> 중요
	 */
	
	public static void ex01() {
		
		//오브젝트에 메소드를 만들수없음
		//다운캐스팅해서 쓸수밖에 없음
		
		Object person = new Person();
		// Object 클래스는 모든 객체를 저장할 수있다
		//안전하게 다운캐스팅하는 방법
		
		/*
	 	오버라이드 하는 이유 override (=다시 만든다)
		부모것을 사용하지 않기 위해서 or 쓰면 안되니까 변형
		 */
	
		if(person instanceof Person) {
			((Person) person).eat();
			((Person) person).sleep();
			//Object 객체는 사용하기 위해서 항상 캐스팅해야 한다
			
		}
		
	}
	
	public static void ex02() {
		
		// name이 같으면 같은 Person으로 처리하기로 한 시스템
		Person person1 = new Person("홍길동");
		Person person2 = new Person("홍길동");
		
		if(person1.equals(person2)) { // 같으면
			System.out.println("같은 Person이다");
		}else {
			System.out.println("다른 Person이다");
		}
		// 다른 Person이다 가 나옴 
		
/*	    문서에서 이퀄 사용법:
		public boolean equals(Object obj) {
	        return (this == obj); //this는 현재값
	        
	        ==> 오브젝트에 이퀄스는 이름이 아니라 참조값으로 비교한다. 
	        ==> 내용물이 아무리 같아도 new!!!라고 새로운 객체를 만들어 줬기 때문에 비교하면 당연히 다르고 false임
*/
		
		
	}
	
	public static void ex03() {
		
		// 참조값 = hashcode
		
		Person person = new Person("홍길동");
		
		System.out.println(person.toString()); { //펄슨을 문자열로바꿔서 출력해줘, 오브젝트가 가지고 있는 투스트링임
		System.out.println(person); // toString 메소드는 호출을 생략한다!! 이것처럼 출력쓰면댐
		
			// 출력하면 필요없는,우리가 쓸수없는 출력값이 나오니까 ==> "객체이름 + @ + 참조값"
			// 그래서 toString을 오버라이딩해줘야한다 ==> 기존에 있는걸 바꾸는것. 다시 만들기.
			// Person클래스가서 string @오버라이드 확인해보면 됨
		}
		
		
		
	}
	public static void main(String[] args) {
		/*
		System.out 모니터
		System.out.println 모니터에 출력하겠다
		 	근데 저장된 애를 꺼내서 다시 사용할때는 원래상태로 돌려놓고 사용해야함
		 */
		ex03();
	}

}
