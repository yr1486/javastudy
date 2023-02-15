package ex01_connection;

public class MainClass {

	public static void ex01() {
		
		// 클래를 로드하는 방법 (메모리에 로드한다 : 사용하겠다)
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // oracle.jdbc.driver.OriclDriver 도 가능
			System.out.println(" 클래스가 로드되었습니다");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		ex01();
		
	}

}
