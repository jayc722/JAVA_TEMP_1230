package day003;

public class Ex18_MultipleTable {

	public static void main(String[] args) {
		/*2 에서 9단을 출력하는 코드 작성
		 * 
		 *
		 * 
		 */

		int stair = 2;
		
		while(stair <= 9) {
			
			System.out.println(stair + "단");
			for(int i = 1; i <=9; i++) System.out.println(stair + " X " + i + " = " + (stair * i));
			stair++;
			
		}
		
		
		
		
		
		
	}

}
