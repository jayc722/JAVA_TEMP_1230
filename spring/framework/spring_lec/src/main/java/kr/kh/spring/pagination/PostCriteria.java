package kr.kh.spring.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {

	private int po_bo_num;
	
	public PostCriteria(int page, Integer perPageNum) {
		super(page, perPageNum);	//부모인 criteria의 생성자
	}
		
}
