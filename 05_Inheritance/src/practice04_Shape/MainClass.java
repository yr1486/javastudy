package practice04_Shape;

public class MainClass {

	public static void main(String[] args) {
		
		// 메인클래스 따로 만드는 이유 : 어떤 클래스든 메인을 가질 수 있다
		// 	public static void main(String[] args) {   ==> 요문장 ,
		
		Shape circle = new Circle(1.5); //upcasting 함 ==> shape만 가진 걸 호출 할 수 있다 ==>써클의 메소드가 바인딩 되서 호출된다
		System.out.println("원 면적 :" + circle.getArea());

		
		Shape ractangle = new Rectangle(1.5, 2.5); // 너비 1.5, 높이 2,5인 사각형
		System.out.println("사각형 면적 : " + ractangle.getArea());
		
		Shape square = new Square(1.5); // 너비, 높이 1.5인 정사각형
		System.out.println("정사각형 면적 : " + square.getArea());
		
		// getArea 역할이 같은 걸 이해하기
		
		
		
	}

}
