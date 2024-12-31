package day002;

public class Ex07_IfNumber {

	public static void main(String[] args) {
		/*
		 * num가 0보다 크면 양수라고 출력 0이면 0이라 출력 0보다 작으면 음수라고 출력
		 */
		
		
		int num = 5;
		
		if(num > 0) {
			System.out.println(num + " 는 양수입니다");
		}else if(num == 0) {
			System.out.println(num + " 는 0입니다");
		}else if(num < 0) {
			System.out.println(num + " 는 음수입니다");
		}else {
			System.out.println("--");
		}
		
		
		
		
	}

}
