package ex04_builder;

public class User {
	
	// User 필드 (Builder 객체가 가진 값을 받아온다)
	private String id;
	private String pw;
	
	// User 생성자
	public User(Builder builder) {
		this.id = builder.id;
		this.pw = builder.pw;
	
	}
	
	// Builder 객체 반환
	public static Builder builder() { // 1. static으로 쓰기위해
		return new Builder();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}

	// Builder 클래스(내부 클래스)
	public static class Builder { // 2. static 클래스로 만들어 준다.
		
		// Builder 필드(여기로 값을 전달 받아서 User 필드로 전달한다)
		private String id;
		private String pw;
		
		// 값을 받아오는 메소드
		// 1. 메소드과 필드 이름을 동일하게 구성한다
		// 2. 메소드 체이닝을 위해서 현재 객체를 반환한다 //현재 객체 : this
		//    ==> 메소드를 연속해서 여러번 부르는 거 : user.setId("admin").setPw("123456") 
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		
		public Builder pw(String pw) {
			this.pw = pw;
			return this;
			
		}
		
		//이제 이래 값들을 맨 위에 있는 클래스에 반환해줘야하니까
		//private String id;
		//private String pw;
		
		// User 객체 반환
		// Builder 필드 값을 가진 User 객체를 반환
		public User build() {
			return new User(this); // this는 id, pw 값을 모두 가지고 있는
		}
		
	}
}
