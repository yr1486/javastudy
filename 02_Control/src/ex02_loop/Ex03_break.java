package ex02_loop;

public class Ex03_break {
	
	/*
	 	break문
	 	1. switch문을 종료 시킬 수 있다
	 	2. 반복문(for, while) 문을 종료 시킬 수 있다
	 	
	 */
	
	public static void ex01() {
		
		/* 무한루프
		   1. 끝나지 않는 반복문
		   2. 형식
		   	for(;;)
		   	while(true)
		 */
		
//	무한루프 예시) 보통 while 씀
//		while(true) {
//			System.out.println("hello world");
//		}
		
		// 1~10 까지 출력
		int a = 1;
		while(true) {
			if(a>10) {
				break;
			}
			System.out.println(a);
			a++;
		}
		
	}

	public static void ex02() { // 연습문제
		// 모금
		
		int goal = 100000; //목표액
		int money = 60; //모금액
		int n = 0; //횟수
		int total = 0; //누적
		
		while(true) {
			// 1회 모금액 60원 현재 60원
			// 2회 모금액 60원 현재 120원
			// ?회 모금액 60원 현재 100000원
			if(total >= goal) {
				break;
			}
			
			total += money;
				System.out.println(++n + "회 모금액 " + money + "원 현재 모금액 " + total + "원");
		}
		
		
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
