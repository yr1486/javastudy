package practice05_Cart;

public class Customer {
	
	// 돈, 적립
	private int myMoney;
	private int myPoint;
	
	//카트를 끌어야하니까
	private Cart myCart;
	
	// 고객만들기
	// 생성자
	public Customer(int myMoney, int myPoint) { //카트를 외부에서 받아올 필요는없고, 돈,적립만
		this.myMoney = myMoney;
		this.myPoint = myPoint;
		this.myCart = new Cart(10);
		
		
		
	}

	public int getMyMoney() {
		return myMoney;
	}

	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}

	public int getMyPoint() {
		return myPoint;
	}

	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}

	public Cart getMyCart() {
		return myCart;
	}

	public void setMyCart(Cart myCart) {
		this.myCart = myCart;
	}

	
	// 카트에 물건 담기
	public void addToCart(Product product) {
		myCart.addProduct(product); // 이미 만들어진거 가져와
		
	}
	
	// 카트에 물건 빼기
	public void deleteFromCart(int prodNo) {
		myCart.deleteProduct(prodNo);
	}
	
	
	// 구매
	// 구매하면 영수증 String 형태로 반환하는걸로 구현
	
	public String buy()	{
		
		int buyMoney = 0; // 구매한 물건들의 가격 합계
		int buyPoint = 0; // 구매한 물건들의 가격에 의한 포인트
		
		String receipt = "----------영수증----------\n"; // 영수증
	
		// 카트끌고다니면서 하나씩 물건 꺼내는 거 구현
		for(int i = 0; i < myCart.getProdCount(); i++) {
			
			Product product = myCart.getProducts()[i]; // 카트에서 뺀 물건 1개   // myCart.getProducts() 배열..==> products임!!
			buyMoney += product.getProdPrice(); //제품의 가격을 더해줌
			buyPoint += product.getProdPrice() * 0.05; // 제품 가격의 5% 포인트로 지급
			receipt += product.getProdName() + "   " + product.getProdPrice() + "원\n";
			
			// 구매가 불가능한 경우 : 돈이 부족함
			if(myMoney < buyMoney) {
				System.out.println("돈이 부족합니다. 구매를 종료합니다");
				return ""; // 영수증이 안나온다 정도 또는 return null; 가능
			}
		}
		
		myPoint += buyPoint;
		myMoney -= buyMoney;
		receipt += "-------------------------\n";
		receipt += "발생한 포인트" + buyPoint + "점\n";
		receipt += "보유 포인트" + myPoint + "점\n";
		receipt += "구매 총액" + buyMoney + "원\n";
		return receipt;
		
		// 커스터머 끝
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
