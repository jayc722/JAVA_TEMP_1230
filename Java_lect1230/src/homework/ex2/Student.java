package homework.ex2;

import lombok.Data;

//getter setter toString equals 등을 제공
@Data
public class Student {

	
	
	private int grade, classNum, num;			//다 private 로 하는게 맞음. 일단
	private String name;
	
	
	
	

	public Subject [] list;			//학생 인스턴스 하나가 과목들을 각각 갖고 있음
									//private로 하는게 원래는 맞음. 게터세터 각각 입력해야
	
	
}
