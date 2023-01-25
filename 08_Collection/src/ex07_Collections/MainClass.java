package ex07_Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static void printList(List<Integer> list) { // 연습문제
		
		// 출력하는 메소드 만들기
		
		for(int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i) + "→"); // 리스트의 값을 가져오는 겟을 씀 // 마지막 요소는 화살표 출력하면 안되니까 위에 for문 구문을 손바쥼
			
		}
		System.out.println(list.get(list.size() - 1)); //마지막 인덱스는 무조건 사이즈 -1 임!!
		
		// int lastIndex = list.size() - 1; 변수를 사용하면 조금 더 짧게 구문을 짤 수 있음
		
	}
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(5, 2, 3, 1, 4);
		// 배열대신 어레이리스트 사용하기
		
		printList(list); // 5 → 2 → 3 → 1 → 4 //프린트리스트라는 메소드를 만들어라, 마지막 요소 출력하고 화살표 안나오게끔
		
		
		
		// 위의 값을 오름차순으로 정렬해보자
		Collections.sort(list); // 오름 차순 정렬
		printList(list);
		
		int idx = Collections.binarySearch(list, 4); // //이진검색, 바이너리 써치 첫번째는 리스트, 다음은 찾고자 하는 값 넣기
		System.out.println(idx); // 3 (4가 가지고 있는 인덱스 3을 출력)
		// 바이너리 서치는 예를 들어 1000개의 데이터가 있으면 1000개를 모두 찾지 않고 500 반으로 갈라서 찾는 또 다음 반으로 갈라서 찾고 ==> 찾을때마다 확률이 반으로 줄어들어서 빨리 찾는다는 얘기
		// 단 바이너리써치를 사용하려렴 "반드시" 정렬이 되어 있어야함!!!! 
		
		if(idx > 0) {
			System.out.println("찾았다");
		}else {
			System.out.println("못 찾았다");
		}
		
	}

}
