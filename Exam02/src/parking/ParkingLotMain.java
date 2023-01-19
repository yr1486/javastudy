package parking;

public class ParkingLotMain {

	public static void main(String[] args) {
		
		// 주차장 만들기 ==> 만들어야 주차장 manage 메소드를 부를 수 있음!!!!!

		ParkingLot parkingLot = new ParkingLot("대박주차장");
		parkingLot.manage(); // 숫자로 입력받았을때,int 위험함잇음..........
	}

}
