package selfstudy.day018.copy;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("은행 입력");
		String bank = scan.nextLine();
		System.out.println("이름 입력");
		String name = scan.nextLine();
		System.out.println("계좌번호 입력");
		String account = scan.nextLine();
		while(true) {
		System.out.println("비밀번호 네자리 입력");
		String pw1 = scan.nextLine();
		System.out.println("비밀번호 확인");
		String pw2 = scan.nextLine();
		if(pw1.length()!= 4 || !pw1.equals(pw2)) {
			System.out.println("비밀번호가 네자리가 아니거나 재입력한 값이 다릅니다.");
			continue;
		}
		break;
		}
		

	}

}
