package day008;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class Ex09_Object {

	public static void main(String[] args) throws CloneNotSupportedException {

		
		String str = "abc";
			
		System.out.println(str);			//.toString()이 생략된 형태
		System.out.println(str.toString());	
		
		
		
		Point p = new Point();
		
		System.out.println(p);
		System.out.println(p.toString());
		//println  은 매개변수가 클래스의 객체이면 객체의 toString을 호출해서 출력
		// ->모든 클래스는 object클래스 상속 -> 물려받은 toString 을 가짐(by 매개변수의 다형성)
		
		
		Student std1 = new Student(1, 1, 1, "홍길동", "국어", 100);
		Student std2 = new Student(1, 1, 2, "홍길동", "국어", 100);
		Student std3 = new Student(1, 1, 1, "임꺽정", "국어", 90);
		
		System.out.println(std1.equals(std2));
		System.out.println(std1.equals(std3));
		
		//Student std4 = std3; 이건 주소만 복사
		
		Student std4 = (Student)std1.clone();		//addtrow 선택
		std1.score = 90;
		System.out.println(std4.toString());
		
		
	}

	public void println(Object object) {
		System.out.println(object.toString());
	}
	
	
}


//@Data -> 이거 넣으면 toString 안넣어도 됨. 오버라이드 하면 직접 꾸며줄수 있음(우크릵->소스->제너레이트 투스트링)					
class Point{
	private int x, t;

	@Override
	public String toString() {
		return "Point [x=" + x + ", t=" + t + "]";
	}
}
@AllArgsConstructor
@ToString
class Student{
	int grade, classNum, num;
	String name, subject;
	int score;
	/*public Student(int grade, int classNum, int num, String name, String subject, int score) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.score = score;
	}*/
	//우클릭 소스 제너레이트 해시/이퀄스
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num, subject);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num
				&& Objects.equals(subject, other.subject);  //object.equals랑 다름(클래스)
	}
	@Override
	public Object clone() throws CloneNotSupportedException{	//클론은 protected라 못쓰는 경우가 발생
		return super.clone();									//overriding 직접 해줘야 가능
	}
	
}