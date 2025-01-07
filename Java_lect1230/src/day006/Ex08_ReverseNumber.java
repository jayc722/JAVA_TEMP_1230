package day006;

import java.util.Arrays;
import java.util.Scanner;

public class Ex08_ReverseNumber {

	public static void main(String[] args) {
		// 4자리 정수를 입력받아 입력받은 정수를 역순으로 출력
		
		//입력 1234 결과 4321
		//입력 1230 결과 0321
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("4자리 정수를 입력하세요 : ");
		
		int num = scan.nextInt();
		
		System.out.println(num);
		
		//1234를 10으로 나눠서 나머지 4 ->123을 10으로 나눠서 나머지 3
		
		int tmp = num;
		
		if(!checkNumber(num,4)) {
			System.out.println("4자리 정수가 아닙니다.");
			return;
		}
		
		while(tmp > 0) {
			//1의 자리 숫자 출력
			System.out.print(tmp % 10);
			//1의 자리 숫자 제거
			tmp /= 10;
			//
		}
		
		//1234를 1000으로 나누면 1 > 1000으로 나눈 나머지 234 > 100으로 나누면 2 > 
		
		
		
		int res [] = new int [4];
		tmp = num;
		for(int i = 0; i < res.length; i++) {
			int lastNum = tmp / (int)pow(10,res.length - (i + 1));   
			res[i] = lastNum;										//lastNum 생략해도 되지만 명확성을 위해
			tmp = tmp % (int)pow(10,res.length - (i + 1));
		}
		System.out.println();
		for(int i =res.length - 1; i >= 0; i--) System.out.print(res[i]);
		
		
		
		
		
		
		
		
		
		
		
	}

	public static boolean checkNumber(int num, int size) {
		int min = 1 * (int)pow(10,size-1);				//n자리 정수인지 확인 4자리면 1000부터 10000까지
		int max = 1 * (int)pow(10,size);
				//Math.pow(a, b) -> a의 b제곱 함수(double형식)
		if(num >= max || num < min) return false;
		return true;
	}

	public static double pow(int a, int n) {			//math.pow 
		if(n == 0) return 1;

		double res = 1;
		if(n > 0) {
			for(int i = 0; i < n; i++) res *= a;	
			return res;
		}
		n = -n;											//음수의 경우 
		for(int i = 0; i < n; i++) {
			res /= (double)a;
		}
		return res;
	}

}
