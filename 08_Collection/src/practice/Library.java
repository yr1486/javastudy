package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Library {
	
	private List<Book> books;
	private Scanner sc;
	
	public Library() {
		books = new ArrayList<Book>();
		sc = new Scanner(System.in);
	}

	private void addBook() {
		System.out.println("=== 책 추가하기 ===");
		System.out.println("isbn >>> ");
		String isbn = sc.next();
		
		System.out.println("title >>> ");
		String title = sc.next();
		
		System.out.println("author >>>");
		String author = sc.next();
		
		Book book = new Book(isbn, title, author);
		books.add(book);
		System.out.println(title + "책이 추가되었습니다");


	}

	private void deleteBook() { //RuntimeException은 UnChecked-Exception이므로 throws RuntimeException을 생략할 수 있다.
		System.out.println("=== 책 삭제하기 ===");
			if(books.isEmpty()) {
				throw new RuntimeException("등록된 책이 없습니다"); //예외처리 던졌으니 받아야하니 캐치
			}
			System.out.println("삭제할 isbn >>>");
			String isbn = sc.next();
			if(isbn.isEmpty() == false) {
				/*
				 	1. 객체 기반 삭제 (Book 객체간 동등 비교가 필요하기 때문에 equals 메소드를 오버라이드 해야한다)
				 	// Book클래스로 넘어가서 소스메뉴 > 해쉬코드 이퀄스 해주기!!!!
				 */
				for(Book book : books) {
					if(isbn.equals(book.getIsbn())) {
						books.remove(book);  // equals 메소드가 내부에서 사용된다.
						System.out.println(book + " 책이 삭제되었습니다.");
						return;
			
					}
					
				}
				/* 2. 인덱스 기반 삭제
				   for(int i = 0; i < books.size(); i++) { // 일반 for문
				 
					Book book = books.get(i); // 한권한권
					if(isbn.equals(book.getIsbn())) {
						//스트링은 =으로 비교 안되서 이퀄스
						Book deleteBook = books.remove(i); // remove(i)는 삭제된 요소(book)를 반환 // 이 구문 없어도됨
						System.out.println(deleteBook + "책이 삭제되었습니다"); // 위문장 없으면 북으로 확인하면 됨
						return;
					}

				}*/

			}
			throw new RuntimeException(isbn + "isbn을 가진 책이 없습니다");
	}

	private void findBook() {
		System.out.println("=== 책 조회하기 ===");
			if(books.isEmpty()) {
				throw new RuntimeException("등록된 책이 없습니다");
			}
			System.out.println("조회할 isbn >>>");
			String isbn = sc.next();
			if(!isbn.isEmpty()) { // 되도록이면 if(books.isEmpty() == false) { 식으로 가기 !느낌표는 자제해서 코드짜기. . 그냥 권장사항
				for(Book book : books) { //향상 for문 ==> 딜레이트와 코드구성이 거의 같은데 여기서는 향상 for문으로 구성을 해보자 향샹이 더 간단하고 쉽다.
														// 단 향상은 인덱스가 없음 참고하기
					if(isbn.equals(book.getIsbn())) {
						System.out.println("조회 결과 : " + book);
						return;
					}
				}
			}
			throw new RuntimeException(isbn + "isbn을 가진 책이 없습니다");

	}

	private void printAllBooks() {
		System.out.println("=== 전체 조회하기 ===");
			if(books.isEmpty()) {
				throw new RuntimeException("등록된 책이 없습니다");
			}
			for(Book book : books) {
				System.out.println(book);
		}
	}

	public void managne() {

		while(true) {
			
			try {
				
				System.out.println("1.추가 2.삭제 3.조회 4.전체 0종료 >>>");
				String choice = sc.next();

				switch(choice) {
				case "1" :
					addBook();
					break;
				case "2" :
					deleteBook();
					break;
				case "3" :
					findBook();
					break;
				case "4" :
					printAllBooks();
					break;
				case "0" :
					System.out.println("도서관리 프로그램을 종료합니다");
					return;
				default :
					System.out.println("잘못된 입력입니다. 다시 시도 하세요");
			}
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
		}
	}

}
