package ex01_branch;

public class Ex01_if {

	public static void ex01() {
	
		// if문
		
		int score = 80;
		
		if(score >= 60)
			System.out.println("합격");
		
		if(score < 60)
			System.out.println("불합격");
		
	
	}
	
	public static void ex02() {
		
		// if 문의 중괄호 사용 방법
		
		// 실행문이 1개인 경우 생략할 수 있다.
		// 실행문이 2개 이상인 경우 반드시 필요하다.
		// 하지만 일반적으로 생략하지 않는다..! 실행문을 구분하기도 편하기 때문에.
		
		int score = 80;
		
		if(score >= 60) {
			System.out.println("합격");
			System.out.println("축하합니다"); // 2가지 문구를 실행할 거기 때문에 해당 실행문에는 탭키를 이용해서 위에 실행문과 맞춰준다.
		}
		
		if(score < 60 ) {
			System.out.println("불합격");	
			System.out.println("보충수업입니다");	
		}
		
		    
	}
	
	
	
	public static void main(String[] args) {
		ex02();
	}

}
