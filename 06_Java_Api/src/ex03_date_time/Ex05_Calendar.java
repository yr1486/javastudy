package ex03_date_time;

import java.util.Calendar;

public class Ex05_Calendar {

	public static void main(String[] args) {

		/*
		 	java.util.Calendar
		 	1. 현재 날짜 또는 특정 날짜를 생성할 수 있다
		 	2. 날짜의 구성 요소 (년 , 월 , 일 . .)를 쉽게 가져다 사용할 수 있다
		 	
		 */
		
		// 현재 날짜
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		
		// 년 , 월 , 일 , 요일 가져오기
		int year = now.get(Calendar.YEAR); // 필드값 1을 넣으면 년도를 가지고 오는 숫자다 // now.get(1)과 동일하게 동작함
		int month = now.get(Calendar.MONTH) + 1; // +1안하면 0값이나옴 , 월(0~11) 주의가 필요함
		int day = now.get(Calendar.DAY_OF_MONTH);
		int weekNo = now.get(Calendar.DAY_OF_WEEK); // 일- 1 , 월 - 2, 화 - 3 ...토 - 7
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		// System.out.println(weekNo); // 화요일
		
		// 화요일 배열로 출력해보기
		
		String[] week = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println(week[weekNo - 1] + "요일"); // 위 3이 나오는 화요일을 한글 '화요일'로 출력 해보기

	
		// 오전/오후, 시, 분, 초
		int ampm = now.get(Calendar.AM_PM); // 오전(0), 오후(1)
		int hour12 = now.get(Calendar.HOUR); // 시(0~11)
		int hour24 = now.get(Calendar.HOUR_OF_DAY); // 시(0~23)
		int minute = now.get(Calendar.MINUTE); // 분(0~59)
		int second = now.get(Calendar.SECOND); // 초(0~50)
		
		System.out.println(ampm);
		System.out.println(hour12);
		System.out.println(hour24);
		System.out.println(minute);
		System.out.println(second);
	
		// 날짜/시간 변경
		now.add(Calendar.DATE, 1); // 1일 후
		//  now.add(Calendar.HOUR, -3); // 3시간 전
	
	
	}

}
