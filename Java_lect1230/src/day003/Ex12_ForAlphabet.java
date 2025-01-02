package day003;

public class Ex12_ForAlphabet {

	public static void main(String[] args) {
		//a부터 z까지 출력하는 코드

		/*반복횟수 : i는 0부터 26보다 작을때까지 1씩 증가
		 * 규칙성 : (char)('a" +i)를 출력
		 * 반복문 종료후 : 없음
		 */
		
		
		char alp = 65;
		System.out.println(alp + " ");

		
		for(int i=0;i<26;i++) {
			System.out.print((char) (i+'a') + " ");
		}		
		
		
		System.out.println();
		/* 반복횟수 : ch는 'a'부터 'z'까지 1씩증가
		 * 규칙성 : ch를 출력
		 * 반복문 종료후 : x
		 */
		
		for(alp = 'a'; ;alp++) {
			System.out.print(alp + " ");
			if(alp == 'z')break;
		}
		
		System.out.println();
		
		for(char ch = 'a'; ch<='z'; ch++) {
			System.out.print(ch + " ");
		}
		
		
		
	}

}
