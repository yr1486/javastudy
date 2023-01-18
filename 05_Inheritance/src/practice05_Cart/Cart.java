package practice05_Cart;

public class Cart {
	
	private Product[] products; // 배열 선언만 함, 생성 안함
	private int prodCount; //카트에 담은 갯수를 알아야 함 , **실제로 products 배열에 저장된 Product의 개수, 카트처음에 0개 담겨있으니까 0으로 가자 따로 적지 않아도됨 필드는 초기값 0

	// 카트끝
	
	// new Cart(10), new Cart(20), ... // 물건 10,20 담을 수 있는 카트를 만든다고 가정
	
	public Cart(int cartSize) { // products; 배열의 사이즈임
		products = new Product[cartSize]; // 배열 생성
		prodCount = 0;
		
	}

	//게터세터 (물건을 뺴겟다 담겠다)
	
	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
	
	//카트에 물건 담기 형식
	// addProduct 호출할떄 (new Meat(1, "소고기", 5000))
	// addProduct(new Pizza(2, "피자", 3000))
	// addProduct(new Noodle(3, "누들면", 1500))
	
	public void addProduct(Product product) { //물건을 받아와서, 배열에 담기
		
		// 카트가 가득 차면 물건을 담지 못한다
		if(products.length == prodCount) { //10개담을수있는 카트라고 가정했을때를 생각해서 10개 == 10개 되면 다 찬거
			System.out.println("카트가 가득 찼습니다");
		}
		// 카트에 물건 담기
		products[prodCount++] = product; //담긴제품이없으면 0이야 //사용하고 늘리기라서 ++
		//addProduct은 끝

		//카트에서 물건 뺴기
			
		}
		public void deleteProduct(int prodNo) { // 물건을 받았다 치고

			// 카트가 비어 있으면 뺄 물건이 없다.
			if(prodCount == 0) {
				System.out.println("카트가 비어있습니다");
				return;
			}
			
			//카트에서 물건 뺴기
			// 배열의 길이는 10이더라도 물건이 10개 없을 수 있어
			
			for(int i = 0; i < prodCount; i++) {
				if(products[i].getProdNo() == prodNo) {	//물건 하나씩 꺼낼때, 하나씩복사하거나, 마지막걸 옮겨버리는 방법을 쓰거나(여긴빈자리) 마지막은 -1하면됨
					products[i] = products[--prodCount - 1]; // 마지막 물건을 뺀 '물건 자리'로 옮기기
					//prodCount--; ==> 위 문장에 합쳐버림
					break;

					//후에 이제 카트 끌 사람만들어야 함 

				}
			}
		}




}



