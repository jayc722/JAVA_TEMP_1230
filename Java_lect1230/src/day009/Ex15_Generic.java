package day009;

public class Ex15_Generic {

	public static void main(String[] args) {

		Array<String> list1 = new Array<String>(10);
		list1.set(0, "abc");
		list1.set(1, "123");
		System.out.println(list1.get(0));
		System.out.println("----------------");
		list1.print();
		
		
		System.out.println("----------------");
		Array<Integer> list2 = new Array<Integer>(5);
		list2.set(0, 100);
		list2.set(2, 200);
		list2.print();
		
		
		System.out.println("----------------");
		print(1);
		print("123");
		
		
	}

	
	
	public static <T> void print(T t) {								//static <T> void -> 리턴타입이 T라는게 아니라 제너릭 메소드라는걸 명시
		if(t==null) {
			return;
		}
		System.out.println(t);					//매개변수가 타입 정해줌
	}
	
	
	
	
}

class Array<T>{
	
	private T [] list;
	
	public void setList(T [] list) {
		this.list = list;
	}
	
	
	public T [] getList() {
		return list;
	}
	
	
	public Array(int size) {
		list = (T[]) new Object[size];
	}
	
	
	/* 특정 번지 값 바꾸기
	 * 바꾸는데 성공하면 기존 데이터 반환, 실패하면 null 반환
	 */
	
	public T set(int index, T data) {
		if(index<0||index>=list.length) {
			return null;
		}
		T tmp = list[index];
		list[index] = data;
		
		return tmp;
	}
	
	public T get(int index) {
		if(index<0||index>=list.length) {
			return null;
		}
		return list[index];
		
	}
	
	
public void print() {
	for(T tmp : list) {
		if(tmp != null) {
			System.out.println(tmp);
		}
	}
}
	
	
	
	
	
	
	
}