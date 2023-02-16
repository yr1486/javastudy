package ex01_Thread;

public class MainClass {

	public static void main(String[] args) {

		Calculator myCalc = new Calculator("영희"); // myCalc 스레드 생성
		myCalc.start(); //start 메소드는 run 메소드를 스스로 호출한다 main은 myCalc 스레드의 시작만 처리하고 동작 완료까지 기다리지 않는다

		
		Calculator yourCalc = new Calculator("상철");// 위와 같음
		yourCalc.start(); // start 메소드는 run 메소드를 스스로 호출한다
		
		// myCalc 스레드가 yourCalc 스레드보다 먼저 실행된다는 보장이 전혀 없다. ==> main메소드가 시작하세요 하고 자기할꺼하는거임 그러니출력이 순서대로가 아닌 저모양
		
		// 스레드 실행 순서를 정하는 건 개발자가 아니라  자바 스스로 = JVM 이다 개발자가 할수 있는게 아님. 자바가 할수 있는 가장 빠른걸 먼저 하기 때문에.
		
		System.out.println("main 메소드를 종료합니다.");
	}

}

// 순서대로 동작하지 않는 스레드. ..
// 