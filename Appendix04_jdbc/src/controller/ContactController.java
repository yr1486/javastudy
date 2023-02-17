package controller;

import java.util.Scanner;

import service.ContactService;
import service.ContactServiceImpl;

public class ContactController {
	//컨트롤러는 서비스를 가지고 있어야대. 그래야 addcontact를 부를 수 있음.
	
	/******************1. field*********************/
	private Scanner sc;
	private ContactService service;
	
	
	/******************2. Constructor*********************/
	public ContactController() {
		sc = new Scanner(System.in);
		service = new ContactServiceImpl();
	}
		
	/******************2. method*********************/
	public void play() {
		while(true) {
			System.out.println("1. 추가 2.삭제 3.수정 4.개별조회 5.전체조회 6.연락처.csv생성 0.종료 >>> ");
			String choice = sc.next(); // 123456을 스트링으로 받아씀.
			switch(choice) {
			case "1" :
				service.addContact();
				break;
			case "0" :
				System.out.println("연락처 관리 프로그램이 종료되었습니다.");
				return; // 완전히 끝나는거
			default :
				System.out.println("잘못된 입력입니다. 다시 시도하세요");
			}
		}

	}
	
	
}
