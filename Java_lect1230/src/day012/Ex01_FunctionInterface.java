package day012;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex01_FunctionInterface {

	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("홍길동", "000101-3", 24));
		list.add(new Person("고길동", "601212-1", 64));
		list.add(new Person("둘리", "000101-1", 24));
		list.add(new Person("또치", "801111-2", 44));
		
		
		//이름
		print(list, p -> System.out.println(p.getName()));
		System.out.println("-------------------");
		//전체
		print(list, p -> System.out.println(p));
		System.out.println("-------------------");
		//주민번호
		print(list, p -> System.out.println(p.getNum()));
		System.out.println("-------------------");
		
		
		
		//xx0101-x랜덤 생성
		Person p = randomNum(() -> {
			int year = (int)(Math.random()*(99 - 0 + 1) + 0);
			DecimalFormat df = new DecimalFormat("00");
			String yearStr = df.format(year);
			int gender = (int)(Math.random()*(4 - 1 + 1) + 1);
			String num = yearStr + "0101-" + gender;
			int age = (year>50) ? (126 - year) : 26 - year;
			return new Person("", num, age);
		});
		System.out.println(p);
		System.out.println("-------------------");
		
		//사람들 이름 출력
		printString(list, p1 -> p1.getName());
		System.out.println("-------------------");
		//사람들 주민번호 출력
		printString(list, p1 -> p1.getNum());
		System.out.println("-------------------");
		
		//consumer랑 출력 위치가 다름 


		//모든 사람들의 나이 1 증가
		replacePerson(list, p1->{
			p1.setAge(p1.getAge()+1);
		return p1;
		});
		print(list,p1->System.out.println(p1));
		System.out.println("-------------------");
		

		//홍길동인 사람의 이름을 홍끼라고 변경
		replacePerson(list, p1->{
			if(p1.getName().equals("홍길동"))p1.setName("홍씨");
			return p1;
		});
		print(list,p1->System.out.println(p1));
		System.out.println("-------------------");



	}
	//오퍼레이터는 매개변수 리턴타입 일치

	public static void replacePerson(List<Person> list, UnaryOperator<Person> op) {
		for(int i = 0; i < list.size(); i++) list.set(i,op.apply(list.get(i)));
	}


	//function은 매개변수 타입이 A이고 리턴타입이 B (A의 필드를 이용해 무언가로 가공해 가공된 결과를 활용
	public static void printString(List<Person> list, Function<Person, String>f) {		//f : 객체 이름
		for(Person p : list) System.out.println(f.apply(p));
	}

	//Supplier 매개변수x 리턴타입 ㅇ
	public static Person randomNum(Supplier<Person> p) {
		return p.get();
	}



	//consumer(매개변수 있고 리턴타입x)
	public static void print(List<Person>list, Consumer<Person> c) {
		for(Person person : list)c.accept(person);
			
	}
	
	
}



@Data
@AllArgsConstructor
class Person{
	private String name;
	private String num;
	private int age;
	
	public String getGender() {								
		String gender = num.substring(7, 8);
		switch(gender) {
		case "1", "3" :
			return "M";
		case "2", "4" :
			return "F";
		default :
			throw new RuntimeException("잘못된 성별");
		}
	}
	
}