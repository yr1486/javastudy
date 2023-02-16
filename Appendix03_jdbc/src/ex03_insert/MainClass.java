package ex03_insert;




// 이 버전으로 공부하기!!!  ??? 물음표 쓰는걸로!!


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {
		// 상수처리할떄 중요한 부분
	
		// 행이 삽입되면 1이 반환. 안되면 0이 반환됨
		// dml 처리용 ps.executeUdate(); 
	
	
		// 상수 삽입
		public static void ex01() {
			
			Connection con = null; //접속을 위해서 필요한 코드들
			PreparedStatement ps = null;
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				
				Properties p = new Properties();
				p.load(new BufferedReader(new FileReader("db.properties")));
				
				//String url = p.getProperty("url");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";

				con = DriverManager.getConnection(url, p);
				
				// insert 했는데 커밋을 안했어. 근데 실행이 됐어. 왜냐. jdbc는 auto커밋이라서.
				// sql에서는 수동커밋이라 계속 해줘야 된다.
				// con.setAutoCommit(false); ==> 이거하면 계속해줘야함...! 오토로가자. 쉅시간에 안쓸거임.
				
				
				String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
				sql += " VALUES(MEMBER_SEQ.NEXTVAL, 'admin', '관리자', '서울', TO_DATE('2023-02-15', 'YYYY-MM-DD'))";
				
				ps = con.prepareStatement(sql);
				
				int insResult = ps.executeUpdate();
				
				System.out.println(insResult  + "개의 행이 삽입되었습니다."); // 성공 1 실패 0
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
				try {
					if(ps != null) ps.close();
					if(con != null) con.close(); // 나중에 만든거 먼저 닫기.
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
			
		}
		// 변수 삽입
		public static void ex02() {
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				
				Properties p = new Properties();
				p.load(new BufferedReader(new FileReader("db.properties")));
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				con = DriverManager.getConnection(url, p);
				
				String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
				sql += " VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
				
				ps = con.prepareStatement(sql);
				String id = "master";
				String name = "운영자";
				String address = "경기";
				
				ps.setString(1, id); // 1번째 물음표(?) 자리에 id를 넣으란 말임.
				ps.setString(2, name);
				ps.setString(3, address);
				// setInt 도 되고 값에 따라서 달라짐!!!!
				
		
				
				
				
				int insResult = ps.executeUpdate();
				System.out.println(insResult + "개의 행이 삽입되었습니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(ps != null) ps.close();
					if(con != null) con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	
		public static void ex03() {
			
			//admin이 작성한 임의의 게시글을 삽입해보자
			
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				
				Class.forName("oracle.jdbc.OracleDriver");
				Properties p = new Properties();
				p.load(new BufferedReader(new FileReader("db.properties")));
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				con = DriverManager.getConnection(url, p);
				
				String sql = "INSERT INTO BOARD_TABLE(BOARD_NO,MEMBER_NO, TITLE, CONTENT, CREATE_DATE)";
				sql += " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
				
				ps = con.prepareStatement(sql);
				
				int memberNo = 1;
				String title = "오늘은 목요일";
				String content = "보충은 취소되었소";
				
				ps.setInt(1, memberNo);
				ps.setString(2, title);
				ps.setString(3, content);
				
				int insResult = ps.executeUpdate();
				
				System.out.println(insResult + "개의 행이 삽입되었습니다");
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
			
			try {
				if(ps != null) ps.close();
				if(con != null) ps.close();
		
			}catch(Exception e) {
				e.printStackTrace();
			}

			}

		}

	public static void main(String[] args) {
		ex03();
	}

}
