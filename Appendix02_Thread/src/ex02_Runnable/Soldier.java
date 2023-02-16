package ex02_Runnable;

// Soldier를 스레드 처리하는 이유
// new Soldier()를 이용해서 객체를 생성할 때마다 해당 객체는 독립적으로 동작한다.
// ===> 메인메소드가 위에서 부터 아래로 실행하는게 아님

/*
	Runnable 인터페이스를 구현하는 방법
	1. implements Runnable 처리한다.
	2. Runnable 인터페이스의 public abstract void run(); 추상메소드를 오버라이드 한다.
	3. Runnable 객체를 만들고 Runnable 객체를 이용해서 Thread 객체를 만든다
	4. Thread 객체가 가진 run 메소드는 start 메소드로 호출한다. ==> 규칙
*/


public class Soldier implements Runnable {

		private String name;
		private Gun gun;
		
		public Soldier(String name, Gun gun) { // new Soldier("김상사", new Gun(10))
			this.name = name;
			this.gun = gun;
			
		}
		
		public void shoot() {
			System.out.print("[" + name + "] "); // [김상사] 빵! 9발 남았습니다 와 같이 출력을 만들자
			gun.shoot(); // 열로 예외가 던져짐. 예외처리에 대한 조치가 없으니 총알이 없어도 동작이하게되는 시스템.
		}
		
		//메뉴-소스 또는 ctrl+space
		@Override
		public void run() { // run의 짝꿍 start.
			// 스레드를 사용할때 1초에 1발씩 쏘기
			// 1초동안 일시중지 시키기 : Tread.sleep(1000); 1000 밀리초(1초) 일시중지 ---> 반드시 예외처리가 필요하다 ==> 예외니까 트라이문에 넣기
			
			
			try {
				while(gun.getBullet() !=0) {
					shoot();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
}
