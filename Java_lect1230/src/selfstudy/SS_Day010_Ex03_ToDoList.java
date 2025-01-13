package selfstudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SS_Day010_Ex03_ToDoList {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*	다음 기능을 갖는 프로그램 작성
		 * 1. 할일 등록
		 * 2. 할일 삭제
		 * 3. 할일 조회
		 * 4. 종료
		 * 1>등원
		 * 2>수업
		 * 3>1. 등원 2. 수업
		 * 2>1. 등원 2. 수업 삭제할 할일을 선택 : 1
		 * 삭제 되었습니다
		 * 	
		 */
		
		List <ToDo> list = new ArrayList<ToDo>();
		
		
		char menu = 0;
		((List<ToDo>) list).add(new ToDo("등원"));
		do {
			menu = 0;
			printMenu("할일 등록", "할일 삭제", "할일 조회", "종료");
			menu = scan.next().charAt(0);
			runmenu(menu, list);
			menu = '4';
			
			
			
			
			
		}while(menu != '4');
		
		
		
		
	}
	private static void runmenu(char menu, List<ToDo> list) {
		switch(menu) {
		case '1' :
			printBar('-',15);
			System.out.println("1. 할일 등록");
			printBar('-',15);
			addList(list);
			break;
		case '2' :
			printBar('-',15);
			System.out.println("2. 할일 삭제");
			printBar('-',15);
			delList(list);
			break;
		case '3' :
			printBar('-',15);
			System.out.println("3. 할일 조회");
			printBar('-',15);
			viewList(list);
			break;
		case '4' :
			printBar('-',15);
			System.out.println("종료합니다.");
			printBar('-',15);
			break;
		default :
			System.out.println("잘못된 입력입니다.");
			break;
		}
		return;

	}
		
	
	private static void viewList(List<ToDo> list) {
		System.out.println(list);
	}
	private static void delList(List<ToDo> list) {
		// TODO Auto-generated method stub
		
	}
	public static void addList(List<ToDo> list) {
		System.out.print("등록할 할일을 입력 : ");
		((List<ToDo>) list).add(new ToDo(scan.next()));
		System.out.println();
		
		return;
		
	}
	
	public static void printBar(char bar, int count) {
		for(int i = 1; i<= count; i++) {
			System.out.print(bar);
		}
		System.out.println();
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
	
	

}
@Data
@AllArgsConstructor		//모든 멤버를 매개변수로 하는 생성자
@NoArgsConstructor		//기본생성자
class ToDo{
	private String toDo;
	
}