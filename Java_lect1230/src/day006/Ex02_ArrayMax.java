package day006;

public class Ex02_ArrayMax {

	public static void main(String[] args) {
		// 배열에 저장된 값 중 가장 큰 값을 출력하는 코드
		
		int [] arr = new int[] {1, 10, 9, 20, 3, 4};

		int temp = arr[0];			//temp = Integer.MIN_VALUE; 하면 정수의 최솟값 가능
									//temp = 0; 으로 할 경우 배열 모든 요소가 음수일 경우 0 출력
			
		for(int i = 0; i < arr.length; i++) {				//배열의 크기 이용

			if (temp < arr[i]) {
				temp = arr[i];
			}


		}
		System.out.println(temp); 

	}

}
