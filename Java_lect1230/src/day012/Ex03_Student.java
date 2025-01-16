package day012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Student>list = new ArrayList<Student>();

	public static void main(String[] args) {
		/*
		 * 1. 학생추가
		 * 학년 반 번호 이름
		 * 2. 학생 조회
		 * 3. 종료
		 * 
		 * 2-1 학년 조회
		 * 2-2 반 조회
		 * 2-3 번호 조회
		 * 2-4 전체 조회
		 * 
		 * -학생 클래스 추가
		 * -List를 이용해 학생 관리
		 * -Stream과 람다식을 이용해서 출력 구현
		 */
		
		list.add(new Student(1,1,1,"홍길동"));
		list.add(new Student(1,1,2,"임꺽정"));
		list.add(new Student(2,1,1,"둘리"));
		list.add(new Student(3,1,1,"고길동"));
		list.add(new Student(3,2,1,"또치"));
		

		int menu = 0;
		do {
			printMenu("학생 추가", "학생 조회", "종료");
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);




		}while(menu != 3);






	

	}
public static void printMenu(String ... menus ) {
	printBar('-', 15);
	//메뉴가 없는 경우
	if(menus.length == 0) {
		System.out.println("메뉴 없음");
		return;
	}
	//메뉴들을 숫자를 붙여서 출력
	for(int i = 0; i < menus.length; i++) {
		String menu = menus[i];
		System.out.println(i+1 + ". " + menu);
	}
	printBar('-', 15);
	System.out.print("메뉴 선택 : ");
}
public static void printBar(char bar, int count) {
	for(int i = 1; i <= count; i++) {
		System.out.print(bar);
	}
	System.out.println();
}

private static void runMenu(int menu) {
	switch(menu) {
	case 1 :
		System.out.println("학생 추가");
		insStd();
		break;
	case 2 :
		System.out.println("학생 조회");
		srcStd();
		break;
	case 3 :
		System.out.println("종료");
		break;
	case 4:
		System.out.println("학생 삭제");
		delStd();
		break;

	default : 

	}
	return;
}


private static void delStd() {

	//이름 입력
	System.out.print("이름 입력 : ");
	String name = scan.nextLine();
	//이름을 포함하는 학생들을 번호와 함께 출력
	List<Student> tmpList = 
			list.stream().filter(s->s.getStdName().contains(name)).collect(Collectors.toList());		
	print(list, s->true, true);
	//삭제할 번호 입력
	System.out.print("삭제할 학생 번호 입력 : ");
	int count = scan.nextInt();
	//입력받은 번호에 맞는 객체 가져옴
	Student tmp = tmpList.get(count-1);
	//리스트에서 삭제할 객체를 이용하여 제거
	list.remove(tmp);

}
private static void srcStd() {

	//조회메뉴 출력
	printMenu("학년 조회", "반 조회", "번호 조회", "전체 조회");
	//조회메뉴 선택
	//조회기능 선택


	int menu = scan.nextInt();
	scan.nextLine();
	
	switch(menu) {
	case 1 :
		srcGrade();

		break;
	case 2 :
		srcClass();

		break;
	case 3 :
		srcNum();
		
		break;
	case 4 :
		srcAll();

		break;
	}
	
	printBar('-', 15);

}

private static void srcAll() {
	//학생 전체 출력
	print(list, s->true);
}
private static void srcNum() {
	System.out.print("학년 입력 : ");
	int grade = scan.nextInt();
	System.out.print("반 입력 : ");
	int clssNum = scan.nextInt();
	System.out.print("번호 입력 : ");
	int num = scan.nextInt();
	
	print(list, s->s.getStdGrade() == grade && s.getStdClass() == clssNum && s.getStdNum() == num );
}
private static void srcClass() {
	System.out.print("학년 입력 : ");
	int grade = scan.nextInt();
	System.out.print("반 입력 : ");
	int clssNum = scan.nextInt();
	
	print(list, s->s.getStdGrade() == grade && s.getStdClass() == clssNum);		//재사용
	
}
private static void srcGrade() {
	System.out.print("학년 입력 : ");
	int grade = scan.nextInt();
	
	print(list, s->s.getStdGrade() == grade);		//재사용

}

private static void print(List<Student> list, Predicate<Student> p) {		//삭제기능에서 사용하기 위해 수정(전체범위 이외에)
	/*Stream<Student> stream = list.stream();
	stream.filter(p).forEach(s->System.out.println(s));*/
	print(list, p,false);
}
private static void print(List<Student> list, Predicate<Student> p, boolean isCount) {		//메소드 오버라이딩
	Stream<Student> stream = list.stream();
	AtomicInteger index = new AtomicInteger(1);
	
	stream
		.filter(p)
		.forEach(s->{
			int num = index.getAndIncrement();
		System.out.println((isCount? num + ". " : "") + s);
});
}



private static void insStd() {
	
	//학년 반 번호 이름 입력
	//입력받은 정보로 학생 객체 생성
	//리스트에 추가
	System.out.println("학생 추가");
	System.out.print("학년 : ");
	int grade = scan.nextInt();
	System.out.print("반 : ");
	int clss = scan.nextInt();
	System.out.print("번호 : ");
	int num = scan.nextInt();
	scan.nextLine();
	System.out.print("이름 : ");
	String name = scan.nextLine();
	
	list.add(new Student(grade,clss,num,name));
	System.out.println(list);
	
	
}


}



@Data
@AllArgsConstructor
class Student{
	private int stdGrade, stdClass, stdNum;
	private String stdName;
	@Override
	public String toString() {
		return  stdGrade + "학년 " + stdClass + "반 " + stdNum + "번 " + stdName;
	}
	
	
	
}