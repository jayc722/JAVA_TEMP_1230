package day003;

import java.util.Random;

public class Ex13_Random {

	public static void main(String[] args) {
		/* min ~ max 사이 랜덤한 수를 생성하는 코드
		 * 
		 */

		int min = 1, max =7;
		
		// Math.random() : 0이상 1미만 랜덤한 실수를 제공
		// 0 <= r < 1
		// 각 항에 (max - min + 1)을 곱함
		// 0 <= r * (max - min + 1) < max - min + 1
		// min ~ max
		
		int r = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(r);

		Random random = new Random();
		r = random.nextInt(max - min + 1) + min; 	// 0부터 해당하는 값 사이 랜덤한 정수를 생성
		System.out.println(r);
		
		
		
	}
	
}
