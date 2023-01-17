package ex02_filed;

public class MainClass {
	
	public static void main(String[] args) {
		
		// school 객체 생성
		School school = new School();
		
		school.name = "철산초"; // 변수의 초기화
		school.students = new Student[3]; // 배열의 이름: school.students
		
		for(int i = 0; i < school.students.length; i++) {
			
			// Student 객체 생성
			school.students[i] = new Student(); // 학생 한명 한명을 만드는 작업, 세명 만드려면 3번을 생성해야함
			
			school.students[i].stuNo = "10101";
			school.students[i].name = "정숙";
			
			// score 객체 생성
			school.students[i].score = new Score();
			
			school.students[i].score.kor = 100;
			school.students[i].score.eng = 90;
			school.students[i].score.math = 80;
		
		System.out.println("학변 : " + school.students[i].name);
		System.out.println("학번 : " + school.students[i].stuNo);
		System.out.println("국어 : " + school.students[i].score.kor);
		System.out.println("영어 : " + school.students[i].score.eng);
		System.out.println("수학 : " + school.students[i].score.math);
		
		
		}
	}
}
