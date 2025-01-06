package day005;

import java.util.Scanner;

public class Ex08_Array {

	public static void main(String[] args) {
		// 학생 3명의 국어성적 관리하기 위해 배열 선언,
		//콘솔을 통해 성적 입력받고, 입력받은 성적을 출력하는 코드
		
		
		int studentCount = 3;
		int [] kors = new int[studentCount];
		
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < studentCount; i++) {
			System.out.print("학생" + (i + 1) + "국어 성적 입력 : ");
			kors[i] = scan.nextInt();
		}
		
		for(int i = 0; i < studentCount; i++) {
		System.out.println(kors[i]);		//배열을 변수처럼 사용 가능
		}
		
		int sumKor = 0;
		for(int i = 0; i < studentCount; i++) {
			sumKor += kors[i]; 
		}
		System.out.println("국어 성적 평균 : " + (double)sumKor/studentCount);
		
		
		
	}

}
