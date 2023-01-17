package ex02_random;

import java.util.UUID;

public class Ex04_UUID {

	public static void main(String[] args) {

		/*
		 	java.util.UUID
		 	1. 전역 고유 식별자(Universal Unique IDentifier)
		 	2. 32개의 16진수와 4개의 하이픈(-)로 구성된 식별자 값이다
		 	3. 전세계에서 만들어도 똑같은 값이 없는
		 */
	
		UUID uuid = UUID.randomUUID();
		// MathID랑 비슷하다
		String str = uuid.toString();
		// 스트링으로 바꿔줘야해
		
		System.out.println(str);
		
		// 출력된 값에는 4개의 하이픈이 있다, 하이픈을 모두 제거해보자
		// 모든 하이픈을 빈 문자열로 바꾸기
		
		String replacedStr = str.replace("-", "");
		System.out.println(replacedStr);
	
		// String replacedStr = str.replace("-", "..");
		// String replacedStr = str.replace("-", "A");
		
		// 일반적인 난수가 필요할 때는 MathRandom
		// 보안랜덤이 필요하면 SecureRandom
		// 중복되지 않는 랜덤값이 필요할때 UUID
		// 랜덤은 중요하니 알아두자..!
	}

}
