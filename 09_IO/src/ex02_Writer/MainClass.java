package ex02_Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass { //writer 파일에 글자를 넣어주는 메소드
	
	/*
	  	스트림 (stream) 앞에 소문자임
	  	1. 통로의 개념이다 (데이터가 돌아다니는 통로)
	  	2. 일반 통행이다
	  		1) 입력 스트림 :이라고하면 입력만 받을 수 있다
	  		2) 출력 스트림 : 출력만 할 수 있따
	 */
	
	/*
	 	Writer ===> 트라이캐치를 달고 사는 아이, 롸이터는 파일을 만드는..역할! csv,xml,json같은 파일 나중에 만들어 갈거임
	 	1. '문자' 기반의 출력 스트림이다
	 	2. Writer로 끝나는 이름의 클래스는 모두, 문자 기반의 출력 스트림이다 ==> 글자를 출력 시키는(내보내는) 아이들
	 	3. 문자를 내 보내는 스트림이다. (파일로 문자를 보낸다, 서버로 문자를 보낸다
	 	
	 */
	
	public static void ex01() {
		
		// 디렉터리 작업
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		// 파일 작업
		File file = new File(dir, "ex01.txt"); // 아직 데이터 저장전
		
		// 출력 스트림 선언 ==> writer ==> 통로 생성, 통로의 이름이 fw인 통로(=스트림) 생성
		FileWriter fw = null;
		// 선언만 한 후에
		
		try {
			// 출력 스트림 생성 ==> 
			//File file = new File(dir, "ex01.txt"); 이때말고 
			//fw = new FileWriter(file); 지금에서 파일이 생기는 거임
			// 트라이구문에 넣어서 생성을 함
			fw = new FileWriter(file); // 반드시 예외 처리가 필요한 코드

			// 출력 스트림으로 문자 보내기
			int c = 'I';
			char[] cbuf = { ' ', 'a', 'm'};
			String str = " a boy.";
			fw.write(c); // 반드시 예외 처리가 필요한 코드
			fw.write(cbuf);
			fw.write(str);
			
			// 1글자만 주고 받을때 chr가 아니라 int를 사용한다 ==> int ch = 'A' 가능 왜?? 'A'가 65이기도 하고, 2바이트를 4바이트에 저장하는데에 아무런 문제가 없음
			// 모든 스트림 작업은 예외처리를 반드시 해야함 try catch

			System.out.println("ex01.txt 파일이 생성되었다.");
			
		} catch(IOException e) {
			e.printStackTrace(); // 캐치코드는 고민하지말고 이 문장 넣기
		} finally { // 예외와 상관없이 반드시 실행되는 코드
			try {
				if(fw != null) {
					fw.close(); //얘도 반드시 예외처리가 필요한 코드 ==> 빨간줄 떠가지고 // 사실 이코드는 try에 있어야 한다는 뜻임.
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	
	}

	public static void ex02() {
		/*
		 	try - catch - resources 문
		 	1. 사용한 스트림을 자동으로 닫아 주는 try문이다
		 	2. 형식
		 		try (스트림 생성) {
		 		나머지는 일반 try-catch와 똑같음!!
		 		코드
		 		} catch(Exception e) {
		 			e.printStackTrace();
		 		}
		 	
		 */
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex02.txt");
		
		try (FileWriter fw = new FileWriter(file)) {
			
			char[] cbuf = { 'a', 'b', 'c', 'd', 'e'};
			String str = "abc가나";
			// 골라서 보내기를 해보자
			fw.write(cbuf, 0, 2); // cbuf에 인덱스 0부터 2글자만 보내시오
			// fw가 스트림이자나. 그니까 스트림으로 보낸다는 뜻
			fw.write(str, 2, 3);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// 이 구문을 쓰면 클로즈가 없음
		// 클로즈가 없어도 돌아가는 코드임
		// 일반 트라이문을 하면 꼭 클로즈를 해야함

	}
	
	public static void ex03() {
		
		/*
		 	BufferedWriter // 자체 기억장소를 갖춘 writer
		 	1. 내부 버퍼를 가지고 있는 Writer이다
		 	2. 속도 향상을 위해서 사용한다
		 	3. 보조 스트림이므로 메인 스트림과 함께 사용해야 한다
		 	파일라이터가 느려서 버퍼를 끼우는 거임
		 */
		
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex03.txt");
		
		// 메인 스트림 선언
		FileWriter fw = null;
		
		// 보조 스트림 선언
		BufferedWriter bw = null;
		
		try {
			//메인 스트림 생성
			fw = new FileWriter(file);
			//보조 스트림 생성
			bw = new BufferedWriter(fw); // 해당 메인 스트림에 버퍼 끼우기
			
			//보조 스트림을 사용해서 문자 보내기
			bw.write("Hello World Hi 방예림");
			
			System.out.println("ex03.txt 파일이 생성되었다!");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 보조 스트림을 사용한 경우에는 보조 스트림만 닫으면 메인 스트림도 함께 닫힌다
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void ex04() {
	
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex04.txt");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		// 메인과 보조를 생성하는거는 이 구문으로 외워버리기
			bw.write("안녕하세요 방예림 입니다\n");
			bw.write("\n");
			bw.write("안녕하세요 \n방예림 입니다");
			
			System.out.println("ex04.txt 파일이 생성되었다!");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void ex05() {
		
		/*
		 	PrintWriter
		 	1. print(), println() 메소드를 지원하는 writer이다
		 	2. 줄바꿈이 자주 필요한 경우에 println() 메소드 사용을 위해서 사용한다
		 	
		 	
		 */
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex05.txt");
		
		PrintWriter out = null;
		
		try {
			
			out = new PrintWriter(file);
			
			// 자동 줄바꿈이 사용되는 println 메소드
			out.println("안녕하세요");
			out.println("반갑습니다");

			System.out.println("ex05.txt 파일이 생성되었습니다");

		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}



	}

	public static void main(String[] args) {
		ex05();
		
	}

}



















