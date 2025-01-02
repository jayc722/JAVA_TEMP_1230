package day003;

import java.util.Scanner;

public class Ex04_ForDivisor {

	public static void main(String[] args) {
		// 입력받은 num의 약수를 출력하는 코드
		//반복횟수 : i 는 1부터 num까지 1씩 증가
		//규칙성 : i가 num의 약수이면 i를 출력 num을 i로 나누었을때 나머지가 0과 같다면 i를 출력
		//반복문 종료 후 :x

		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		for(int i =1; i <= num; i++) {
			if(num % i ==0) {
				System.out.print(i + " ");
			}
			
		}
		
		
	}

}
