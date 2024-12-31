package day002;

import java.util.Scanner;

public class Ex10_Scanner {

	public static void main(String[] args) {
	
		// Scanner를 이용해서 콘솔에서 입력받은 값 활용하는 예제
		
		
		Scanner scan = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println("입력받은 정수 : " + num);
		
		System.out.print("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println("입력받은 실수 : " + num2);
		
		System.out.print("단어를 입력하세요 : ");		//next()는 공백을 제외한 단어를 가져옴
		String str = scan.next();
		System.out.println("입력받은 단어 : " + str);
		
		System.out.print("문자를 입력하세요 : ");
		char ch = scan.next().charAt(0); 	//스캐너에는 문자입력이 없음 > charAt은 가져온 단어의 n번째 글자를 가져옴 
		System.out.println("입력받은 문자 : " + ch);
		
		scan.nextLine();		//앞에서 입력한 엔터를 처리하기 위해 사용
		
		System.out.println("문장을 입력하세요"); //
		String str2 = scan.nextLine();						// nextLine은 엔터 전까지
		System.out.println("입력받은 문장 : " + str2);
		
		
		scan.close();
	}

}
