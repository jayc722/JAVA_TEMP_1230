package day008;

public class Ex08_Interface {

	public static void main(String[] args) {

		
		//ConsoleProgram cp = new ConsoleProgram();
	
		System.out.println(ConsoleProgram.num);
	
		ConsoleProgram cp = new StudentScoreProgram();
		cp.run();    // ->  구현
		
		ConsoleProgram.test();			//정적메소드는 기능구현 있기 때문에 시행 가능
		
	}

}


interface ConsoleProgram{
	
	/*public static final 이 앞에 붙어있다고 봐야 */int num = 10;
	
	void printMenu();						// -> public abstract 안붙여도 자동으로 취급
		
	void runMenu(int menu);		
	
	void run();		//main에 해당
	
	//void func1(); 		//추가되면 이후 프로그램에 에러
	
	default void func1() {				//디폴트 메소드 
		
	}
	//static void test();
	
	static void test() {
		System.out.println("테스트 시행");
	}
}

//인터페이스를 이용하여 구현 클래스를 정의	=>메소드 오버라이딩으로 통해 인터페이스의 추상 메소드를 구현
class StudentScoreProgram implements ConsoleProgram{			//추상클래스로 만들거나 기능 추가해야 실행 가능
	
	@Override
	public void printMenu() {
		System.out.println("메뉴 출력");
	}
	@Override
	public void runMenu(int menu) {
		System.out.println("메뉴 실행");
	}
	@Override
	public void run() {
		System.out.println("프로그램 구동");
		
	}
	
	
}


interface Program {
	void run();
}
/*
 * 추상메소드 run 과 추상메소드 run 이 겹칩 -> 오버라이딩 필요
 */

interface GeneraProgram extends Program, ConsoleProgram{
	
}













