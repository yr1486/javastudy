package ex02_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
	
	public static void ex01() {  
		
		// 배열 리스트(ArrayList)	 선언 및 생성
		List<String> list = new ArrayList<String>(); //꺽쇠의 역할이? 꺽쇠가 나오면 제너레이트임
		// 맨앞 리스트는 컨트롤 스페이스 해서 인터페이스껄로 고르기 기호가 I면 인터페이스 C면 클래스 임!, 이렇게 하면 맨위 임폴트 util list생김
		// new 뒤에 arrayList도 컨트롤 스페이스해서 선택하면 맨위 임폴트 생김, 이게 배열생긴건데 여기선 리스트라고 부르는거임
		// 인터페이스 객체생성 못함
		
		// 배열 추가
		list.add("summer");	// 인덱스 지정이 없으면 항상 마지막에 추가됨
		list.add("autumn");
		list.add("frog"); // 삭제 해보자
		list.add("winter");
		
		list.add(0, "spring"); // 인덱스 0에 spring 추가됨
		
		// 배열 수정
		list.set(2, "fall"); // 인덱스 2의 요소를 fall로 수정함 // 현재 0번의 spring 추가해서 2번이 autumn이 되는거임
		
		
		// 배열 삭제 - 2가지 방법
		// list.remove("frog"); // 삭제할 대상을 전달하는 방법
		list.remove(3); // 삭제할 대상의 인덱스를 전달하는 방법
		
		
		
		// 추가 및 삭제 확인하기
		System.out.println(list); // 0, spring 확인
		
		
		
	}
	
	public static void ex02() { // 연습문제
		
		// ArrayList 초기화
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		// 리스트 길이 구하기 ( = 배열의 길이 구하기)
		System.out.println("리스트 길이 :" + list.size()); // 5
		
		// 개별 요소 확인하는 방법
		System.out.println("첫번째 요소 : " + list.get(0)); // 1
		System.out.println("두번째 요소 : " + list.get(1)); // 2
		System.out.println("마지막 요소 : " + list.get(list.size() - 1)); // 5
		// System.out.println(list.size(1)); ==> 왜 안되지?
		
		
		// 리스트 순회 해보기
		// 모든 요소의 합계 구하기
		
		int total = 0;
	//	for(int i = 0; i < list.size(); i++) { //length 대신 size 로 쓰이는 거, 이문장이 보통 우리가 쓰던 문장인데
		for(int i = 0, length = list.size(); i < length; i++) { // 위 문장을 개선한 for문 이라고 보면됨, 가운데 초기값은 최초 한번만 실행이 되는,
			total += list.get(i);
		}
		System.out.println("모든 요소의 합 : " + total); // 5
		
		
	}
	
	
	public static void ex03() {
		
		List<User> userList = new ArrayList<User>(); // 배열인데 길이가 없는 모습 ==> 이러면 돌아가지 않음 처음에 얼마라고 길이의 값을 줘야함
		
		for(int i = 0; i < 3; i++) { // 개선한 for문도 익혀보기
			
			User user = new User("user", "123456");
			userList.add(user); // ==> 유저리스트 배열에. 유저를 추가했다 ? 무슨말인지 모르겠음.
			System.out.println(userList.get(i)); //유저리스트에 저장된 요소를 하나씩get 가져오기
			
		} 
		
		// 아이디만 출력하기
		for(int i = 0, length = userList.size(); i < length; i++) {
			System.out.println(userList.get(i).getId());
			
		}
	}

	// 객체를 만들어서 array 리스트 만들고 순회하는 방법까지 익히고 가기
	
	public static void main(String[] args) {
		ex03();
	}

}



