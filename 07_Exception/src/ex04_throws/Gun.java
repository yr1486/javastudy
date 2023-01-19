package ex04_throws;

public class Gun {
	private int bullet;
	public static final int MAX_BULLET = 10; // 파이널이니까 값을 못바꾸니까 퍼블릭으로 해버리고 스테틱은 어차피 하나밖에 못만들고
	
	// 총알 넣기
	public void reload(int bullet) throws RuntimeException { //reload 메소드를 호출하는 곳으로 예외를 던지겠다
		if(this.bullet + bullet > MAX_BULLET) { // 예외 부분이니까 try, throw, catch 해줘야함
			throw new RuntimeException("장전 불가능");
		}
		this.bullet += bullet; // 아니면 넣기
	}
	
	// 총 쏘기
	public void shoot() throws RuntimeException { // 메소드에 명시할때는 throws 
		if(bullet == 0) {
			throw new RuntimeException("총알 부족"); //던질때는 throw
		}
		bullet--;
	}

	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	// throws RuntimeException 생략할수 있음 ==>unchecked exception 익셉션이라서!!

}
