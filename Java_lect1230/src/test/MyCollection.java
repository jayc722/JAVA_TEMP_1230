package test;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MyCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test();
		
	}

	public static void test() {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(new Fruit("사과", "빨강"));
		list.add(new Fruit("메론", "초록"));
		list.add(new Fruit("포도", "보라"));
		list.add("맛있는 과일");
	
	for(int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}
	
}
}
@Data
@AllArgsConstructor
class Fruit{
	String fruit1, fruit2;
	
}
