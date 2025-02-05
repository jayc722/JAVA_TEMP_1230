package day023;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex02_If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		//홀짝 판별 예제
		
		int num = 3;
		
		if (num % 2 == 0) {
			System.out.println(num + "는 짝수");
		}
		if( num % 2 != 0) {
			System.out.println(num + "는 홀수");
		}
		
		
		//10부터 1까지 출력
		
		for(int i = 10; i >= 1; i--) {
			System.out.print(i);
		}
		
		System.out.println();
		
		for(int i = 1; i <= 10; i++) {
			System.out.print(i);
		}
		
		System.out.println();
		
		List<Object> list = new ArrayList<Object>();
		list.add(new Point());
		list.add(new Point(1,2));
		list.add(new Point(1));
		list.add(1);
		
		*/
		//list.add(new Point());
		 
		
		
		//음료 클래스 drink
		// 필드로 메뉴명과 금액
		//클래스는 캡슐화에 맞춰 구현
		//getter / setter 작성
		//매개변수가 있는 생성자를 작성
		/*
		
		
		List<Drink> list2 = new ArrayList<Drink>();
		
		Drink drink1 = new Drink();
		Drink drink2 = new Drink("커피", 1000);
		Drink drink3 = new Drink("모과차",300);
		
		list2.add(drink1);
		list2.add(drink2);
		list2.add(drink3);
		
		System.out.println(drink1);
		System.out.println(drink2);
		System.out.println(drink3);
		System.out.println(list2);
		*/
		//다음 코드를 실행했을 때 생기는 예외에 대한 원인과 해결방법에 대해 설명
		/*
		int num1 = 1, num2 = 0;
		try {
		System.out.println(num + "/" + num2 + "=" + num1/num2);
		}catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		*/
/*
		double num1 = 1, num2 = 0;

		try {

			if(num2 == 0) {
				throw new Exception();
			}
			System.out.println(num1 + "/" + num2 + "=" + num1/num2);


		}catch (Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	*/
		/*
	String str;
	Scanner scan = new Scanner(System.in);
	
	do {
		System.out.print("입력 : ");
		str = scan.next();
		System.out.println("출력 : " + str);
		
	}while(!str.equals("EXIT"));
	
	*/
	//람다식 예제	
		
		
	List<Point> list = new ArrayList<Point>();
	list.add(new Point(0,0));
	list.add(new Point(1,1));
	list.add(new Point(-1,1));
	
	//좌표가 0 이상인 좌표들만 출력
	
	for(int i = 0; i < list.size();i++) {
		if(list.get(i).getX()>=0)System.out.print(list.get(i));
	}
	
	System.out.println();
	
	for(int i = 0; i < list.size();i++) {
		if(list.get(i).getY()>=0)System.out.print(list.get(i));
	}
	
	System.out.println();
	System.out.println();

	printListX(list);
	
	System.out.println();
	System.out.println();
	
	//람다식 => 메소드를 간결하게 표현해서 객체를 생성할때 사용 ()->{}
	//함수형 인터페이스(추상 메소드가 한개뿐인 인터페이스)가 필요->함수형 인터페이스의 객체를 만들때 사용
	
	
	print(list, p -> {
		if(p.getX()>=0)System.out.print(p);
	});
	
	System.out.println();
	
	print(list, p -> {
		if(p.getY()>=0)System.out.print(p);
	});
	
	System.out.println();
	System.out.println();
	
	
	////////////////////////////두개가 같음
	
	printList(list, new Predicate<Point>() {
		
		@Override
		public boolean test(Point t) {
			return true;
		}
	});
	
	System.out.println();
	
	printList(list, t->true);
	
	
	System.out.println();
	System.out.println();

	
	printList(list, p->p.getX()>=0);
	printList(list, p->p.getY()>=0);
	
	
	
	
	
	
	}//main
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void print(List<Point>list, Consumer<Point> c) {
		for(Point point : list)c.accept(point);
	}

	
	
	
	public static void printList(List<Point> list, Predicate<Point> p) {
		for(Point tmp : list)if(p.test(tmp))System.out.println(tmp);
	}
	
	public static void printListX(List<Point> list) {
		for(Point tmp : list) {
			if(tmp.getX() >= 0) {
				System.out.print(tmp);
			}
		}
	}
}



class Drink implements Serializable{	//직렬화 역직렬화 serial imple

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String menu;
	private int cost;


	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public Drink() {
		super();
		this.menu = "디폴트";
		this.cost = 0;
	}


	public Drink(String menu, int cost) {
		super();
		this.menu = menu;
		this.cost = cost;
	}


	public Drink(String menu) {
		super();
		this.menu = menu;
		this.cost = 0;
	}
	@Override
	public String toString() {
		return menu + ", " + cost;
	}

}






@Data
@AllArgsConstructor
class Point{

	private int x, y;

	/*
	public Point(int i, int j) {
		this.x = i;
		this.y = j;
	}

	public Point() {
		this.x = 10;
		this.y = 0;
	}

	public Point(int i) {
		this.x = i;
		this.y = 0;
	}
	*/
}

