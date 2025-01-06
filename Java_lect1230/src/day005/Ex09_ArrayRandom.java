package day005;

import java.util.Random;

public class Ex09_ArrayRandom {

	public static void main(String[] args) {
		// 1에서 10 사이 랜덤한 수 6개 배열 생성
		//중복 허용


		System.out.println("1부터 10까지 랜덤한 수 6개 생성 : ");

		RandNums(1, 10, 6);

		System.out.println();
		System.out.println("------------------ ");


		int [] array2 = RandNums(1, 10, 6);
		System.out.println();
		for (int i = 0; i < 6; i++) {
			System.out.print(array2[i] + " ");
		}



	}

	public static int[] RandNums(int min, int max, int count) {

		if(count <=0) return null;		

		Random rand = new Random();
		int randNum [] = new int[count];

		for(int i = 0; i < count; i++) {
			randNum[i] = rand.nextInt(max - min + 1) + min;
			System.out.print(randNum[i] + " ");

		}

		return randNum ;

	}

}
