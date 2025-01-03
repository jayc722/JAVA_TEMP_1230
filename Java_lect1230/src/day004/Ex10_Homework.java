package day004;

import java.util.Random;
import java.util.Scanner;

public class Ex10_Homework {

	public static void main(String[] args) {
		/* 다음과 같이 실행되도록 작성(UpDown게임참고)
		 * 
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 
		 * 
		 * 처음 2번 선택
		 * 게임을 실행한 적이 없습니다
		 * 
		 * 1번 선택
		 * 입력 : 50
		 * Down!
		 */


		Scanner scan = new Scanner(System.in);

		char input = 0;

		int bestScore = 0;
		int inputUD = 0;
		do {															//메뉴
			printmenu();			

			input = scan.next().charAt(0);
			runMenu(input,bestScore);

		}while(input != '3');

		System.out.println("프로그램을 종료합니다.");
		System.out.println("감사합니다!");













	}

	public static void printmenu() {
		System.out.println("--------------");
		System.out.println("메뉴");
		System.out.println("1. UpDown 게임 실행");
		System.out.println("2. 최고기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
	}
	
	public static void runMenu(char input, int bestScore) {

		switch(input) {
		case '1' :											//1번 updown
			int count = 1;
			int num = (int)(Math.random()*100) + 1;
			do {

				System.out.println("--------------");
				System.out.print(count + " 회차 시도 \n1부터 100까지의 정수를 입력 : ");
				inputUD = scan.nextInt();
				if(inputUD<1||inputUD>100) {
					System.out.println("1부터 100 사이 정수로 입력해 주세요.");
				}else if(num>inputUD) {
					System.out.println("Up!");
					count++;
				}else if(num<inputUD) {
					System.out.println("Down!");
					count++;
				}else {
					System.out.println("정답!");
					break;
				}

			}while(true);


			if(bestScore==0|bestScore>count) {
				bestScore = count;
				System.out.println("최고기록 경신!" );
			}
			System.out.println("최고기록 : " + bestScore);
			break;

		case '2' :							//2번 최고점수
			if(bestScore==0)System.out.println("플레이 기록이 없습니다.");
			else System.out.println("최고기록 : " + bestScore);
			break;


		case '3' :							//3번 종료
			break;
		default :
			System.out.println("메뉴 창에서 숫자로 선택해 주세요.");
		}
	}

}
