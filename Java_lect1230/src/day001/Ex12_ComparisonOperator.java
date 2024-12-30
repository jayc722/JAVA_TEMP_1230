package day001;

public class Ex12_ComparisonOperator {

	public static void main(String[] args) {
		// 비교연산자 예제 true / false
		int num1 = 1, num2 = 2;
		System.out.println(num1 + " > " + num2 + " ? " + (num1 > num2));
		System.out.println(num1 + " >= " + num2 + " ? " + (num1 >= num2));
		System.out.println(num1 + " < " + num2 + " ? " + (num1 < num2));
		System.out.println(num1 + " <= " + num2 + " ? " + (num1 <= num2));
		System.out.println(num1 + " == " + num2 + " ? " + (num1 == num2));
		System.out.println(num1 + " != " + num2 + " ? " + (num1 != num2));
		
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		
		System.out.println(str1 + " == " + str2 + " ? " + (str1 == str2));
		System.out.println(str1 + " == " + str3 + " ? " + (str1 == str3));
		System.out.println(str1 + " == " + str2 + " ? " + (str1.equals(str2)));
		System.out.println(str1 + " == " + str3 + " ? " + (str1.equals(str3)));

	}

}
