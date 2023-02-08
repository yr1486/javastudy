package ex01_internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MainClass {
	// 10번에서 1번 젤 중요, 그담 6번

	/* ====> 시험문제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 아는대로 서술하시오. // 아는대로서술하시오가 몇개 많이 나온댭..
	 	URL 
	 	1. Uniform Resource	Locator
	 	2. 정형화된 자원의 경로
	 	3. 실제로 웹주소를 의미한다
	 	4. 구성
	 	
	 		프로토콜://	호스트		/	서버경로	 ?파라미터=값&파라미터=값&....
	 		https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90
	 		------------------------------------------------------------------------------------------------------------------------
	 		-프로토콜: 	http
	 		-호스트: 		search.naver.com/
	 		-서버경로: 	search.naver?
	 		-파라미터 문장: where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90
	 		-파라미터: 	where=nexearch& 파라미터=값&파라미터=값&
	 					파라미터는 주소 끄트머리에 붙인다 ==> ?(물음표 뒤에 옴)
	 		------------------------------------------------------------------------------------------------------------------------
	 		1) 프로토콜(http): 	통신 규약
	 		   프로토콜s(https): 	http에 secure 보안처리된 하이퍼텍스트 전송 프로토콜
	 		2) 호스트: 			서버의 대표 주소
	 		3) 서버경로: 			URL Mapping(URL Pattern)
	 							서버경로는 개발자가 만든 것
	 		4) 파라미터: 			서버로 보내는 데이터를 의미 (변수라고 생각하면 된다)
	 */
	public static void ex01() {
		
		// 주소가 올바르게 되어있는지 확인할수있는거 ==> 예외처리! try catch
		String apiURL = "https://search.naver.com/search.naver?query=삼성전자";
		URL url = null;
		
		try {
			
			url = new URL(apiURL); // 반드시 예외 처리가 필요한 코드라서 try안에 넣어야함
			
			
			System.out.println("프로토콜 : " + url.getProtocol()); // 프로토콜 : https
			System.out.println("호스트 : " + url.getHost()); //호스트 : search.naver.com
			System.out.println("파라미터 : " + url.getQuery()); //파라미터 : query=삼성전자
			
		
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
			System.out.println("apiURL 주소 오류");
		} 
	}
	
	public static void ex02() {

		// 웹 접속을 담당하는 HttpURLConnection

		String apiURL = "https://search.naver.com";
		URL url = null;
		HttpURLConnection con = null;

		try {

			url = new URL(apiURL); // MalformedURLException 처리가 필요하다
			con = (HttpURLConnection)url.openConnection(); //IOExceptißon 처리가 필요하다

			/*
			 	HTTP 응답 코드 공부하기
				1. 200 : 정상이다
				2. 40X : 400번대는 요청이 잘못되었다, 잘못된 요청 (사용자가 잘못한거) ex) 404 : 사용자가 주소를 잘못입력 했을 경우
				3. 50X : 서버측 오류일때 (서버가 잘못하였음) 우리가 잘못짠거
			 */

			System.out.println("정상 응답 "+ HttpURLConnection.HTTP_OK); // 여기서 HttpURLConnection.HTTP_OK는 숫자 200을 뜻함 걍 아무뜻없음 200임!! 그케 공부하기 까먹지 말기
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND);
			System.out.println("Internal Error :" + HttpURLConnection.HTTP_INTERNAL_ERROR);
			System.out.println();

			//apiURL 접속 확인
			int responseCode = con.getResponseCode(); 
			if(responseCode == 200) { // 200대신 HttpURLConnection.HTTP_OK 써도됨
				System.out.println(apiURL + " 접속 완료"); // https://search.naver.com 접속 완료
			}
			System.out.println();


			// 요청 방식(요청 메소드)
			String requestMethod = con.getRequestMethod();
			System.out.println("요청 방식 : " + requestMethod); // 요청 방식 : GET

			// 컨텐트 타입 ==> 웹상으로 주고받는 데이터의 타입
			String contentType = con.getContentType(); 
			System.out.println("컨텐트 타입 : " + contentType); // 컨텐트 타입 : text/html; charset=UTF-8 // int나 double같은거임 외우기!!!!

			// 요청 헤더
			String userAgent = con.getRequestProperty("User-Agent");
			System.out.println("User-Agent : " + userAgent); // User-Agent : Java/11.0.17

			String referer = con.getRequestProperty("Referer");
			System.out.println("Referer : " + referer); //Referer : null
			// 이전 주소가 나오는 코드
			// null이 나오는거는 우리가 바로 네이버로 가서 이전 주소가 없음
			// 쓰임. 만약 웹툰 볼라고하는데 로그인하라고 나오면 로그인 이후에 그전페이지로 돌아가게 해줘야하니까 이런 코드를 입력함

			// 접속 종료
			con.disconnect(); // 생략해도되지만 적자아.

		}catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			System.out.println("apiURL 접속 오류");
		}



	}

	public static void ex03() { // 연습이 되면 버퍼도 끼워보자,,,, ==> 04번으로!

		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";

		URL url = null;

		HttpURLConnection con = null;

		InputStream in = null; // Daum 로그를 읽어 들이는 입력 스트림

		FileOutputStream out = null; // C:\storage\daum.png로 내보내는 출력 스트림

		try {

			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();

			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {

				in = con.getInputStream();
				out = new FileOutputStream("C:" + File.separator + "storage" + File.separator + "daum.png");

				byte[] b = new byte[10];
				int readByte = 0; // 10바이트라고 했지만 실제로 아닐수있으니까 리드바이트 선언해주기

				while((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte); //내보내시오

				}
				System.out.println("다운로드 완료");

				out.close();
				in.close();
				con.disconnect();

			}

		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}


	}

	public static void ex003() { //위 문제의 버퍼끼우기

		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;

		BufferedInputStream in = null; // Daum 로그를 읽어 들이는 입력 스트림
		BufferedOutputStream out = null; // C:\storage\daum.png로 내보내는 출력 스트림
		File file = new File("C:" + File.separator + "storage" + File.separator + "daum1.png");

		try {

			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();

			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {

				in = new BufferedInputStream(con.getInputStream());
				out = new BufferedOutputStream(new FileOutputStream(file));
				//("C:" + File.separator + "storage" + File.separator + "daum.png");

				byte[] b = new byte[10];
				int readByte = 0; // 10바이트라고 했지만 실제로 아닐수있으니까 리드바이트 선언해주기

				while((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte); //내보내시오

				}
				System.out.println("다운로드 완료");

				out.close();
				in.close();
				con.disconnect();

			}

		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}

	}

	public static void ex04() {

		// 텍스트 다운로드

		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";

		URL url = null;
		HttpURLConnection con = null;

		BufferedReader reader = null;
		BufferedWriter writer = null;
		//InputStreamReader reader = null;
		//파일과 연결하려면 라이터가 필요

		File file = null;
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();

			String message = null;
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				// 커넥션은 리더와 라이더를 제공하지 않는다
				// 바이트입력 스트림을 문자 입력 스트림으로 변환하는 인풋스트림리더를 사용하는 거임
				// 인풋스트림리더 개중요함
				// 글자 내려 받는거!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				file = new File("C:" + File.separator + "storage", "다운로드문서.txt");
				message = "다운로드 성공";


			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				file = new File("C:" + File.separator + "storage", "다운로드문서.txt");
				// 정상 스트림과 에러스트림 각각있서효
				message = "다운로드 실패";

			}

			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[2];
			int readCount = 0;

			while((readCount = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}

			// 이제 라이터로 보내야해

			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());

			writer.close();
			reader.close();
			con.disconnect();

			System.out.println("message");


		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void ex05() {
		/*
	 	인코딩(암호화)	: 원본 데이터를 UTF-8 방식으로 암호화
	 	디코딩(복호화)	: UTF-8 방식으로 암호화된 데이터를 복원

		 */

		String data = "한글 english 12345 !@#$%";

		try {
			//인코딩
			String encodeData = URLEncoder.encode(data, "UTF-8");
			System.out.println(encodeData);

			//디코딩 ==> 보너스 개념, 대충봐
			String decodeData = URLDecoder.decode(encodeData, "UTF-9");



		}catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패"); //%ED%95%9C%EA%B8%80+english+12345+%21%40%23%24%25 ===> 공백자리에 +가 출력됨

		}

	}

	public static void ex06() {
	
	// 1시간마다 갱신되는 전국 날씨 정보
	// storage/sfc_web_map.xml로 다운로드 받기
	String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
	
	URL url = null;
	
	try {
		url = new URL(apiURL);
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getQuery());
		
	}catch(MalformedURLException e) {
		e.printStackTrace();
		System.out.println("주소 오류");
	}
	
	
}

	public static void main(String[] args) {
		ex05();
		
	}

}






















