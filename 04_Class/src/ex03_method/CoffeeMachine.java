package ex03_method;

public class CoffeeMachine {
	
	// 필드
	int moneyPot;
	int[] prices = {900, 1500, 2000};
	String[] menu = {"아메리카노", "카페라떼", "마끼아또"};
	
	//메소드
	CoffeeAndChange buyCoffee(int money, int choice) {
		int price = prices[choice - 1];  //prices[0] ===> 아메리카노
		
		if(money < price) { // 1000<900
			CoffeeAndChange cnc = new CoffeeAndChange();
			cnc.change = money;
			return cnc; // 돈이 모자르면 money 그대로 반환
		}
		
		String coffee = menu[choice - 1]; // 아메리카노
		moneyPot += price; // 제일 나중에 생성되는 조건
		
		CoffeeAndChange cnc = new CoffeeAndChange();
		cnc.coffee = coffee; //아메리카노
		cnc.change = money - price; //1000-900=100
		return cnc; // 값을 반환하고 나면 코드 끝, 리턴 다음에는 코드가 올 수 없다
	}

}
