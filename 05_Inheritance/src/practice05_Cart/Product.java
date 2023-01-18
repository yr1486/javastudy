package practice05_Cart;

public class Product {
	
	// 우유 고기 등을 product 안에 담을거야 왜냐 하나씩 선언할수 없고(100개 있다면 100개 선언해야함) 배열로 만들자
	
	private int prodNo; //제품번호
	private String prodName;
	private int prodPrice;
	
	//new Product(1, "새우깡", 2000) 이렇게 만들고 싶다
	// 우클릭 소스코드로 불러오기
	public Product(int prodNo, String prodName, int prodPrice) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		
		
		// 우클릭 G,S 만들어 주기
		// 게터세터는 부모에 만들어 놓는것.
		
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	
	
	
	
	
}
