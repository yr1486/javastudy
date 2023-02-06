package ex02_Runnable;

public class Gun {

	private int bullet;
	
	public Gun(int bullet) {
		this.bullet = bullet;
	}
	
	public void shoot() {
		if(bullet == 0) {
			throw new RuntimeException("총알이 없습니다"); // 모든 언체크드익셉션은 런타임익셉션의 자식임. 예외처리하는 코드가 없어도 동작하는 애임.
		}
		bullet--;
		System.out.println("빵!" + bullet + "발 남았습니다");
		
	}

	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	
}
