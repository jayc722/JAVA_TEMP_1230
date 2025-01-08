package day007;

public class Ex03_PrimeNumber {

	public static void main(String[] args) {
		//소수인지 판별

		int num = 12;
		if(isPrime(num)) System.out.println(num + "은 소수");
		else System.out.println(num + "은 소수가 아님");

		
		//100이하의 소수 판별 배열 활용
		int max = 100;
		boolean primeArray [] = new boolean [max+1];
		
		for(int i = 0; i <= max; i++) {
			primeArray[i] = isPrime(i);
			if(primeArray[i])System.out.print(i + " ");
		}
		

	}


	public static boolean isPrime (int num) {
		int i;
		for(i = 2; i < num; i++) { 
			if(num % i == 0)break;
		}
		if(i==num) return true;
		return false;

	}




}
