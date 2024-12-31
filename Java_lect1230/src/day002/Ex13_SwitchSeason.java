package day002;

import java.util.Scanner;

public class Ex13_SwitchSeason {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int month = 0;
		
		System.out.print("월수를 입력하세요 : ");
		month = scan.nextInt();
			
		switch (month) {
		case 1 : case 2 : case 12 :
			System.out.println(month + " 는 겨울 입니다.");
			break;
		case 3 : case 4 : case 5 :
			System.out.println(month + " 는 봄 입니다.");
			break;
		case 6 , 7, 8 :
			System.out.println(month + " 는 여름 입니다.");
			break;
		case 9, 10, 11 :
			System.out.println(month + " 는 가을 입니다.");
			break;
			default :
			System.out.println("1에서 12 까지의 값만을 입력해주세요.");
		}
		
	}

}
