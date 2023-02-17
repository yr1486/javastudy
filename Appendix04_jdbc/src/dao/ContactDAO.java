package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
	
	
	// CRUD 메소드 - 2 (연락처 삭제하기)
	// 1. 반환값 : 0 실패 , 또는 1 성공
	// 2. 매개변수 : int contact_no 변수에는 삭제할 연락처의 고유 번호가 저장되어 있다.
	public int deleteContact(int contact_no) {
		
		try {
			
			con = getConnection();
			sql = "DELETE FROM COTACT_TBL WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			res = ps.executeUpdate(); // ps 결과 받아오기
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
		
		// 삭제 DAO 완성..
	}

	// CRUD 메소드 - 3 (이름을 이용한 연락처 조회하기)
	// 1. 반환값 : List<ContactDTO>
	// 2. 매개변수 : String name 변수에는 조회할 연락처의 이름이 저장되어 있다
	public List<ContactDTO> selectContactsByName(String name) { // 여러개 반환할거임
		
		List<ContactDTO> contactList = new ArrayList<ContactDTO>();
		
		try {
			
			con = getConnection();
			sql =  "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE NAME = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			// 실행하자
			rs = ps.executeQuery(); // rs는 한번에 한줄밖에 처리못함 여러개하면 반복문 이용해야함
			
			while(rs.next()) { // 조회결과가 있으면
				// rs는 행단위로 처리한다.
				ContactDTO contact = new ContactDTO();
				contact.setContact_no(rs.getInt("CONTACT_NO"));
				contact.setName(rs.getString("name"));
				contact.setTel(rs.getString("TEL"));
				contact.setEmail(rs.getString("EMAIL"));
				contact.setAddress(rs.getString("ADDRESS"));
				// 칼럼에 명을 직접 입력해서 가져오는 방법.
				// 위에서 한줄씩 바꿔서
				contactList.add(contact); // 어레이리스트에 저장.
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return contactList; 
	}
	
	// CRUD 메소드 - 4 (연락처 수정하기)
	// 1. 반환값 : 0(실패), 또는 1(성공)
	// 2. 매개변수 : ContactDTO contact 객체에는 연락처정보(name,tel,email,address) 모두 저장되어 있다.
	
	public int updateContact(ContactDTO contact) {
		
		try {
			
			con = getConnection();
			sql =  "UPDATE CONTACT_TBL";
			sql += "   SET NAME = ?, TEL = ?, EMAIL = ?, ADDRESS = ?";
			sql += " WHERE CONTACT_NO = ?";
				// 웨얼에 띄어쓰기 꼭 해주기
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName()); // 컨텍에 들어가있ㄴ는거 이해하기
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			ps.setInt(5, contact.getContact_no());
			
			res = ps.executeUpdate();
			
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	
	// CRUD 메소드 - 5 (연락처 No를 이용한 연락처 조회하기)
	// 1. 반환값 	: ContactDTO
	// 2. 매개변수 : int contact_no 변수에는 조회할 연락처의 고유 번호가 저장되어 있다
	public ContactDTO selectContactByNo(int contact_no) {
		
		ContactDTO contact = null; // new가 아닌 null임을 알아야함
		
		try {
			con = getConnection();
			sql =  "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, contact_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {// 결과가 1개니까 while이 아닌 if임
				contact = new ContactDTO();
				contact.setContact_no(contact_no);
				contact.setName(rs.getString(2));
				contact.setTel(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setAddress(rs.getString(5));
				// 칼럼에 명을 숫자로 입력해서 가져오는 방법.
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return contact; // 처음만들때와 동시에 같이 코드 만들어 놓기.
		
		
	}
	
	// CRUD 메소드 - 6 (전체 연락처 연락처 조회하기)
	// 1. 반환값 : List<ContactDTO>
	// 2. 매개변수 : 없음 
	// 위에 메소드 3번에서 조금만 번형하면 전체 연락처조회를 만들 수 있다.
	public List<ContactDTO> selectsAllContacts() {
		
		List<ContactDTO> contactList = new ArrayList<ContactDTO>();
		
		try {
			
			con = getConnection();
			sql =  "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " ORDER BY CONTACT_NO DESC";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); // rs는 한번에 한줄밖에 처리못함 여러개하면 반복문 이용해야함
			
			while(rs.next()) { // 조회결과가 있으면
				// rs는 행단위로 처리한다.
				ContactDTO contact = new ContactDTO();
				contact.setContact_no(rs.getInt("CONTACT_NO"));
				contact.setName(rs.getString("name"));
				contact.setTel(rs.getString("TEL"));
				contact.setEmail(rs.getString("EMAIL"));
				contact.setAddress(rs.getString("ADDRESS"));
				// 칼럼에 명을 직접 입력해서 가져오는 방법.
				// 위에서 한줄씩 바꿔서
				contactList.add(contact); // 어레이리스트에 저장.
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return contactList; 
	}
	
	
	
	
	
	
	
}



















