package ex02_loop;

public class Ex05_nasted_loop {

	
	public static void ex01() {
		// 중첩 for문
		for(int day = 1; day <= 5; day++) {
			for(int hour = 1; hour <= 8; hour++) {
				System.out.println(day + "일차" + hour + "교시 수업");
				
			}
		}
		
		
	}
	
	public static void ex02() { // 연습문제
		
		// 위에 코드 while문으로 바꿔보기
		
		int day = 1;
		while(day <= 5) {
			
			int hour = 1;
			while(hour <= 8) {
			System.out.println(day + "일차" + hour + "교시 수업");
			hour++;
			}
			day++;
		}
		
	}	
	
	public static void ex03() { // 연습문제 하
		
		// 전체 구구단 출력하기
		// 2 x 1 = 2
		// 9 x 9 = 81
		
		int a = 2;
		int n = 1;
		
		for(a = 2; a < 10; a++) {
			for(n = 1; n < 10; n++) {
			System.out.println(a + " x " + n + " = " + (a * n));
		}
		}
		
		
	}
	
	public static void ex04() { // 연습문제 상
		
		//전체 구구단 출력하기
		// 2x1=2 3x1=3 4x1=4 ... 9x1=9
		// 9x1=9                 9x9=82
		
		
		for(int n = 1; n < 10; n++) {
			for(int dan = 2; dan < 10; dan++) {
				System.out.print(dan + "x" + n + "=" + (dan * n) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		ex04();
	}

}
