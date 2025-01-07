package day006;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07_BaseballGame {

	public static void main(String[] args) {
		/* 숫자 야구 게임을 구현하세요
		 * S : 숫자가 있고 위치가 같은 경우
		 * B : 숫자가 있지만 위치가 다른 경우
		 * O : 일치하는 숫자가 하나도 없는 경우
		 * 
		 * 랜덤 수 : 3 7 1
		 * 입력 : 1 2 3
		 * 2B
		 */

		//랜덤수 생성, 중복되지 않는 1에서 9 사이의 3자리 수

		int [] com = createRandomArray(1, 9 ,3);
		System.out.println(Arrays.toString(com));
		//반복 : 3 개의 수를 생성할 때 까지

		int strike, ball;
		int user [] = new int[3];

		do {									//반복
			strike = 0;
			ball = 0;
			user = new int[3];					//초기화(안하면 이전값 남음)

			
			if(!inputNum(user)) {				//정수 입력받음
				continue;
			}
			
				
			strike = getStrike(com, user);		//스트라이크 판별

			ball = getBall(com, user);			//볼 판별   -> 겹치는 숫자 - 스트라이크 숫자

			printResult(strike, ball);			//스트라이크 볼의 개수 따라 출력


		}while(strike < 3);
		System.out.println("프로그램을 종료합니다.");

	}
	
	
	
	
	
	
	
	

	private static boolean inputNum(int[] user) {			//중복 or 범위초과 시 false 
		Scanner scan = new Scanner(System.in);

		System.out.print("정수 3개 입력(1 ~ 9, 중복 x) : ");
		boolean outOfBounds = false;
		boolean duplicated = false;
		for(int i = 0; i < user.length; i++) {
			int tmp = scan.nextInt();
			if(tmp < 1 || tmp > 9) {
				System.out.println("범위를 벗어났습니다");
				outOfBounds = true;
			}
			if(contains(user, tmp)) {
				duplicated = true;	
			}
				user[i] = tmp;
				
		}
		if(outOfBounds || duplicated) {
			System.out.println("범위를 벗어나거나 중복된 수가 있습니다.");
		}

		return !outOfBounds && !duplicated;
	}

	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("3O");
		}

		System.out.println();

	}

	public static int getBall(int[] com, int[] user) {
		int count = 0;
		for(int tmp : com) {
			if(contains(user,tmp)) {
				count++;
			}
		}

		return count - getStrike(com,user);
	}

	public static boolean contains(int[] user, int num) {
		for(int tmp : user) {
			if(tmp == num) {
				return true;
			}
		}
		return false;
	}

	public static int getStrike(int[] com, int[] user) {
		int strike = 0;
		for(int i = 0; i < user.length; i++) {
			if(com[i] == user[i]) {
				strike++;
			}
		}

		return strike;
	}

	private static int[] createRandomArray(int min, int max, int size) {

		if(max < min) {								//거꾸로 입력한 경우
			int tmp = max;
			max = min;
			min = max;
		}


		if(max - min + 1 < size) {						//랜덤 범위보다 size 가 큰 경우
			return null;
		}
		if (size <= 0) {
			return null;
		}
		int count = 0;

		int [] arr = new int[size];
		do {
			int r = (int)(Math.random()*(max - min + 1) + min);
			
			if(!contains(arr,r)) {
				arr[count++] = r;					//count에 대입하고 count 1 증가
			}

		}while(count < 3);


		return arr;
	}





}
