package practice_for_while;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { //더하기 싸이클
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int count = 0;
		
		while(true) {
			int sip = n / 10;
			int il = n % 10;

			count += sip + il;
			if(n == count) {
			
			}break;
			
		}

	}

}
