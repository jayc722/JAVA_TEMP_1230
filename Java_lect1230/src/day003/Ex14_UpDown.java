package day003;

import java.util.Random;
import java.util.Scanner;

public class Ex14_UpDown {

	public static void main(String[] args) {
		/* 1 에서 100 사이 랜덤한 수를 생성해서 맞히는 게임
		 * 예시
		 * 랜덤한 수 : 30
		 * 입력 : 50
		 * Down! 출력
		 * 입력 : 10
		 * Up! 
		 * 입력 : 30
		 * 정답! 
		 */
		
		Scanner scan = new Scanner(System.in);

		int randNum = (int)(Math.random()*100) + 1;
		Random random = new Random();
		int r = random.nextInt(100) + 1;
		
		System.out.println(randNum);
		
		int count = 1;
		for(;;) {
			System.out.print(count + " 번째 시행. 1에서 100 사이의 숫자를 입력해 주세요 : ");
			int num = scan.nextInt();
			if(num<1||num>100) {
				System.out.println("1에서 100 사이 숫자를 입력해 주세요.");
			}else if(num>randNum) {
				System.out.println("DOWN!");
				count++;
			}else if(num<randNum) {
				System.out.println("UP!");
				count++;
			}else  break;
		}
		System.out.println("정답은 " + randNum + " 이었습니다. 시행 횟수 : " + count);

		count = 1;
		for(int num = 0;num != r;) {
			System.out.print(count + " 번째 시행. 1에서 100 사이의 숫자를 입력해 주세요 : ");
			num = scan.nextInt();
			if(num<1||num>100) {
				System.out.println("1에서 100 사이 숫자를 입력해 주세요.");
			}else if(num>r) {
				System.out.println("DOWN!");
				count++;
			}else if(num<r) {
				System.out.println("UP!");
				count++;
			}else {
				System.out.println("정답은 " + r + " 이었습니다. 시행 횟수 : " + count);
			}
		}
		
		
	}

}
