package ex03_method;

public class Car {
	
	// 필드
	int oilPot; // 1
	int carSpeed; // 2 pushAccel 마다 속도는 10씩 증가, 최대 속도 100, pushBrake 마다 속도 10씩 감소
	
	// 기름 넣기 메소드
	void addoil(int oil) { //반환할게 없음
		oilPot += oil;
		if(oilPot > 50)	{
			oilPot = 50;
		}
	}

	
	void addoil2(int oil) {
		if(oilPot + oil > 50) {
			oilPot = 50;
			return; // 메소드를 종료하시오. // 반환값이 '없으면' 메소드를 종료 하는 의미 ==> 반환 타입이 void인 경우에만 사용 할 수 있다
		}
		oilPot += oil;
	}
	
	// 달리기 메소드
	void pushAccel() { // 기름을 먼저 처리
		if(oilPot == 0) {
			return;  // 기름이 비어 있으면 메소드 종료
		}
		oilPot--;
		
		if(carSpeed + 10 > 100) { // 다음 속도
			carSpeed = 100;
			return;
		}
		carSpeed += 10;
		
	}
	
	// 멈추기 메소드
	void pushBrake() {
		if(carSpeed == 0) {
			return;
		}
		carSpeed -= 10;
		if(carSpeed < 0) {
			carSpeed = 0;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
