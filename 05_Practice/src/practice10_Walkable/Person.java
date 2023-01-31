package practice10_Walkable;

public class Person {

	// 기본 생성자
	
	// 음식 주기
	public void foodFeed(Pet pet, String food) {
		System.out.println(pet.getPetName() + "에게 " + food + "주기");
	}
	
	// 산책 하기
	// 주의. public void walk(Pet pet)이 아님을 주의할 것.
	public void walk(Walkable pet) {
		System.out.println(((Pet) pet).getPetName() + "와 산책"); // 앞에 펫타입을 왜 쓰워준거지..
	}
	
}
