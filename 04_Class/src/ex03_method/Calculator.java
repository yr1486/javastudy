package ex03_method;

public class Calculator { // 메소드
	
	// 2023-01-10 5교시
	
	// 필드 (변수)  ===> 클래스 안에 생성,
	// 메소드 (함수, 어떤 기능을 만드는 것) ===> 메소드 안에 생성: 변수
	
	/* 
	   메소드 형식
	   
	   반환타입 메소드명(매개변수) {
	   	 메소드 본문
	   	 return 반환값
	   	 }
	   	 
	   	 1. 반환값 + 반환타입
	   	 	메소드 실행(메소드 호출)의 결과
	   	 2. 메소드명
	   	 	개발자 마음대로 정함
	   	 3. 매개변수
	   	 	메소드로 전달되는 값(인수 = argument)을 저장하는 변수
	 */
	
	
	/*
	 	메소드의 4가지 형식                                  메소드 호출
	 	
	 	1. 반환값X, 인수X (없을때)
	 		void method() {								method();
	 			메소드 본문
	 		}
	 		
	 	2. 반환값X, 인수O									int a = 0;
	 		void method(int arg) {						method(a);
	 			메소드 본문
	 		}
	 	
	 	3. 반환값O, 인수X
	 		int method() {								int result;
	 			메소드 본문									result = method();
	 			return 반환값
	 		}
	 			
	 	4. 반환값O, 인수O									int a = 0;
	 		int method(int arg) {						int result;
	 			메소드 본문									result = method(a);
	 			return 반환값
	 		}
	 	
	 	*반환값: 메소드가 돌려주는 값
	 	*인수: 메소드에 전달하는 값
	 */

	
	
	// 덧셈 메소드 정의
	double addition(double a, double b) {
		
		return a + b; // 값을 돌려주겠다
		
		
	}
	// 뺄셈 메소드 정의
	double subtraction(double a, double b) {
		
		return a - b; // 값을 돌려주겠다
		
	}

}