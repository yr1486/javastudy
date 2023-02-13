package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


//String serviceKey = "DLjEGtKd0aG9T74nl2maZRl/blGjHeobRhUq0XPHXjKETff59wf/SvKbgvSLtNHqpc+MlmuKNQ46v51Q46bL7g==";
// 이주소가 맞는지 쉽게 확인하려면 포스트맨 활용하기
// 서비스키에서 인코딩된데이터로 보내주는ㄷ거 기억하기
// 포스트맨에 키와 밸류 직접 입력 /// 다하고 센드 눌러보면 아래에 값 받아오는 지 뜸.

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
		
		// 일단 try catch 문 안에 다 값을 넣는다.
		
		try {
			String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
			// 주소..., 다시 확인해보기 
			
			// 아래처럼 일반화 시켜 놓으면 다른데 가서 복붙해서 쓸수있음..! 실전에서!
			apiURL += "?serviceKey=" + URLEncoder.encode( "DLjEGtKd0aG9T74nl2maZRl/blGjHeobRhUq0XPHXjKETff59wf/SvKbgvSLtNHqpc+MlmuKNQ46v51Q46bL7g==","UTF-8");
			apiURL += "&searchYear=" + URLEncoder.encode("2021", "UTF-8");
			apiURL += "&siDo=" + URLEncoder.encode("1100", "UTF-8");
			apiURL += "&guGun=" + URLEncoder.encode("1125", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("10", "UTF-8");
			apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8");
		
			// URL 객체 생성(API주소의 형식 검증)
			URL url = new URL(apiURL);
			
			// API주소 접속
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			// GET 방식의 요청임을 처리
			con.setRequestMethod("GET");
			
			// 응답 데이터는 "json"임을 처리
			// 웹 상에서 주고 받는 데이터의 타입 : Content-Type
			con.setRequestProperty("Content-Type", "application/json");
			
			// 접속된 API로부터 데이터를 읽어 들일 입력 스트림 생성
			// 1. 정상 스트림과 에러 스트림으로 구분해서 생성
			// 2. API 입력 스트림은 오직 바이트 입력 스트림만 지원하므로 문자 입력 스트림으로 바꾸는 작업이 필요
			// 3. 속도 향상을 위해서 Buffer가 내장된 스트림을 생성
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// BufferedReader는 readLine 메소드를 지원한다.
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			// 이제 API의 응답 데이터는 sb에 저장되어 있다.
			// System.out.println(sb.toString());
			
			//API의 응답 데이터를 분석하기 위해서 JSONbject로 변환한다
			//json 라이브러리 사용을 위해서 Build Path 작업을 수행한다. ==> 우클릭해서 제이슨 불러오기.
			
			//JSONObject obj = new JSONObject(sb.toString());
		//	JSONObject items = obj.getJSONObject("items");
	//	JSONArray itemList = items.getJSONArray("item");
			
			JSONArray itemList = new JSONObject(sb.toString()).getJSONObject("items").getJSONArray("item");
			
			// 리스트는 포문 밖에 있어야 한다 . 
			List<Accident> list = new ArrayList<Accident>();
			
			for(int i = 0; i < itemList.length(); i++) {
				// 응답 데이터엥서 필요한 데이터를 분석 파싱 한다.
				
				JSONObject item = itemList.getJSONObject(i);
				
				String occrrncDt = item.getString("occrrnc_dt");
				String occrrncDayCd = item.getString("occrrnc_day_cd");
				int dthDnvCnt = item.getInt("dth_dnv_cnt");
				int injpsnCnt = item.getInt("injpsn_cnt");
				//==> 이 4개의 정보를 하나로 어떻게 만들거냐, 빈(accident)으로 만들거나,맵으로 만들거나!!!! 아주 중요 
				// ==> 엑시던트 객체로 만들어야 해!!!
				
				// 아래 빈으로 하나의 객체를 만들고 4개의 정보를 담았어 (4개의 정보를 하나의 객체로 관리할 수 있게)
				// 응답 데이터에서 추출한데이터를 하나의 객체(bean)로 만든다.
				Accident accident = new Accident();
				accident.setOccrrncDt(occrrncDt);
				accident.setOccrrncDayCd(occrrncDayCd);
				accident.setDthDnvCnt(dthDnvCnt);
				accident.setInjpsnCnt(injpsnCnt);
				// 객체를 어레이 리스트에 저장하기 
				list.add(accident);
				// ==> 이과정대신 맵으로 만들어도 됨!!
				//List<Map<String, Object>
				
				
				
				//System.out.println(occrrncDt);
				//System.out.println(occrrncDayCd);
				//System.out.println(dthDnvCnt);
				//System.out.println(injpsnCnt);
				//System.out.println("---------");
				
				
			}
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}

	}



public static void main(String[] args) {
	ex01();
	
	
}
}