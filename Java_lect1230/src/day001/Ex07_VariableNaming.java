package day001;

public class Ex07_VariableNaming {

	public static void main(String[] args) {

		int num = 10;
		int NUM = 10;		//	1. 대소문자 구분
		
		//int int; 			//	2. 예악어(키워드) 사용 불가
		
		//int 4num = 10;	//	3. 변수명은 숫자로 시작 x
		
		
		int _num = 10;		//	4. 특수문자는 _와 $만 가능
		
		//int n um = 10;
		//int %num = 10;
		
		//int num = 20;		//	5. 중복 선언 불가
		
		System.out.println(num + NUM + _num);
	}

}
