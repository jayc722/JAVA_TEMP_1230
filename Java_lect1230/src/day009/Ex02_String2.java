package day009;

import java.util.Scanner;

public class Ex02_String2 {

	public static void main(String[] args) {
		/* 파일명 수정 기능 구현
		 * 기존 파일명 입력(확장자를 포함)
		 * 수정하려는 파일명 입력(확장자 제외)
		 * 파일명 수정
		 * 
		 * 입력 : test.txt
		 * 수정 : 연습
		 * 결과 : 연습.txt
		 * 
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("입력하려는 파일명 입력 (확장자 포함) : ");
		
		String fileName =scan.nextLine();		//처음 입력하는 scan은 입력버퍼에 엔터 x
		System.out.println("파일명 : " + fileName);
		
		int index = fileName.lastIndexOf("."); 
		
		if(index < 0) {
			System.out.println("확장자가 없는 파일입니다.");
			return;
		}
		
		System.out.print("수정하려는 파일명 입력 : ");
		
		String rpName =scan.nextLine();		//전에 nextLine이라 엔터 x
		
		String oriFileName = fileName.substring(0, index);
		
		fileName = fileName.replace(oriFileName, rpName);
		
		System.out.println(fileName);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
