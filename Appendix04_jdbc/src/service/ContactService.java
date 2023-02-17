package service;

/* 서비스는 DAO가 필요하다. DAO의 메소드를 불러서 그작업을. 호출해줘야함

임폴트는 패키지가 다르면 필요해. 기억하기.
private ContactDAO dao; // 널값 가지고 있음
private ContactDAO dao = ContactDAO.getInstance();
static 메소드는 클래스 이름으로!!! 부른다. 클래스 이름으로 메소드 부르기. 변수가아닌.

*/
//interface = abstract class
public interface ContactService {
// 서비스만들때 인터페이스만들고 얘를구성하는 클래스를 만드는데. 클래스 이름은 OOO서비스로 인터페이스만들고 그걸 OOOservice impl 해가지고 여기에 담고.  ==> 곧 서비스라고 붙어있으면 인터페이스
// OOO서비스에는 인터페이스니까 메소드만 있고. OOOservice impl여기에 구현된거있음.
	
	public void addContact();
	
	
	
	
}

