package practice10_Concert;

public class Seat { // 첫번째로 올 클래스
	
	
	private String name; // 예약한 사람의 이름을 달자 // 필드는 null로 초기화 되어 있는 상태
	
	public Seat() {} //좌석이름이 안정해져 있을때 얘는 꼭 setName("홍길동")과 같이 와야함
	
	
	public Seat(String name) { // 좌석이름이 정해져있을떄
		this.name = name;
	}

	// 생성자 2개 만듬
	
	// 값을 받아올떄
	public String getName() { // name 확인용 메소드 ===> 예약자 확인용으로 사용가능
		return name;
	}
	
	// 값을 바꿔줄떄
	public void setName(String name) { // ===> 실제 name 저장용 메소드 (예약 처리용)
		this.name = name;
	}
	
	// 예약하기
	public void reserve(String name) { // 예약 처리할때 보여줄 메소드
		setName(name); //여기에 들어온 셋네임은 다시 위에 셋네임에 저장되는 거임. 단순하게
		//reserve("홍길동") 호출하면 셋네임이 다시 호출되어서 처리된다 ==> 예약 메소드를 그냥 통일하기 위해서, 세터를 살리기 위해서!
	}

	// 예약취소
	public void cancel( ) {
		name = null;
	}
	public boolean isOccupied() { //반환타입이 차지했는지 차지하지 않았는지 2가지 점유되었으면 true 반환
		if(name == null) {
			return false; // 점유되어 있지 않다
		} else {
			return true; // 점유되어 있다
		}
		
		// 쌤 추천하는 코드 투르와 폴스 모두 반환할 수 있는 한줄 코드
//		return name != null;
	}
	
	// 예약자 이름과 예약하려는 사람의 이름을 비교하려고 메소드를 만들거임
	public boolean isMatched(String name) { // 좌석의 네임과 매개변수 스트링 네임이 동일하면 트루를 반환 , 매게변수는 받아와야 확인할수 있으니!!!
		if(this.name.equals(name)) {// 이름이 같으면 리턴
			return true;
		
		}else {
			return false;
		}
		// 추천하는 코드
		// return this.name.equals(name));
	
	}
}
	
	
	
	



















