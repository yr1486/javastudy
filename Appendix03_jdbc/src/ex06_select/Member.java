package ex06_select;

import java.sql.Date;

// 셀렉트 여러 정보를 하나의 객체로 저장하려고 지금 공부하는 거임.

// 셀렉트 한줄당 멤버 객체 1개.
// 셀렉트 여러줄 멤버 객체 여러개.

public class Member {

	// 필드는 테이블의 칼럼과 1:1로 매칭한다.
	private int member_no;
	private String id;
	private String name;
	private String address;
	private Date join_date;
	// 변수 이름 주의 할 점 : mNo
	
	// 생성자는 혹시 몰라서 2개 만들어논거. 상황에 따라서 멀쓸지 모르니까 2개 준비.
	public Member() {}

	public Member(int member_no, String id, String name, String address, Date join_date) {
		super();
		this.member_no = member_no;
		this.id = id;
		this.name = name;
		this.address = address;
		this.join_date = join_date;
	}
	
//----------------------------------------------
	
	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	// system.out으로 '''''출력''''하려고 만들어놓는거임.
	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", id=" + id + ", name=" + name + ", address=" + address
				+ ", join_date=" + join_date + "]";
	}
	
	
	
	
	
	
}
