package ex03_method;

public class MainClass { //
	
	// 2023-01-10 5교시
	
		public static void ex01() {
			
		// Calculator 객체 선언 + 생성
		Calculator calc = new Calculator();
		
		double add = calc.addition(1.5, 2.5); // addition 메소드 호출
		System.out.println(add);
		
		double sub = calc.addition(2.5, 1.3); // sub 메소드 호출
		System.out.println(sub);
		
	}
		
		public static void ex02() {
			
			CoffeeMachine coffeeMachine = new CoffeeMachine();
			
			CoffeeAndChange coffeeAndChange = coffeeMachine.buyCoffee(1000, 1); //(500,1)
			System.out.println(coffeeAndChange.coffee);
			System.out.println(coffeeAndChange.change);
			
			System.out.println(coffeeMachine.moneyPot);
			
		}
		
		public static void ex03() {
			Car car = new Car();
			
			car.addoil(50);
			
			for(int n = 0; n < 51; n++) {
				car.pushAccel();
			}
			System.out.println(car.oilPot);
			System.out.println(car.carSpeed);
			
			for(int n =0; n < 11; n++) {
				car.pushBrake();
			}
			System.out.println(car.oilPot);
			System.out.println(car.carSpeed);
				
			}
		
	public static void main(String[] args) {
		ex03();
		
	}
	
}