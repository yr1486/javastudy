package ex04_throws;

public class MainClass {

	public static void main(String[] args) {

		Gun gun = new Gun();
		
		// 메소드가 많아도 try catch 한번
		try {
			gun.reload(11); // reload 메소드 호출
			for(int n =0; n < 11; n++) {
				gun.shoot();
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
