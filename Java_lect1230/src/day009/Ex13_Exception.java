package day009;

public class Ex13_Exception {

	public static void main(String[] args) {

		
		
		try {
		test1();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();			//예외가 발생했을 때 발생한 메소드를 추적하여 출력
		}
		System.out.println("프로그램 종료");
		
		
		
	}

	
	
	
	
	public static void test1() {
		test2();
		
	}





	private static void test2() {
		test3();
		
	}





	private static void test3() {
		throw new RuntimeException("예외 발생");			//생성자에서 만들어진 문자가 message에 저장 > getMessage로 불러옴
	}
}
