package day006;

import java.util.Arrays;
import java.util.Collections;

public class Ex06_ArraySort {

	public static void main(String[] args) {
		// 정렬 예제  - 정렬 : 알고리즘 학문이 따로 있음, 방식에 따라 수행속도 천차만별
		// 자바는 라이브러리로 정렬 제공해줌
		int [] arr = new int[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		
		//버블정렬 - 수행속도 느림	시간복잡도 0(n^2)
		//하나씩 정렬 - arr.length - 1번 항까지 비교를 총 arr.length - 1 번 실행 
		for (int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j+1]) {						//오름차순. 여기 부호 반대로 하면 내림차순.
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		Ex05_EnhancedFor.print2(arr);			

		int [] arr2 = new int[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		
		Arrays.sort(arr2);								//오름차순 정렬
														//Dual-Pivot Quicksort 알고리즘 이용. 시간복잡도 O(nlogn)*/
		System.out.println(Arrays.toString(arr2));		//배열을 문자열로 변환 [값, 값, ...
		//System.out.println(arr2);						//값이 아니라 주소가 나옴
		
		Integer [] arr3 = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		//배열의 내림차순은 기본 자료형으로는 제공x -> integer 배열을 활용
		//Arrays.sort(arr2, Collections.reverseOrder());		//안됨
		Arrays.sort(arr3, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr3));
		
	}

}
