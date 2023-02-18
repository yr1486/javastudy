package practice_for;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int count = 0; //값을 돌려서 저장할 공간을 만들어야하기때문에 변수 선언하고 초기화.
		while(true) {
			if(n == count) {
				
				int sip = n / 10;
				int il = sip % 10;
				count = sip + il;
				
			}
			break;
		
			
		
			
			
			
		}

		
	}
	
}
