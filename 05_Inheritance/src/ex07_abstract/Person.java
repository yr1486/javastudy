package ex07_abstract;

public abstract class Person { // abstract 클래스와 abstract 메소드
	// 1. abstract 메소드를 사용하기 때문에 2. 클래스에 abstract가 붙는거임 순서 알아두기

	public void eat() {
		System.out.println("먹는다");
			
		}
	public void sleep()	{
		System.out.println("잔다");
	}
	 

	// public void study() {  ==> 일종의 링크, person과 student를 연결만 해준다, 얘를 Person에서 호출하지만 여기서 실되는게 스튜던트에서 실행됨
	// }                        
	
	// 본문 : {}
	// 본문이 필요없으면 지우면 됨
	// public void study() {} ==> public void study(); ==> 본문이 없는 이 형태를 '추상 메소드'라고 부름
	
	
	/*
	 	추상 메소드
	 	1. abstract method
	 	2. 본문이 없는 메소드이다
	 	3. 중괄호를 없애고, 세미콜론을 붙이고, abstract 키워드를 '메소드' 앞에 추가한다 
	 		public 'void study()' {} ==> ''부분이 메소드 구성 요소 '반환타입 변수 매개변수'
	 	public void study() {} ==> 이 형태를
	 	public abstract void study(); 로 만들면 추상 메소드
	 	//
	 	 	
	 */

	public abstract void study();
	
	//-----------------------------
	
	/*
	 	추상 클래스
	 	1. abstract class
	 	2. '추상 메소드'를 1개 이상 가진 클래스이다
	 		현재 person이 추상 클래스가 되는거임
	 	3. abstract 키워드를 클래스 앞에 추가한다 ==> public abstract class Person
	 	4. 추상 클래스를 상속 받는 클래스는 (=student) '반드시' '모든' '추상메소드'를 오버라이드 해야한다
	 		(꼭 본문을 만들어)
	 	5. 추상 클래스는 객체 생성이 불가능하다 (new Person 불가능)
	 		(추상 메소드를(=본문이 없는 메소드를) 가지고 있기 때문에
	 		(본문이 없으면 메모리에 실을 수 없으니까 = 저장이 안된다 )
	 		
	 		추상 클래스 : 특징을 정의할 수 없는 클래스 (대부분 상속관계로 만들어지는)
	 		ex) 사람 : 취준생? 직장인? 학생? 백수?
	 		ex) 꽃 : 향 => 향을 정의 할 수없으니까 장미를만들때 오버라이드 백합을 만들때 오버라이드
			
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
