package day006;

public class Ex03_ArrayCopy {

	public static void main(String[] args) {
		
		
		int [] arr1 = new int[] {1, 3, 5, 7, 9};
		int [] arr2;
		
		
		//arr1의 값을 arr2에 복사
		print(arr1);
		
		
		
		
		arr2 = arr1;			//arr2는 arr1의 주소만 가져오기 때문에 arr1이 바뀌면 같이 바뀐다
		arr1[0] = 10;
		print(arr2);		
		
		arr1[0] = 1;
		
		
		
		
		int [] arr3 = new int[arr1.length];
		for(int i = 0; i < arr1.length; i++) arr3[i] = arr1[i];
		arr1[0] = 10;
		print(arr3);
		
		
		
		
		int arr4 [] = new int[arr3.length];
		System.arraycopy(arr3, 0, arr4, 0, 5);
		print(arr4);
		
		
		
		int arr5[] = new int[arr4.length];
		System.arraycopy(arr3, 0, arr5, 2, 2);
		print(arr5);
		
		
	}

	private static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
}
