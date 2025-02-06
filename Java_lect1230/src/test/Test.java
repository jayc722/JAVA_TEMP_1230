package test;

import lombok.Data;

public class Test {
	public static void main(String[] args) {
		Person[] pArr = new Person[3];
		
		
		
		for(int i = 0; i < pArr.length; i++) {
			pArr[i] = new Person();
			pArr[i].setName(i + 1 + "번");
			System.out.println(pArr[i].getName());
		}
	}
}



@Data
class Person{
	private String name;
	
}