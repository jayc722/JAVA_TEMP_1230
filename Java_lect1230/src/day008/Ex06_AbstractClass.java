package day008;

public class Ex06_AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A1 a1 = new A1();						->추상 클래스는 직접 객체 형성 x

		A1 a1 = new B1();		//자식 클래스인 B1 클래스를 이용하여 객체 생성 후
								//업캐스팅을 이용하여 클래스 형변환

		
		A2 a2 = new B2_2();
		
		a2.print();






	}
}

//추상 메소드가 없어도 abstract 붙이면 추상 클래스가 됨
abstract class A1{

}

class B1 extends A1{
	
}

abstract class A2{							//반드시 추상 클래스로 만들어야 함
	public abstract void print();			//->추상 메소드 가지는 클래스는
											//
	public void print2() {}					//이건 구현이 안된 그냥 메소드

}

abstract class B2_1 extends A2{					//추상 클래스를 상속받은 클래스는//추상 클래스가 되거나//
	
}

class B2_2 extends A2{							//오버라이딩 해서 일반 클래스가 될 수 있음

	@Override
	public void print() {
		System.out.println("출력합니다.");
	}							
	
		
}