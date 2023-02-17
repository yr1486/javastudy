package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import dto.ContactDTO;

/*
 	DAO
 	1. Database Access Object
 	2. Database에 접근해서 쿼리문을 실행하고 쿼리문의 실행 결과를 받아온다 (jdbc코드가 dao에 모임)
 	3. 여러 객체가 만들어 지지 않도록 singleton 패턴으로 생성한다
 	
 */
// singleton => 지금 여기서 프라이빗으로 외부에서 new 생성자 생성을 막았기 때문에 생성자를 get으로 불러와야함
// 참고 빈 프로젝트- 3번 패키지 참고
public class ContactDAO {

	/******************1. singleton*********************/
	private static ContactDAO dao = new ContactDAO();
	private ContactDAO() {}
	
	// 생성자를 외부에서 못만드니까. 외부에서 생성자를 사용할 수 있게 해주는 메소드 : getInstance메소드!
	public static ContactDAO getInstance() {
		return dao;
	}
	
	//public void 목록보기() {}


	/******************2. field *********************/
	// 해당 클래스가 가지는 메소드들이 공동으로 사용할 값을 필드로 선언.
	// ContactDAO 클래스의 메소드들이 공통으로 사용할 요소를 선언한다.
	private Connection con; // 필드에 한번 선언해서 모든 메소드가 가져다 쓰게. // 데이터베이스접속
	private PreparedStatement ps; //쿼리문 실행하는 애
	private ResultSet rs; // 셀렉 결과 처리하는애
	private String sql; // 쿼리문 자체
	private int res; //실행결과는 int값. 한개가 삽입됐다. // insert,update,delete결과
	
	/******************3. method *********************/
	// CRUD
	//CREATE(=INSERT얘기하는거임), READ(=SELECT얘기하는거임), UPDATE, DELETE
	// CRUD란, DB기본 작업이다.
	
	// CRUD 메소드의 진행 순서 : Connection 얻기 > CRUD 작업 > 사용한 자원 반납
	// 화장실갈때 키갖고!!! 갖다와서 키반납하고!!
	// 어제 연습했던 코드들을 메소드로 만들거임!!!!
	// 사용한 자원 반납 : rs,con,ps.close() 이거

	
	// 공통 메소드 - 1 (Connection 얻기)
	private Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			con = DriverManager.getConnection(p.getProperty("url"), p);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	

	// 공통 메소드 - 2 (사용한 자원 반납)
	private void close()	 {
		
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// CRUD 메소드 - 1 (연락처 추가하기)
	// 1. 반환값 : 0(실패), 또는 1(성공)
	// 2. 매개변수 : ContactDTO contact 객체에는 연락처정보(name,tel,email,address) 모두 저장되어 있다.
	
	//dao 하는일이 연락처집어넣고 답이오면 또 넘겨주려고 하는거
	// 반환타입이 int 인거 기억하기!!!
	public int insertContact(ContactDTO contact) { // ContactDTO에 다 들어있음.. 네임.. 이메일 ..  모든 정보가 다 들어있다고 생각하기.(contact에)
		
		// ps => 쿼리문 실행객체
		// 익스큐트업데이트로 실행
		// int로받아와
		// ??? -> 값이 변하는 변수라 ? 처리
		// ps.setString , setInt이용해서 값을 채워넣고
		
		try {
			
			// 위에 다만들어놨으니 호출하자.
			con = getConnection();
			// 쿼리문 집어넣자.
			sql = "INSERT INTO CONTACT_TBL(CONTACT_NO, NAME, TEL, EMAIL, ADDRESS) VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?)";
			//쿼리문실행객체 PS만들고 sql 넣기(쿼리에 변수값 채우기)
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName()); // 1번물음표에 컨텍트객체에 저장된 겟네임(네임값 불러오기)
			ps.setString(2, contact.getTel()); 
			ps.setString(3, contact.getEmail()); 
			ps.setString(4, contact.getAddress()); 
			
			res = ps.executeUpdate(); // ps의 실행결과
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	
		return res; // 서비스로 넘겨서 그다음 작업 할 수 있게
	
		// 여기까지 insert담당하는 DAO 완성
	
	}
	
	
}



















