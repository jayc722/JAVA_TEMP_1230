package day008.ex02;


public class KiaCar extends Car{

	
	public String logo = "기아";

	
	@Override
	public void repair() {					//접근제한자 -> 부모보다 넓어질수는 있지만 좁아질수는 x (public의 경우 public 뿐) 
		System.out.println("기아 자동차 수리");
	}
	
	
	
}
