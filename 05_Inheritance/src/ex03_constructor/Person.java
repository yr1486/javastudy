package ex03_constructor;

public class Person {
	
	// 생성자 //아래가 디폴트 생성자와 같은 모습
	public Person() {
		System.out.println("Person 생성");
	}
	
	/*********************************************/
	
	// 필드
	private String name;
	
	// 생성자
	public Person(String name) {
		this.name = name;	//받아온 이름을 필드에 저장
	}
	
	// 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}


