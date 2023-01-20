package ex05_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainClass {
	
	// 맵을 만들고 받아오는 방법 익히기 꼭 (받아오려면 for문 돌려서)
	
	/*
		 	HashMap
		 	1. 하나의 데이터가 2개의 요소로 구성된다 
		 		==> Entry가 두개의 요소로 구성된다
		 	2. 용어 정리
		 		1) Entry : 하나의 데이터
		 			- Key	: Entry의 구성 요소, '식별자 역할'을 수행(배열의 인덱스와 같은 역할)
		 			- Value : Entry의 구성 요소, 실제 데이터(배열의 저장된 데이터와 같은 역할)
		 		
		 	3. 주로 key는 String을 사용한다. '변수 이름'
		 	4. 주로 Value는 Object를 사용한다.(변수에 저장된 값)
		 	5. 'Key는 중복이 불가능'하고, Value는 중복이 가능하다. 
		 	====> key값을 변수이름이라고 생각하면 쉬움 ===> key(=변수)는 중복이 불가능하다.
		 
	 */
	
	public static void ex01() {
		
		
		// Person 정보를 HashMap으로 만들기    ====> 겁나 많이씀 중요 중요 중요 중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 만들기와 추가하기!!!!
		
		//	Map<K, V> 맵은 인터페이스로 불러오면 제네릭이 2개보이고, 키와 밸류 다 ===> 맵의 타입
		
		// 문법
		Map<String, Object> person = new HashMap<String, Object>(); // 실무에 굉장히 많이 나옴 , 수업시간에도 많이쓰임
		// 	Map<String, Object> person = new HashMap<>(); ===> 뒤에 안써도 가능
		
		
		// 추가하기 (키와 밸류가 모여야 하나의 데이터가 되는거임)
		// put(Key, Value)
		
		person.put("name", "홍길동");
		person.put("age", 30);
		// Class person과 비슷한 기능을 하는 Map ==> 실제로 객체 안만들고 Map을 많이 씀
		
		
		// 수정하기
		// 기존의 요소를 수정해보자 // 수정도 추가와 똑같이 put을 씀
		// put(Key, Value)
		person.put("age", 40); // 기존 key(위에 추가 부분의 key)와 동일한 key를 전달하면 해당 key값의 Value가 수정된다 (덮어씌우기)
		
		// 삭제하기
		// remove(Key)
		// person.remove("age"); 
		// // 현재 상황에서 리무브를 하면 뒤에 가지고 있던 40을 반환 해버린다 // 어딘가에 반환하는데 변수에 담으면 됨.
		// // 밸류는 오브잭트 타입이므로 캐스팅 해야 사용할 수 있는 점을 주의하자.
		// int age = person.remove("age"); 
		// // ===> 40을 반환해서 int age에 담는건데, 40이 Object 타입임으로 int가 받을 수 없으니 캐스팅한 후 사용할 수 있다
		
		int age = (int)person.remove("age");
		System.out.println("삭제된 나이 " + age);
		
		
		// 동일한 값이 저장되지 않는 것 set,
		// 해쉬코드를 동일하게 활용하기 때문에 해쉬맵이라고 함.
		// 해쉬는 빨리찾는다 중복값을 저장하지 않기 위해서, 이퀄스랑 그룹핑을 통해서 빠르게 찾는거임
		// 해쉬맵은 KEY땜에 해쉬라는 단어를 쓰는거임
		
		
		// 확인하기
		System.out.println(person);//{name=홍길동, age=30} ===> 엔트리가 2개로 구성된 맵이다.
		// key값을 변수이름이라고 생각하면 쉬움 //  Object는 전부 저장할 수 있음
		// 
		
	}
	
	public static void ex02() { // 저장해두고싶은건 밸류 
		
	Map<String, String> dictionary = new HashMap<String, String>();
	dictionary.put("spring", "봄");
	dictionary.put("summer", "여름");
	dictionary.put("autumn", "가을");
	dictionary.put("winter", "겨울");
	
	// Value 가져오기
	// get(Key)
	String season = dictionary.get("winter");// get메소드는 키만 전달하면 가져올수있어!!!!!!
	System.out.println(season);
	// 키를전달하면 밸류를 빼오는거, 키를 이용해서 밸류를 가져오는거
		
		
	}
	
	public static void ex03() { // for문 돌리기
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("spring", "봄");
		dictionary.put("summer", "여름");
		dictionary.put("autumn", "가을");
		dictionary.put("winter", "겨울");
		
		
		// 중복없는 자료구조 set를 써서.
		
		// Map 순회하기 (방법2가지)
		
		// 1. key만 모두 가져온 뒤, 해당 key값을 가진 Value를 가져오기
		Set<String> keySet = dictionary.keySet(); // 키 세트로 가져오기 , == 키만 빼서 가져오기
		// set는 인덱스가 업으니까 일반for문 못씀 
		// 저위에 봄여름가을겨울이 순서대로 들어있지 않음. 동전지갑에서 동전뺴는데 순서없음
		for(String key : keySet) {
			System.out.println(key + ":" + dictionary.get(key)); //get메소드는 키만 전달하면 가져올수있어!!!!!!
		}
		
		// 2. Entry를 모두 가자ㅕ온 뒤, key와 Value로 분리하기
		// 쌤은 이걸로 많이씀
		
		//for(엔트리 : 맵) 맵을 하나씩뺴서 엔트리에다 담은 향상for문 모습
		for(Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue()); //==> 누각봐도 키와 밸류 값의 식
		}
	}
	
	
	public static void ex04() {
		// 제목 title, 저자 author, 가격price 로 구성되는 책(book) ===> HashMap 만들기
		// 책 3권이 저장된 ArrayList 를 만들어 보기
		
		Map<String, Object> book1 = new HashMap<String, Object>();
		book1.put("title", "어린왕자");
		book1.put("author", "생텍쥐페리");
		book1.put("price", 10000);
		
		Map<String, Object> book2 = new HashMap<String, Object>();
		book2.put("title", "곰세마리");
		book2.put("author", "곰아저씨");
		book2.put("price", 20000);
		
		Map<String, Object> book3 = new HashMap<String, Object>();
		book3.put("title", "양치기소년");
		book3.put("author", "양농부");
		book3.put("price", 30000);
		
		// 책 3권이 저장된 ArrayList 를 만들어 보기
		// 똑같이 생겼으니까 반복문
		List<Map<String, Object>> books = new ArrayList<Map<String,Object>>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		// for문 순회
		
		// List의 순회
		// 배열대신 리스트!! 
		// 객체대신 맵으로 사용
		for(int i = 0, length = books.size(); i < length; i++) {
			//Map의 순회(list에 저장도니 요소가 Map이다
			Map<String, Object> book = books.get(i);
			System.out.println((i + 1) + "번째 책의 정보");
			for(Entry<String, Object> entry : book.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
				
				
			}
		}

		// 트리맵 TreeMap ==> 알고리즘 쪽,
		// 데이터가 정리되어 있음
		// 해쉬맵 정리x

	}
	public static void main(String[] args) {
		ex01();
		
		
		
		
	}

}
