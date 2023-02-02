package practice07_Coffee;

// 에스프레소

public class Espresso {

	// 필드
	private CoffeeBean coffeeBean;  // 커피 원두
	private int water;              // 물
	
	// 설명 : 그 다음 커피빈과 워터 필드를 선언 한 다음에
	
	// 생성자
	public Espresso(CoffeeBean coffeeBean, int water) {
		this.coffeeBean = coffeeBean;
		this.water = water;
	
	// 설명 : 앞에서랑 똑같이 커피빈값과 워터값을 받아와서 필드값을 초기화 시켜주는 생성자를 만들어주고
	}

	// 필요한 메소드
	
	// 설명 : 그리고 값을 매긴 필드값을 활용해줄! 게터와 세터 메소드도 불러와줬어.
	
	public CoffeeBean getCoffeeBean() {
		return coffeeBean;
	}

	public void setCoffeeBean(CoffeeBean coffeeBean) {
		this.coffeeBean = coffeeBean;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}
	
	// 설명 : 그다음.. 앞클래스에서 만든 원두 정보를 함께 호출하는 인포 메서드를 설정했어
	public void info() {
		coffeeBean.info();
		System.out.println("물 ml : " + water + "ml");
	}
	
}
