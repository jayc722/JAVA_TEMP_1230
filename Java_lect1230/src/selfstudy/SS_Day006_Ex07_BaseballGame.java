package selfstudy;

import java.util.Arrays;
import java.util.Scanner;

import day005.Ex11_ArrayRandom2;

public class SS_Day006_Ex07_BaseballGame {

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
		
		int max = 3;
		Scanner scan = new Scanner(System.in);
		
		
				
		int [] baseball = day005.Ex11_ArrayRandom2.createRandomArray(1, 9, max);
		//System.out.println(Arrays.toString(baseball));
		System.out.println(Arrays.toString(baseball));
		int ball;
		int strike;
		int count = 0;
		do {
			count++;
			ball = 0;
			strike = 0;
			boolean check = false;
			int input [] = new int[max];
			do {
				check = false;
			System.out.println("세 자리 숫자 입력 : ");
			for(int i = 0; i < input.length; i++) {
				if(input[i]>9||input[i]<1) {
					
				}}
			}while(check);
			
			for(int i = 0; i < max; i++) {
				input[i] = scan.nextInt();
			}
			for(int i = 0; i < max; i++) {
				if(day005.Ex11_ArrayRandom2.contains(baseball, input[i])) {
					if(input[i]==baseball[i]) strike++;
					else ball++;
				}
			}
			if(ball>0) {
				if(strike>0) {
					System.out.println(strike + " S " + ball + " B ");
				}else {
					System.out.println(ball + " B ");
				}
			}else if(strike>0) {
				System.out.println(strike + " S ");
			}else System.out.println("3O");
			
			
			
		}while(strike<3);
		
		System.out.println("정답입니다! 시행 횟수 " + count);
		
		
		
	}

}
