package practice_for_while;

import java.util.Scanner;

public class MMM {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[20];
		arr[0] = 1;
		arr[1] = 1;
		
		// i=index // 인덱스는 2부터.
		// 피보나치 수열.
		for(int i=2; i<arr.length; i++) {
			//int n = sc.nextInt();
			arr[i] = arr[i-1] + arr[i-2];
		}
		// 먼저 초기화를 해주고 출력은 따로. 
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		

	}

}

		
/*
 피보나치 수열 : 
1	
1		i 			배열에먼저 집어넣기.

	   2-1        2-2
// arr[i-1] + arr[i-2]
2	
3		
5		
8
13
21
34
 
 */
 