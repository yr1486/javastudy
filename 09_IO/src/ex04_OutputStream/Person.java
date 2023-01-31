package ex04_OutputStream;

import java.io.Serializable;

/*
 	ObjectOutputStream & inputStream을 통해서
 	객체 입출력을 수행하려면 "반드시" 직렬화 처리를 해야한다
 	// 뭉쳐있는걸 직렬화해서 보내면 다시 처음에 그 뭉쳐있는 모습으로 정렬을 해야하는거
 */

/*
 	직렬화 처리 방법
 	1. java.io.Serializable 인터페이스를 구현(implements)한다 (필수) 	==> 07_Exception 프로젝트에서 익셉션 클래스 만들때 잠깐 수업에서 설명했었음
 	2. serialVersionUID 필드 값을 정의한다 (선택,안해도됨 단,경고메세지는뜸)
 	==> 뭉쳐있는걸 직렬화해서 보내면 다시 처음에 그 뭉쳐있는 모습으로 정렬을 해야하니까 필드값에다가 정렬하는거임
 */

public class Person implements Serializable { //	// 직렬화 처리 방법 1임
	
	private static final long serialVersionUID = 7033755836244474051L; // 직렬화 처리방법 2 / 중복이 없는 값
	
	// 직렬화 처리 방법 1임
	
	
	// 객체로 만들어서 내보내 보기
	
	private String name;
	private int age;
	private double height;
	private boolean isAlive;
	
	// 객체 생성방법은 일반적으로 2개임 ==>세터 또는 컨스트럭터 / 빈 폴더가 객체 생성하는 방법의 여러가지를 나열한거임.. 세터로 만들기, 컨스트럭터로 만들기, 빌더로만들기 등등
	
	// 1. 디폴트 생성자의 세터 호출하기 //디폴트 생성자와 세터를 이용하는거.
	// 2. 컨스트럭터 // 생성자를 직접 만들어 내는 방식!! 직접 값을 받아서!!!! this.id = id; 처럼
	// ==> 모두다 사용할 수 있게 준비를 하는거임.
	
	// 생성자 1 ==> 기본
	public Person() {
		
	}

	// 생성자 2 ==> 소스 메뉴로 컨스트럭터 불러오기
	public Person(String name, int age, double height, boolean isAlive) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
	}

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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + "]";
	}
	
	
	
	
	
	

}
