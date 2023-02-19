package practice_if;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

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
			if (f != s && s != f) {      // 셋중가장 큰 값 구하기...
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
}
