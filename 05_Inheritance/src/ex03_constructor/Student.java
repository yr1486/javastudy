package ex03_constructor;

/*
  	상속 관계의 생성자
  	1. 자식 클래스는 "반드시" 부모 클래스를 먼저 생성한다 ==> 엄마 태어나고 자식 태어나고 이렇게
  	2. 자식 클래스의 생성자를 호출하면 "반드시" 부모 클래스의 생성자가 먼저 호출된다
  	3. 부모 클래스의 생성자가 "디폴트 생성자" 형식이면 자식 클래스에서 부모 클래스의 생성자 호출을 생략할 수 있다
	4. 부모 클래스의 생성자를 호출할 때 super()를 사용한다
	
	this : 현재 객체
	this() : 현재 객체의 생성자
	
	super : 부모 객체
	super() : 부모 객체의 생성자
	
 */
public class Student extends Person {

	// 생성자
	public Student() {
		// super(); 생략된 부분, 디폴트 값일때는 언제나 생략할 수 있다 ,아니면 개발자가 적어줘야함
		// 생략 가능한 부모 클래스의 생성자 호출(매게변수가 없는 디폴트 형식의 생성자는 생략 가능)
		System.out.println("Student 생성");
	}
	
	/*********************************************/
	
	// 필드
	private String school;
	
	
	// 생성자
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}
	

	// 메소드
	public String getSchool() {
		return school;
	}




	public void setSchool(String school) {
		this.school = school;
	}
	
	
	
	
	
	
	
}
