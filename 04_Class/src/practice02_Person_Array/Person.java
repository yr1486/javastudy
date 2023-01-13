package practice02_Person_Array;

public class Person {
	
	// 필드
	private String name;
	private int age;
	
	// 생성자
	// 생성자는 불러올 수 있다
	
	// 생성자를 2개 만들기
	// 메뉴 소스 > 제너레이터 ~필드 로도 가능
	
	public Person()	 { } // new Person()
	//디폴트 타입의 생성자인데, 생성자를 하나라도 만들면 디폴트값을 쓸수 없다, ==> 하나도 안만들때 쓰는 거
	
	
	public Person(String name, int age) { // new Person("alice", 20)
		this.name = name;
		this.age = age;
	}


	// 메소드
	// 이름과 나이를 바꿔줄수 있는 메소드는 getter setter ...!!!!!
	// bean 만들기 ( 생성자 넣어놓고 get setter 만들어놓는걸 말하고 나중에 배울 수업 내용!!
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

}
