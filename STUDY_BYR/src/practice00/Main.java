package practice00;

import java.util.Scanner;

public class Main {

	public static void ex01() {
		Scanner s = new Scanner(System.in);
		int user = s.nextInt();
		
		for(int i = 0; i < user; i++) {
			System.out.println(i+1);
		}
	}
	
	public static void ex02() {
		Scanner s = new Scanner(System.in);
		int user = s.nextInt();
		
		for(int i = 0; i < user; i++) {
			System.out.println("The number is " + user);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
