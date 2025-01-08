package day007;

public class Ex02_For {

	public static void main(String[] args) {
		//1부터 10까지 합
		
		int max = 10, sum = 0;
		for(int i = 1; i <= max; i++ ) {
			if(i % 2 == 0) sum -= i;
			else sum += i;
		}
		
		System.out.println(sum);

	}

}
