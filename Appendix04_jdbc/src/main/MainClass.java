package main;

import controller.ContactController;

public class MainClass {

	public static void main(String[] args) {

		new ContactController().play();
		
	}

}
// 아주 중요
// 1번 메인  / 메인이 부르는 호출: contactcontroller / 서비스임플 ?  > 서비스 > 
// 구현은 반대로 역순으로 만드는 거임!!