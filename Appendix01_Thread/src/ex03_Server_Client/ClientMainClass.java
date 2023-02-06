package ex03_Server_Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;





public class ClientMainClass {

	public static void main(String[] args) {
		
		Socket socket = null;
		//클라이언트가 서버쪽으로 보내는
		BufferedWriter writer = null; // 서버로 텍스트를 보내는 출력 스트림
		Scanner sc = null;
		
		try {
			
			
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9090)); // 서버 주소는 localhost이고 포트번호는 9090이다
			
			// socket 정보를 이용하는 클라이언트를 스레드로 생성
			
			Client client = new Client(socket); // localhost:9090 서버로 연결할 수있는 socket
			client.start();
			
			
			sc = new Scanner(System.in);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));	
			
			while(true) {
				System.out.println( ">>> ");
				String message = sc.nextLine(); //채팅내용을 입력
				writer.write(message + "\n"); //서버가 엔터까지를 입력으로 인식할수있도록 \n
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch(IOException e) {
			e.printStackTrace();
			}


		}

	}
}