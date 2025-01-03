package day004;

public class Ex06_VariableAgument {

	public static void main(String[] args) {

		
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3,4,5,6,7));
		
		
		
		
	}
	//가변매개변수 이용하여 여러개의 정수를 합하는 메소드 예제
	public static int sum(int ... nums) {
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		return sum;
		
	}
	
	int sum1(int num1, int num2) {
		return 0;
	}
	
	
}
