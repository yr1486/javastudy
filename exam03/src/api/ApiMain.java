package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;



public class ApiMain {
	/*
	 - 상세구현

	- 1) 2021년 서울특별시 금천구의 사망교통사고정보를 모두 조회한다.

	- 2) 조회된 결과를 이용해서 accident.txt 파일을 생성한다. 파일의 경로는 작성하지 않는다. 예시 File file = new File("accident.txt");

	- 3) 다음 값을 저장할 수 있는 Accident 클래스를 생성한다.

	        String occrrncDt;  // 발생월일시 (2019011622)

	        String occrrncDayCd;  // 발생요일코드 (4)

	        int dthDnvCnt;  // 사망자수 (0)

	        int injpsnCnt;  // 부상자수 (1)

	- 4) 조회된 사고 1건의 정보는 Accident 객체에 저장한다. 조회된 사고 건수만큼 Accident 객체를 생성한다.

	- 5) 생성된 모든 Accident 객체를 컬렉션 ArrayList에 모두 저장한다.

	 */
	
	public static void ex01() {
		
		String serviceKey = "DLjEGtKd0aG9T74nl2maZRl/blGjHeobRhUq0XPHXjKETff59wf/SvKbgvSLtNHqpc+MlmuKNQ46v51Q46bL7g==";
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath";
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			String sidoName = "1100";
			String guGun = "1125";
			String seachYear = "2021";
			String numOfRows = "10";
			String pageNo = "1";
			
			StringBuilder sbURL = new StringBuilder();
			
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8"));
			sbURL.append("&guGun" + URLEncoder.encode(guGun, "UTF-8"));
			sbURL.append("&seachYear" + URLEncoder.encode(seachYear, "UTF-8"));
			sbURL.append("&numOfRows" + URLEncoder.encode(numOfRows, "UTF-8"));
			sbURL.append("&pageNo" + URLEncoder.encode(pageNo, "UTF-8"));
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		
			
			
			
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close(); 
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		ex01();
	

	}
	
}





















