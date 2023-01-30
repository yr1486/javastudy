package ex05_InputStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import ex04_OutputStream.Person;

public class MainClass {
	
	public static void ex01() {
		
		File file = new File("C:" + File.separator + "storage", "ex01.bin");
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream(file);
			
			//입력단위
			//1. int : 1개
			//2. byte[] : 2개 이상
			
			int c = 0;
			StringBuilder sb = new StringBuilder();
			
			
			while((c = fis.read()) != -1) {
				sb.append((char)c);
				
			}
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void ex02() {
		
		// 원래 깨져서 출력되는 코드들 ( 바이트 스트림과 한글처리의 문제 확인하는 용도)
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin");
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			
			byte[] b = new byte[4]; // 이게 3으로 설정한다고 제대로 읽어오는게 아님. 왜냐, 한글로만 작성된 문서는 없어, 띄어쓰기도 있자나? 그럼 오류가 나지유
			// 4로 변경해서 돌리면 그이유를 알수 있음 ==> 안�����세요
			int readByte = 0; // 실제로 4바이트를 못읽을수도 있으니까 실제로 읽은 바이트를 저장해 둘수 있음
			// 한번에 4바이트 읽을건데 4바이트 미만이 남아있으면 실제 읽은거를 기록을 해주는 변수로 저 코드 두줄이 같이 쓰여야한당
			StringBuilder sb = new StringBuilder();
			
			while((readByte = fis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte));
			}
				System.out.println(sb.toString()); // 배열 b의 인덱스 0부터 readByte개 데이터를 사용한다. 4바이트읽었다면 4개 3바이트읽었다면 3개 사용한다는 뜻
				
				// 저번에는 겟바이츠스트링 했는데
				// 반대로 읽어들일때는 뉴스트링
				// 이거 만들었던 코드.. 지웠음 while(true)로 진행했을때 가능한 코드 내용..
				
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex02_complete() {
		
		// ex02 해결 버전
		
		// 스트림을 하나 더쓰면 됨!! // 모든 글자를 제대로 읽을수 있는건 Reader뿐임!!
		
		//읽어들어는 스트림이 바이터스트림이기때문에 리더를 그냥 쓸수없어. 바꿔줘야해
		// 바이트 입력 스트림을 문자 입력 스트림으로 변환하는 InputStreamReader
		
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin");
		
		InputStreamReader isr = null;
		//fis = new FileInputStream(file); // 바이트 기반 스트림
		//isr = new InputStreamReader(fis); // 문자 기반 스트림
		
		try {
			isr = new InputStreamReader(new FileInputStream(file)); // 문자 기반 스트림
			
			char[] cbuf = new char[4]; // 한번에 4글자를 읽어오시오
			int readCount = 0; // 실제로 읽은 글자수를 저장해 두시오
			StringBuilder sb = new StringBuilder();
			
			while((readCount = isr.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}
				System.out.println(sb.toString()); // 배열 cbuf의 인덱스 0부터 
				
				// 저번에는 겟바이츠스트링 했는데
				// 반대로 읽어들일때는 뉴스트링
				// 이거 만들었던 코드.. 지웠음 while(true)로 진행했을때 가능한 코드 내용..
				
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isr != null) {
					isr.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex03() {
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		BufferedInputStream bis = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(file));
			
			byte[] b = new byte[4];
			int readByte = 0;
			StringBuilder sb = new StringBuilder();
			
			while((readByte = bis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte));
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) {
					bis.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		// 버퍼를 껴도 속도만 빨리질뿐 깨지는건 동일함!!!! 이걸 보려고 해본거임 
	}
	
	public static void ex03_complete() {
		
		// ex03 해결 버전
		// 버퍼를 써서 해결 해보기
		// 버퍼 기반으로 읽기
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file))); // 바이트 인풋 버퍼씌우기
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = br.readLine()) != null) {
				sb.append(line + "\n"); // 한줄씩 차곡차곡
			}
				System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	public static void ex04() {
		
		//String name, int age, 
		
		File file = new File("C:" + File.separator + "storage", "ex04.dat");
		DataInputStream dis = null;
		
		try {
			
			dis = new DataInputStream(new FileInputStream(file));
			
			// 입력 (변수 타입에 따라서 메소드가 다름)
			String name = dis.readUTF(); // writeUTF에 대응
			int age = dis.readInt();	// writeInt
			double height = dis.readDouble();	//writeDouble 
			boolean isAlive = dis.readBoolean();	//readBoolean 대응
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(height);
			System.out.println(isAlive);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(dis != null) {
					dis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex05() {
		
		//Person의 객체가 3개 저장되어 있는 (List<Person> 2개, Person 1개) ex05.dat 파일
		
		File file = new File("C:" + File.separator + "storage", "ex05.dat");
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 입력
			// readObject 메소드는 Object를 반환하므로 적절하게 캐스팅 해야 한다
			
			@SuppressWarnings("unchecked")
			List<Person> people = (List<Person>)ois.readObject();
			Person person = (Person)ois.readObject();
			
			System.out.println(people);
			System.out.println(person);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) {
					ois.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ex05();
	}

}




















