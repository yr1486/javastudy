package practice10_Concert;

import javax.swing.JOptionPane;

public class SeatGroup {

	// 각 좌석의 갯수가 타입마다 다르다 S 20 R 30 A 40
	
	private String seatType; // S R S
	
	private Seat[] seats; // 배열의 선언
	
	// new SeatGroup("S", 10) : S석이 10개 있다 형태로 만들거야
	public SeatGroup(String seatType, int length) {
		this.seatType = seatType; // 우선 시트타임에 저장시키고 // 좌석타입설정
		seats = new Seat[length]; // 배열의 생성 
		// 인덱스로 값을 구해야하니까 인덱스는 0부터 시작하니까 "인덱스+1"
		// 생성자의 타입을 작성해서 원하는 값을 받으려고 게터세터가 아닌 직접 생성자를 만드는 과정
		// 아직 배열의 공간을 만들고 그 안에 저장시킨 값이 없는 상황
		
		for(int i = 0; i < length; i++) {
			seats[i] = new Seat(); // 점유되지 않은! 빈좌석을 배열의 길이만큼 만들기 ==> 만들었지만 모두 비어 있는 좌석인 상태 // 포문돌릴려면 먼저 생성해줘야하니까 객체생성
			// 기본 생성자 부른거임
			// 뉴시트는 여기 안와도되 내가 코드짜기 나름이여서 이런 형식의 코드도 있구나 하고 보면 됨, 예를 들어 예약할때 하나씩넣어주는방법으로 접근하거나.
			
			// ==> 시트그룹이 만들어진다
		}
		
	}

	// 예매 상황
	public void info() {
		System.out.println("[" + seatType + "] 타입");
		for(int i = 0; i < seats.length; i++) {
			System.out.print((i < 9 ? "0" : "") + (i+1)); //비어있는 자리다 / 이름과 같이 공백 6개 쥼.
			if(seats[i].isOccupied() == false) {
				System.out.print("      ");
			}else {
				// 비어있는자리가 아니면 예약자 이름 보여줘 겟네임
				System.out.print(seats[i].getName());
				
			}
				// 인덱스가 9일때 19일때 29일때 줄바꿈으로 보여지는 값을 표현해보자.
				// 인덱스 일의 자리가 9이면 줄을 바꾸고 아니면 공백을 주자.
				if(i % 10 == 9) { // 인덱스 1의 자리가 구다
					System.out.println(); //줄바꿈
				} else { 
					System.out.print(" ");
					
				}
		}
	}
	
	// 예약하기
	public boolean reserve() {
		info(); // 현재의 좌석상황이 어떻다고 보여준다음 == 예매상황
		String strNo = JOptionPane.showInputDialog("예약할 시트번호를 입력하세요"); // 스캐너의 다른 버전
		int seatNo = Integer.parseInt(strNo);
		if(seatNo < 0 || seatNo > seats.length) {
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다.");
			return false; // 예약하기 실패
		}
		if(seats[seatNo - 1].isOccupied()) { // 점유된 자리라면
			System.out.println(seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false;	// 예약하기 실패
			
			// 실패 경우를 앞에 두고 성공을 나중에 설계하기
			
		}
		String name = JOptionPane.showInputDialog("예약자 성함을 입력하세요.");
		seats[seatNo - 1].reserve(name); // 디폴트 생성자 드디어 완성스
		System.out.println(seatNo + "번 좌석 예약이 성공했습니다");
		return true; 
	}
	
	// 예약 취소하기
	public boolean cancel() {
		info(); //현재 예매내역
		String name = JOptionPane.showInputDialog("취소자 성함을 입력하세요.");
		for(int i = 0; i < seats.length; i++) { // 어딨는지 모르니까 풀 포문 돌리는거지
			if(seats[i].isOccupied()) {
				if(seats[i].isMatched(name)) { // 같은 이름은 없다는 가정으로 풉니다
					seats[i].cancel();
					JOptionPane.showMessageDialog(null, "예약자 " + name + "의 예약이 취소되었습니다.");
					return true;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "입력된 이름 " + name + "은 존재하지 않습니다.");
		return false;
	}




	
	public static void main(String[] args) {
	SeatGroup seatGroup = new SeatGroup("S", 30);
	seatGroup.info();

}

}
























