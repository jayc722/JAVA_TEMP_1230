package day019;

public class Ex01_String {

	public static void main(String[] args) {
		// 주어진 문자열에서 검색어가 몇 번 들어가 있는지 확인하는 코드를 작성

		String str = "cabcbabcabcababbabcabcbacbabcabcbacbacbabcabc";
		String search = "ab";

		//내가한거 1번
		int count = 0;
		for(int i = 0; i < str.length()-1; i++) {
			if(str.substring(i, i+2).equals(search))count++;
		}
		
		System.out.println(str.substring(0, 2));
		System.out.println(str.subSequence(0, 2));
		
		System.out.println(search + "는 " + count + " 개 있습니다.");
		
		/* tmp에 str 저장 -> 그냥 덮어쓰면 원본문자열 못 찾음
		 * 
		 * 반복 : index가 -1이 되면 종료
		 * str에서 search가 몇번지에 있는지 확인 : index 
		 * 
		 * index 0이상이면 index +1번지부터 부분문자열을 추출해서 tmp에 저장
		 *  count 1 증가
		 * */
		
		String tmp = str;
		
		int index = 0;
		int count2 = 0;
		for(;index>=0;) {
			index = tmp.indexOf(search);
			if(index>=0) {
				tmp = tmp.substring(index+2);
				System.out.println(tmp);
				count2++;
				System.out.println(count2);
			}
		}
		System.out.println(search + "는 " + count2 + " 개 있습니다.");
		
		
		/////강사님///////////////
		
		String tmp3 = str;
		
		int index3 = -1, count3 = 0;

		do {
			index3 = tmp3.indexOf(search);
			if(index3 != -1) {
				count3++;
				int pos = index3 + search.length();
				if(pos >= tmp3.length()){
					index3 = -1;
					continue;
				}
				tmp3 = tmp3.substring(pos);
				//index3 = index3 + search.length() >= str.length() ? -1 : index3 + search.length(); 
				//if(index3 != -1) tmp3 = tmp3.substring(index3);
				//count3++;
			}
		}while(index3 != -1);
		System.out.println(str + "에 " + search + "가 " + count3 + "번 있습니다.");
		
	}

}
