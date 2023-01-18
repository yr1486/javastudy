package ex06_Object;

public class Person {
	
	private String name; // 필드라고 함 ==클래스 변수
	
	// 이름을 안받아 오는 방법
	public Person() {
		
	}
	// 이름을 받아오는 방법
	public Person(String name) { // 네임을 불러오고
		this.name = name; // 네임을 저장 까지
		
		// 게터세터 넣어주기
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void eat() {
		System.out.println("먹는다");
		
	}

	public void sleep() {
		System.out.println("잔다");
	}
	
	// 오브젝트에 오버라이드 과정
	
	// 밑에는 나중에 배울 내용이라 넘어가~~
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	// 소스메뉴엥서 불러오기
	@Override
	public boolean equals(Object obj) {
		if (this == obj) //같은객체면 같겠지
			return true;
		if (obj == null) //비교대상이 없으니 false
			return false;
		if (getClass() != obj.getClass()) //다른클래스와 비교
			return false;
		Person other = (Person) obj; // 펄슨으로 오버라이딩해서 사용
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) //이름이같지 않으면 false
			return false; //아닌경우를 엄청 if로 늘어놓고, 마지막 이름이 같으면 true 내놓는 구조
		return true; //여기에 와서 비로소 이름이 같으면 같다
	}
	
	
	// 소스메뉴에서 불러오기
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
	
	
	
	
	
}
