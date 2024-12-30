package day001;

public class Ex13_EvenNumber {

	public static void main(String[] args) {
		// 주어진 넘버가 짝수이면 true를 아니면 false가 출력되도록 코드를 작성하세요.
		
		int num = 3;
		
		
		
		boolean even = 1 != (num % 2);
		
		System.out.println(num + " 은 짝수인가? " + even);
		

	}

}
