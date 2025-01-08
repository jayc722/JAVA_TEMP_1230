package day007;

public class Ex01_For {

	public static void main(String[] args) {
		//1에서 16까지 출력 코드
		
		int max = 16, enter = 4;
		for(int i = 1; i <= max; i++) {
			
			System.out.print(i + " ");
			if(i % enter == 0) {
				System.out.println();
			}
			
		}
		
		
		
	}

}
