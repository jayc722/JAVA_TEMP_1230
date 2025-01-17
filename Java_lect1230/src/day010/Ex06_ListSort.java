package day010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ex06_ListSort {

	public static void main(String[] args) {
		// 리스트 정렬
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(10);
		list1.add(20);
		list1.add(1);
		list1.add(3);

		System.out.println(list1);
		
		Collections.sort(list1);		//오름차순 정렬
		
		System.out.println(list1);
		
		Collections.sort(list1, Collections.reverseOrder());		//내림차순 정렬
		
		System.out.println(list1);
		
		/* sort 메소드는 Comparator 인터페이스의 구현 클래스의 객체가 필요
		 * => 구현 클래스의 메소드를 이용해서 정렬하기 때문에
		 * --->매개변수의 다형성(인터페이스로 설정해 놓으면 가져올수있음)
		 * 익명 클래스를 만들고 익명 클래스의 객체를 생성해서 sort의 매개변수로 넘겨줌
		 * 익명 클래스 : 클래스 이름이 없음, 일회용
		 */
		
		
		list1.sort(new Comparator<Integer>() {					//list는 comparable이 아니라 comparator가 필요 (comparator는 익명 클래스)
																//인터페이스의 구현 클래스

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2;					//o2 - o1 오름차순 
			}		//copare 메소드 오버라이딩 하면 정렬방식 지정 가능
		});
		
		System.out.println(list1);
		
		list1.sort((o1,o2)->o2-o1);				//이렇게 줄여쓸 수 있음(위와 같은 결과)
												//람다식		
		System.out.println(list1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
