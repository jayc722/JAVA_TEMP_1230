package day003;

public class Ex15_WhileEvenNumber {

	public static void main(String[] args) {
		/*1에서 10 사이 짝수 출력 while문 예제
		 * 
		 * while문은 변수선언x
		 * 
		 * while(조건식){
		 *  	실행문;
		 *  	증감식;
		 *  }
		 */

		int i = 1;
		while(i <= 10) {
			if(i % 2 ==0) System.out.print(i + " ");	
			i++;
		}
		System.out.println();
		i = 0;
		while(++i <= 10) {						//이런식으로 편법 이용 가능
			if(i % 2 != 0) {
				continue;						//조건식으로 감(증감식x)
			}
			System.out.print(i + " ");
		}
		
		
		
		
		
	}

}
