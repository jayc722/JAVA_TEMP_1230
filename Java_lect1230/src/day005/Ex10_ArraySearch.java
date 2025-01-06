package day005;


public class Ex10_ArraySearch {

	public static void main(String[] args) {
		/* 다음 배열에 num 이 있는지 없는지 판별하는 코드
		 * 
		 */

		
		
		
		int [] array = new int[] {1,2,3,4,5};
		int num = 4;
		

		boolean result = false;
		for(int i=0; i<array.length; i++) {				//배열의 길이
			if (array[i] == num) {
				System.out.println((i+1) + " 번 째");
				result = true;
				break;
			}
					
		}
		if(!result) {
			System.out.println("해당하는 숫자 " + num + " 가 없었습니다.");
		}
		
		if(contains(array, num)) {
			System.out.println("해당하는 숫자 " + num + " 가 없었습니다.");
		}
		
		if(contains(array, 3, num)) {
			System.out.println("해당하는 숫자 " + num + " 가 없었습니다.");
		}
		
		
		
		
		
	}

	/* 배열에 num 가 있는지 알려주는 메소드
	 * 매개변수 : 배열과 num => int[]arr, int num
	 * 리턴타입 : 있는지 없는지 => boolean 
	 * 메소드명 : contains 
	 */
	
	public static boolean contains(int[]arr, int num) {
		for(int i=0; i<arr.length; i++) {						//배열의 길이
			if (arr[i] == num) {
				System.out.println((i+1) + " 번 째");
				return true;
			}
		}
		return false;
	}
	
	
	/* 배열 중 0 번지부터 n 개를 비교하여 num 가 있는지 없는지 알려주는 메소드
	 * 매개변수 : 배열, 비교 개수, num => int[] arr, int count, int num
	 * 리턴타입 : 있는지 없는지 => boolean
	 * 메소드명 : contains (메소드 오버로딩으로 매개변수가 다르기때문에 동명의 메소드 존재 가능)
	 * 
	 */
	
	public static boolean contains(int[]arr, int count, int num) {
		if(arr.length < count) count = arr.length;			//배열의 크기보다 큰 숫자가 count로 오면 count를 배열의 크기로 변경.
		for(int i = 0; i < count; i++) {						
			if (arr[i] == num) {
				System.out.println((i+1) + " 번 째");
				return true;
			}
		}
		return false;
	}
	
}
