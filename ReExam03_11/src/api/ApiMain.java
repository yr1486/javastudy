package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class ApiMain {

	// 1. 제일 먼저 빌드패스 해주기!! JSON
	public static void main(String[] args) {
		// api : 웹기반 데이터 반환 시스템이며, 데이터베이스나 서버로 쉽게 접근할 수 있도록 수많은 함수들을 관리하는 코드이다.
		// json 객체들을 나타내는 데이터 대표적인 표현기법.
		
		try {
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "aplication/xml");
			
			BufferedReader reader = null;
			
				if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
																			// 읽어들이는데바이트임.
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				
			}
			String line = null; 
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {  // 문자를다읽으면NULL이라뜸. = 끝까지 읽어
				sb.append(line);
			}
			reader.close();
			con.disconnect();
			
			
			// 응답데이터(xml) 확인
			// System.out.println(sb.toString());
			
			// 응답데이터(xml) 를 json 데이터로 변환하기
			JSONObject obj = XML.toJSONObject(sb.toString());
			// System.out.println(obj);
			
			// pubDate 조회
			String pubDate = obj.getJSONObject("rss")
													.getJSONObject("channel")
													.getString("pubDate");
			System.out.println(pubDate);
			
			
			// category 조회
			String category = obj.getJSONObject("rss")
													.getJSONObject("channel")
													.getJSONObject("item")
													.getString("category");
			System.out.println(category);
			
			// data 속성에 저장된 날씨 배열 가져오기
			JSONArray dataList = obj.getJSONObject("rss")
													.getJSONObject("channel")
													.getJSONObject("item")
													.getJSONObject("description")
													.getJSONObject("body")
													.getJSONArray("data");
			
			// 순회
			for(int i = 0; i < dataList.length(); i++) {
				JSONObject data = dataList.getJSONObject(i);
				System.out.println(data.getInt("temp"));
				System.out.println(data.getString("wfKor"));
				System.out.println(data.getInt("hour"));
			}
			
			// 결과 파일 만들기
			BufferedWriter writer = new BufferedWriter(new FileWriter("weather.txt"));
			writer.write(pubDate + "\n");
			writer.write(category + "\n");
			writer.close();
			// 경로지정안하면 프로젝트에 텍스트파일이 생김 
			// 목록을 파일에 누적??? 이게 뭐지.. => 서술형 20점 나옴..
			
			// 서술형1문제!!
			// DTO 에 대해서 아는대로 서술하시오
			// Data Transfer Object
			// 전송을 위한 객체 데이터를 보내기 위한 객체
			// dto 는 bean의 다른말,
			// 데이터베이스에서 읽어드린 정보를 하나의 객체로.?
			// 반대로도 가능함.
			//////////
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

