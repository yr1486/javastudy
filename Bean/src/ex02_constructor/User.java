package ex02_constructor;

public class User {
	
	private String id;
	private String pw;
	
	// 필드 만들기 소스>필드
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	
}
