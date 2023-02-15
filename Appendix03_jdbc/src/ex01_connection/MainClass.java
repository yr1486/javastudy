package ex01_connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainClass {

	public static void ex01() {
		
		// 클래를 로드하는 방법 (메모리에 로드한다 : 사용하겠다)
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // oracle.jdbc.driver.OriclDriver 도 가능
			System.out.println(" 클래스가 로드되었습니다");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
		
		
	}
	
	public static void ex03() {
		
		BufferedReader reader = null;
		Connection con = null;
		
		try {
			
			// 프로퍼티 파일을 읽는 문자 입력 스트림 생성하기
			reader = new BufferedReader(new FileReader("db.properties"));
			
			// 프로퍼티 파일을 읽어서 프로퍼티 객체 생성하기
			Properties properties = new Properties();
			properties.load(reader);
			
			// 프로퍼티 객체에 저장된 각  Property 읽기 => user, password
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			
			// DriverManager로부터 Connection 객체 얻기
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB에 접속되었습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args) {
		
		//ex01();
		ex03();
		
	}

}





