package day008;

public class Ex05_Super {

	public static void main(String[] args) {

		Parent p = new Parent("홍길동");
		p.print();
		System.out.println("--------");
		
		Child c = new Child("임꺽정");
		c.print();
		
		
		Child c1 = new Child();
		c1.print();


	}


}



class Parent{

	String name;

	public Parent(String name) {
		this.name = name;
	}
	public void print() {
		System.out.println("출력합니다.");
	}

}

class Child extends Parent{
	
	
	String type;
	
	public Child() {    				//기본 생성자 자동으로 생성 -> super() 자동 생성->부모 클래스의 기본생성자(없으면 에러) ->부모 클래스 기본생성자 만들어 주거나 문자열 들어간 super("") 넣어주면 됨
		super("");						//부모클래스 생성자로 초기화부터 하기때문에 순서 바뀌면 에러
		type = "";
		
	}
	public Child(String name) {
		super(name);
		type = "일반";
	}
	
	
	@Override  // 실수 체크해줌
	public void print() {
		//출력합니다
		
		super.print();						//super 뺴면 재귀메소드. 내가 나를 부름.
		System.out.println(name + " : " + type);
		
	}
	
	
}