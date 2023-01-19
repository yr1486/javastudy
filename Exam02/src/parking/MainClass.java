package parking;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("차량번호1 >>> ");
		String carNo = sc.next(); // 공백이 들어오면 끝난줄 인식
		System.out.println(carNo);
		
		System.out.println("차량번호2 >>> ");
		String carNo2 = sc.nextLine(); // 공백 포함 가능, 라인까지를 입력으로 본다
		System.out.println(carNo2);

	
	}

}
