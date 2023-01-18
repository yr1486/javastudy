package ex01_try_catch; // try_catch 예외문

import java.util.Scanner;

public class MainClass {
	
	public static void ex01() {
		
		try {

			String[] season = new String[4];

			season[0] = "spring";
			season[1] = "summer";
			season[2] = "autumn";
			season[3] = "winter"; //winter를 숨겨서 출력해보기
			season[4] = "what??"; // 만약 인덱스를 length를 넘게 설정하였을 경우 아래 catch문 바로 실행 ==>"ArrayIndexOutOfBoundsException 발생"으로 출력값 바꿔주기

			
			for(String str : season) {
				System.out.println(str.substring(0, 3));
			}

			// null 포인트는 부를수 없다
			// 예외처리 코드가 없어도 돌아간다 == 언익셉션
		} catch(Exception e) { // 모든 예외는 Exception으로 처리 가능
			System.out.println("ArrayIndexOutOfBoundsException 발생");
		}
	}

	public static void ex02() {
		
		try {
			
			String input = "1,2,3,,4,5";
			String[]numbers =input.split(",");
			int[] iNumbers = new  int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++) {
				iNumbers[i] = Integer.parseInt(numbers[i]);
				System.out.println(iNumbers[i]);
			}
			
			
			
		} catch (NumberFormatException e) { // // UnChecked Exception이므로 RuntimeException 가능
				System.out.println("NumberFormatException 발생");
		}
		
	}
	
	public static void ex03() {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("덧셈식을 입력하시오(예:1+2 >>");
			String expr = sc.next();
			String[] item = expr.split("[+]");
			int number1 = Integer.parseInt(item[0]);
			int number2 = Integer.parseInt(item[1]);
			System.out.println(number1 + number2);
			sc.close();
					
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("+를 포함해서 입력하세요");
		}  catch(NumberFormatException e) {
			System.out.println("정수 덧셈만 가능합니다");
		} catch(Exception e) { //마지막 catch 블록은 Exception으로 모든 예외를 처리한다
			System.out.println("예외가 발생했습니다");
		}
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
