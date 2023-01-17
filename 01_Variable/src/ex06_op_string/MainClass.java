package ex06_op_string;

public class MainClass {
	
	public static void ex01() {
		
		// 연결 연산
		// 문자열과 + 연산자가 만나면 문자열로 연결됩니다.
		
		String str1 = "구디" + "아카데미";
		String str2 = 4 + "달라";
		String str3 = 100 + 10 + "번지";
		
		System.out.println(str1); // 구디아카데미
		System.out.println(str2); // 4달라
		System.out.println(str3); // 110번지
	}

	public static void ex02() {
		
		//"100" -> 100 parsing
		//100 -> "100"
		
		//모든 타입의 데이터는 빈 문자열 ("") 과 + 시키면 문자열이 된다.
		
		int a = 100;
		String str = a + "";
		
		// a를 문자열로 바꿨음
		
		//원래는 이런게 있습니다.
		// String str = String.value0f(a);
		// 잘 쓰지 않으니 위에 식을 활용하기. a + ""
		
		System.out.println(str); //100
		System.out.println(str.getClass().getName()); // 변수타입 확인
	}

	public static void ex03() {
		
		// 문자열의 비교는 == , != 으로 하지 않는다. 다음 아래와 같기 때문.
		// 문자열에서 사용할 수 있는 연산자는 + 뿐이다.
		
		String str1 = "hello";
		System.out.println(str1 == "hello"); //true
		
		String str2 = new String("hello");
		System.out.println(str2 == "hello"); //false
		
		
		
	}
	

	public static void main(String[] args) {
		ex02();
	}

}
