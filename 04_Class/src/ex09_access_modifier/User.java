package ex09_access_modifier;

public class User {
	
	/*
	 	접근 제어 지시자(Access Modifier)
	 	1. private 		: 클래스 내부에서만 접근할 수 있다
	 	2. default 		: 동일한 패키지에서만 접근할 수 있다
	 	3. protected 	: 동일한 패키지 또는 상속 관계의 클래스에서만 접근할 수 있다
	 	4. public 		: 누구나 접근할 수 있다
	 */
	
	/*
	 	정보 은닉(Information Hiding)
	 	1. 클래스의 내부 정보를 외부에 노출하지 않는 것을 말한다
	 	2. 클래스의 내부 정보는 "필드"를 의미하므로 "필드"값을 외부에 공개하지 않는 것을 말한다
	 	3. "필드"는 private 하게 처리한다 특별한 사유가 아니면 100% private!! 아무나 사용 못하게 막기
	 	4. "메소드"는 public 하게 처리한다. "필드"에 접근하기 위해서는 "메소드"를 통해서 접근해야 한다
	 */
	
	/*
	 	Getter 와 Setter
	 	* 자동완성 기능 사용하기
	 		( 상단 메뉴: source > generate getter and setter > select all > generate 하게 되면 자동 완성, 또는 우클릭 통해서 이와 같음)
	 		
	 	1. Getter
	 		1) 필드값을 외부로 반출하는 메소드 (유저클래스 외부에서 값을 확인할수 있도록 값을 반환하는 역할)
	 		2) 정해진 이름의 규칙이 있음
	 			'get + 필드' 이름을 가지는데 이를 수정하면 안 된다. 단, boolean 타입일때는 달라진다
	 			
	 	2. Setter
	 		1) 외부로부터 필드값을 받아오는 메소드
	 		2) 이름의 정해진 규칙이 있음
	 			'set + 필드' 이름을 가지는데 이를 수정하면 안 된다
	 			
	 	3. boolean 타입의 필드의 경우는 이름이 다름
	 	
	 */
	
	// 필드
	private String id;
	private String pw;
	private boolean isVip; // 대문자로 작성해야함 주의하기
	
	
	// 메소드 ( 메뉴: source > generate getter and setter > select all > generate 하게 되면 자동 완성 )
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	
	
	
//	타입이 클래스인 경우 변수가 아니라 객체라고 부른다
//	객체가 메소드를 부른다
//	User user = new User(); ==> new User(); 이 부분에서 'User' 앞에 대문자면 클래스 이름
	
	// 클래스가 메소드를 부를때
	// static 메소드는 class 메소드라고도 부름
	
	
}
