package day003;

import java.util.Scanner;

public class Ex10_ForInput {

	public static void main(String[] args) {
		/*문자를 입력받아 q이면 종료되도록 코드륵 작성
		 * 
		 */

		Scanner scan = new Scanner(System.in);
		
		for(;;) {
			System.out.print("q 입력 시 종료 : ");
			char str = scan.next().charAt(0);
			System.out.println(str + "를 입력받았습니다.");
			if(str == 'q')break;
		}
		System.out.println("시스템을 종료합니다.");
		
		
		
	}

}
