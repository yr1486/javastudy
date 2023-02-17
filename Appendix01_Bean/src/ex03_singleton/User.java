package ex03_singleton;

	/* singleton
		객체를 하나만 만들수 있다. = User를 하나만 만들수 있다
		하나만 만들수 있으니 만들지 못하게 설정을 해줘야 함
		
	*/

// 외부에서 못만듬.
public class User {

		// static 필드로 (미리 User를 만들어 둔다)
		// 메인에서 원래 뉴유저해서 만드는데, 그걸 미리 해두는거
		private static User user = new User();
		// static = 미리.
		
		//private 생성자 (외부에서는 생성자를 호출할 수 없다 ==> 외부에서는 유저를 만들지 못한다 = 메인에서 못 만든다)
		private User() {
			//프라이빗으로 막았음. 뉴를 막았음. 밖에서는 여기서 미리 만들어논 생성자를 불러와서 써야하는 상황임.
		}
		
		// static 메소드 (를 사용하기 위해서는 static 필드를 사용해야함) =스테틱메소드 = 클래스 메소드 ==> 클래스메소드는 클래스 이름으로 가지고 가야하는 걸(불러오는걸) 기억하기
		// user 필드를 외부에서 사용할 수 있도록 반환하는 일종의 Getter를 만드는 것
		public static User getInstance( ) { // 인스턴스 = 객체
			return user;
		}

}
