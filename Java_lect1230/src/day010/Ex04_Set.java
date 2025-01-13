package day010;

import java.util.HashSet;

public class Ex04_Set {

	public static void main(String[] args) {

		
		/* set
		 * 	- Collection 인터페이스의 자식 인터페이스
		 * 	- 중복 허용x, 순서 보장x
		 * HashSet
		 * 	- Set 인터페이스의 구현 클래스
		 * 
		 * 
		 */
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		set.add(1);
		set.add(2);
		set.add(3);
		
		
		System.out.println(set);		//여기까지는 list랑 차이 없는데
		
		
		set.add(100);
		set.add(200);
		set.add(1);
		set.add(2);
		
		System.out.println(set);		//중복 허용하지 않기 때문에 1, 2는 들어가지 않음
		
		//get, indexof 등은 번지 의존이기 때문에 없음
		
		System.out.println(set.contains(10));	//collection에서 물려받은 것이기 때문에 가능
		
		System.out.println(set.remove(20));		//없는 숫자 삭제 시 false
		
		System.out.println(set.remove(2));
		
		
		System.out.println(set);
		
		
	}

}
