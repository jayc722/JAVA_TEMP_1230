package selfstudy;

import java.util.Scanner;

public class SS_1231_star {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int num = 0;
		
		for(int k = 0; k != 1;) {
		System.out.print("임의의 숫자를 입력하세요 : ");
				num = scan.nextInt();
		
		if(num > 0 && num < 20) {
		for(int i=1; i<=num; i++) {
			for(int j=0; j<i; j++) {
			System.out.print(" * ");
		}
			System.out.println();
		} k++;
		}else {
			System.out.println("0보다 크고 20보다 작은 수를 입력해 주세요");
		}
		}

	
	}
}
