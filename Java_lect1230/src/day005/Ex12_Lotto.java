package day005;

import java.util.Scanner;

public class Ex12_Lotto {

	public static void main(String[] args) {

		/* 1 ~ 45 사이의 랜덤한 수 6개 생성, 1개의 보너스 번호를 생성한다.
		 * 1 ~ 45 사이의 정수 6개를 입력받아, 입력한 정수가 몇 등인지 확인하는 코드를 작성.
		 * 
		 * 1등 : 6개 다 맞는 경우
		 * 2등 : 5개 일치, 보너스 일치
		 * 3등 : 5개만 일치
		 * 4등 : 4개 일치
		 * 5등 : 3개 일치
		 * 꽝 : 나머지
		 * 
		 */

		//랜덤으로 중복되지 않는 배열 생성
		//반복문 : 랜덤으로 생성된 숫자가 배열에 있을 경우 반복, 없으면 종료
		//랜덤으로 보너스 번호를 생성
		//반복문 6번
		//번호를 입력
		//랜덤 번호와 입력 번호의 일치하는 개수를 셈
		//일치하는 개수에 따라 등수 출력
		//6개 일치하면 1등이라고 출력
		//5개 일치하면 > 보너스 번호도 일치하면 2등이라고 출력 아니면 3등이라고 출력
		//4개 일치 > 4등이라고 출력
		//3개 일치 > 5등이라고 출력
		// 아니면 > 꽝이라고 출력

		int min = 1, max = 45;
		int [] lotto = Ex11_ArrayRandom2.createRandomArray(min, max, 6);

		Ex11_ArrayRandom2.printArray(lotto);

		int bonus;

		do {
			bonus = (int)(Math.random()*(max - min + 1) + min);
		}while(Ex11_ArrayRandom2.contains(lotto, bonus));

		System.out.println("보너스 : " + bonus);

		int user [] = new int[6];
		Scanner scan = new Scanner(System.in);
		System.out.println("로또 번호 입력 : ");

		for(int i = 0; i < user.length; i++) {

			user[i] = scan.nextInt();
		}

		int count = 0;
		for(int i = 0; i<lotto.length; i++) {
			if(Ex11_ArrayRandom2.contains(user, lotto[i])) {
				count++;
			}
		}

		switch(count) { 
		case 6 :
			System.out.println("1");
			break;
		case 5 :
			if(Ex11_ArrayRandom2.contains(user, bonus)) {
				System.out.println("2");
			}else {
				System.out.println("3");

			}
			break;
		case 4 :
			System.out.println("4");
			break;

		case 3 :
			System.out.println("5");
			break;
		default :
			System.out.println("꽝");


		}
	}
}
