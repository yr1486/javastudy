package ex01_String;

public class Ex03_StringBuilder {

	public static void main(String[] args) {
		
		/*	
		java.lang ==> 패키지란 뜻
		
	 	java.lang.StringBuilder 클래스(JDK1.5) ==> StringBuffer가 처음에 생기고, 느리니까 , 좀 더 빠른 builder가 생긴거임
	 	1. String을 연결하는 클래스이다
	 	2. 싱글스레드 환경에서 사용이 가능하다
	 	3. 동작이 빠르다
	 	
		*/

		// StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		
		// 문자열 연결 ==> 굉장히 많이 쓸 예정 ex) 파일작업
		sb.append("app");
		sb.append("le");
		
		// StringBuilder를 String 으로 변환
		String str = sb.toString();
		System.out.println(str);

	}

}
