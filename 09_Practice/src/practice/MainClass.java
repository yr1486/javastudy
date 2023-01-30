package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainClass {

	public static void ex01() {

		// 문제1. 현재 시간을 이용하여 디렉터리를 생성하시오
		// 예시 ) C:\14\31\01

		//Calendar now = Calendar.getInstance();

		//int hour = now.get(Calendar.HOUR);
		//int minute = now.get(Calendar.MINUTE);
		//int second = now.get(Calendar.SECOND);
		// 날짜 가져오는거는 프로젝트06_ex03에서 EX05,06정도 

		LocalTime now = LocalTime.now();

		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();

		String sep = File.separator;
		File dir = new File("C:" + sep + hour + sep + minute + sep + second);

		if(dir.exists() == false) {
			dir.mkdir();

		}

	}

	public static void ex02() {

		// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.

		/*
			2023-01-04  오후 02:19    <DIR>          bin
			2023-01-04  오후 02:19    <DIR>          conf
			2023-01-04  오후 02:19    <DIR>          include
			2023-01-04  오후 02:19    <DIR>          jmods
			2023-01-04  오후 02:19    <DIR>          legal
			2023-01-04  오후 02:19    <DIR>          lib
			2023-01-04  오후 02:19               160 README.html
			2023-01-04  오후 02:19             1,302 release
			               2개 파일               1,462 바이트
		 */

		String sep = File.separator;
		File dir = new File("C:" + sep + "Program Files" + sep + "Java" + sep + "jdk-11.0.17");

		if(dir.exists()) {

			File[] list = dir.listFiles();

			int fileCount = 0;
			long totalFileSize = 0;

			for(File file : list) {
				if(file.isHidden()) {
					continue; // 컨티뉴는 실행에서 제외한다는 뜻

				}
				String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd  a hh:mm").format(file.lastModified()); // 날짜 생성
				String directory = file.isDirectory() ? "<DIR>" : "" ;
				String size = "";
				if(file.isFile()) {
					long length = file.length();
					size = new DecimalFormat("#,##o").format(length); //파일의 크기는 렝스로 구한다 //삼항연산자
					fileCount++;
					totalFileSize += file.length();
				}
				String name = file.getName();
				String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name); //%이거 공부하려고 하지마 안쓰여...!! 그냥 수업에서만 
				System.out.print(result);

			}
			System.out.println();
			System.out.println(fileCount + "개 파일 " + new DecimalFormat("#,##0").format(totalFileSize) + " 바이트");
		}
	}

	public static void ex03() {

		// 문제3. C:\storage 디렉터리를 삭제하시오.
		// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.

		File dir = new File("C:" + File.separator + "storage");

		/*
		 	
		File file = new File(dir, "myfile.tXt");
		if(file.exists()) {
			file.delete();
		}
		 */
		
		// 이건 저장된 모든 파일을 지운다는 코드입니다.(디렉터리는 없다는 가정이요.)
		File[] files = dir.listFiles();
		if(files != null) {			
			for(File file : files) {
				if(file.isFile()) {
					file.delete();
				}
			}
		}
		if(dir.exists()) {
			dir.delete();
		}

	}

	public static void ex04() {

		// 문제4. 사용자로부터 입력 받은 문자열을 C:\storage\diary.txt 파일로 보내시오
		// 총 5개 문장을 입력 받아서 보내시오.

		Scanner sc = new Scanner(System.in);


		String[] stc = new String[5];
		System.out.println("5문장을 입력하세요 >>> ");
		for(int i = 0; i < stc.length; i++) {
			stc[i] = sc.nextLine();
		}

		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}

		File file = new File(dir,"diary.txt");

		try(PrintWriter out = new PrintWriter(file)) {

			for(int i = 0; i < stc.length; i++) {
				out.println(stc[i]);

			}

			System.out.println("diary 파일이 생성되었다.");

		} catch(IOException e) {
			e.printStackTrace();
		}

		sc.close(); //스캐너의 클로즈

	}

	public static void ex05() {
		// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생 시간을 저장한 C:\storage\log.txt 파일을 생성하시오.
		// C:\ storage \ log.txt
		// 2023-01-26 12:08:30 / by zero

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("첫번째 정수를 입력하세요 >>> ");
			int number1 = sc.nextInt();

			System.out.println("두번째 정수를 입력하세요 >>> ");
			int number2 = sc.nextInt();


			int add = number1 + number2;
			int sub = number1 - number2;
			int mul = number1 * number2;
			int div = number1 / number2;

			System.out.println(number1 + "+" + number2 + "=" + add);
			System.out.println(number1 + "-" + number2 + "=" + sub);
			System.out.println(number1 + "*" + number2 + "=" + mul);
			System.out.println(number1 + "/" + number2 + "=" + div);

			sc.close();


		} catch(Exception e) { // 익셉션으로 받아야 정수입력 안했을때, 0으로 나눴을때

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String dateTime = dtf.format(now);

			// 예외 클래스 이름
			String className = e.getClass().getName();

			// 예외 메세지
			String message = e.getMessage();

			// 로그 파일 만들기
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdir();
			}
			File file = new File(dir, "log.txt");

			// 생성 모드(언제나 새로 만든다) new FileWriter(file)
			// 추가 모드(기존 내용에 추가한다) new fileWriter(file, true)
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

				bw.write(dateTime + " " + className + " " + message + "\n");
				// bw.newLine(); ==> \n 을 대신할 수 있는 코드

				System.out.println("예외 메세지가 log.txt 파일에 기록되었습니다");

			} catch(IOException e2) {
				e2.printStackTrace();
			}
		}
	}	
	
	public static void ex06() {
		
		// 문제6
		// C:\storage\diary.txt 파일을 C:\storage2\diary.txt 파일로 이동하시오.
		// 이동에 소요된 시간을 출력하시오
		
		
		File from = new File("C:" + File.separator + "storage", "diary.txt");		
		
		File toDir = new File("C:" + File.separator + "storage2");
		if(toDir.exists() == false) {
			toDir.mkdirs();
		}
		File to = new File(toDir, from.getName());
		
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			long startTime = System.currentTimeMillis();

			br = new BufferedReader(new FileReader(from));
			bw = new BufferedWriter(new FileWriter(to));
			
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			br.close();
			
			if(from.length() == to.length()) {  // 복사 성공했다면 삭제
				from.deleteOnExit();
			}

			long stopTime = System.currentTimeMillis();
			
			System.out.println("이동에 걸린 시간 : " + (stopTime - startTime) + "밀리초");
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void ex07() {
		// 문제7. System.in은 키보드로부터 바이트 데이터를 입력 받는 InputStream이다.
		// System.in으로부터 문장 1개를 입력 받아서 출력하시오
		// Scanner 대신 BufferedReader를 사용하시오
		// 바이트스트림을 문자 스트림으로 바꿔야함
		
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new InputStreamReader(System.in)); // 괄호안에 파일간의 연결이 아닌 키보드와 연결을 하는거임 어려운게 아님 
				//키보드가 들어오는데이터가 문자로 바끼고 속도가 향상된다!! ==> 괄호부터니까 괄호부터 밖으로 해석하기
				// InputStreamReader 인풋스트림을 리더로 바꿔주는애
				System.out.println(" 문장 입력 >>> ");
				String sentence = br.readLine(); // 리드라인 메소드 역할 찾아보기

				System.out.println("입력된 문장 : " + sentence);
				
				// 파일의 정보를 읽어들일때 스캐너로 읽어 들일 수 있다
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
				try {
					if(br != null) {
						br.close();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
		}

	}

	public static void ex08() {
		// 문제8. 키보드로부터 하나의 문장을 입력 받은 뒤 C:\storage\ex08.txt 파일에 출력하시오
		// Scanner와 DataOutputStream을 사용하시오
		
		Scanner sc = new Scanner(System.in);
		DataOutputStream dos = null;
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(new File("C:" + File.separator + "storage", "ex08.txt")));
		
			System.out.println("문장 입력 >>> ");
			String sentence = sc.nextLine();

			dos.writeUTF(sentence);
			
			sc.close();
		
	}catch(IOException e) {
		e.printStackTrace();
		
	}
		
	}
	
	public static void ex09() {
		// 문제9. C:\GDJ61\installer\eclipse-jee-2021-03-R-win32-x86_64.zip 파일을
		// C:\storage\eclipse.zip 로 복사하시오
		
		// 읽어들이기 불러오기 from to를 잘 활용해보자.
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		ex09();

	}
}
























