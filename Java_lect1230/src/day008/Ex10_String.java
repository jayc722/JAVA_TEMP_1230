package day008;

public class Ex10_String {

	public static void main(String[] args) {

		String str = "abc";
		System.out.println(str + "에서 3번째 글자는? " + str.charAt(3-1));
		
		String str2 = new String("abc");
		//equals(문자열) : 같은 문자열인지 확인
		System.out.println(str + ".equals(" + str2 + ") :" + str.equals(str2));
		System.out.println(str + " == " + str2 + " : " + ( str == str2));
		
		String str3 = "Hello World!";
		String search = "l";
		
		//indexOf(문자열)
		int index = str3.indexOf(search);
		System.out.println(str3 + " 에서 첫 번째 " + search + " 의 위치는? " + index + "번지(없으면 -1)");
		
		//lastInexOf(문자열)
		index = str3.lastIndexOf(search);
		System.out.println(str3 + " 에서 마지막 " + search + " 의 위치는? " + index + "번지(없으면 -1)");
		
		//contains(문자열)
		System.out.println(str3 + " 에 " + search + " 가 있나? " + str3.contains(search));
		
		//length()
		System.out.println(str3 + " 의 길이 " + str3.length());
		
		//replace(a, b) a문자열이 있으면 b로 교체
		String str4 = "I love C언어. C언어는 최고.";
		String str5 = str4.replace("C언어", "JAVA");
		System.out.println(str5);
		
		//substring(index) : index번지 부터 마지막까지의 문자열
		String str6 = str5.substring(2);
		System.out.println(str6);
		//substring(index, endIndex) : index번지 부터 index-1까지의 문자열
		String str7 = str5.substring(2, str5.length()-1);
		System.out.println(str7);
		
		//toLowerCase()	: 소문자로
		//toUpperCase()	: 대문자로
		System.out.println(str5.toLowerCase());
		System.out.println(str5.toUpperCase());
		
		
		//trim() : 첫글자 앞의 공백과 마지막 글자 뒤의 공백 제거
		String str8 = "\n\n\n          abc \n\n\n";
		System.out.println(str8.trim());
		
		//String.valueOf : 기본형을 문자열로
		String str9 = String.valueOf(1);
		System.out.println(str9);
		
		//split(구분자) : 구분자를 기준으로 문자열을 추출하여 배열로 반환
		String fruits = "바나나 사과 딸기";
		String fruitList [] = fruits.split(" ");
		for(String fruit : fruitList){
			System.out.println(fruit);
		}
	
		
				
		
		
	}

}
