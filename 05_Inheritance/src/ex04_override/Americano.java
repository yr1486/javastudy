package ex04_override;

/*
 	메소드 오버라이드 // 나중에 무지하게 사용함
 	1. method override
 	2. 부모 클래스의 메소드와 '동일한 메소드 형식'으로 자식 클래스가 새로운 메소드를 만드는 것이다
 	3. 부모 클래스의 메소드를 사용할 수 없기 때문에, 새로운 메소드를 다시 만드는 것이다
 		에스프레소와 아메리카노 비교 : 에스프레소가 부모클래스이고 아메리카노가 자식클래스인데 부모클래스의 쓰다를 가져오면 자식클래스는 아메리카노를 쓰다고 해야하니까 
 		변경해줄 부분이 필요함. 그래서 Override를 써서 아메리카노의 메소드를 새로 만드는 것.
 	4. 자식 클래스가 메소드를 다시 만들 때는 ( = 오버라이드 할때는) 애너테이션(Annotation) 중 @Override 를 추가한다.
 		(나 다시 만든 메소드야 라고 적어주는 것)
 	 // 애너테이션의 목적: 자바한테 알려주려고. 오버라이드 된거다~~
 	
 	
 	TIP. 기술면접 )
 	메소드 오버로딩과 메소드 오버라이드 차이를 설명해 보세요
 	공통점을 뽑자면 같은 역할을 수행하는 메소드는 같은 이름을 쓰라는 것
 	하나의 클래스의 ;;;....이름이 같은데도 사용할수 있는게 오버로딩
 	부모가 가지고 있는걸 자식이 가지겠다 그러면 오버라이드
 	
 */

public class Americano extends Espresso{

	@Override
	public void taste() {
		System.out.println("아메리카노는 맛있다");
	} 

	
}
