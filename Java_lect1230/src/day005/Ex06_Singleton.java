package day005;

public class Ex06_Singleton {

	public static void main(String[] args) {
		
		//Singleton s = new Singleton(); private라 불러올 수 없음
		
		Singleton s1 = Singleton.getInstance();		//new연산자를 이용한 것이 아니기때문에 각각 생성된것이 아니라
		Singleton s2 = Singleton.getInstance();		//같은 값을 공유
		
		System.out.println(s1.getNum());
		System.out.println(s2.getNum());
		
		s1.setNum(20);						//static변수가 아닌데도 같은 인스턴스를 공유하기때문에 같이 바뀜
		System.out.println(s1.getNum());
		System.out.println(s2.getNum());
		
		
	}

}


class Singleton{
	
	//싱글톤 클래스는 객체를 생성해서 클래스 변수에 연결. 생성자는 이때만 사용(이후는 사용불가)
	private static Singleton s = new Singleton();
	
	private int num = 10;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	private Singleton() {
		num = 10;
	}
	
	public static Singleton getInstance() {
		return s;
	}
	
	
}