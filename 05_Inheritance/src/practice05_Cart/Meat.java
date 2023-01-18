package practice05_Cart;

public class Meat extends Product { //
	
	// 미트를 상속해야함, 프러덕 사용하기 위해
	// 상속 : 자식이 태어날때는 꼭 부모부터
	
	// new Meat(1, "소고기", 5000) 생각하고 만들기
	
	public Meat(int prodNo, String prodName, int prodPrice) {
		//super(); // 생성자 호출 --> 부모가 디폴트값이 없으니까 자식에서 불러줘야함
		super(prodNo, prodName, prodPrice);
		
		
	}
	

}
