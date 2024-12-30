package day001;

public class Ex11_PrefixincrementOperator {

	public static void main(String[] args) {
	
		
		int num1 = 10, num2 = 10;
		
		System.out.println("증가 전 (전위형)num1 : " + num1);
		System.out.println("증가 전 (후위형)num2 : " + num2);
		
		++num1;
		num2++;
		
		System.out.println("증가 후 (전위형)num1 : " + num1);
		System.out.println("증가 후 (후위형)num2 : " + num2);
		
		
		System.out.println("\n------------------------\n");
		
		
		System.out.println("증가 전 (전위형)num1 : " + num1);
		System.out.println("증가 전 (후위형)num2 : " + num2);
		
		System.out.println("증가 중 (전위형)num1 : " + ++num1);
		System.out.println("증가 중 (후위형)num2 : " + num2++);
		
		System.out.println("증가 후 (전위형)num1 : " + num1);
		System.out.println("증가 후 (후위형)num2 : " + num2);
		
		
	}

}
