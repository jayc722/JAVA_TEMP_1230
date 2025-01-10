package day009;

import java.util.ArrayList;
import java.util.Iterator;

import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Ex16_List {

	public static void main(String[] args) {

		/*	List : interface
		 * 	ArrayList, LinkedList, Vector : List를 구현한 구현 클래스
		 * 	List :	순서 보장, 중복 허용
		 * 
		 */
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(20);
		System.out.println(list);			//list 자체 toString 제공
		
		list.set(1, 20);					//1번지 값을 20으로
		
		System.out.println(list);
		
		//list.remove(20);	//예외 발생 remove()는 collection에서 제공하는 remove(Integer필요)
							//List에서 제공하는 remove(int)랑 둘다 가능하기때문
		list.remove((Integer)20);
		
		list.remove((int)1);
		
		System.out.println(list);
		
		System.out.println("저장된 개수 : "  + list.size());
		
		
		
		ArrayList<Point> list2 = new ArrayList<Point>();
		
		list2.add(new Point(1,1));
		list2.add(new Point(10,10));
		
		list2.remove(new Point(1,1));	//boolea remove(Object o)
										// 이 remove는 같다를 Objects.equals를 이용하여 판단
								//Objects.equals(Object o1, Object o2)
								//o1과 o2 가 다른 클래스이면 비교없이 false
								//같은 클래스이면 o1.equals(o2)
								//Point 클래스의 생성자 오버라이딩 없으면 주소만 비교 -> 다르다 판별
		System.out.println(list2); 
		
		list2.add(new Point(10, 10));
		System.out.println(list2); 
		list2.add(new Point(-1, -1));
		System.out.println(list2); 
		
		//Iterator 이용한 반복문
		
		Iterator<Point> it = list2.iterator();
		System.out.println("------------");
		while(it.hasNext()) {
			Point tmp = it.next();
			System.out.println(tmp);
			
		}
		
		//indexOf(객체) 객체가 몇번지?
		//Object.equals로 객체 찾아 번호 반환 /-> 역시나 오버라이딩 중요
		int index = list2.indexOf(new Point(10, 10));
		System.out.println(index);
		
		boolean res = list2.contains(new Point(1, 3));
		System.out.println(res);
		
		Point p = list2.get(1);
		p.x=2;p.y=3;
		System.out.println(list2);
		
		
		
	}

}

@ToString
@EqualsAndHashCode				//모든 멤버변수 비교 -> 일부만 비교하고 싶으면 직접 오버라이딩 필요
class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
