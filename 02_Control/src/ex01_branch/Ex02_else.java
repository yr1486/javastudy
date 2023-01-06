package ex01_branch;

public class Ex02_else {

	public static void main(String[] args) {

//		tap 키 잘 활용하기 shift + tap 
		int score = 80;
		
		if(score >= 60) {
			System.out.println("합격");
			System.out.println("축하합니다"); // 2가지 문구를 실행할 거기 때문에 해당 실행문에는 탭키를 이용해서 위에 실행문과 맞춰준다.
		}
		
		else {
			System.out.println("불합격");	
			System.out.println("보충수업입니다");	
		}
		
	}

}
