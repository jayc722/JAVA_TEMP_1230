package day023;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Ex14_Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<String> list = Arrays.asList("안녕", "홍길동", "KH", "테스트", "고길동");		//간편하게 초기화할때 사용
		
		//문자열에 길동이 포함된 문자열 출력
		
	
		String str = "길동";
	
		for(String tmp : list) {
			if(tmp.contains(str)) {
				System.out.println(tmp);
			}
		}
		
		//스트림을 이용
		/*	//안되네...
		Stream<String> stream = list.stream();
		
		stream.filter((p)->{return p.contains(str);});
		*/
		
		
		
		list.stream().filter(s->s.contains(str)).forEach(s->System.out.println(s));
	
		//스트림을 이용하여 3글자 문자열 출력 코드 작성
		//스트림 정의해서 사용하면 한번 사용한거 재사용 불가 ->새로 만들거나 이렇게 일회용으로 쓰거나
		
		list.stream().filter(s->s.length()==3).forEach(s->System.out.println(s));
		
		Stream<String> stream = list.stream();
		stream = list.stream();
		stream.filter(s->s.length()==3).forEach(s->System.out.println(s));
		//stream.filter(s->s.length()==3).forEach(s->System.out.println(s));	//얘는 스트림 새로 만들어야
		
	}
}
