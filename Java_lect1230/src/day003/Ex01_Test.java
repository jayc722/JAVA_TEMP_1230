package day003;

import java.util.Scanner;

public class Ex01_Test {

	public static void main(String[] args) {
		/*세 학생의 국어 성적을 입력받아 총점과 평균을 구하는 코드를 작성하세요.
		 * 
		 */

		Scanner scan = new Scanner(System.in);
		
		
		int scoreA=0, scoreB=0, scoreC=0, scoreTot=0;
		double scoreAve=0;
		
		for(int i = 0; i==0;) {
		System.out.print("A학생의 국어 성적을 입력하세요. : ");
		scoreA = scan.nextInt();
		System.out.println(scoreA + "점");
		if(scoreA<0||scoreA>100) {
			System.out.println("0에서 100 사이 값을 입력해주세요");
		}else i++;
		
		}
		for(int i = 0; i==0;) {
			System.out.print("B학생의 국어 성적을 입력하세요. : ");
			scoreB = scan.nextInt();
			System.out.println(scoreB + "점");
			if(scoreB<0||scoreB>100) {
				System.out.println("0에서 100 사이 값을 입력해주세요");
			}else i++;
			
			}
		for(int i = 0; i==0;) {
			System.out.print("C학생의 국어 성적을 입력하세요. : ");
			scoreC = scan.nextInt();
			System.out.println(scoreC + "점");
			if(scoreC<0||scoreC>100) {
				System.out.println("0에서 100 사이 값을 입력해주세요");
			}else i++;
			
			}
		
		scoreTot = scoreA + scoreB + scoreC;
		scoreAve = (double)scoreTot / 3;					//scoreTot/3.0 하는게 더 간편
		
		System.out.printf("총점은 " + scoreTot + "점, 평균은 " + "%.2f" + "점 입니다.",scoreAve);
		
		
	}

}
