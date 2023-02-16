package ex05_lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//singleton은 안됨!

@ToString
@NoArgsConstructor //아규먼트가 없는 ===> 디폴트 생성자
@AllArgsConstructor 

// AllArgsConstructor 는 아래 식과 같은 거임!
/*
public User(String id, String pw) {
	super();
	this.id = id;
	this.pw = pw;
*/





public class User {
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
	private String id;
	private String pw;
}
