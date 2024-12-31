package day002;

import java.util.Scanner;

public class Ex19_ForMultipleTable {

	public static void main(String[] args) {
		//n단을 출력하는 코드 작성
		//반복횟수 : 9
		//규칙성 2 X i = (결과)
		//반복문 종료후 x
		
		
		int mult = 2;
		Scanner scan = new Scanner(System.in);
		
		for(int k=0; k != 1;) {
			
			System.out.print("구구단 n 단! : ");
			mult = scan.nextInt();
		
			if(mult < 1 || mult > 19)System.out.println("1에서 19 사이의 값을 입력해 주세요");	
			else if(mult >=1 && mult <=9) {
				for(int i =1; i <=9; i++) {
					System.out.println(mult + " X " + i + " = " + (mult * i));
				}k++;
			}else {
				for(int j = 1; j <= 19; j++) {
					System.out.println(mult + " X " + j + " = " + mult*j);
				}k++;
			}
		}
	}

}
