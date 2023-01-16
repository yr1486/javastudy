package ex06_downcasting;

public class Person {

	public void eat() {
		System.out.println("먹는다");
			
		}
	public void sleep()	{
		System.out.println("잔다");
	}
	 
	// 해결책은 => override
	// override : 부모가 가지고 있는걸 자식이 또만든것(다시만드는것) 
	// (동일한 메소드를 또 만드는것)
	public void study() {
		
	}
}
