package ex01_variable;

public class MainClass {
	// single comment - 주석 : 설명을 달아주는 부분
	/* 시작
	 * multiple comment
	 * 여러 줄 주석 , 시작과 끝을 제외하고는 * 없어도 무관
	 끝 */ 
	
	/*
	 키워드 이름 규칙
	 1. 프로젝트 : 마음대로 (소문자 대문자 다 가능)
	 2. 패키지 : 모두 소문자로만 작성. 실무에서는 회사 도메인과 앱 이름으로 작성(ex ))) com.samsung.galaxy)
	 3. 클래스 : 첫 글자만 대문자로 작성하고 나머지는 소문자. Upper Camel Case 방식.(Hellowold) 
	 			public static void main(String[] args) { ===> 이부분에서 클래스는 String!!
	 4. 메소드 : 첫 글자만 대문자로 작성하고 나머지는 소문자. LowerCamel case 방식.(helloWold)
	 5. 변수 : 첫 글자만 대문자로 작성하고 나머지는 소문자. LowerCamel case 방식.(helloWold)
	 6. 상수 : 모두 대문자로 작성. 변하지 않는 값. ex) 파이, 단어 사이에 하이푼을 사용하여 만들기. Snake Case 방식 (HELLO_WORLD)
	  
	 */
	
	/*
	 	main 메소드
	 	1. Java가 실행될때 메인 메소드가 실행된다.
	 	2. 열린 main 메소드가 없으면 최근에 실행에 성공한  main 메소드를 실행한다.
	 */
	
	public static void main(String[] args) {
		// 코드는 들여쓰기가 잘 되어 있어야 한다. (탭 키 사용)
		// 변수 선언하기(어떤 데이터를 저장할 것인가? 어떤 이름을 사용할 것인가?)
		
		// 타입의 구분
		// 1. primitive type : 기본 타입(소문자로 되어 있음), 값을 저장하는 타입
		// 2. reference type : 참조 타입(첫 글자가 대문자로 되어 있음, 모든 클래스는 참조 타입), 값이 저장된 참조값을 저장하는 타입
		
		
		
		
		// 논리 타입 (참과 거짓)
		boolean isGood = true;
		boolean isAlive = false;
		
		//빠른 입력 1. sysout c+스페이스바
		
		System.out.println(isGood);
		
		//빠른 입력 2. syso ctrl+스페이스바+엔터키
		
		System.out.println(isAlive);
		
		// 문자 타입 (Character) :1글자, 작은 따옴표 안에 글자를 담아두기
		char ch1 = 'A';
		char ch2 = '홍';
		char ch3 = '\n'; // 라인 피드 - 줄바꿈 사용할 때
		char ch4 = '\t'; // 탭
		char ch5 = '\''; // 작은 따옴표 (역슬래시와 함께 기재)
		char ch6 = '\"'; // 큰 따옴표
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		
		
		// ctrl + alt + 방향키 아래 ===> 하면 복사댐
		// ctrl + D ====> 한줄 삭제
		
		
		// 정수 타입 integer = int
		int age = 32;
		long money = 10000000000L;
		// 조금 긴 숫자를 입력할 경우 long 사용 후 끝에 L을 붙임
		System.out.println(age);
		System.out.println(money);
		
		// 정수 구분의 기준 (아래 값의 이상이면 long 사용, 이하면 int 사용)
		System.out.println(Integer.MAX_VALUE);
		
		// 실수 타입 (float의 두배 크기가 double)
		double leftEye = 0.7;
		double rightEye = 1.2;
		System.out.println(leftEye);
		System.out.println(rightEye);
		
		// 문자열 타입 (여러 글자를 의미, 글자 수의 제한이 없음, 한글자여도 되고 글자가 없어도 됨.)
		String name = "방예림"; //java에서 기본타입과 같은 사용법을 제공
		System.out.println(name);
		
		String country = new String("Korea"); // 대부분의 참조 타입 사용법
		System.out.println(country);
		
		
		// 상수 선언하기 (final 키워드가 필요)
		final double PI = 3.141592;
		System.out.println(PI);
		
		
		
		
		

		

	}

}
