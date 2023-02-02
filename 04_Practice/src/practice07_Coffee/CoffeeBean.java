package practice07_Coffee;

// 커피 원두

public class CoffeeBean { //커피원두 필드

	// 필드
	private String origin;  // 커피 원산지 정보
	
	
	// 설명 : 커피 원산지의 값을 담을 오리진이라는 필드 하나만들어 줬고
	
	// 생성자
	public CoffeeBean(String origin) {
		this.origin = origin;
		
	// 설명 : 외부에서 값을 받아서 필드를 초기화하는 생성자를 만들었어
	}
	
	// 조회 메소드
	public void info() {
		System.out.println("원산지 : " + origin);
		
		// 설명 : 그리고 이 값을 전달해줄 info라는 메소드를 하나 만들었어.
		// 그다음에 에스프레소 클래스로 가서
	}
	
}
