package ex02_random;

import java.util.Random;

public class Ex02_Random {
	
		
		/*
		 	자바의 클래스 이름을 부르려면 자바의 패키지 이름을 붙이는게 정석
		 	원래는 java.lang.String str = "hello"; 이렇게 해야함
		 	java.lang.Math.random(); 이렇게
		 	
		 */
		
		/*
		 	import
		 	1. 어떤 패키지에 속한 클래스인지 명시하는 코드
		 	2. java.util.Random 클래스의 경우 import java.util.Random; 방식으로 사용된다
		 	3. import java.util.*; 방식으로 java.util 패키지의 모든 클래스를 import 할 수 있다
		 	4. import를 생략할 수 있는 경우
		 		1) java.lang 패키지의 클래스 (자바의 기본 클래스) system, void ...등 모두
		 		2) 동일한 패키지의 클래스
		 	5. import 방식 : 클래스를 입력할 때 "항상" 자동 완성을 이용한다
		 	6. 
		 */
		
	
	
	
		/* java.util 이란 자바 유틸 패키지
		 	
		 	java.util.Random
		 	1. 시드(seed)를 이용해서 난수를 생성한다
		 	2. 기본적으로 현재 시간을 시드(seed)로 사용한다
		 	3. 동일한 시드(seed)를 사용하면 동일한 난수가 발생한다
		 	
		 */
	
	
	public static void ex01() {
	
		Random random = new Random(); 
		// 이거 쓰면 (자동으로 불러와서 써야함) 맨 위 상단에 자동으로 import 생김
		// 자동완성 : Ran 치고 ctrl + space 해서 enter ! 자동완성
		
		// 실수 난수
		double randNumber1 = random.nextDouble(); // 0.0 <= 난수 < 1.0
		System.out.println(randNumber1);
		
		// 정수 난수
		int randNumber2 = random.nextInt(); // int 범위 내의 난수 발생
		System.out.println(randNumber2);
		
		int randNumber3 = random.nextInt(10); // 10개(0~9) 난수 발생
		System.out.println(randNumber3);
	
		
		
		
	}

	public static void main(String[] args) {
		ex01();
		
	}

}
