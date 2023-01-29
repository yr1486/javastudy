package ex04_method_overloading;

public class Calculator {
	
	// 더하기 기능 만들기 => 에디션
	double addition(double a, double b)	{
		return a + b;
	
	/*
	 	메소드 오버로딩
	 	1. 같은 이름의 메소드를 여러개 만들 수 있다
	 	2. 제한 조건
	 		1) '메소드' 이름이 같아야 한다
	 		2) '매개변수'의 타입이나 개수가 달라야 한다
	 		3) 주의: 반환타입 메소드 오버로딩과 연관이 없다 ==> 같아도 되고 달라고 된다
	 */
	}
	double addition(double[]numbers) { //()안에 값이 메인메소드에서는 arr이라고 불림
		double total = 0.0;
		for(int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		return total;
	}

	
	// 예제) 삼각형 넓이 구하기 중 오버로딩이 되는지 생각해보기
	
	// int area = cal.getArea(3,4)
	// double area = cal.getArea(3,3)	
	
	// ==> 이름도 같고 개수도 같아서 오버로딩이 되지 않음
	// ==> 반환타입(int, double은 오버로딩과 연관이 없음!!
	
	// int area = cal.getArea(int 3, 4)
	// double area = cal.getArea(double 3, 3)	
	// 위 는 가능.
}

