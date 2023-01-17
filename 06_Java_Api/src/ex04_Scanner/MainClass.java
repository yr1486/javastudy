package ex04_Scanner;

import java.util.Scanner;

public class MainClass {
	
	public static void ex01() {
		
		
	}

	public static void main(String[] args) {

		/*
			java.util.Scanner
		 	1. 어떤 정보를 읽어 들일 때 사용한다
		 	2. 사용자로부터 입력된 정보를 처리하는 용도로 주로 사용한다
		 	3. 데이터 타입에 따라 입력 메소드가 구분되어 있다
		 	 1) int		: nextInt()
		 	 2) long	: nextLong()
		 	 3)	double	: nextDouble()
		 	 4) String 	:
		 	 	(1) next()		: 공백 포함 불가능
		 	 	(2) nextLine()	: 공백 포함 가능
		 	
		 */
		
		/*
		 	기본 입출력 장치 (콘솔) 자바의 기본 입출력 장치
		 	1. 기본 출력 장치(모니터와 연결되어있음) 	: System.out
		 	2. 기본 입력 장치(키보드)				: System.in
		 */
		
		// // 1. Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		
		
		// String 입력
		System.out.print("이름이 뭐예요? >>>");
		String name = sc.next(); //공백이 없으니까
		System.out.println("입력된 이름은 " + name + "입니다"); // 만약 이름 입력을 톰 크루즈 라고 입력하면 톰 만 나옴!! nextLine쓰면 톰 크루즈 다나옴
		
		
		// int 입력
		System.out.println("몇 살이예요? >>>");
		int age = sc.nextInt();
		System.out.println("입력된 나이는 " + age + "살입니다");
		
		// double 입력
		
		System.out.println(" 키는 얼마인가요? >>>");
		double height = sc.nextDouble();
		System.out.println("입력된 키는 " + height + "cm입니다");
		
		
		// char 입력
		
		System.out.println("성별은 무엇인가요? (남/여) >>>"); // 이건 예외적으로 sc. 치면 안나와.. ==> String 쓰임에 가서 참고해서 풀어보기
		char gender = sc.next().charAt(0);
		System.out.println("입력된 성별은 " + gender + "입니다");
		
		// // 2. Scanner 객체 종료 (생략 가능 ==> 경고 메세지는 뜸)
		sc.close();
		
		
		
	}

}
