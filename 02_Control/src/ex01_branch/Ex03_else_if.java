package ex01_branch;

public class Ex03_else_if {
	
	public static void ex01() {
		
		// 80 이상 : 상
		// 60 이상 : 중
		// 나머지 : 하
		
		int score = 80;
		
		if(score >= 80) {
			System.out.println("상");
		}
		else if(score >= 60) {
				System.out.println("중");    // if안에 또 if를 집어 넣을때 else if를 씁니다.
		}
		else {
			System.out.println("하");
		}

		
	}
	
	public static void ex02() {
		
		// 수 90, 우 80, 미 70, 양 60, 가, 잘못된 점수 
		// 힌트 : 잘못된 점수 만들기를 주의해서 봐야함. 잘못된 점수란 0 보다 작거나(<) 100 보다 큰 것 (>).
		
		int score = 10;
		
		if(score < 0 || score > 100) {
			System.out.println("잘못된 점수");
		}
		else if(score >= 90) {
			System.out.println("수");
		}
		else if(score >= 80) {
			System.out.println("우");
		}
		else if(score >= 70) {
			System.out.println("미");
		}
		else if(score >= 60) {
			System.out.println("양");
		}
		else { // 나머지 모든 경우는  else 로 묶기
			System.out.println("가");
		}
		
	}
	
	public static void ex03() { // 연습문제 : 겨울 출력하기
		
		// 봄345 여름678 가을91011 겨울1212 출력하기
		// 겨울 12 1 2 를 생각하기. ==> 나눌 경우 나머지로 활용
		
		
		int month = 0;
		
		int mod = month % 12;
		
		
		if(mod <= 2) {
			System.out.println("겨울");
		}
		else if(mod <= 5) {
			System.out.println("봄");
		}
		else if(mod <= 8) {
			System.out.println("여름");
		}
		else {
			System.out.println("가을");
		}
		
	}

	public static void ex04() {
		
		int day = 6;
		int nDay = 10; // 10일 후

		day += nDay; // ===> 같은식 day = day + nDay;
		
		String weekName;  //월요일
		
		int mod = day % 7;
		
		if(mod == 0) {
			weekName = "토";
		}
		else if(mod == 1) {
			weekName = "일";
		}
		else if(mod == 2) {
			weekName = "월";
		}	
		else if(mod == 3) {
			weekName = "화";
		}	
		else if(mod == 4) {
			weekName = "수";
		}
		else if(mod == 5) {
			weekName = "목";
		}
		else {
			weekName = "금";
		}
		
		System.out.println(nDay + "일 후는 " + weekName + "요일이다.");

	}
	

	public static void main(String[] args) {
		ex04();

		
		
	}

}
