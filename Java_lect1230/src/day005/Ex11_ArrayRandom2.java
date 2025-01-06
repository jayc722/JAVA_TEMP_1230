package day005;

import java.util.Random;

public class Ex11_ArrayRandom2 {

	public static void main(String[] args) {
		/* 1에서 10 사이의 중복되지 않은 랜덤한 수 6개를 배열에 저장하는 코드를 작성
		 * 저장된 개수가 6개가 될때까지 반복
		 * 배열의 0번지부터 저장된 개수만큼 확인해서 있는지 없는지 확인
		 * 있으면 건너뜀
		 * 없으면 배열에 저장하고 저장된 개수를 1 증가
		 */

		
		int count = 0;
		int [] arr = new int[6];
		int min = 1, max = 7;
		

		//////////////////////////////////////////////////
		
		int [] arr2 =	createRandomArray(min, max, 6);
			
		printArray(arr2);
		
		
		
		///////////////////////////////////////////////////
		
		while(count < arr.length) {
			int r = (int)(Math.random()*(max-min+1)+min);
			
			if(contains(arr,r)) continue;
			arr[count] = r;
			count++;
		}
		
		printArray(arr);
	
	}


	public static int [] createRandomArray(int min, int max, int size) {
		if(size <= 0) {
			return null;
		}
		
		int [] arr = new int [size];
		int count = 0;
		
		while(count < arr.length) {
			int r = (int)(Math.random()*(max-min+1)+min);
			boolean result = false;
			
			for(int i = 0; i<arr.length;i++) {
				if(arr[i] == r) {
					result = true;
					break;
				}
			}
			
			if(result) {
				continue;
			}

			arr[count++] = r;
		}
		return arr;
	}
	
	



	public static void printArray(int [] arr) {

		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}





	public static boolean contains(int[]arr, int num) {
		
		for(int i = 0; i < arr.length; i++) {						
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}
}
