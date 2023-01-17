package ex01_String;

public class Ex02_StringBuffer {

	public static void main(String[] args) {

		/*	
		 	java.lang ==> 패키지란 뜻
		 	java.lang.StringBuffer 클래스(JDK1.0) ==> 이거 대신 + 로 사용했었음, +는 메모리를 많이 차지함 그래서 buffer를 사용
		 	1. String을 연결하는 클래스이다
		 	2. synchronized가 적용되어 멀티스레드 환경에서 사용이 가능하다 ==> 자바가 여러개 실행되는 형태
		 	3. 동작이 느리다 (상대적으로, 다른 스레드에서 사용하고 있나? 확인하는)
		 	
		 	
		 */
	
		// StringBuffer 객체 생성
		StringBuffer stringBuffer = new StringBuffer();
		// 현재 아무 문자열도 저장되지 않은 상태
		
		// 문자열을 추가하는 메소드
		// 문자열 추가(String의 + 연산자를 대신하는 메소드)
		stringBuffer.append("ba");
		stringBuffer.append("na");
		stringBuffer.append("na");
		
		// StringBuffer에 저장된 문자열을 String으로 변환
		String str = stringBuffer.toString();
		System.out.println(str);
		
	
	}

}
