package db.ex2_my.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data	
@RequiredArgsConstructor
public class Subject implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8676622834102556027L;
	/**
	 * 
	 */
	private int num;//sj_num
	@NonNull
	private int grade;//sj_grade
	@NonNull
	private int semester;//sj_semester
	@NonNull
	private String name;//sj_name

	@Override
	public String toString() {
		return grade +"학년 " + semester + "학기 " + name;
	}

}