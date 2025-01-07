package day006;

public class Ex05_EnhancedFor {
	//향상된 for문

	public static void main(String[] args) {
		int [] arr = new int[] {1, 5, 10, 2, 3};
		
		print(arr);
		System.out.println("------------");
		print2(arr);								//향상된 for문

	}

	
	public static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {			// 이 두줄이
			int tmp = arr[i];							//
			System.out.print(tmp + " ");
		}
		System.out.println();
	}
	
	public static void print2(int [] arr) {
		for(int tmp : arr) {							//이렇게 변함 (무조건 0번지부터 끝까지)
			System.out.print(tmp + " ");
			//tmp = 10;									//해도 표시되는것만 바뀌지 내용이 바뀌진 않음
		}
		System.out.println();
	}
	
	
	
}
