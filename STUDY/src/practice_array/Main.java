package practice_array;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		
		for(int i=0; i<size; i++) {
			for(int ss=0; ss<(size-i); ss++) {
				System.out.print("-");
			}
			for(int j=0; j<(i*2)+1; j++) {
				System.out.print("*");
				// 별이 1,3,5,7... 규칙이 있어
				// i가 인덱스니까 +1 해줘야 1,3,5 로 똑바로 나와.
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
}
