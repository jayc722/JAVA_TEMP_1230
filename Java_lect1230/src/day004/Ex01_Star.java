package day004;

public class Ex01_Star {

	public static void main(String[] args) {
		//  오른쪽에 붙은 삼각형
		
		
		
		int max = 5;
		
		
		
		for ( int i = 1; i <= max; i++) {
			for ( int j = 1; j <= max - i; j++) System.out.print(" ");
			for (int k = 1; k <= i; k++)System.out.print("*");
			System.out.println();
		}
		
		
		for ( int i = 1; i <= max; i++) {
			for ( int j = 1; j <= max - i; j++) System.out.print(" ");
			for (int k = 1; k <= 2*i - 1; k ++) System.out.print("*");
			System.out.println();
		}
		
		
		for ( int i = 1; i <= max; i++) {
			for ( int j = 1; j <= max - i; j++)	System.out.print(" ");
			for (int k = 1; k <= i; k++) System.out.print("*");
			for (int l = 1; l < i; l++) System.out.print("*");
			System.out.println();
		}
		
		int max2 = 7;
		
		for ( int i = 1; i <= max2; i++) {
			if(i <= (max2 + 1) / 2) {
				for ( int j = 1; j <= max2 - i - (max2/2); j++) System.out.print(" ");
				for (int k = 1; k <= 2*i - 1; k ++) System.out.print("*");
			}else {
				for (int j = 1; j <= i - 1 - (max2/2); j++) System.out.print(" ");
				for (int k = 1; k <= 2*(max2 - i + 1) - 1; k ++) System.out.print("*");
			}
			System.out.println();			
			
		}
		
		
		
		
		
		

	}

}
