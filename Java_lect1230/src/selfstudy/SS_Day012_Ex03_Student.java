package selfstudy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SS_Day012_Ex03_Student {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Student12>list = new ArrayList<Student12>();

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
	}
	return;
}


private static void srcStd() {
	System.out.println("학생 조회");
	
	System.out.println();
	
	
	Stream<Student12> stream = list.stream();
	
	System.out.print("1. 학년 2. 반 3. 번호 4. 이름 : ");
	int menu = scan.nextInt();
	switch(menu) {
	case 1 :
		System.out.print("학년 입력 : ");
		int tmp = scan.nextInt();
		stream
		.filter (p -> p.getStdGrade() == tmp)
		.forEach(p -> System.out.println(p));
		break;
	case 2 :
		System.out.print("반 입력 : ");
		int tmp2 = scan.nextInt();
		stream
		.filter (p -> p.getStdClass() == tmp2)
		.forEach(p -> System.out.println(p));
		break;
	case 3 :
		System.out.print("번호 입력 : ");
		int tmp3 = scan.nextInt();
		stream
		.filter (p -> p.getStdNum() == tmp3)
		.forEach(p -> System.out.println(p));
		break;
	case 4 :
		scan.nextLine();
		System.out.print("이름 입력 : ");
		String tmp4 = scan.nextLine();
		stream
		.filter (p -> p.getStdName().contains(tmp4))
		.forEach(p -> System.out.println(p));
		break;
	}
	
	printBar('-', 15);

}
private static void insStd() {
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
	
	list.add(new Student12(grade,clss,num,name));
	System.out.println(list);
	
	
}


}



@Data
@AllArgsConstructor
class Student12{
	int stdGrade;
	int stdClass;
	int stdNum;
	String stdName;
	
}