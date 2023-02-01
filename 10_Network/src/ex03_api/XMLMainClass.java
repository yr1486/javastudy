package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;


public class XMLMainClass {
	
	public static void ex01() {
		/*
			한국공항공사_항공기 운항정보 : 공항 코드 정보
			1. 서비스 URL : http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty
			2. 요청 변수(Request Parameter)
				1) serviceKey : 내 인증키 ===> 홈페이지에 대문자S로 나와있는데!!잘못나와있음!!!!!소문자로 쓰기

		 */
		
		String serviceKey = "DLjEGtKd0aG9T74nl2maZRl%2FblGjHeobRhUq0XPHXjKETff59wf%2FSvKbgvSLtNHqpc%2BMlmuKNQ46v51Q46bL7g%3D%3D";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			String sidoName = "서울";
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8"));
			
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
			
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject body = obj.getJSONObject("response").getJSONObject("body");
			JSONArray items = body.getJSONArray("items");
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				String stationName = item.getString("stationName");
				String pm10Value = item.getString("pm10Value");
				String o3Value = item.getString("o3Value");
				System.out.println(stationName + " : 미세먼지 " + pm10Value + ", 오존농도 " + o3Value);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
		
		/*
		한국공항공사_항공기 운항정보 : 국제선 운항 스케줄
		1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
		2. 요청 변수(Request Parameter)
			1) serviceKey : 인증키 ===> 홈페이지에 대문자S로 나와있는데!!잘못나와있음!!!!!소문자로 쓰기
			2) pageNo : 페이지번호
			3) pageNo1 : 조회할 페이지 번호
			4) 검색일자
	*/
	

	String serviceKey = "DLjEGtKd0aG9T74nl2maZRl/blGjHeobRhUq0XPHXjKETff59wf/SvKbgvSLtNHqpc+MlmuKNQ46v51Q46bL7g=="; //정보포털에서 내 디코딩 고유번호
	String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
	
	URL url = null;
	HttpURLConnection con = null;
	
	BufferedReader reader = null; // 1차 이후 스트림 씌우기 부분
	
	BufferedWriter writer = null;
	
	try {
		
		apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
		//두번째 파라미터붙일때는 & 이 붙음
		apiURL += "&pageNo=1";
		apiURL += "&schDate=20230201";
		apiURL += "&schDeptCityCode=ICN";
		apiURL += "schArryvCityCode=JDK";
		url = new URL(apiURL);
		con = (HttpURLConnection) url.openConnection();
	
		// 겟방식
		con.setRequestMethod("GET"); //겟은 반드시 대문자로 적기
		// 정보포털에서 다운받는게 XML이니까 이거 방식
		con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); //Content-Type ==> 0000-type이 형식임
		
		
		int responseCode = con.getResponseCode();
		// System.out.println(responseCode);
		
		// 스트림 씌우기 부분
		if(responseCode == 200) { //HttpURLConnection.HTTP_OK 이 200을 의미함
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
		
		File file = new File("C:" + File.separator + "storage", "국제선운항스케줄.xml");
		writer = new BufferedWriter(new FileWriter(file));
		writer.write(sb.toString());
		writer.close();
		
		System.out.println("국제선운항스케줄 xml이 생성되었습니다.");
		
	
	} catch(Exception e) {
		e.printStackTrace();

	}
	
		
	}
	
	public static void main(String[] args) {
		ex01();
	}

}












