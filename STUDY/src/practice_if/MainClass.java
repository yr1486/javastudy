package practice_if;

import java.util.Scanner;

public class MainClass {

	public static void ex01() { // 백준 알람시계 2884
		
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt(); // 상근 
	
		
		if(m < 45) {
			h--;   // h = h-1;
			//m = 60 - (45-m);
			m +=15;      // m = m+15;
			System.out.println(h + " " + m);
		}
		else {
			System.out.println(h + " " + (m-45));
		
		}
	}
		
	
	public static void ex02() { // 백준 오븐시계 2525
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		while(true) {
			int cook = sc.nextInt();
			
			if(cook > 60) {
				h++;
				m = (m+cook)-60;
				System.out.println();
			}
			else {
				System.out.println();
			}
		}
		
		
	}
	
	public static void ex03() { // 백준 주사위 세개 2480

	Scanner sc = new Scanner(System.in);
	int f = sc.nextInt();
	int s = sc.nextInt();
	int t = sc.nextInt();
	
	while(true) {
		if(f == s && s == t) {
			System.out.println(10000+(f*1000));
		}
		else if(f == s && s != t || f != s && s == t) {
			System.out.println(1000+(f*100));
		}
		else {      // 셋중가장 큰 값 구하기...
			int m = 0;
			//f = 1 s = 5 t = 3
			if(m<f) {
				m = f;
			}
			if(m<s) {
				m = s;
			}
			if(m<t) {
				m = t;
			}
			System.out.println(m*100);
		}
		break;
	}
}

	public static void main(String[] args) {
		ex03();
	}

}
