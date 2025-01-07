package day006;

public class Ex01_Swap {

	public static void main(String[] args) {
		// 두 정수의 값을 바꾸는 코드 작성
		
		int num1 = 10, num2 = 20;
		
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		int temp = num1;
		
		num1 = num2;
		
		num2 = temp;
		
		System.out.println("num1 = " + num1 + ", num2 = " + num2);

	}

}
