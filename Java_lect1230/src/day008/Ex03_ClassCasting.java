package day008;

import day008.ex02.BenzCar;
import day008.ex02.Car;
import day008.ex02.KiaCar;

public class Ex03_ClassCasting {

	public static void main(String[] args) {
		/* 다양한 자동차를 관리하는 프로그램 제작
		 * 
		 * 
		 * 
		 */
		/*
		KiaCar [] kiaList;
		BenzCar [] BenzList;
		*/
		
		Car [] list = new Car[10];
		
		list[0] = new BenzCar();
		//car - > BenzCar 업캐스팅(자동 클래스 변환)
		list[1] = new KiaCar();
		
		
		int count = 2;
		//for(int i = 0; i < count; i++) System.out.println(list[i].logo);		//Car 클래스라 logo가 안됨
		
		for(int i = 0; i < count; i++) {
			Car tmp = list[i];
			if(tmp instanceof KiaCar) {
					// 다운 캐스팅(강제 클래스 변환 -> 제한적 조건부 )
				KiaCar kiatmp = (KiaCar)tmp;
				System.out.println(kiatmp.logo);		
			}else if(tmp instanceof BenzCar) {
				System.out.println(((BenzCar)tmp).logo);	
		}
		
		}
		
		
		
		
	}

}
