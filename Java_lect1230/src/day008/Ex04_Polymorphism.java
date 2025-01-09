package day008;

import day008.ex02.BenzCar;
import day008.ex02.Car;
import day008.ex02.KiaCar;

public class Ex04_Polymorphism {

	public static void main(String[] args) {

		KiaCar kia = new KiaCar();
		BenzCar benz = new BenzCar();
		
		repair(kia);
		repair(benz);
		
		
	}
	/*매번 하나하나 입력 ->자동차 종류별로 메소드 오버라이딩
	public static void repair(KiaCar kia) {
		kia.repair();
	}

	public static void repair(BenzCar benz) {
		benz.repair();
	}
	 */

	public static void repair(Car car) {
		car.repair();
	}

}
