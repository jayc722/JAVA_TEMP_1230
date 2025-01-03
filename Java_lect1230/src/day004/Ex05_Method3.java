package day004;

public class Ex05_Method3 {

	public static void main(String[] args) {
		// 2단에서 9단까지 구구단 출력(단, 메소드 활용)

		
		for(int i = 2; i <= 9; i++)multipleTable(i);
		
		
	}
	
	/** stair 단을 출력하는 메소드 
	 * 매개변수 : 출력할 단 => int num
	 * 리턴타입 : 없음	=> void
	 * 메소드명 : prinMultipleTable
	 * @param stair 출력할 단
	 * @return void 없음(원래는 안씀)
	 * 
	 */
	public static void multipleTable(int stair) { 
		System.out.println(stair + "단");
		for(int i = 1; i <=9; i++) System.out.println(stair + " X " + i + " = " + (stair * i));
		System.out.println();
	}
}