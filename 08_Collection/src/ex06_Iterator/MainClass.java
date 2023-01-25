package ex06_Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainClass {
	
	/*
		 	Iterator 인터페이스
		 	1. 특정 Collection(컬렉션 == list 와 set를 뜻함)을 순회할 때 사용한다
		 	2. 주요 메소드 ==> 주머니에서 구슬을 꺼낼때 
		 		1) hasNext() : 남아 있는 요소가 있으면 true 반환 (주머니에 구슬이 있냐없냐 역할)
		 		2) next()	 : 요소를 하나 꺼냄
	 */
	
	public static void ex01() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("동그랑땡");
		list.add("동태전");
		list.add("굴전");
		
		// 순회
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			String food = itr.next();
			System.out.println(food);
		}
	}
	// for문이 대체된거라 할 수 있음
	
	public static void ex02() {
		
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(5);
		set.add(15);
		set.add(105);
		
		// 순회
		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()) {
			Integer number = itr.next();
			System.out.println(number);
		}
	}
	// set는 인덱스가 없고 랜덤으로 출력됨

	public static void ex03() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 해쉬맵에서는 add 사용 x put이 add역할 함
		
		map.put("name", "방예림");
		map.put("age", 32);
		map.put("isAlive", true);
		
		// 키값을 출력하면 밸류를 돌려준다
		// System.out.println(map.get("name")); // 방예림
		
		// map의 키를 뽑으려면 map.keySet()
		Set<String> keySet = map.keySet();
		Iterator<String> itr = keySet.iterator();
		
		while(itr.hasNext()) {
			String key = itr.next();
			System.out.println(map.get(key)); //true 방예림 32
		} // key는 원래 set에 저장되기 때문에 내가 입력한 순서대로 나오지 않음!!! 다시한번 기억하기
		
//		
		/* while(itr.hasNext()) {
		 
			String key = itr.next();
			Object value = map.get(key);
			==> 위 두문장을 입력하면 키값과 밸류값을 같이 출력 하는 거임
			System.out.println(map.get(key)); //true 방예림 32
		} 
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		ex03();
	}

}
