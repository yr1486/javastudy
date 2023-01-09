package ex01_one_dim;

public class Ex02_reference { //참조

	public static void ex01() {
		
		int[] arr;
		arr = new int[5];
		
		System.out.println(arr); // 5개 배열 요소의 참조값 (주소값, 번지값 이라고도 함)
		
		// 기술면접 : String, 참조값에 대한 기술을 물을때, 어딘가에 참조값이 저장되어있고~ 기술할 수 있어야 함

	}
	public static void ex02() {
		int[] a = new int[5];
		int[] b;
		
		b = a; 
		// a도 배열이고 b도 배열이고, a를 통해서 10번지에 도달해도 되고, b를 통해서 10번지에 도달해도 되고.
		// 주소에 도달할때 int 값은 4byte 사용하니까 주소의 값은 예를들어 4번지 8번지 12번지 등으로 부여되게 된다.
		
		System.out.println(b[0]);
		
	}

	
	public static void ex03() { // 심화
		
		// 생성된 배열의 크기를 늘이는 방법
		// 기존 배열 
		int[] a = new int[5];
		
		// 신규 배열
		int[] b = new int[10];
		
		// 기존 배열 -> 신규 배열 요소로 복사
		for(int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		
		// 기존 배열의 참조값을 신규 배열의 참조값으로 수정
		a = b;
		
		// 기존 배열이 신규 배열로 변경되었으므로 확인
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args) {
		ex03();
		
	}

}
