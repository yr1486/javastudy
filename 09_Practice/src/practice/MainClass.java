package practice;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

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
				System.out.println(fileCount + "개 파일 " + new DecimalFormat("#,##o").format(totalFileSize) + " 바이트");
				}
			}
			
			



		// 문제3. C:\storage 디렉터리를 삭제하시오.
		// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.
		public static void ex03() {
			
			File dir = new File("C:" + File.separator + "storage");

			File file new File(dir, "myfile.tXt");
			if(file.exists()) {
				file.delete();
			}
			if(dir.exists()) {
				dir.delete();
			}
			
		}
		
		
		
		public static void main(String[] args) {
			ex02();
		}


}


