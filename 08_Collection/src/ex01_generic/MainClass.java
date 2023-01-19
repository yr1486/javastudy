package ex01_generic;

public class MainClass {

	public static void main(String[] args) {

		// Generic 처리할 때는 "항상" 참조 자료형을 전달해야 한다 int => Integer , char => Character
		Box<Integer> box1 = new Box<Integer>(); // 정수를 저장할 수 있는 박스 생성
		//Box box = new Box(); 가 위처럼 변한거임 , int타입을 박스에 담을 수 있는게 생겼다고 생각하기
		
		box1.setItem(10);
		System.out.println(box1.getItem());//10
		
		
		// JDK 1.7 이후로 생성자에는 자료형을 생략할 수 있다
		Box<String> box2 = new Box<>(); //뒤에 참조 자료형 생략되고 꺽쇠만 남았음
		
		box2.setItem("hi");
		System.out.println(box2.getItem());//hi
	}

	
	
	
}
