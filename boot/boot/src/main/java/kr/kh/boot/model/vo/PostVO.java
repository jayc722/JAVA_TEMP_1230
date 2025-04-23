package kr.kh.boot.model.vo;

import java.util.List;

import lombok.Data;

@Data
public class PostVO {
	int po_num;
	String po_title;
	String po_content;
	String po_me_id;
	int po_view;
	int po_up, po_down;
	int po_bo_num;
	String po_del;
	String po_date;	//date가 아니라 String으로 해서 별거 안해도 예쁘게 나오지만 수정은 귀찮음
	
	List<CommentVO> list;
}
