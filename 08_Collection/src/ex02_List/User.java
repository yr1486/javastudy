package ex02_List;

public class User {

	private String id;
	private String pw;
	
	public User() { // 디폴트 타입의 생성자
		
	}
	
	// 필드 생성 (메뉴소스로 불러오기)

	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	// 게터 세터 생성
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

	// 투스트링
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
}
