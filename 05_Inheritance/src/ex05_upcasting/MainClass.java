package ex05_upcasting;

/*
 	업캐스팅
 	1. upcasting //upcasting 자식을 부모타입으로 바꿔서 저장할 수 있다. 앞서 배운 casting은 형변환 (타입을 바꾼다)
 	2. 자식 클래스 객체를 부모 클래스 타입으로 저장할 수 있다
 	3. 강제로 캐스팅하지 않아도 자동으로 처리된다 (캐스팅보다 일종의 프로모션에 가까움 , 자동으로 처리된다)
 */

/*
 	업캐스팅의 장점
 	1. 하나의 클래스로 여러가지 객체를 저장할 수 있다
 	2. 부모 타입으로 모든 자식 객체를 저장할 수 있다
 	
 */

/*
 	업캐스팅의 단점
 	1. 부모 타입으로 저장되기 때문에 부모 클래스의 메소드만 호출할 수 있다
 	2. 자식 클래스의 메소드를 호출할 수 있도록, 부모 클래스에도 자식 클래스에서 호출할 메소드를 추가해 준다
 		override를 써서
 		
 */
public class MainClass {

	public static void main(String[] args) {

		// 부모 타입 객체 선언
		Person person; //이게 스튜던트도 되고 알바도 되고~
		
		// 자식 객체 선언
		
		// 선언은 부모인데 만드는건 자식인 상황, 아무캐스팅도 안했는데 자동으로 바뀐다 // 자식을 저장할 때 대부분 부모타입을 쓴다
		// 반대의 경우는 안됨
		person = new Student();
		//	person = new Alba(); // 자식(스튜던트)의 자식(알바)도 가능함

	
		/*
		   그럼
		   Person person;
		   person = new Student();
		   person = new Alba();
		   이기 때문에
		   
		   person[] (배열)로 묶을 수 있어

		 */
		
		 // 메소드 호출 확인하기 (단점이 여기서 나타남)
		person.eat();
		person.sleep();
		person.study(); /// 스튜던트에 있는 스터디를 못 부르는 상황 ,,, person 클래스에서 '단점 보완' 부분을 만든 이후에야 에러가 사라짐
		// person.work(); 도 됨
		
		
		
		/*
		   Person person;
		   person = new Student();
		   person.study() 동작 방식
		 	
		 	1. Person person 이므로 Person 클래스의 study 메서드를 호출한다 ==> public void study() {}
		 	2. study 메소드를 실행하기 위해서 person 객체를 확인한다
		 	3. person = new Student() 이므로 Student 클래스의 study 메소드를 가져온다
		 	4. 최종적으로 Student 클래스의 study 메소드가 실행된다 ===> 동적 바인딩
		 */
		
	}

}
