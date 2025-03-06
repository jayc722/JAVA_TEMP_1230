package db.ex1.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentVO {

	
	private int st_key;		//변수들은 카멜 표기법 따라야 하지만...
	private int st_grade;
	private int st_class;
	private int st_num;
	private String st_name;
	
	
	//학생객체 toString 
	@Override
	public String toString() {
		return st_grade + "학년 " + st_class + "반 "
				+ st_num + "번 " + st_name;
	}
	
	
}
