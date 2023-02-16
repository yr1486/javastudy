package practice02;

import java.util.Scanner;


public class Main {
   public static void main(String[] args) {
      
    
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
}

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



