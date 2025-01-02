package day003;

public class Ex21_NestingStar {

	public static void main(String[] args) {
		// 별 다섯개 다섯줄
		
		
		for(int j = 1; j <= 5; j++ ) {
		for(int i = 1; i <= 5; i++ ) System.out.print("*");
		System.out.println();
		}
		
		
		for(int j = 1; j <= 5; j++ ) {
			for(int i = 1; i <= j; i++ ) System.out.print("*");
			System.out.println();
			}

	}

}
