package day005;

public class Ex05_Static2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sum1(1,2));
		
		Ex05_Static2 s = new Ex05_Static2();		//static은 이렇게 해야함
		System.out.println(s.sum2(1,2));
		
		Ex01_Day04_Homework.main(args);				//이런식으로 불러올수있음 모든 main 은 static이기때문
		
		
		
	}

	
	
	public static int sum1(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sum2(int num1, int num2) {
		return num1 + num2;
	}
}



class StaticTest{
	int a;
	static int sa;
	
	
	public void printA() {
		a=10;
		sa=10;
	}

	public static void printSa() {
		//a=10;		//객체변수(인스턴스변수)는 정적 메소드에서 사용할수 없음
		sa=10;
		StaticTest st = new StaticTest();
		st.a=10;
		
	}
	
	public void test() {
	printA();
	printSa();
	
	}
	public static void staticTest() {
		StaticTest st = new StaticTest();
		st.printA();
		printSa();
	
		//printA()     //객체 메소드는 x
		
		
	}
		
}
		
		