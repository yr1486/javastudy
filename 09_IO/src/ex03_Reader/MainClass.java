package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {
	
	/*
	 	Reader
	 	1. '문자' 기반의 입력 스트림이다
	 	2. Reader로 끝나는 이름의 클래스는 모두, 문자 기반의 입력 스트림이다 ==> 글자를 읽어 들이는
	 	3. 문자를 읽어 들이는 스트림이다. (파일의 내용을 읽는다. 서버가 보낸 내용을 읽는다 등등
	 	
 */
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex01.txt");
		
		FileReader fr = null;
		
		
		try {
			
			fr = new FileReader(file);
			
			// int c = fr.read(); // fr로부터 글자를 하나 읽어 오시오. 한글자만.
			// c = fr.read(); 쭉 계속 호출해서 i am a boy이후까지 코드를 넣게되면 다 읽고 난후에는 더이상 읽을게 없어서 -1을 반환함
			// 자 이걸 for문으로 바꿔보자.
			
			int c; // 1글자를 저장할 변수
			
			
			// 스트링 빌더부터 싹다 코드 외우기
			StringBuilder sb = new StringBuilder();
			while((c = fr.read()) != -1) { // -1이 아.니.면 계속!! ==> 통째로 외우기 while(())
				sb.append((char)c);
			}
			
			System.out.println(sb.toString());
			/* 위에 코드를 풀어쓴건데 참고만 하고 위에 코드를 외우기.
			while(true) {
				c = fr.read();
				if(c == -1) {
					break;	
				}
				System.out.println((char)c);
			 */
			
			System.out.println(c); // 73 ==> 대문자 i의 값임 아스키 코드~~~~~ 인트로저장해서~~~ 캐릭터로저장안대 입출력의 약속임
		//	System.out.println((char)c); // 73으로 받았지만 난 char값으로 보고싶다고 하면 앞에 형변환을 해주면 됨 
			
		} catch(IOException e) { //0 원래는 읽어들이는 파일이 없으면? 하고 예외 코드를 해줘야하는데 fileNotFoundException!! 근디 얘의 부모가 io익셉션임, io로 처리가능 적어줄거믄 둘다 적어도 됨 1번 파일낫 2번 io로
			e.printStackTrace();
		} finally { // fr 클로즈 해야 하니까
			try {
				if(fr != null) {
					fr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		File file = new File(dir, "ex02.txt");
		
		FileReader fr = null;
		
		try {
		
		char[] cbuf = new char[5]; // 5글자를 읽어 들이는 배열
		int readCount = 0; // 첫시작이니까 읽은 글자가 없다  그러니 0
		StringBuilder sb = new StringBuilder();
		
		while((readCount = fr.read(cbuf)) != -1) {
			
			sb.append(cbuf, 0, readCount); // 인덱스 0부터 readCount개 글자를 sb에 추가하시오. 첫번째 루프에서는 5글자, 두번째루프에서는 2글자저장하는거.
			// ex02.txt 읽는 과정
			// 루프	readCount	 cbuf
			// 1	5			a b c d e
			// 2	2			f g c d e
			// 3 	-1

			//for(int i = 0; i < readCount; i++) { // 리드카운트라고 적은거는
			//	System.out.println(cbuf[i]);
			//}

		} // while

		System.out.println(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void ex03() {
		
		// 예제 1,2번은 하나씩 읽어들이는거고
		// 이제 한 줄씩 읽어들이는 방법을 알아보자
		
		// BufferedWriter의 반대
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		File file = new File(dir, "ex03.txt");
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			char[] cbuf = new char[5];
			int readCount = 0;
			StringBuilder sb = new StringBuilder();
			
			while((readCount = br.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}
			
			System.out.println(sb.toString()); // 와일문 끝나고 넣기
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void ex04() { // 버퍼리더 ==> 제일 권장문! 익히기
		/*
		 	BufferedReader의 장점
		 	1. 속도가 빠르다
		 	2. readLine메소드를 사용할 수 있다
		 */
	
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		File file = new File(dir, "ex02.txt");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file)); // 파일리더와 버퍼리더를 한줄로 생성.
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}			
			System.out.println(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

		
	public static void main(String[] args) {
		ex04();
	}

}













