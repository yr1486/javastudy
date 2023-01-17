package ex02_random;

public class Ex01_Math_random {

	public static void ex01() {
		
		// java.lang.Math 클래스
		
		double randNumber = Math.random(); // 0.0 <= 난수 < 1.0
		// System.out.println(randNumber);
		// 가위바위보 등 게임.
		// 비밀번호 인증코드, OTP 등
		// 0.0 <= 난수 < 1.0
		// 0%  <= 난수 < 100%
		
		if(randNumber < 0.1) { // 10% 확률
			System.out.println("대박");
		} else {
			System.out.println("꽝");
		}
		
	}
	
	public static void ex02() {
		
		/*
		 	난수 생성하기
		 	Math.random()					0.0 <= n < 1.0
		 	Math.random() * 3				0.0 <= n < 3.0
		 	(int)(Math.random() * 3)		  0 <= n < 3
		 	(int)(Math.random() * 3) + 1	  0 <= n < 4
		 	--------------------------------------------------
		 	(int)(Math.ramdom() * 개수) + 시작값 // 시작값 0인지 1인지 그런거
		 	(int)(Math.random() * 개수 + 시작값) //괄호 위아래 다 가능
		 	
		 */
	
		// 숫자 0~9 x 6 // string으로 출력
		
		// 주사위 돌리기 ==> 내가 해본 코드
		int n = (int)(Math.random() * 6) + 1;
		System.out.println(n);
		
		
		// 인증코드 6자리 만들기
		StringBuilder sb = new StringBuilder();
		for(int count = 0; count < 6; count++) {
			sb.append( (int)(Math.random() * 10) );
			//0~9를 만들어
		}
		String code = sb.toString();
		System.out.println(code);
		
		
	}
	
	public static void main(String[] args) {
		ex02();
		
	}

}
