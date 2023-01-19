package ex05_exception_class;

/*
 	예외 클래스 만들기
 	1. Exception 클래스를 상속 받는다(필수)
 	2. Exception 클래스의 슈퍼 클래스인 Throwable 클래스가 Seriallizable(직렬화) 인터페이스를 구현하기 때문에 serialVarsionUID 값을 가질 수 있다 (선택)
 	3. 
 */
public class GunException extends Exception {

	private static final long serialVersionUID = 3700059434730916901L; // 2번 선택 해본거임, 건익셉션에 커서댄 후 2번째 메뉴 누르면 생성됨

	private String exceptionCode;
	
	public GunException(String message, String exceptionCode) {
		super(message); // Exception임!
		this.exceptionCode = exceptionCode;
		
		
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
}
