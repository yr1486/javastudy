package ex10_static;

public class MainClass {

	public static void main(String[] args) {
		//위에 static이 붙은 이유 : 

		// static 요소는 객체를 이용해서 호출할 수있으나, 권장하지 않는다
		
		MyMath myMath = new MyMath();
		System.out.println(myMath.PI);
		
		MyMath yourMath = new MyMath();
		System.out.println(yourMath.PI);
		
		
		// static 요소는 클래스를 이용해서 호출하는 것이 권장이다
		// static 붙어있는 애들은 클래스 영역에 '하나만' 만들어서, 다 가져다가 쓸 수 있게 해준다
		
		System.out.println(MyMath.PI);
		
		System.out.println(MyMath.getCircleArea(1.5));
		
		System.out.println(MyMath.max(1.1, 2.2, 3.3));
		System.out.println(MyMath.max(1.1, 2.2, 3.3, 4.4));
		System.out.println(MyMath.max(1.1, 2.2, 3.3, 4.4, 5.5));
		
		System.out.println(MyMath.min(1.1, 2.2, 3.3));
		System.out.println(MyMath.min(2.2, 3.3, 4.4));
		System.out.println(MyMath.min(3.3, 4.4, 5.5));
	}

}
