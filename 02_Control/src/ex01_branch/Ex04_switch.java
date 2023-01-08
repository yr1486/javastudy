package ex01_branch;

public class Ex04_switch {
	
	/*
	 switch(표현식) {
	 case 값1: 실행문
	 case 값2: 실행문
	 ...
	 default: 실행문 ==> else 개념과 같음
	 
 	표헌식의 결과로 주로 사용하는 타입
	int
	String
	
	표현식의 결과로 사용 불가능한 타입
	boolean
	long
	double
	 
	 */
	
	public static void ex01() {
		
		int month = 1;
		
		switch(month) {
		case 12:
		case 1:
		case 2: System.out.println("겨울"); break;
		case 3:
		case 4:
		case 5: System.out.println("봄"); break;
		case 6:
		case 7:
		case 8: System.out.println("여름"); break;
		default: System.out.println("가을"); // 가을은 마지막 실행문이라서 break를 넣지 않아도 된다. 물론 넣어도 문제는 없다.
		}
		
	}
	
	public static void ex02() {
		
		int day = 13;
		String weekName;
		
		switch(day % 7) { //7로 나눈 나머지 값
		case 0: weekName = "토"; break;
		case 1: weekName = "일"; break;
		case 2: weekName = "월"; break;
		case 3: weekName = "화"; break;
		case 4: weekName = "수"; break;
		case 5: weekName = "목"; break;
		default: weekName = "금";
 		}
		
		System.out.println(day + "일은 " + weekName + "요일이다.");
	}
	
	
	public static void ex03() {
		// 수, 우, 미, 양, 가, 잘못된 점수
	
		int score = 85;
		
		switch( score / 10) {
		case 10:
		case 9: System.out.println("수"); break;
		case 8: System.out.println("우"); break;
		case 7: System.out.println("미"); break;
		case 6: System.out.println("양"); break;
		default: System.out.println("가");
		
		}
		
	}
	
	public static void ex04() {
		// 1분기, 2분기, 3분기, 4분기
		
		int month = 1;
		
		System.out.println((month - 1) / 3 + 1 + "분기");
		
//		switch(month - 1) / 3 {
//		case 0:
//			System.out.println("1분기");
//			break;
//		case 1:
//			System.out.println("2분기");
//			break;
//		case 2:
//			System.out.println("3분기");
//			break;
//		default:
//			System.out.println("4분기");

//		}
		
		switch(month) {
		case 1: case 2: case 3:
			System.out.println("1분기");
			break;
		case 4: case 5: case 6:
			System.out.println("2분기");
			break;
		case 7: case 8: case 9:
			System.out.println("3분기");
			break;
		default:
			System.out.println("4분기");	
			
		}
		

		
	}
	public static void main(String[] args) { // ctrl + 스페이스 하면 나옴
		ex04();
	

	}

}
