package re_exam;

import java.util.Arrays; // import : 불러들이다

public class MainClass {
	
	// 문제1. 절대값 구하기
	
	public static void ex01() {
		
		int number = 5;
/*
		int absNumber;
		if(number >= 0) {
			absNumber = number;
			
		} else {
			//absNumber = number * -1;
			 absNumber = -number;
		System.out.println(absNumber);
		}
	*/
		// 한줄로 요약 ==> 삼항 연산자
		int absNumber = (number >= 0) ? number : -number;
		System.out.println(absNumber);
	}
	
	public static void ex02() {
		
		// 0~7 미취학 아동
		// 8~13 초등학생
		// 14~16 중학생
		// 17~19 고등학생
		// 20~100 성인
		// 나머지 : 잘못된 나이
		
		// 숫자들 다룰때는 if를 많이쓴다.
		// 스위치로 바꿔서 식을 세울 생각 하지마... 쓸데없는 고민
		
		String strAge = "30";
		
		int age = Integer.parseInt(strAge);
		
		if(age < 0 || age > 100) {
			System.out.println("잘못된 나이");
		} else if (age <= 7) {
			System.out.println("미취학 아동");
		} else if (age <= 13) {
			System.out.println("초등학생");
		} else if (age <16) {
			System.out.println("중학생");		
		} else if (age <19) {
			System.out.println("고등학생");
		} else {
			System.out.println("성인");
		}
		
		
		
		// switch를 쓰는 경우
		// 웹 페이지에 주소값에 따라 출력되는 페이지가 다를 경우 switch 사용하는 경우가 있음
		
	}

	
	public static void ex03() {
		
		// 삼각형 넓이 구하기
		// /2
		int width = 3;
		int height = 3;
		double area = width * height * 0.5; // ==> 이거 왜 곱하는거지.. 제일 좋은 식
		// double area = width * height / 2.0; ==> 내 식..
		System.out.println("삼각형 넓이 : " + area);
		
		
		
	}
	
	
	public static void ex04() {
		
		// 월 -> 계절과 마지막 일 출력하기
		// 1 겨울 , 31 출력하기
		
		/* 	month % 12 ==> 나머지를 구한 후 다시 / 3 
			month % 12 / 3
			겨울 : 0 
			봄  : 1 
		 	여름 : 2 
			가을 : 3
		*/ 
		
		
		
		int month = 13;
		String[] season = {"겨울", "봄", "여름", "가을"}; //우리가 만든 규칙을 써야하니까 겨울을 맨앞에
		int[] lastDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(month < 0 || month > 12) {
			System.out.println(month + "월은 잘못된 입력입니다");
			return;
		}
		System.out.println(month + "월은 " + season[month % 12 / 3] + "입니다.");
		System.out.println(month + "월은 " + lastDay[month] + "일까지 있습니다");
		//또는
		// int[] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 로 진행 시
		// System.out.println(month + "월은" + lastDay[month-1] + "일까지 있습니다"); //-1 추가
		
		
	}
	
	
	public static void ex05() {
		
		// 10과 가까운 수 찾기
		// 1. a와 b가 10과 얼마의 차이가 나냐를 생각해야함
		// 큰 수에서 작은 수를 빼는 것
		
		int a = 8;
		int b = 11;
		
		int diff1 = (a > 10) ? a - 10 : 10 - a;
		int diff2 = (b > 10) ? b - 10 : 10 - b;
		System.out.println("10과 가까운 수는 " + (diff1 < diff2 ? a : b) + "입니다.");
				
	}
	
	public static void ex06() {
		// money 분리하기
		// 5만원, 1만원 등
		
		int money = 87654;
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 숫자 1 생략가능
		int[] count = new int[unit.length];
		
		
		for(int i=0; i < unit.length; i++) {
			count[i] = money / unit[i];
			money %= unit[i];
			System.out.println(unit[i] + "원권 : " + count[i] + "개");
		}
		
		System.out.println(Arrays.toString(unit)); // 배열을 문자열로 바꿔주는 메소드
		System.out.println(Arrays.toString(count));
		/*
		count[0] = money / unit[0]; // 50000원의 개수
		money = money % unit[0];
		
		count[1] = money / unit[1];
		money = money % unit[1];
		*/
		
		
		
		
		
	}
	
	public static void ex07() {
		
		// 2차원 배열에 구구단 결과 저장하기
		
		int[][] arr = new int[8][9];

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++ ) {
				arr[i][j] = (i+2) * (j+1);
					
		}
			
//		for(int i = 0; i < arr.length; i++);
//		System.out.println(Arrays.toString(arr[i]));
	
				
	}
	}
	
	public static void main(String[] args) {
		ex07();
	}

}
