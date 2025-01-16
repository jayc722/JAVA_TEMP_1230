package selfstudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SS_day012_Ex09_ObjectStream2 {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Car>list = new ArrayList<Car>();	//List도 상관없고 ArrayList도 상관없음
	public static final String fileName = "src/day012/object_stream_car.txt";
	public static void main(String[] args) {

		/* 저장기능과 불러오기 기능을 추가
		 * 저장은 프로그램 종료 전
		 * 불러오기는 프로그램 시작 전
		 * 
		 * 메뉴
		 * 1. 자동차 추가
		 * 2. 자동차 조회(전체)
		 * 3. 종료
		 * 
		 */
		
		
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			ArrayList<Car> car = new ArrayList<Car>();
			
			car = (ArrayList<Car>)ois.readObject();
					
			list.addAll(car);	//->이걸 안했구나............................ 
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}
		
		int menu = 0;
		do {
			printMenu("자동차 추가", "자동차 조회", "종료");
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);




		}while(menu != 3);
		
		
		System.out.println("저장합니다.");
	
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);


		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");

		}





	

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
		System.out.println("자동차 추가");
		insCar();
		break;
	case 2 :
		System.out.println("자동차 조회");
		viewCar();
		break;
	case 3 :
		System.out.println("종료");
		break;
	}
	return;
}
private static void viewCar() {
	if(list.isEmpty()) {
		System.out.println("등록된 자동차 없음");
		return;
	}
	
	System.out.println(list);
	
}
private static void insCar() {
	System.out.print("차종 : ");
	String name = scan.nextLine();
	System.out.print("브랜드명 : ");
	String brand = scan.nextLine();
	
	Car car = new Car(name, brand);
	list.add(car);
	System.out.println("자동차 등록");
}
		
		
		
		
	

}
@Data //게터세터
@AllArgsConstructor	//생성자

class Car implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7241086586372707911L;
	private String name;
	private String brand;
}