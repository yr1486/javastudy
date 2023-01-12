package ex03_constructor;

public class Alba extends Student {
	
	//필드
	private String company;

	// 생성자          //생성자와 getter, setter 손으로 쓰지 않기!!! 소스메뉴에서 불러오기
	// 소스에서 코드 불러오기 :  source > generate constructor ~ feild > String(string~) > generate 클릭, 소스코드에 getter,setter 선택
	public Alba(String name, String school, String company) {
		super(name, school);
		this.company = company;
	}

	// 메소드
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	

}
