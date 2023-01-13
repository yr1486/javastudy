package practice02_Person_Array;

public class Home {
	
	// 필드
	private Person[] arr; //new 가 아닌 이유 집집 마다 다르기 때문에 , 선언만 되어 있음
	private int count;
	
	// 생성자
	// 배열은 생성하고 선언해야 사용할 수 있다
	public Home(int count) {
		arr = new Person[count];
		this.count = count; // count = arr.length 와 동일해서 안써도 되는데~~ 한번 써본 문장
		
	}

	// 메소드
	public Person[] getArr() {
		return arr;
	}

	public void setArr(Person[] arr) {
		this.arr = arr;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
