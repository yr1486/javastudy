package practice05_Employee;

import java.util.Scanner;

// 내가 회사를 차렸고. 직원들의 정보를 한눈에 보고 싶어서 필드랑 메소드를 이것 저것 만들었어
// 하나씩 설명 해볼게


public class Company {

	
	private Employee[] employees; // 내가 고용한 직원들을 담을수 있는 배열을 만들어줬고
	private int idx; // 인덱스는 총 직원의 수를 알아야하니까 필드 설정해주고
	private Scanner sc; // 스캐너 선언해주고.
	
	public Company() { // 이 회사의 생성자를 만들어주고. 필드를 초기화 했는데
		employees = new Employee[5];  // 내 회사는 사원을 최대 5명 고용할 수 있는 회사여서 배열의 길이만. 5로 설정해줬어. 아직 생성전. 
		sc = new Scanner(System.in); // 얘는 뭐 스캐너 초기화 부모클래스에서 생성하면 자식에서도 다 쓸수 있으니까 선언부가 앞인거임.
	}
	
	// 설명 : 그리고 직원을 뽑아야 하는데 최대 5명만 고용할 수있으니까
	// 이걸 에드임플로이 메소드로 만들어서 경우의 수를 모두 담았어.
	
	//이 메소드는
	public void addEmployee() {
		if(idx == employees.length) { // 임플로이즈의 수가 곧 배열의 길이잖아. 그래서 둘이 같아지게 되면. 조건문을 종료하는 메소드를 만들었고.
			System.out.println("더 이상 사원을 고용할 수 없습니다.");
			return; // 설명 : 여기서의 리턴은 실행을 종료한다는 뜻.
		}
		System.out.print("고용 형태 선택(1.정규 2.비정규) >>> "); // 설명 : 위에 이프문이 폴스일때 실행되고 너 정규직이냐 비정규냐 선택값을 받게하고
		String kind = sc.next(); // 설명 : 그값을 카인드에 담아놓기
		System.out.print("신규 사원번호 >>> "); // 사원번호도 입력
		int empNo = sc.nextInt(); // 임플로이넘버에 저장
		System.out.print("신규 사원명 >>> "); // 이름 적게하고
		String name = sc.next(); // 그 값을 네임에 저장
		switch(kind) { // 그다음에 카인드가, 정규 비정규 선택이였으니까, 1번을 입력하거나 한글로 정규를 입력하거나 하면 기본급을 적게하고
		case "1":
		case "정규":
			System.out.print("기본급 >>> ");
			int salary = sc.nextInt(); // 또 그값을 샐러리에 담았어
			employees[idx++] = new Regular(empNo, name, salary); // 그리고 나서 여기서 아까 배열의 길이만 만들어 놨으니까 이 스위치문에서 선언하고
			// 그 인덱스 0에서 4까지 채워넣을 값을? 맞나 , 이 어떤 직원들의 사원번호 이름 급여를 하나의 배열로 묶어서 idx++에 넣어줬어.
			break; // 1번 또는 정규를 선택하면 이제 스위치문 종료해 하고 브레이크 걸어주고 안걸어주면 밑에 까지 실행 되니까
		case "2": // 그리고 만약 2번이나 비정규라고 한글로 쳤을 경우 시급을 적게하고 그 값을 변수하나 맨들어서 값을 담아줬어.
		case "비정규":
			System.out.print("시급 >>> ");
			int hourPay = sc.nextInt();
			Temporary temporary = new Temporary(empNo, name, hourPay); // 여기도 2번 눌렀으면. 템퍼러리 변수에 또 그 알바의 알바번호 이름 시급을 저장해준다음
			employees[idx++] = temporary; // 임플로이에 배열에 변수를 넣어줘. 여기서 원래 배열의 생김새가 {}중괄호 통해서 값을 직접 대입할수도 있고, 이렇게 변수를 넣어줘도 되고. 형식이 다양한 모습... 인거지?
			break; // 그담 디폴트값이 실행되지 않게 여기서 스위치문에 브레이크문을 걸어주기
		default: // 디폴트는 이 위에 케이스가 다 아닌 경우 즉 선택지에 없는 이상한 값을 입력했을때 출력하려고 디폴트에 해당 내용을 출력하게 해놨어. 디폴트 다음에는 끝이니까 브레이크가 안와도 되고.
			System.out.println("잘못된 고용 형태입니다. 다시 시도하세요.");
		}
		System.out.println("사원 등록 완료. 현재 등록된 사원 " + idx + "명"); // 그다음 만들어준 인덱스가 몇개 찼는지 알수 있는 출력문을 만들었어.
	}
	
	// 그리고 이제 인덱스 5개에 채워준 값을 활용할건데. 없을수도있고 삭제할수도 있잖아. 
	public void dropEmployee() {
		if(idx == 0) { // 인덱스의 값이 0일 경우.............를 설정해주고 근데 사실...여기서 헷갈렸는데.. 인덱스 0부터 시작하는데 왜 0이 등록이 없지..하고 조금 막혔어..
			System.out.println("등록된 사원이 없습니다.");
			return;
		}
		System.out.print("삭제할 사원번호 >>> ");
		int empNo = sc.nextInt();
		for(int i = 0; i < idx; i++) { 
			if(empNo == employees[i].getEmpNo()) {
				System.arraycopy(employees, i + 1, employees, i, idx - 1 - i); //임플로이 
				employees[--idx] = null;
				System.out.println("사원 삭제 완료. 현재 등록된 사원 " + idx + "명");
				return;
			}
		}
		System.out.println("사원번호 " + empNo + "인 사원은 존재하지 않습니다.");
	}
	
	public void findEmployee() {
		if(idx == 0) {
			System.out.println("등록된 사원이 없습니다.");
			return;
		}
		System.out.print("조회할 사원번호 >>> ");
		int empNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(empNo == employees[i].getEmpNo()) {
				System.out.println("사원 조회 완료. 조회된 사원 정보");
				employees[i].info(); // 부모가 편하게 갖다 쓰려고.
				System.out.println(); // 
				return;
			}
		}
		System.out.println("사원번호 " + empNo + "인 사원은 존재하지 않습니다.");
	}
	
	public void printAllEmployees() { // 이제 전체 직원의 급여를 내가 알고싶어서 이런 메소드를 만들었꼬. 만약 또 직원이 0일 경우를 대비해서 조건문을 돌렸고
		if(idx == 0) {
			System.out.println("등록된 사원이 없습니다.");
			return;
		}
		int totalPay = 0;  // 전체 사원의 급여 합계  // 그담 조건문으로 예외를 처리ㅎ했으니까 . 내가 고용한 직원들이 다시한번 몇명있는지 출력해서 보고
		System.out.println("전체 사원 목록(" + idx + "명)");
		for(int i = 0; i < idx; i++) {
			employees[i].info();
			System.out.println("[월급:" + employees[i].getPay() + "원]"); // 이 직원들의 월급 겟페이로 다불러와
			totalPay += employees[i].getPay(); //
		}
		System.out.println("[사원 전체 급여:" + totalPay + "원]");
	}
	
	public void manage() {
		while(true) {
			System.out.print("1.추가 2.삭제 3.조회 4.목록 0.종료 >>> ");
			String choice = sc.next();
			switch(choice) {
			case "1": addEmployee(); break;
			case "2": dropEmployee(); break;
			case "3": findEmployee(); break;
			case "4": printAllEmployees(); break;
			case "0": System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("잘못된 요청입니다. 다시 시도하세요.");
			}
		}
	}
	
}
