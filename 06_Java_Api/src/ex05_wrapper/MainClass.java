package ex05_wrapper;

public class MainClass {
	
	/*
	 	wrapper class
	 	감싸놓은 클래스
	 	
	 	1. 기본 자료형(Primitive Type)을 참조 자료형(Reference Type)으로 만들어 놓은 클래스
	 	2. 주요 종류
	 		byte	→	Byte
	 		int		→	Integer
	 		long	→	Long
	 		
	 		double	→	Double
	 		
	 		boolean →	Boolean
	 		
	 		char	→	Character
	 	
	 	3. 용어 정리
	 		1) Auto Boxing	 : 기본 자료형을 참조 자료형으로 변환할때 자동으로 진행된다 int = 10; 원래 이건데 바로 적용 가능 →	Integer a = 10;
	 		2) Auto UnBoxing : 참조 자료형 → 기본 자료형==> 똑같이 Integer a = 10; 원래 이건데 바로 적용 가능 →	int = 10;
	 			그냥 둘다 서로 왔다갔다 사용 가능하다.. 차이가 없다
	 			
	 	4. '반드시' '참조 자료형'을 요구하는 제네릭에서(generic) 주로 사용한다
	 	
	 */
	

	public static void main(String[] args) {

		Integer a = 10; // Auto Boxing 함
		Integer b = 10; // "
		
		int sum = a+b; // Auto UnBoxing 함
		System.out.println(sum);
	}

}
