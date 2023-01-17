package ex02_has_a;


/*
 	has a 관계
 	1. 상속 관계로 만들 수 있는 관계이다
 	2. Soldier has a Gun //가지고 있다
 	3. 자식 has a 부모
 		(군인이 자식 총이 부모)
 */
public class Gun {

	// 필드 (변수)
	
	private String model;
	private int bullet;
	private final int MAX_BULLET = 20;
	
	
	// 메소드
	// 우클릭 후 소스 불러오기
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getBullet() {
		return bullet;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	// 총알 넣기 
	//반환값 없으니 void //총알 넣기에 한도가 있음 주의
	public void reload(int bullet) {
		if(this.bullet == MAX_BULLET) {
			return;
		}
		this.bullet += bullet;
		this.bullet = (this.bullet > MAX_BULLET) ? MAX_BULLET : this.bullet; // (조건식) ? 참 : 거짓; ==> if 대신 삼항 연산자로 써보기
		
	}
	
	// 총 쏘기 
	//반환값 없으니 void //총알 쏘기에 한도가 있음 주의
	public void shoot() {
		if(bullet == 0) {
			System.out.println("헛빵");
			return;
		}
		bullet--; //this 는 매개변수와 필드 이름이 같아서 구분이 필요할때 쓰이니, 여기서는 안쓰임
		System.out.println("빵");
	}
	
}
