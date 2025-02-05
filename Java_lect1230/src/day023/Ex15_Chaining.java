package day023;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex15_Chaining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Point4 p = new Point4(10, -10);
		
		
		//print1은 리턴이 void 여서 체이닝 x
		p.print1();
		System.out.println("-------------");
		//print2은 리턴이 Print4 여서 Point4에서 제공하는 메소드 체이닝 가능
		p.print2().print2().print1();
		System.out.println("-------------");
		String str = p.print2().toString().substring(3);
		//print2은 리턴이 Print4 여서 Point4에서 제공하는 메소드 체이닝 가능, toString은 리턴이 String이어서 String에서 제공하는 substring을 체이닝으로 사용 가능
		System.out.println("-------------");
		//system 클래스의 클래스 필드(static이 붙은 필드. 클래스 이름으로 호출 가능)로 PrintStream 클래스의 객체 out이 있고,
		//printStream에서 제공되는 println을 사용 가능
		System.out.println(str);
		
		
		
	}

}


@Data
@AllArgsConstructor
class Point4{
	private int x, y;
	
	public void print1() {
		System.out.println(x + "," + y);
	}
	
	public Point4 print2() {
		System.out.println(x + "," + y);
		return this;
	}
	
}
