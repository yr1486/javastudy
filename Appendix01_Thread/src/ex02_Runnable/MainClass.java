package ex02_Runnable;

public class MainClass {

	public static void main(String[] args) {

		
		Thread sol1 = new Thread(new Soldier ("김상사", new Gun(10))); // 러너블객체를 먼저 만들고
		Thread sol2 = new Thread (new Soldier("박중사", new Gun(6)));
		
		sol1.start();
		sol2.start();
	}
	// 독립적인 객체가 지가먼저 내가먼저 출력되는걸 볼수 있음.
}
