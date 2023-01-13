package practice02_Person_Array;

public class MainClass {
		
		public static void ex01() {
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		Person[] arr = new Person[3];
		// 배열의 생성임 , 
		// 배열이 생성됨 각각의 person이 3개 생성, 초기값은 null 값이 들어있음 왜? int도 아니고 Person 이니까
		// 사람이 들어갈 집만 만들어진 상태
		
		for(int i = 0; i < arr.length; i++) {
			// System.out.println(arr[i]); 이 코드로 null 값이 있는걸 확인 할 수 있음
			arr[i] = new Person();
			//각각의 집에 사람을 넣어서 만든다
			// System.out.println(arr[i]);
			arr[i].setName(nameList[i]);
			arr[i].setAge(ageList[i]);
			System.out.println("이름 : " + arr[i].getName() + " , 나이 : " + arr[i].getAge());
		}
	}
		
		public static void ex02() {
			
			String[] nameList = {"정숙", "상철", "미희"};
			int[] ageList = {20, 30, 40};
			
			Person[] arr = new Person[3];
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = new Person(nameList[i], ageList[i]); // setname setage를 할필요 없는 부분
				System.out.println("이름: " + arr[i].getName() + " , 나이: " + arr[i].getAge());
				
			}
		}
		
		public static void ex03() {
			
			String[] nameList = {"정숙", "상철", "미희"};
			int[] ageList = {20, 30, 40};
			
			Home home = new Home(3);
			for(int i = 0; i < home.getArr().length; i++) { //home.arr 안나오는 이유는 private 이기 때문
			home.getArr()[i] = new Person(nameList[i], ageList[i]);
			System.out.println("이름: " + home.getArr()[i].getName() + ", 나이: " + home.getArr()[i].getAge());
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		public static void main(String[] args) {
			ex03();
			
		}
}
