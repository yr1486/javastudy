package ex01_generic;

public class Box<T> { //new Box<int>() 지금 int가 T로 간다고 생각하면 됨
	
	// private Object item; // 오브젝트는 만능이지만, 빼서 쓸때는 캐스팅해야해서 불편함
	
	private T item;
	
	

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	} 

}
