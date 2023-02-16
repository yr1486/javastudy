package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

		public class CreateTableMainClass {

			public static void main(String[] args) {

				
				// Connection 생성  모든 작업의 시작!
				// 모든DB 작업에는 jar 필요
				
				Connection con = null;
				
				try {
					// 오라클 드라이버 로
					Class.forName("oracle.jdbc.OracleDriver"); // 이름으로 클래스 호출하기, 왠쪽 패키지에서 라이브러리 열어서 경로로도 볼수있어!! 외우면좋음 . 
					//얘의 예외는? 클래스낫파운드. 빌드패스 안잡거나, 오타나거나. 
					
					
					// 프로퍼티 파일 읽어서 프로퍼티 객체 생성
					Properties p = new Properties();
					p.load(new BufferedReader(new FileReader("db.properties")));
					
					//프로퍼티 객체에저장된 각 프로퍼티(속성) 가져오기
					String url = p.getProperty("url");
					String user = p.getProperty("user");
					String password = p.getProperty("password");
					
					// Connection 생성
					con = DriverManager.getConnection(url, user, password);
					
					System.out.println("접속되었습니다");
					
				} catch(Exception e) {
					e.printStackTrace();
				}

		/*
		  	2. 쿼리문 작성 및 실행
		  	PreparedStatemenet 인터페이스
		  	
		  	1. Prepared : 미리준비하시오 
		  	2. Statement : 쿼리문을 
		  	3. 작성된 커리문을 전달하면 해당 쿼리문을 실행해 주는 역할을 수행한다
		  	4. Statement 인터페이스는 보안 문제로 사용하지 않는 것이 좋다 --구글링해서 나오는 정보 걸러내기..! 사용안하는게 좋음
		 
		 */
				
			/*
				SELECT * FROM ID = 변수 AND PW = 변수;
				아이디에 입력한 값 : 'aaa' --
				비밀번호에 입력한 값 : aaa 
				
				SELECT * FROM ID = 'aaa' -- AND PW = aaa;
				
			
			*/
			
			
			// 주의!! JDBC 에서는 쿼리문의 마지막에 세미콜론(;)을 붙이지 않는다.
				
			StringBuilder sb = new StringBuilder();
			sb.append("CREATE TABLE MEMBER_TBL (");
			sb.append("MEMBER_NO NUMBER NOT NULL CONSTRAINT PK_MEMBER PRIMARY KEY");
			sb.append(", ID VARCHAR2(30 BYTE) NOT NULL UNIQUE");
			sb.append(", NAME VARCHAR2(30 BYTE) NOT NULL");
			sb.append(", ADDRESS VARCHAR2(30 BYTE)");
			sb.append(", JOIN_DATE DATE NOT NULL)");

			String sql = sb.toString();
			PreparedStatement ps = null;
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
		



			}
			
		}