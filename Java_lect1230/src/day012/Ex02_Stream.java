package day012;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex02_Stream {

	public static void main(String[] args) {

		List<Person2> list = new ArrayList<Person2>();
		list.add(new Person2("홍길동", 20, "남"));
		list.add(new Person2("하니", 20, "여"));
		list.add(new Person2("산타", 80, "남"));
		list.add(new Person2("또치", 75, "여"));
		
		Stream<Person2> stream = list.stream();
		
		//남자들의 정보만 출력
		
		stream
			.filter((p)->{										//남자만 남도록	 predicate 매개변수 ->boolean 매개변수 person
				return p.getGender().equals("남");				//그냥 리턴트루만 넣으면 -> 전체 출력
			})													//실행문 한줄로 허면
																//.filter(p->p.getGender().equals("남"));
			
			.forEach(p -> System.out.println(p));				//정보 출력
		System.out.println("------------------------------------");
		
		//나이 30 미만인 여자들의 정보만 출력
		//스트림 재사용 안됨 다시 생성	->같은이름 ㅇ
		stream = list.stream();
		
		stream
		.filter (p -> p.getAge() < 30)
		.filter (p -> p.getGender().equals("여"))		//&&로 해도 됨
		.forEach(p -> System.out.println(p));
		System.out.println("------------------------------------");
		
		
		//여자들 수
		stream = list.stream();
		
		long count = stream
					.filter (p -> p.getGender().equals("여"))		
					.count();										//forEach 대신 count	->리턴이 long
		
		System.out.println("여자들의 수 : " + count);
		System.out.println("----------------------x--------------");
		
		
		
		//map
		//평균나이 계산
		//map은 person2를 R로 리턴 
		//mapToInt()는 Person2를 Integer로 리턴 -> 미리 만들어놓기
		//OptionalDouble를 쓰는 이유 : average() 는 평균을 구하는데 스트림에 아무것도 없어서 평균 구할수없는 경우 발생 
		//-> OptionalDouble에는 isPresent() 메소드를 통해 평균이 있는지 없는지 확인 가능
		stream = list.stream();
		OptionalDouble avg = stream.mapToInt(Person2::getAge).average(); 		//나이 추출해서 보내줌
		//OptionalDouble avg = stream.mapToInt(p->p.getAge()).average();
		if(avg.isPresent())System.out.println("평균 나이 : " + avg.getAsDouble()); //OptionalDouble -> isPresent
		else System.out.println("일치하는 사람 없습니다.");
		
		
		//orElse는 OptionalDouble에서 제공하는 메소드로 평균이 있으면 평균, 없으면 ()값을 double로 반환
		stream = list.stream();
		double avg2 = stream.mapToInt(Person2::getAge).average().orElse(0);		//같은 내용. 없으면 0을 출력
		System.out.println("평균 나이 : " + avg2);
		
		//스트림을 객체로 변환
		
		stream = list.stream();
		List<Person2> list2 = stream.filter(p -> p.getAge()>30).collect(Collectors.toList());
		System.out.println(list2);
		
		//숫자와 함께 출력
		stream = list.stream();
		
		AtomicInteger index = new AtomicInteger(0);		//숫자 0부터 1까지 자동증가
		
		stream.forEach( p ->{
			int curIndex = index.getAndIncrement();		//현재 번지 가져오고 1증가
			System.out.println(curIndex + 1 + ". " + p);//변수가 람다식에 들어가면 상수가 되기 때문
		});
		
		
	}

}



@Data
@AllArgsConstructor
class Person2{
	private String name;
	private int age;
	private String gender;
}