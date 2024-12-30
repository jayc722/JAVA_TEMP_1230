package day001;

public class EX02_VariableCharjava {

	public static void main(String[] args) {
		
		char ch1 ; 	//문자 변수 ch1을 선언
		// The local variable ??? may not have been initialized : 초기화 없이 사용시 발생
		//System.out.println(ch1);	//에러 발생
		ch1 = '1'; // 저장 0 		ch1 = '11'; 은 안됨. 한글자만
		System.out.println(ch1);	// 에러 x
		
		char ch2 = '한';	//선언과 동시에 초기화
		System.out.println(ch2);

		char ch3 = '\u0041';
		System.out.println(ch3); //유니코드 0041에 해당하는 A가 출력
		
		char ch4 = '\\' , ch5 = '\n' , ch6 = '\"';
		System.out.println(ch4);
		System.out.println(ch5);	//엔터	
		System.out.println(ch6);

	}

}
