package practice_for_while;

import java.util.Scanner;

public class MainClass {

	public static void ex01() { // 정수 하나를 입력받아 입력 받은 값까지 순서대로 출력하는 프로그램.

	/*	
		[문제1_예제 입력]
		3

		[문제1_예제 출력]
		1
		2
		3
	 */	
		Scanner s = new Scanner(System.in);
		int user = s.nextInt();
		
		for(int i = 0; i < user; i++) {
			System.out.println(i+1);
		}
		
	}
	
	public static void ex02() { // 정수 n을 입력받아 해당 숫자를 다음과 같은 형식으로 n번 출력

	/*	
		[문제2_예제 입력 1]
		5

		[문제2_예제 출력 1]
		1. The number is 5
		2. The number is 5
		3. The number is 5
		4. The number is 5
		5. The number is 5
	*/
		Scanner s = new Scanner(System.in);
		int user = s.nextInt();
		
		for(int i = 0; i < user; i++) {
			System.out.println((i + 1) + "." + "The number is " + user);
			
		}
		
		
	}
	
	public static void ex03_1() { // 정수 n을 입력받아 1부터 n까지 짝수의 갯수를 세어 출력하는 프로그램 (n도 포함)

	/*
	[문제3_예제 입력 1]
	3
	
	[문제3_예제 출력 1]
	짝수의 갯수 : 1
	
	[문제3_예제 입력 2]
	10
	
	[문제3_예제 출력 2]
	짝수의 갯수 : 5
	 */
		Scanner s = new Scanner(System.in);
		int user = s.nextInt();
		
		// for문 1부터 입력받은 숫자까지 하나하나씩 검사.
		// for문 안에서 짝수인지 아닌지 검사 if로
		// 짝수의 갯수를 담아줄 변수가 있어야해. 
		// +1 	해줘야해. 
		//	count ++;
		
		for(int i=0; i<user; i++) {
			
		}
		
		
		
		
		
		
		
		
		
			if(user % 2 == 0) {
				int result = user / 2;
				System.out.println("짝수의 갯수 : " + result);
			}
			else {
				System.out.println("잘못 입력 하셨습니다.");
			}


		
	}
		
	public static void ex03_2() {
		
		Scanner s = new Scanner(System.in);
		int user = s.nextInt();
		
		int result = user / 2; 
		
			//for(int i=0; i<user; i++) {
			
			//}
			System.out.println("짝수의 갯수 : " + result);
		
	}
	
	public static void ex04() {	// 구구
		/*
		 --[문제4]--
<beakjoon : 구구단 >
https://www.acmicpc.net/problem/2739

		 */
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
			for(int j=1; j<10; j++) {
				System.out.println(n + " * " + j + " = " + n*j);
				
			}

		
	}

	public static void ex05() {	// 별찍
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		// 1부터 입력받은 숫자까지 출력 
		for(int i=0; i<size; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
	
	public static void ex06() {	
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i=0; i<t; i++) {
			int A = s.nextInt();
			int B = s.nextInt();
			
			System.out.println(A+B);
		}
		
		
	}
	
	public static void ex07() {	
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		int m = -1; // 
		//T 만큼 숫자받아서 출력 그중에서 최댓값출력 
		for(int i=0; i<t; i++) {
			int A = s.nextInt();
				if(m < A) {
					m = A;
				}
		}
		System.out.println(m);

	
	}

	public static void ex08() {	
		
			Scanner s = new Scanner(System.in);
			int x = s.nextInt();
			int n = s.nextInt();
			int add = 0;
			
			for(int i=0; i<n; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				int result = a*b;
				add += result;
			}
			
			if( x == add) {
				System.out.println("Yes");	
			}
			else {
				System.out.println("No");
			}
		}

	public static void ex09() {	
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i=0; i<t; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			System.out.println("Case #" + (i+1) + ": " + a + " + " + b + " = " + (a+b));
		}
		
	}
	
	public static void ex10() {	// 별찍기 
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int ss=1; ss<n-i; ss++) { // +1씩 증가하는 친구가 i니까 !!!!! i활용 
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public static void ex11() {	// 더하기계산기&별찍기&종료 
		/*
		프로그램을 시작하면 다음과 같은 메뉴가 출력된다.

		[1] 더하기 계산기
		[2] 별찍기
		[3] 종료

		1을 입력하면 더하기 계산기, 2를 입력하면 별찍기, 3을 입력하면 종료가 실행된다.

		더하기 계산기의 경우 두 개의 값을 입력받아 더한 후 출력하고 다시 메뉴를 띄운다.

		별찍기의 경우 하나의 값을 입력받아 입력받은 값만큼 *을 출력한 후 다시 메뉴로 돌아온다.

		3을 입력하면 프로그램을 종료할 것인지 물어보고 값을 하나 받으며, 1을 입력하면 종료, 0을 입력하면 종료를 취소하고 다시 메뉴창으로 돌아간다.
		 */
	      while(true) {
	    	  System.out.println("[1] 더하기 계산기");
	    	  System.out.println("[2] 별찍기");
	    	  System.out.println("[3] 종료");
	    	  
	         Scanner s = new Scanner(System.in);
	         
	         int select = s.nextInt();
	         
	         
	         	if( select == 1 ) {
	        	 System.out.println(" 더하기 계산기 입니다. 두 정수를 입력하세요 ");
	            int add1 = s.nextInt();
	            int add2 = s.nextInt();
	            
	            int add = add1 + add2;
	            
	            System.out.println(add);
	         	}
	         	else if(select == 2) {
	        	 System.out.println("별찍기 입니다 정수를 입력하세요 ");
	            int b = s.nextInt();
	            
	            for(int i = 0; i < b; i++) {
	               System.out.print( "*" );
	                  
	            }
	            System.out.println();
	         	}
	         	else if (select == 3){
	            System.out.println("종료하시겠습니까? 종료 : 1 / 취소 : 0 ");
	            int c = s.nextInt();
	            	if( c == 1 ) {
	               System.out.println("종료");
	               break;
	            	}
	            	else {
	            	System.out.println(" 종료하지 않습니다 ");
	            	}
	         }
	         	else {
	         		System.out.println("잘못 입력 하셨습니다");
	         	}

	      }
	}

	public static void main(String[] args) {
		ex10();
	}

}







