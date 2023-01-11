package ex05_ellipsis;

public class MainClass {

	public static void main(String[] args) {

		
		// 객체 생성
		Calculator calc = new Calculator();
		
		// 매개변수의 갯수가 정해지지 않았을 경우
		// 오버로딩을 아래와 같이 4개 만들어서 사용해도 되지만..
		// ... numbers 를 활용하여 편리하게 사용한다
		System.out.println(calc.addition(1.1, 2.2));
		System.out.println(calc.addition(1.1, 2.2, 3.3));
		System.out.println(calc.addition(1.1, 2.2, 3.3, 4.4));
		System.out.println(calc.addition(1.1, 2.2, 3.3, 4.4, 5.5));
	}

}
