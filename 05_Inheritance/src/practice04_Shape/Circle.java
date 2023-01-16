package practice04_Shape;

public class Circle implements Shape {

	// 필드
	private double radius;
	
	// 생성자
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	// 클래스를 만들때 interface구역에서 > add > sha > 검색해서 불러오기 하면 됨
	// 아래 코드를 치지 않고 불러오는 방법 : 메뉴 소스 > 
	
	@Override
	public double getArea() {
		return PI * radius * radius;
		// ==>써클의 메소드가 바인딩 되서 호출된다
	}

}
