package ex05_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//singleton은 안됨!
@Builder
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

@Getter //@Setter치고 컨트롤 스페이스해서 임폴트 해줘야됨
@Setter //@Setter치고 컨트롤 스페이스해서 임폴트 해줘야됨
public class User {
	private String id;
	private String pw;
}
