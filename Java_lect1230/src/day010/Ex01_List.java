package day010;

import java.util.ArrayList;

public class Ex01_List {

	public static void main(String[] args) {
		/* 퀄렉션 프레임워크 사용하는 이유
		 *	-여러 데이터를 편하게 사용하기 위해서
		 * 	-배열은 꽉차면 늘려줘야 함
		 * 	-배열은 중간에 삭제하면 당겨줘야
		 * Collection 인터페이스의 자식 인터페이스
		 * List는 인터페이스
		 * 	-중복 허용, 순서 보장 =>특정 번지 접근 가능
		 * ArrayList
		 * 	-List 인터페이스의 구현 클래스
		 * 	-제네릭 클래스(멤버변수/메소드의 타입이 정해지지 않은 클래스, 객체 생성 시 타입을 결정)
		 * 	-타입은 클래스만 가능
		 */
		
		ArrayList<Integer> list = new ArrayList<Integer>();		//<Integeter> 타입지정 생략해도 됨 -> 조상인 object기준으로 만듦 ->형변환 필요
		
		list.add(10);			//Collection 인터페이스에서 제공하는 메소드 오버라이딩	->set에도 있음
		list.add(20);
		list.add(30);
		
		System.out.println(list);
		
		list.add(1, 11);	//1번지에 11 추가하고 밀기
		
							//List 인터페이스에서 제공하는 메소드					->set에 없음
		
		System.out.println(list);
		
		list.remove((Integer)10);	//Collection 인터페이스에서 제공하는 메소드		->set에도 있음
		
		System.out.println(list);
		
		list.remove(0);				////List 인터페이스에서 제공하는 메소드			->set에 없음
		
		System.out.println(list);
		
		System.out.println(list.get(0));		//List 인터페이스에서 제공
												// -> 번지 이용하는건 대부분 List 제공이라고 봐도
		
		System.out.println(list.contains(20));	//Collection 인터페이스에서 제공하는 메소드
																//기능 -> 교과서 예제 확인하면 됨
		
		System.out.println(list.indexOf(0));	//List에서
		
					//->List들은 set에 없는 애들
		
		
	}

}
