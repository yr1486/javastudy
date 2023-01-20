package parking;

import java.util.Scanner;

public class ParkingLot {
	
	private String name; 
	private Car[] cars; //주차장에 차가 들어오면
	private int idx; // 배열에 인덱스이기도 하고 실제로 들어온 차량의 수 이기도 함, 배열에 2번부터 비어있는 상황임.....
	private Scanner sc;
	
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
		
	}
	
	public void addCar() { 
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(idx == cars.length) {
			System.out.println("더이상 차량 등록이 불가능 합니다");
			return;
		}
		System.out.print("차량번호 >>> ");
		String carNo = sc.next(); 
		
		System.out.print("모델 >>> ");
		String model = sc.next();
		
		Car car = new Car(carNo, model);
		cars[idx++] = car;
		System.out.println("차량번호" + carNo + "차량이 등록 되었습니다");

	}
	
	public void deleteCar() {
		if(idx == 0) { 
			System.out.print("등록된 차량이 없습니다");
			return;
		}
		System.out.print("제거할 차량번호를 입력하세요 >>> ");
		String carNo = sc.next();
		
		for(int i = 0; i < idx; i++) {
			Car car = cars[i]; // 자동차 한대 씩 꺼내는거임 ==> 이부분 못함
			if(carNo.equals(car.getCarNo())) { // 이퀄스로 확인
				// 방법1. 삭제할 요소의 뒤에 있는 것들을 모두 한 칸씩 앞으로 옮기기
				System.arraycopy(cars, +i+1, cars, i, idx -i -1); // 어레이리스트를 쓰면 아주걍 간단하게 만들수있음 아래 방법2처럼 배열 안해도 됨
				cars[--idx] = null;
				System.out.println("차량번호" + carNo + "인 차량이 삭제되었습니다");
				
				/* 방법2
				 	마지막 차량을 옮겨오기
					제거할 차량의 '위치' : i
					마지막 차량의 위치 : idx-1 //idx자리는 새로운 차량이 들어올거라 비어잇어요
					cars[i] = cars[idx-1]; //cars[--idx]; 가능 더 좋은 코드 // 줄이는거 먼저, 널갑 넣기 ==> idx[2]에 있던 애가 idx[0] 덮에 쓴건데!!! idx[2]자리는 없어지기전이니까 idx[2]의 null값을 줘야함
					첫번째차량 = 마지막차량
					cars[--idx] = null; //인덱스값 하나 줄어준 다음에 그자리에 널값을 주는것. ==> 차량이 줄어들었으니까
					return; // break;도 가능
				*/
			}
		}
		// ==> 삭제할 차량이 없을때 이곳으로 올 수 있음. 위에서 똑같은 차량을 못만나서 for문이 종료되거든.
		System.out.println("대상 차량이 존재하지 않습니다"); // else가 오면 안됨 ==> 3번출력하게되는거임, 차량이 100개면 100개 출력됨 //이미 다 비교를 맞췄어 리턴안만났고 for문이 걍 리턴을 못만나서 끝나는 거임

	}

	public void printAllCars() {
		if(idx == 0) {
			System.out.print("등록된 차량이 없습니다");
			return;
		}
		System.out.println(name + "차량 목록"); //0부터~idx 이전까지만 확인하면됨, 끝까지 가려고하면 널값때문에 바이
		for(int i = 0; i < idx; i++) {
			Car car = cars[i];
			System.out.println(car); // toString 해놓으면 syso에 집어 넣을 수 있음, 투스트링 왜하냐? 시스템아웃에 출력하려고요.
		}
		for(int i = 0; i < cars.length; i++) { //앞에서부터 순차적으로 채워지게끔 되어있어. 그래서 널이아니면 보여주겠다가 가능함
			Car car = cars[i];
			if(car != null) { //배열을 끝까지 순회할필요가 없음
				System.out.println(car);
			}
			
		}
		
	}
	
	public void manage() {
		
		while(true) {
			
			System.out.print("1.추가 2.삭제 3.전체 0.종료");
			String choice = sc.next();
			
			switch(choice) {
			case "1": 
				addCar();
				break;
			case "2":
				deleteCar();
				break;
			case "3":
				printAllCars();
				break;
			case "0":
				return;
			default:
				System.out.println("존재하지 않는 메뉴 입니다");
			}
		}

	}

}
