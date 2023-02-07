package ex03_api; 


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	public static void ex01() {
		
		/*
		한국환경공단_에어코리아_대기오염정보 : 시도별 실시간 측정정보 조회
		1. 서비스 URL : http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty
		2. 요청 변수(Request Parameter)
			1) serviceKey : 인증키
			2) returnType : xml 또는 json
			3) sidoName : 시도 이름
	*/
		
		String serviceKey = "DLjEGtKd0aG9T74nl2maZRl/blGjHeobRhUq0XPHXjKETff59wf/SvKbgvSLtNHqpc+MlmuKNQ46v51Q46bL7g==";
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
			
			url = new URL(sbURL.toString()); // 스트링 빌더선언해서 더한 객체들을 다 담아줬음 
			con = (HttpURLConnection) url.openConnection(); //  길을 뚫어줌 . 값을 거기서 받 오려면 . 메소드가 필요함. 둘의 메소드를 둘다 쓰기위해서 둘을 연결해줬음 
			
			con.setRequestMethod("GET"); // 우리는 읽어들이기만 하면 되니까 get 을 씀 / 호스트는 수정하고 업데이트하는 방식.
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) { // 200과 같은 코드 
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close(); // 리더는 읽어만 주는 거니 클로즈 
			con.disconnect(); // 
			
			
			// 제이슨 명칭 : 원래는 프로퍼티와 밸류라고 함 근데, 맵구조로 만든거기때문에 맵이랑 똑같은 키랑 밸류로 많이씀!! obj.get("response") 오브젝트로부터 가지고오시오 리스펀스를. 근데 이거 안됨 ==> 캐스팅해야함 ==>(JSONObject)obj.get("response")
			// 이거말고 두번째 방법 obj.getJSONObject !! 방법 2개있는거 돌아가서 다시 복습하기 // (캐스팅할필요없이 전용메소드로)
			System.out.println(sb.toString());
			
			JSONObject obj = new JSONObject(sb.toString());
			
			JSONObject body = obj.getJSONObject("response").getJSONObject("body"); // 리스펀 대괄호 값과 바디의 값을 출력하는.. 기호 같은..
			
			JSONArray items = body.getJSONArray("items");  // 배열만 담을 수 있으니까.
			
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i); // 여기서도 방법 2가지 겟을 쓰면 앞에다가 캐스팅하기, 아니면 타입자체를 겟타입으로
				// System.out.println((i + 1) + "--" + item);
				String stationName = item.getString("stationName");
				String pm10Value = item.getString("pm10Value");
				String o3Value = item.getString("o3Value");
				System.out.println(stationName + " : 미세먼지 - " + pm10Value + ", 오존농도 - " + o3Value);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void ex02() {
		
		/*
		한국환경공단_에어코리아_대기오염정보 : 시도별 실시간 측정정보 조회
		1. 서비스 URL : http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth
		2. 요청 변수(Request Parameter)
			1) serviceKey : 인증키
			2) returnType : xml 또는 json
			3) searchDate : 통보시간 검색
	*/
	
		
		String serviceKey = "DLjEGtKd0aG9T74nl2maZRl/blGjHeobRhUq0XPHXjKETff59wf/SvKbgvSLtNHqpc+MlmuKNQ46v51Q46bL7g==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&searchDate=2023-01-30");
			
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
			
			JSONArray items = new JSONObject(sb.toString())
								.getJSONObject("response")
								.getJSONObject("body")
								.getJSONArray("items");
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				System.out.println(item.getString("frcstOneDt") + " : " + item.getString("frcstOneCn"));
				System.out.println(item.getString("frcstTwoDt") + " : " + item.getString("frcstTwoCn"));
				System.out.println(item.getString("frcstThreeDt") + " : " + item.getString("frcstThreeCn"));
				System.out.println(item.getString("frcstFourDt") + " : " + item.getString("frcstFourCn"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ex01();
	}


}
















