package practice_array;

import java.util.Scanner;

public class MainClass {

	public static void ex01() {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[100];

		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();

		}

		int count = 0;
		int a = sc.nextInt();


		for(int i=0; i<n; i++) {
			if(a == arr[i]) {
				count++;
			}


		}
		System.out.print(count);


	}
	
	public static void ex02() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();


		int[] arr = new int[10000]; //공간만 만들어졌어 


		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}

		for(int i=0; i<n; i++) {
			if(x > arr[i]) {
				System.out.print(arr[i] + " ");


			}
		}

	}
	
	public static void ex03() {
		

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int arr[] = new int[1000000];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			// 값을 저장해야하는데 for문으로 배열을 돌리면 차례대로 값이 넣어지니까. 
			
		}
		
		int max = -1000000;
		int min = 1000000;
		
		for(int i=0; i<n; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
			if(min > arr[i]) {
				min = arr[i];
			}
			
		}
		System.out.print(min + " " + max);
		
	}
	public static void ex04() {
		
		Scanner sc = new Scanner(System.in);
		
		boolean arr[] = new boolean[30]; // 집 생김.
		
		
		for(int i=0; i<30; i++) {
			arr[i] = false;			
		}
		
		for(int i = 0; i < 28; i++) {
			int temp = sc.nextInt();
			arr[temp - 1] = true;
		}
		
		for (int i = 0; i < 30; i++) {
			if (arr[i] == false)
				System.out.println(i+1);
			// i는 인덱스. i가 몇번째 위치인지 보는거니까 +1
		}
		
	}
	public static void ex05() {
		
	}
	public static void ex06() {
		
	}


	public static void main(String[] args) {
		ex01();
	}

}
