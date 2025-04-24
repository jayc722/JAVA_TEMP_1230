package kr.kh.boot.dao;

import java.util.List;

import kr.kh.boot.model.vo.CommentVO;
import kr.kh.boot.utils.CommentCriteria;
import kr.kh.boot.utils.Criteria;

public interface CommentDAO {

	boolean insertComment(CommentVO comment);

	List<CommentVO> selectCommentList(Criteria cri);

	int selectCountCommentList(CommentCriteria cri);

	boolean deleteComment(int co_num);
	
}
