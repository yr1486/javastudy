package main;

import controller.ContactController;

//아주 중요
//1번 메인 > contactcontroller / 컨텍트서비스임플  > 컨텍트다오 > 컨텍트서비스 > 컨택트(sql) 
//구현은 반대로 역순으로 만드는 거임!!

public class MainClass {

	public static void main(String[] args) {

		new ContactController().play();
		
		
	}

}
