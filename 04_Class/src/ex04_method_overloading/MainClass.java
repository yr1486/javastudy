package ex04_method_overloading;

public class MainClass {

	public static void main(String[] args) {

		// Calculator 객체 선언
		Calculator calc;
		
		// Calculator 객체 생성
		calc = new Calculator();
		
		
		// addition(double a, double b) 호출
		// 호출의 1단계 
		// = 만들어놓은 calc 변수의, (다른창) Calculator 클래스에서 계산을 불러오는것 ==> calc.addition
		// calc.addition(1.5, 2.5)
		
		// (호출하게 되면 Calculator로 가서 계산을 끝낸 후 
		// return 하여 돌아오게 된다.
		
		double result = calc.addition(1.5, 2.5);
		System.out.println(result);
		
		
		//addition(double[] numbers) 호출
		double[] arr = {1.1, 2.2, 3.3};
		//호출하고 결과 받아오기
		double result2 = calc.addition(arr);
		System.out.println(result2);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
