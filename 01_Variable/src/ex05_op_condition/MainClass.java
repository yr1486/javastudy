package ex05_op_condition;

public class MainClass {

		public static void ex01() {
			
			int a = 3;
			int b = 4;
			
			boolean result1 = a > b;
			boolean result2 = a >= b;
			boolean result3 = a < b;
			boolean result4 = a <= b;
			boolean result5 = a == b;
			boolean result6 = a != b;
			
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);
			System.out.println(result5);
			System.out.println(result6);
			
		}
		
		public static void ex02() {
			
			// 논리 연산
			// 1. 논리 AND : &&, 모든 조건이 true 면 true , 아니면 false
			// 2. 논리 OR : ||, 하나의 조건이라도 true 면 true, 아니면 false
			// 3. 논리 NOT : ! 조건이 true 면 false, 조건이 false 면 true
			
			int a = 10;
			int b = 10;
			
			boolean result1 = (a == 10) && (b == 10);
			boolean result2 = (a == 10) && (b == 20);
			
			System.out.println(result1);
			System.out.println(result2);
			
			boolean result3 = (a == 10)  || (b == 10);
			boolean result4 = (a == 10)  || (b == 20);
			
			System.out.println(result3);
			System.out.println(result4);
			
			boolean result5 = !(a ==10);
			boolean result6 = !(a ==20); // !는 답과 반대의 결과로
			
			System.out.println(result5);
			System.out.println(result6);
			

		}
		
		
		public static void ex03() {
			// Short Circuit Evaluation
			// 1. 논리 AND의 경우 조건의 결과가 FALSE인 경우가 발생하면 더이상 동작하지 않는다. 최종 결과가 FALSE로 정해졌기 때문이다. 앞에서부터 실행하기 때문에
			// 2. 논리  OR의 경우 조건의 결과가 TRUE인 경우가 발생하면 더이상 동작하지 않는다. 최종 결과가 TRUE로 정해졌기 때문이다. 앞에서부터 실행하기 때문에
			
			int a = 10;
			int b = 10;
			
			boolean result1 = (a == 20) && (++b == 11);  //실제로는 뒤에 b가 늘었어야하는데 앞에서 false 라서 실행되지 않아 10에 머물러 있는다.
			
			System.out.println(b);
			System.out.println(result1);
			
			boolean result2 = (a == 10) || (++b == 11); //실제로는 뒤에 b가 늘었어야하는데 앞에서 true 라서 실행되지 않아 10에 머물러 있는다.
			
			System.out.println(b);
			System.out.println(result2);
		}
		
		public static void ex04() { // 연습 문제
			
			int score = 70;
			
			boolean result = (score >= 70) && (score < 80); // 70점대는 트루 아니면 펄스
			
			System.out.println(result); //true
			
			// boolean result = (score / 10) == 7;  위와 같은 식임
			
			
					
		}
		
		
		public static void ex05() {
			
			// 조건 연산 ==> 삼항 연산
			// (조건식) ? true 일 때 : false 일 때
			
			int score = 50;
			
			String result = (score >= 60) ? "합격" : "불합격";    
			
			// 단항 연산자 : ++a, !조건식
			// 이항 연산자 : a + b, a + b + c
			// 삼항 연산자 : (score >= 60) ? "합격" : "불합격"; 
			
			
			System.out.println(result); //불합격
				
		}
		
		
		public static void ex06() { // 연습 문제 : 짝수와 홀수 결과값 출력하기
			
			int n = 3;
			
			String result = (n%2 == 0) ? "짝수" : "홀수"; // n의 값을 홀수 짝수로 바꿔주게 되면 결과 값이 달라지는걸 볼수 있음
			System.out.println(result); //홀수
			
			
		}
		
		public static void ex07() { // 연습 문제 : 짝수, 홀수, 3의 배수 결과값 나오게 하기
			
			int n = 3;
			
			// String result = (n % 3 == 0) ? "3의 배수" : ( n % 2 == 0) ? "짝수" : "홀수"; // n의 값을 바꿔주면 결과값 달라짐
			
			String result = (n !=0 && n % 3 == 0) ? "3의 배수" : ( n % 2 == 0) ? "짝수" : "홀수"; 
			// 위의 식으로 만들어야 n의 값을 0으로 설정했을때 3의 배수가 아닌 '짝수'로 나오는 정상적인 결과값 도출 가능
			// 위에 2가지 식을 주석 풀어보면서 결과 도출해보기
			
			System.out.println(result); // n = 3으로 설정 했을때 : 3의 배수

		}
		
		public static void main(String[] args) {
			ex07();
	}

}
