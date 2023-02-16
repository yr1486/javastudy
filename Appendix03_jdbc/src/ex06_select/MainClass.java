package ex06_select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class MainClass {

	//select 결과 행이 1개인 경우
	
	public static void ex01() {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		//다 작성한 후 추가한 애
		ResultSet rs = null; // 결과집합. 셀렉트결과
		// 오직 SELECT문에서만 사용한다
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
			// 아래.. 자꾸 빼먹는 문구.. 조심하기
			con = DriverManager.getConnection(url, p);
			
			String sql = "SELECT MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE";
			sql += " FROM MEMBER_TBL";
			sql += " WHERE MEMBER_NO = ?";
			// 한줄로 만들면 되는데 쌤이 보여줄라고 3줄로 쪼갬
			
			ps = con.prepareStatement(sql);
			
			int memberNo = 1;
			ps.setInt(1, memberNo);
			
			rs = ps.executeQuery(); // SELECT문 실행 메소드
			
			//System.out.println(rs.next()); // 첫번째 결과 행이 있으면 true, 없으면 false
			//System.out.println(rs.next()); // 두번째 결과 행이 있으면 true, 없으면 false
			//System.out.println(rs.next());
			
			Member member = null; // 멤버가 널이면 조회된 결과가 없었다는 의미가 된다.
			
			// 결과 행이 최대 1개 있으므로 if문으로 분기 처리
			if(rs.next()) {
				// Member 객체 선언
				
				// 결과 행의 각 칼럼 정보를 읽어서 Member 객체 만들기
				member = new Member();
				member.setMember_no(rs.getInt("MEMBER_NO"));
				member.setId(rs.getString("ID"));
				member.setName(rs.getString("NAME"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setJoin_date(rs.getDate("JOIN_DATE"));
				
				//결과 행의 각 칼럼 정보 읽기
				
			}
			/*
			 	| MEMBER_NO |  ID   |  NAME  |  ADDRESS   |  JOIN_DATE | 최초 rs가 가리키는 위치 : 없음
			 	|     1     | admin |  관리자	 |    서울     |   23/02/15 | <-첫 번째 rs.next() 호출한 경우 , 한번에 한줄씩 조회할수 있어,전체를 한번에 조회할수 없어, 그래서 셀렉트의 결과가 몇개냐에 따라서 코드가 달라지는 거임
			 	|     2     | master|  운영자	 |    경기     |   23/02/16 | <-두 번째 rs.next() 호출한 경우
			 															<-세 번쨰 rs.next() 호출한 경우 결과가 없으므로 false가 반환 
			 	1. ResultSet rs 객체는 하나의 행(Row)을 가리키는 포인터 역할이다.
			 	2. next 메소드를 통해서 각 행(Row)을 가리킬 수 있다.
			 		1) next 메소드를 1번 호출하면 SELECT 전체 결과 중 1행을 가리킨다.
			 		2) next 메소드를 2번 호출하면 SELECT 전체 결과 중 2행을 가리킨다.
			 	3. next 메소드의 호출 결과는 boolean이다.
			 		1) 조회된 결과 행이 있으면 true가 반환된다.
			 		2) 조회된 결과 행이 없으면 false가 반환된다.
			 		
			 	4. 결과 행의 칼럼 정보 가져오는 방법
			 		1) 칼럼의 이름을 그대로 사용한다
			 			rs.getInt("MEMBER_NO")
			 			rs.getString("ID")
			 			rs.getString("NAME")
			 			rs.getString("ADDRESS")
			 			rs.getDate("JOIN_DATE")
			 		2) 결과 행의 칼럼 순서대로 번호를 붙여서 사용한다.
			 			rs.getInt(1)
			 			rs.getString(2)
			 			rs.getString(3)
			 			rs.getString(4)
			 			rs.getDate(5)
			 */
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void ex02() {
	// rs를 이용한 셀렉트 목록 가져오기 ==> 어레이리스트 준비하고 객체 만들어서 집어넣고 와일문 돌리고!!!!!
		
	// select 결과 행이 2개 이상인 경우
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		
		Properties p = new Properties();
		p.load(new BufferedReader(new FileReader("db.properties")));
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
		// 아래.. 자꾸 빼먹는 문구.. 조심하기
		con = DriverManager.getConnection(url, p);
		
		sql = "SELECT MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE";
		sql += " FROM MEMBER_TBL";
		// 전체 결과를 조회하겠다는 뜻.
		
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery(); // SELECT문 실행 메소드
		
		// 결과 행이 여러 개 있으므로 ArrayList 를 준비한다
		List<Member> memberList = new ArrayList<Member>();
		
		Member member = new Member();
		//member.setMember_no(rs.getInt("MEMBER_NO");
		// 이런식으로 넣어줘도 됨
		
		//memberList.add(new Member) 해서 만들어줘도 됨
		//만드는 방법 2가지
		
		// 결과 행이 여러 개 있으므로 while문으로 분기 처리
		while(rs.next()) {
			
			// 결과 행의 각 칼럼 정보를 읽어서 Member 객체 만들기
			member = new Member();
			member.setMember_no(rs.getInt("MEMBER_NO"));
			member.setId(rs.getString("ID"));
			member.setName(rs.getString("NAME"));
			member.setAddress(rs.getString("ADDRESS"));
			member.setJoin_date(rs.getDate("JOIN_DATE"));
			
			//멤버 객체를 어레이리스트에 저장하기
			memberList.add(member); // 한줄저장
			
			
			
		}
		
		// while 문이 종료된 뒤, ArrayList의 크기가 0이라면 조회된 결과가 없었다는 의미가 된다
		
		for(int i=0; i<memberList.size(); i++) {
			System.out.println(memberList.get(i)); // 하나씩가져온다 겟 i
			
		}
		/*
		 	| MEMBER_NO |  ID   |  NAME  |  ADDRESS   |  JOIN_DATE | 최초 rs가 가리키는 위치 : 없음
		 	|     1     | admin |  관리자	 |    서울     |   23/02/15 | <-첫 번째 rs.next() 호출한 경우 , 한번에 한줄씩 조회할수 있어,전체를 한번에 조회할수 없어, 그래서 셀렉트의 결과가 몇개냐에 따라서 코드가 달라지는 거임
		 	|     2     | master|  운영자	 |    경기     |   23/02/16 | <-두 번째 rs.next() 호출한 경우
		 															<-세 번쨰 rs.next() 호출한 경우 결과가 없으므로 false가 반환 
		 	1. ResultSet rs 객체는 하나의 행(Row)을 가리키는 포인터 역할이다.
		 	2. next 메소드를 통해서 각 행(Row)을 가리킬 수 있다.
		 		1) next 메소드를 1번 호출하면 SELECT 전체 결과 중 1행을 가리킨다.
		 		2) next 메소드를 2번 호출하면 SELECT 전체 결과 중 2행을 가리킨다.
		 	3. next 메소드의 호출 결과는 boolean이다.
		 		1) 조회된 결과 행이 있으면 true가 반환된다.
		 		2) 조회된 결과 행이 없으면 false가 반환된다.
		 		
		 	4. 결과 행의 칼럼 정보 가져오는 방법
		 		1) 칼럼의 이름을 그대로 사용한다
		 			rs.getInt("MEMBER_NO")
		 			rs.getString("ID")
		 			rs.getString("NAME")
		 			rs.getString("ADDRESS")
		 			rs.getDate("JOIN_DATE")
		 		2) 결과 행의 칼럼 순서대로 번호를 붙여서 사용한다.
		 			rs.getInt(1)
		 			rs.getString(2)
		 			rs.getString(3)
		 			rs.getString(4)
		 			rs.getDate(5)
		 */
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
