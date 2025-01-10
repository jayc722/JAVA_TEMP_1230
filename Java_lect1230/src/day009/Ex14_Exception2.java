package day009;

import java.util.Arrays;

public class Ex14_Exception2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int [] arr = new int[5];
		
		System.out.println(Arrays.toString(arr));

		/*

		try {
			arr= expand(arr, -10);							//축소하는 경우 복사에서 문제 발생
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}

		*/

		try {
			arr = null;								//배열이 null이면 문제 발생
			arr = expand(arr, 100);
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("프로그램 종료");




	}



	public static int [] expand(int [] arr, int addSize) {


		//arr배열에 addSize만큼 크기를 늘려서 새로운 배열을 만들어 반환하는 메소드 구현

		//발생 가능한 예외 처리

		if(addSize < 0) throw new RuntimeException("배열을 축소할 수 없습니다");

		if(arr == null) throw new NullPointerException("없는 배열을 확장할 수 없습니다.");

		int [] arr2 = new int [arr.length + addSize];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		return arr2;

	}

}
