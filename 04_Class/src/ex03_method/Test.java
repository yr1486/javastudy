package ex03_method;

public class Test {
	
	public static void ex01() {
		
		// 문제1. int serial의 첫 번째 글자가 1,3,5이면 "남자", 2,4,6이면 "여자"를 출력하시오.
		// int serial의 첫 번째 글자는 항상 1 ~ 6 사이의 정수라고 가정한다.
		// 예시
		// 남자입니다.
		
			int serial = 5;
			
			if(serial % 2 == 1) {
				System.out.println("남자입니다.");
			}
			else if(serial % 2 == 0) {
				System.out.println("여자입니다.");
			}
			
	}
	
	public static void ex02() {
		
		// 문제3. 구구단을 모두 출력하지 말고 5 x 5 = 25까지만 출력하시오. 2~9단까지 다나오고 5단만 5 x 5 = 25까지만 출력
		// 예시
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		// 5 x 5 = 25
		
		// break...?
		
		for(int i = 2; i < 6; i++) {
			for(int j = 1; j < 10; j++) {
				if(i*j == 30) {
					break;
				}
			System.out.println( i + " x " + j + " = " + (i * j));
			}
		}
	}
			
	public static void ex03() {
		
		// 문제5. 1부터 100 사이의 모든 짝수와 홀수를 각각 더한 결과를 모두 출력하시오.
		// 예시
		// 짝수 합은 2550입니다.
		// 홀수 합은 2500입니다.
		
		int a = 0;
		int b = 0;
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				a += i;
			}
			else 
				b += i;
			
		}

		System.out.println("홀수" + b);
		System.out.println("짝수" + a);
	}

	
	public static void main(String[] args) {
		ex03();

	}

	
	
	
	
	
	
	
	
	
	
	
}
