package ex10_static;

public class MyMath {
	
	// ctrl+ shift + x, y ==> 대문자 소문자 변환 단축키
	
	// static 붙어있는 애들은 클래스 영역에 '하나만' 만들어서, 다 가져다가 쓸 수 있게 해준다
	
	/*
	 	static
	 	1. 정적 요소
	 	2. 객체 생성 이전에 클래스 영역에 만들어 지는 요소
	 	3. 객체마다 생성되지 않고 클래스별로 1개씩만 생성(만든다)
	 	4. 클래스를 이용해서 호출하기 때문에 클래스 변수, 클래스 메소드라고 부름
	 	5. static 요소는 다른 static 요소만을 참조할 수 있다 (먼저 만들어진 애들)
	 		*static 애들은 static만 쓸 수 있다 참조할 수 있다
	 		*non-static (나중에 만들어 진다) 요소는 참조할 수 없음
	 		
	 	**쌤이 말하는 필드 = 변수를 의미함
	 	*
	 */

	// 필드
	public static final double PI = 3.141592; // PI 대문자로 수동 전환 해야함

	
	// 메소드
	public static double getCircleArea(double radius) {
		return PI * radius * radius;
		
	}
	
	
	
	public static double max(double...numbers) { //... -> 배열로 해석
		double max = Double.MIN_VALUE; //이름 대문자니까 클래스로 불렀네. .다음 대문자니까 상수네
		for(int i = 0; i < numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		return max;
	
	}
	public static double min(double...numbers) {
		double min = Double.MAX_VALUE;
		for(int i = 0; i < numbers.length; i++) {
			if(min > numbers[i]) {
				min = numbers[i];
			}
		}
		return min;
	
	}
	
}
