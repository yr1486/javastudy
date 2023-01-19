package ex03_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainClass {
	
	public static void ex01() {
		
		/*
		 	Set 메소드 특징
		 	1. 저장된 요소들에 인덱스가 없다 ==> 저장 순서가 없다
		 	2. 중복 저장이 되지 않는다 ==> 동일한 데이터는 한번만 저장, ex) 로또 번호 출력 , 중복 데이터 거르는 작업 할 때
		 */
		
		// HashSet 객체의 선언 및 생성 과정
		Set<String> set = new HashSet<String>(); // Set은 인터페이스! 컨트롤 스페이스, HashSet도 인터페이스!!컨트롤 스페이스
		
		// 추가 (같은 값은 중복 저장되지 않고 생성됨)
		set.add("spring");
	//	set.add("spring"); ==> 중복 저장 안됨
	//	set.add("spring"); ==> 중복 저장 안됨
		set.add("summer");
		set.add("autumn");
		set.add("winter");
		
		// 제거
		set.remove("winter"); 
		//어레이리스트랑 차이점은 제거가 2가지 방법이 있었음, 인덱스로 부르는거 있었는데 얜 순서가 없으니까 불러올 수 없으니 제거방법이 하나
		
		// 확인
		System.out.println(set); // [spring, autumn, summer]
		//arrayList는 순서가 있었는데 얘는 순서가 없음, 확인하기 과정, 동전지갑에 동전을 넣는데 뺄때 순서대로 빼지 않는것처럼 그냥 없음
		
	}

	
	public static void ex02() {
		
		// HashSet  객체의 초기화
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(6,5,4,3,2)); 
		// HashSet 할때 컬렉션을 받아들이는 컨트롤 스페이스 하고 collection~ 두번째꺼 클릭
		
		// 인덱스가 없기 때문에 향상 for문만 가능 (set 구조는 인덱스가 없기 때문에)
		for(Integer n : set) {
			System.out.println(n);//2 3 4 5 6
		}
	}
	
	public static void ex03() {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3,4,5,6,7));
		
		// 교집합
		set1.retainAll(set2); //set1에 교집합 결과가 저장된다
		
		System.out.println(set1);//[3, 4, 5]
		System.out.println(set2);//[3, 4, 5, 6, 7]
		
	}
	
	public static void ex04() {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3,4,5,6,7));
		
		// 합집합
		set1.addAll(set2); // set1에 합집합 결과가 저장된다
		
		System.out.println(set1);//[1, 2, 3, 4, 5, 6, 7]
		System.out.println(set2);//[1, 2, 3, 4, 5, 6, 7]
		
	}
	
	public static void ex05() {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3,4,5,6,7));
		
		// 차집합
		set1.removeAll(set2); // set1에 차집합 결과가 저장된다
		
		System.out.println(set1);//[1, 2]
		System.out.println(set2);//[3, 4, 5, 6, 7]
		
	}
	
	public static void ex06() {
		
		// 로또번호 : 1 ~ 45 사이에 숫자 6개 랜덤으로 발생
		// 중복된 숫자 제거해서 ==> set 이용
		// Math.random 사용해서 만들어 보기
		
		Set<Integer> lotto = new HashSet<Integer>();
		
		while(lotto.size() < 6) { // 언제끝날지 모른다, for문은 안됨, 배열로 짜려고 해도 힘듬
			lotto.add( (int)(Math.random() * 45) + 1);
		}
		System.out.println(lotto);//[32, 18, 4, 5, 6, 13]
	
	}
	
	// 언제끝날지 모른다, for문은 안됨, 배열(list)로 짜려고 해도 힘듬
	// 부모가 같다는건 메소드가 동일하다는 거 set과 list queue의 부모가 collection ==> 그래서 메소드 사용법이 비슷함
	// 쌤 ppt 자료에서 컬렉션프레임워크 보기
	
	public static void main(String[] args) {
		ex06();

	}

}
