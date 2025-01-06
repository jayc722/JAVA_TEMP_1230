package day005;

import java.util.Random;
import java.util.Scanner;




public class Ex01_Day04_Homework {



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




		char input = 0;
		Scanner scan = new Scanner(System.in);
		int bestScore = 0;

		do {															
			printmenu();									//메뉴
			input = scan.next().charAt(0);

			bestScore = runMenu(input,bestScore);			//메뉴 실행

		}while(input != '3');

		System.out.println("프로그램을 종료합니다.");
		if(bestScore!=0)System.out.println("플레이 해주셔서감사합니다!");













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

	/** 메뉴 출력 
	 * @param input 입력한 값
	 * @param bestScore 종전 최고기록
	 * @return 최고기록
	 */



	public static int runMenu(char input, int bestScore) {
		Scanner scanRM = new Scanner(System.in);
		int bestScoreRM = bestScore;
		switch(input) {
		case '1' :											//1번 updown
			bestScoreRM = gameUpDown(bestScore);
			break;
			
			
		case '2' :							//2번 최고점수
			if(bestScoreRM==0)System.out.println("플레이 기록이 없습니다.");
			else System.out.println("최고기록 : " + bestScoreRM);
			break;


		case '3' :							//3번 종료
			break;

		default :
			System.out.println("메뉴 창에서 숫자로 선택해 주세요.");
			break;

		}
		return bestScoreRM;
	}

	/**
	 * 업다운게임
	 * @param bestScore 종전 최고기록
	 * @return 최고기록
	 */




	public static int gameUpDown (int bestScore) {
		int count = 1;
		int num = (int)(Math.random()*100) + 1;
		int bestScoreUD = bestScore;
		Scanner scanUD = new Scanner(System.in);
		System.out.println("종료하려면 0을 입력해 주세요.");
		do {

			System.out.println("--------------");
			System.out.print(count + " 회차 시도 \n1부터 100까지의 정수를 입력 : ");
			int inputUD = scanUD.nextInt();
			if(inputUD<0||inputUD>100) {
				System.out.println("1부터 100 사이 정수로 입력해 주세요.");
			}else if(inputUD==0) {
				count = 0;
				System.out.println("게임 종료합니다.");
				break;
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


		if(bestScoreUD==0|(bestScoreUD>count&&count!=0)) {
			bestScoreUD = count;
			System.out.println("최고기록 경신!" );
			System.out.println("최고기록 : " + bestScoreUD);
		}

		return bestScoreUD;

	}

}
