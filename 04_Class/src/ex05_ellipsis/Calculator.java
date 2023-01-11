package ex05_ellipsis;

public class Calculator {

	/* 
	 	매개변수 생략 (개수 생략) 하기
	 	1. 전달 되는 인수의 개수가 정해지지 않은 경우에 사용한다
	 	2. 말 줄임표(...)를 코드에서 활용한다
	 	3. 실제로는 배열로 처리된다 (...을 java가 알아서 배열로 받음)
	 */
	
	double addition(double... numbers) { // 몇개가 넘어오든 double 타입으로 받을수 있다
		double total = 0.0;
		for(int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		return total;
	}
	
}
