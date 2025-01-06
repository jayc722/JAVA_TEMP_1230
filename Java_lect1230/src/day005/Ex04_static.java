package day005;

public class Ex04_static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KiaCar k1 = new KiaCar("레이");
		KiaCar k2 = new KiaCar("니로");
		KiaCar k3 = new KiaCar("K5");
		
		k1.print();
		k2.print();
		k3.print();
		
		//k1.setCompany("KIA");
		KiaCar.setCompany("KIA");//static 변수는 클래스를 통해 부르는게일반
		
		
		k1.print();
		k2.print();
		k3.print();
		
	}

}
	
	

class KiaCar{
	private static String company;				//static 붙이는 것으로 전체를 한꺼번에 바꿀수
	private String carName;

	//게터세터
	public String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		KiaCar.company = company;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}

	private String carType;


	public void print() {
		System.out.println(company + " : " + carName);
	}

	//생성자
	public KiaCar(String carName) {
		company = "기아";
		this.carName = carName;
	}

	}
