package day001;

public class Ex04_VariableOverflow {

	public static void main(String[] args) {

		
		byte num1 = 127;
		num1++;					//num1에 1 증가 -> 127 > -128 오버플로우
		System.out.println(num1);
		
		byte num2 = -128;
		num2--;
		System.out.println(num2); 	//언더플로우
		//정수타입 설정의 중요성
		
		
		
	}

}
