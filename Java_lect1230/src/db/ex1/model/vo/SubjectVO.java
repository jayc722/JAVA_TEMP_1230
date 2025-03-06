package db.ex1.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectVO {

	//subjectVO의 필드명은 subject 테이블의 속성이름과 반드시 같아야?  => 반드시는 아님.
	//같게 하는 이유 : Mapper에서 추가 작업을 하지 않기 위해(속성명과 변수명이 다르게 하려면 추가 작업 필요)  => 오타 있는 경우엔 기본값(int는 0 문자열은 null)
	
	private int sj_num;		
	private int sj_grade;
	private int sj_semester;
	private String sj_name;
	
	
	
	@Override
	public String toString() {
		return sj_grade + "학년 " + sj_semester + "학기 "
				+ sj_name;
	}
	
	
	
}
