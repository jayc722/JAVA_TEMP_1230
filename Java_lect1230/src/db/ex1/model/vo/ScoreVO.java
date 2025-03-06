package db.ex1.model.vo;

import lombok.Data;

@Data
//@AllArgsConstructor -> 추가하면 안됨(subject객체 안쓰는 예제가 있기 때문)
public class ScoreVO {

	private SubjectVO subject;
	
	private int sc_num;		
	private int sc_score;
	private int sc_st_key;
	private int sc_sj_num;
	
	
	
	@Override
	public String toString() {
		return subject + " : " + sc_score + "점";
	}

	
	
}
