package homework.ex2.v1;
///////////////////////////////숙제////////////////////////////////////////

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
		
	
	
	private int grade;					//얘들도 원래는 private가 맞음
	private int semester;
	private String name;
	
	
	
	@Override
	public String toString() { //
		return grade + "학년 " + semester + "학기 " + name;
	}
	
	
									//과목은 학생별로 가지고 있어야
	
	
	
	
	
}
