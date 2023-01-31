package ex04_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;


public class MainClass {
	
	/*
	 	출력 스트림 1,2
	 	1. writer 글자 보내는 타입
	 	int
	 	char[]
	 	String
	 	출력 메소드 : writer
	 	
	 	2. OutputStream 글자 보내는 타입
	 	int
	 	byte[] -128 ~ 127
	 	
	 	출력 메소드 : writer
	 */
	
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		
		File file = new File(dir, "ex01.bin");
		
		FileOutputStream fos = null;
		
		try {
			/*
			  	출력 단위
				1. int : 1개 출력
				2. byte[] : 2개 이상
			 */
			fos = new FileOutputStream(file); // 파일로 보내는 통로를 만들었음 filewriter와 같은 구조, 인트 또는 바이트 배열만 보낼 수 있음
			int c = 'A';
			String str = "pple"; //  FileOutputStream 은 인트아니면 바이트밖에 못보내서
			byte[] b = str.getBytes(); // str을 바이트로 바꿔줄 겟바이트 메소드 호출!!!
			// 이제 c하고 b를 보내면 됨!!
			
			fos.write(c);
			fos.write(b);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos !=null) {
				fos.close();
				} 
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex02.bin");
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			
			String str = "안녕하세요";
			
			//getBytes(Charset charset)을 불러온거
			byte[] b = str.getBytes(StandardCharsets.UTF_8); //유티에프8로 인코딩해서 만들어주세요
			// byte[] b = str.getBytes(); // 예제1번에서 str을 바이트로 바꿔줄 겟바이트 메소드 호출했었는데 여기서는 매개변수로 다른 기능을 한번더 호출한 모습
			
			//getBytes(String charsetName)을 불러오면
			//byte[] b = str.getBytes("UTF_8"); //유티에프8로 인코딩해서 만들어주세요
			
			fos.write(b);
			
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close(); // ==> 모르는 부분 : 파이널리 하고 트라이캐치문이 또 오는 이유는 fos.close(); 이 한문장 때문에!! ==> fos.close(); 이 닫아주는 코드는 트라이 안에 있어야한다.
				}
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("ex02.bin 파일의 크기 : " + file.length() + "바이트");

	}

	public static void ex03() {
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex03.bin");
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream(file)); // ==>괄호안쪽이 먼저 실행되는걸 알기
			bos.write("반갑습니다\n또만나요".getBytes("UTF-8")); // ==> 이건 직접치는거라 오타일 확률도 높아
			//byte[] b = str.getBytes(StandardCharsets.UTF_8); ==> 이건 자동완성이니 이방법으로 쓰자, 단 버전에 따라 다를수도 있으니 주의하기.
			
			//bos를 모두사용한 다음에 bos.close(); 가 여기에 위치 할 수 있음!! 그럼 아래 finally구문 싹-안써도됨!!!!
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ex03.bin 파일의 크기 : " + file.length() + "바이트");
	}
	
	public static void ex04() {
		
		// 변수를 그대로 출력하는 DataOutputStream (==> 보조스트림이라서 혼자는 못쓴다, 버퍼랑 비슷하지?? 메인 만들고 보조만들고)
		
		//한글처리할때 많이 쓰임
		//실제로는 스트링을 많이 주고 받음
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex04.dat"); //파일형식이 달라져도 달라지는건 낫띵.,,..,,
		
		DataOutputStream dos = null;
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(file));
			
			//통로 다만들었으니
			// 변수 준비하자
			// 변수들 내보내기!
			
			String name = "에밀리";
			int age = 30;
			double height = 180.5;
			boolean isAlive = true;
			
			// 출력할 변수(변수 타입에 따라서 메소드가 다름)
			
			dos.writeUTF(name); // "에밀리" 라는 한글을 보낼거니까 한글을 변환해주는 UTF로 네임전달을 해야하는거임!!
			dos.writeInt(age); // 나머지도 리터럴에 따른 롸이트를 잘 설정해주기
			dos.writeDouble(height);
			dos.writeBoolean(isAlive);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex04.bin 파일의 크기 : " + file.length() + "바이트");
	}
	
	public static void ex05() {
		
		// 객체를 그대로 출력하는 ObjectOutputStream
		
		File dir = new File ("C:" + File.separator + "storage");
		File file = new File(dir, "ex05.dat");


		ObjectOutput oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 출력할 객체
			List<Person> people = Arrays.asList(
				new Person("에밀리", 30, 180.5, true),
				new Person("제시카", 35, 190.5, true)
				);
			
			// 출력할 객체
			Person person = new Person();
			person.setName("제임스");
			person.setAge(40);
			person.setHeight(170.5);
			person.setAlive(false);
			
			// 출력
			oos.writeObject(people);
			oos.writeObject(person);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex05.bin 파일의 크기 : " + file.length() + "바이트");
		// java.io.NotSerializableException: ex04_OutputStream.Person
		// 펄슨이 직렬화 되지 않았다. // 일렬로 줄세워서 보내야 한다는 뜻.
		// 직렬화 코드를 알아보자. ==> 펄슨클래스에 작성함!!
		
	}
	
	public static void main(String[] args) {
		ex05();
	}

}



















