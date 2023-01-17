package ex04_po_number;

public class MainClass {
	
	// ex01 메소드 정의 (기능을 하나 만드는 것)
	public static void ex01() {
		
		int a = 5;
		int b = 2;
		
		int add = a + b;
		int sub = a - b;
		int mul = a * b;
		int div = a / b;  // 몫
		int mod = a % b;  // 나머지
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(mod);
		
		

		
	}
	
	// ex02 메소드 정의
	public static void ex02() {
	
		int a = 5;
		int b = 2;
		
		double div = (double)a / b; 
		// 캐스팅을 하나만 바꿔주면 나중꺼는 알아서 바꿔 계산됨 
		// ==> double div = (double)a / (double)b; 위와 답은 같지만 굳이 둘다 안바꿔도 됨
		
		System.out.println(div);  // 2.5
		
		
			
		}
		
	// ex03 메소드 정의
	public static void ex03() {
				
		int second = 90;
				
		int min = second / 60; 
		int sec = second % 60;
				
		System.out.println(min); // 1
		System.out.println(sec); // 30

			}
				
	// ex04 메소드 정의
	public static void ex04() {		
		
		// 1 증가 : ++
		// 2 감소 : --
		
		// 전위 연산 (post operator)
		// ++a 또는 --a
		// 변수 a의 값을 1 증가(감소) 시킨 뒤에 사용하시오.
		
		int a = 10;
		System.out.println(--a); //9
		
		
		//후위 연산(post operator)
		//b++ 또는 b--
		// 변수 b의 값을 사용한 뒤에 1 증가(감소)시키시오.
		
		int b = 10;
		System.out.println(b++); //10
		System.out.println(b); //11

		
	}
	
	// ex05 메소드 정의
	public static void ex05() {
		
		// 대입 연산
		// 등호(=)의 오른쪽 값을 왼쪽으로 보내는 연산

		// a = b 와 b = a 는 완전히 다른식임
		
		int a;
		
		a = 10;
		System.out.println(a);
		
		// int a = 10;
		
	}

	// ex06 메소드 정의
	public static void ex06() {
		
		int x = 10;
		int y = 20;
		
		//x와 y 값 교환 (1. 변수에 백업 후 2. 변수에 대입 3. )
		
		int temp = x;
		x = y;
		y = temp;
		
		System.out.println(x);  //20
		System.out.println(y);  //10
		
	}
	
	// ex07 메소드 정의
	public static void ex07() {
		
		int account = 10000;
		account += 5000;   // 같은식이고 줄여서 씀. account = account + 5000;
		// account ++ // 같은식이고 왼쪽을 쓰도록 하기 account += 1;
		
		account -= 5000; //같은 식 account = account - 50000;
		System.out.println(account); //10000
		
	}
	
	//ex08 메소드 정의
	public static void ex08() {
		
		long account = 123456;
		
		// account 값의 5% 이자 받으면 총 얼마일까?
		
		double result;
		result = account * 1.05;
		// result = account + account * 0.05;
		
		System.out.println(result); //129628.8
		
	}
	
	public static void main(String[] args) {
		ex08();
	}
}
