package ex02_socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


/*
 	IntputStream : 한글 처리 못한다
 	OutputStream : 한글 처리 못한다
 	
 	==> 방법
 	1. InputStreamReader, OutputStreamWriter로 변환해서 한글 처리하기
	2. DatainputStream의 readUTF, DataOutputStream의 writeUTF로 한글 처리하기
	
	==> 둘 중 하나는 내가 쓸줄 아는 방법으로 만들기
	==> 쌤추천은 1번
 	
 */


public class ServerMainClass {

	public static void main(String[] args) {
		
		// ServerSoket : 서버가 사용하는 Socket
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(); // 트라이문 밖으로 빼면 빨간밋줄이 생겨 그건 예외가 생긴다는거
			// 그래서 트라이문 안에 써줘야하고 IOException 처리가 필요함
			
			// InetSocketAddress : Socket 사용 시 "호스트", "포트번호" 를 관리하는 클래스
			
			InetSocketAddress address = new InetSocketAddress("localhost", 9090);
			serverSocket.bind(address);
			
			// 무한루프로 serverSocket 구성
			while(true) {
				
				System.out.println("[서버] 클라이언트 접속을 기다리고 있습니다.");
				
				// 클라이언트의 접속 요청을 허용
				Socket clientSocket = serverSocket.accept();
				
				// 클라이언트의 접속 확인을 위해서 InetSocketAddress를 활용
				InetSocketAddress clientAddress = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
				System.out.println("[서버] 접속된 클라이언트 : " + clientAddress.getHostName());
				
				// 클라이언트에게 welcome 메시지 보내기
				DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream()); //접속한 클라이언트로 데이터를 보내는 출력 스트림
				out.writeUTF("[서버] 어서오세요 환영합니다!"); //writeUTF 메소드를 이용하면 바이트 스트림으로도 한글 깨짐 없이 데이터를 보낼 수 있다
				
				// 클라이언트가 보낸 메세지 확인하기
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String line = null; // 한줄밖에 안보냈지만, 여러줄 가정하에 줄 단위로 읽어온다. 코드를 짜보자
				StringBuilder sb = new StringBuilder();
				while((line = in.readLine()) != null) {
					sb.append(line + "\n");
					System.out.println("[서버]" + sb.toString());
				}
				
				// 스트림 종료
				in.close();
				out.close();
				
				// 클라이언트 접속 종료 (생략 가능)
				clientSocket.close();
			
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
