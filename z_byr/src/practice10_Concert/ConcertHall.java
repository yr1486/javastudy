package practice10_Concert;

import javax.swing.JOptionPane;

public class ConcertHall {
	
	private SeatGroup[] seatGroups;
	private String[] seatTypes = {"S", "R", "A", "B"};
	
	private int[] seatCount = {30, 40, 50, 60};
	
	//new ConcertHall()
	public ConcertHall()	{
		seatGroups = new SeatGroup[seatTypes.length]; // 배열의 선언과 생성
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i] = new SeatGroup(seatTypes[i], seatCount[i]);
		}
	}

	// 예약 확인하기
	public void info() {
		// seatGroups[0].info(); // s석의 정보 보여주세요 ...등등등 이니까 이것도 for문 돌려!!!
		for(int i=0; i < seatGroups.length; i++) {
			seatGroups[i].info();
			System.out.println("---------------------------------------------------------------");
			
			
		}
	}
	
	// 예약하기
	public void reserve() { // 좌석타입만 확인하면 되는걸 상상하기
		String seatType = JOptionPane.showInputDialog("좌석 타입을 입력하세요");
		for(int i = 0; i<seatTypes.length; i++) {
			if(seatType.equals(seatTypes[i])) {
				seatGroups[i].reserve(); // S R A의 나열 자리가 인덱스와 같으니까 FOR문 돌려
				return; // 예약종료
			}
		}
		JOptionPane.showMessageDialog(null, "입력한 " + seatType + "타입은 존재하지 않습니다");
	}
	
	// 예약 취소하기
	public void cancel() {
		String seatType = JOptionPane.showInputDialog("좌석 타입을 입력하세요");
		for(int i = 0; i<seatTypes.length; i++) {
			if(seatType.equals(seatTypes[i])) {
				seatGroups[i].cancel(); // S R A의 나열 자리가 인덱스와 같으니까 FOR문 돌려 // 캔슬안에 널이 들어가면 안댐유
				return; // 예약 취소 종료하기.
			}
		}
		JOptionPane.showMessageDialog(null, "입력한 " + seatType + "타입은 존재하지 않습니다");
	}
	
	
	public static void main(String[] args) {
		ConcertHall hall = new ConcertHall();
		hall.reserve();
		hall.info();
		hall.cancel();
	}
	
	
	
	
	
	
}
