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

				Scanner sc = new Scanner(System.in);
				
				int arrEng[] = new int[10];
				boolean arrKor[] = new boolean[10];
				
				for(int i=0; i<10; i++) {
					arrEng[i] = sc.nextInt();
				}
				

				for(int i=0; i<10; i++) {
					int temp = sc.nextInt();
					// 시험에 응시한 학생 배열에 대입하기 위해 값을 변수에 임시 저장
					if(temp == 1) {
						arrKor[i] = true;
					}
					
					else {
						arrKor[i] = false;
						// 인덱스의 값으로 temp가 오면 0,1 = 첫번째자리,두번째자리밖에 못오는 상황
						// i이용해서 채워줘야해.
					}
				}
				
				for(int i=0; i<10; i++) {
					if(arrKor[i] == true && arrEng[i] > 80) {
						System.out.print(i + " ");
						
					}
				} 
				
	}
	/*
	 10명의 학생의 영어 성적과 한국사 시험 응시 유무를 순서대로 입력받는다.

	<영어 성적이 80점 이상이고 한국사 시험을 본 학생들의> 학번을 순서대로 출력한다.


	학번 : 인덱스. 인덱스+1

	예제 입력 1
	10
	78
	90
	99
	100
	65
	85
	20
	57
	100
	1
	1
	0
	1
	1
	0
	0
	0
	0
	0

	예제 출력 1
	3 4
	 */




	public static void ex06() {
		
	}


	public static void main(String[] args) {
		ex01();
	}

}
