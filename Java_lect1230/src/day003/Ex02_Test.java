package day003;

import java.util.Scanner;

public class Ex02_Test {

	public static void main(String[] args) {
		/*월을 입력받고 월의 마지막 일을 출력하는 코드를 작성
		 * 31: 1, 3, 5, 7, 8, 10, 12
		 * 30: 4, 6, 9, 11
		 * 28: 2
		 * 잘못된 월 : 1~12 가 아닌 월
		 */

		Scanner scan = new Scanner(System.in);
		int month=0, day=0;
		
		for(;day == 0;) {
		System.out.print("월을 입력하세요 : ");
		month = scan.nextInt();
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12 :
			day = 31;
			break;
		case 4, 6, 9, 11 :
			day = 30;
			break;
		case 2 :
			day = 28;
			break;
		default :
			System.out.println("1에서 12 사이의 값을 입력해 주세요");
			break;
		}
		}
		System.out.println(month + "월은 " + day + " 일 까지 입니다");
	}

}
