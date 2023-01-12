package ex02_has_a;

public class MainClass {

	public static void main(String[] args) {

		Soldier soldier = new Soldier();
		
		soldier.reload(0);
		soldier.shoot();
		
		//soldier 클래스에 아무것도 없음 ===> Gun에서 불러온 결과 들임 ==> 솔저가 자식의 역할이기 때문에
		
		// has a 관계는 상속이 아닌 방법으로 풀자 상속은 is a
	}

}
