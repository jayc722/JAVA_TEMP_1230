package day003;

public class Ex03_ForEvenNumber {

	public static void main(String[] args) {
		// 10이하의 짝수를 출력하는 코드를 작성하세요
		
		
		int num = 10;		
		
		//반복횟수 : i 는 1부터 10까지 1씩 증가 규칙성 : i가 짝수이면 i를 출력
		
		for(int i=1; i<=num; i++ ) {
			if(i%2==0) {
			System.out.print(i + ", ");
			}
		}
		System.out.println("");
		
		//2~10 2씩 증가 i를 출력
		
		for(int i=2; i<=num; i +=2 ) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		
		//1~5 1씩 증가 2*i를 출력
		
		for(int i=1; i<=num/2; i++ ) {
			System.out.print((2*i) + ", ");
		}
	}

}
