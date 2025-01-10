package day009;

import java.util.ArrayList;

import day008.ex02.KiaCar;

public class Ex05_Wrapper {

	public static void main(String[] args) {

		int num1 = 10;
		
		Integer num2 = num1; 		//박싱
		
		int num3 = num2;			//언박싱
		
		System.out.println(num2 + " , " + num3);
				
		//언박싱 null 유의
		
		num2 = null;	//래퍼 클래스는 클래스이기 때문에 null 저장 가능
		
		//num3 = num2;		//예외 발생. null을 정수로 x
		
		 ArrayList<Integer> list = new ArrayList<Integer>();			//<> 제네릭클래스 - > 
		 list.add(1);
		 list.add(2);
		
		System.out.println(list);
		
		
	}

}
