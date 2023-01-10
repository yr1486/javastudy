package ex02_loop;

public class Ex01_for {
	
	/* 
	  for문
	  1. 연속된 숫자를 생성하는 반복문(배열에서 주로 사용)
	  2.형식
	   for(초기문; 조건문; 증감문) {
	       실행문
	  	}
	  	
	  	실행 순서 - 초기문, 조건문, 실행문, 증감문
	  	처음 초기문 한번만 실행되며, 나머지 2,3,4번이 실행되는 형식
	 */
	
	
	public static void ex01() {
		
		// 1~10
		for(int a = 1; a <= 10; a++) { //++a도 가능, 차이가 없음, a<11도 가능
			System.out.println(a);
			
//		for(int a = 0; a <=9; a++) { // 위와 같은 식
//			System.out.println(a+1);
		}

	}
	
	public static void ex02() {	
		
		// 횟수를 정해놓고 생성하는 반복문
		// 5번
		// 보통 횟수를 정해놓고 반복 시 1이 아닌 '0'부터 시작 - 위 예제 1번과의 변화는 '<=' 가 있음

//		for(int a = 0; a < 5; a++) {
//			System.out.println("Hello World");
		
			// 횟수를 저장하는 변수가 하나 있고, 그걸 조건문에 적용한 예
			int count = 5;
			for(int a = 0; a < count; a++) {
				System.out.println("Hello World");
		}
	}

	public static void ex03() { // 연습문제
		// 10 ~ 1 거꾸로 출력
		for(int a = 10; a > 0; a--) {
			System.out.println(a);
		}
	
	}
	
	
	public static void ex04() { // 연습문제
		// 구구단 2단 연습
		// 2 x 1 = 2  //여기서 변하는, 증가하는 값인 1~9까지가 a가 되는 부분임 
		// 2 x 2 = 4  // 값의 부분은 2 * a
		
		int dan = 2; // 변수값을 사용하면 원하는 값의 구구단을 출력 할 수 있음
		
		for(int a = 1; a < 10; a++) {
			System.out.print(dan + " x " + a + " = " + (dan * a));
		}
	
	}
	
	public static void main(String[] args) {
		ex04();
	}

}
