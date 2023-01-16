package practice04_Shape;

public class Square extends Rectangle { // 정사각형은 인터페이스 잡을 필요 업음

	// 필드 필요 없음 (Rectangle이 가지고 있으니까)
	
	// 필드가 없을때 생성자 만드는 방법
	// 소스 > 슈퍼클래스 불러오기
	
	// 생성자
	public Square(double width) {
		super(width, width);
	}
}
