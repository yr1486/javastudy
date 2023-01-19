package ex04_hash;

public class User {
	
	// hash는 이해안해도 됨..............
	
	private String id, pw;
	// private String id;
	// private String pw; 두 문장을 한문장으로 줄임

	// 생성자 만들기 > 메뉴소스로 불러와 유징 필드
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	// 참조값 보기싫어서 의미가 없으니 tostring 하는거임
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	// set은 중복값 저장 안하니까.......equals 통해서 두 값이 같은지 보자 ==> 그럼 똑같으면 안넣어주고 다르면 넣어주고
	// 객체를 비교하는 필요한 상황이 오면 이퀄스를 떠올리기!!! 내가 코드 쓰는게 아니라 메뉴소스에서 불러오기 ==> 이퀄스가 없으면 참조값만 비교하기때문에 무조건 false가 나옴 왜? 주소가 다르니까
	// Hash를 가진애들은 확인을 두번함 1. Hash값 확인 2. 실제 equals 확인 // 동일한 값을 가지고 있으면 비교 시작
	// 해쉬 구조를 쓰고 있다 하면 객체에다가 메뉴소스>이퀄스만 추가해주면 됨
	// id랑 pw 제너레이트 하라고 나올텐디 우리는 id중복만 볼거니까 선택 id만 함
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
