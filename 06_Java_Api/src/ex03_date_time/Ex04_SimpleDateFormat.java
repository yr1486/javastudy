package ex03_date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04_SimpleDateFormat {

	public static void main(String[] args) {
		
		/*
			형식
			1. yy	: 23
			2. yyyy : 2023
			3. M	: 1
			4. MM	: 01
			5. MMM	: 1월 // 너네 나라에 맞는 월을 써라, 잘 안씀
			6. d	: 7
			7. dd	: 07
			8. E	: 화
			9. a	: 오후
			10. h	: 2 (1~12)
			11. hh	: 02 (01~12)
			12. H	: 2	(0~23)
			13. HH	: 14 (00~23)
			14. m	: 8 (0~59)
			15. mm	: 08 (00~59)
			16. s	: 3 (0~59)
			17. ss 	: 03 (00~59)
			
			2023.01.03.18:11
			yyyy.MM.dd.HH:mm

		 	
		 */

		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String strNow = sdf.format(now);
		System.out.println(strNow);
		//꼭, simpleDa할때 컨트롤 스페이스 자동완성으로 값을 넣기
		
		
		
	}

}
