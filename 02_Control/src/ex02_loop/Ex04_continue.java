package ex02_loop;

public class Ex04_continue {
	
	/*
	  continue 문 **무언가를 제외하고 실행하는 기능이 포인트**
	  1. 반복문의 실행 시작 지점부터 다시 실행
	  2. 어떤 코드를 '제외'하고 반복문을 실행하고 싶을 때 사용
	  
	 */
	

	public static void main(String[] args) { // 연습문제

		// 1 ~ 50 사이에서 4의 배수를 제외하고 출력하기
//		n%4 !=0
		
		for(int a = 1; a <=50; a++) {
			if(a % 4 == 0) {
				continue; // 아래 출력문을 만나기 전에 for문으로 돌아가시오.
			}
			
			System.out.println(a);
	}
	}
	
}
	
