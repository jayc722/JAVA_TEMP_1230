package day008.ex02;

public class BenzCar extends Car{
	
	public String logo = "벤츠";
	
	@Override
	public void repair() {					//접근제한자 -> 부모보다 넓어질수는 있지만 좁아질수는 x (public의 경우 public 뿐) 
		System.out.println("벤츠 자동차 수리");
	}
}
