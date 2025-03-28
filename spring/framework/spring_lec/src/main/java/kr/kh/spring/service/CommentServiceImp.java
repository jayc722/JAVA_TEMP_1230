package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	private CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null) {
			return false;
		}
		if(user == null) {
			return false;
		}
		try {
			comment.setCo_me_id(user.getMe_id());
			return commentDao.insertComment(comment);
		}catch ( Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) return null;
		
		
		return commentDao.selectCommentList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		if(cri == null) return null;			//여기서 null 올일은 없지만 null체크는 항상 하는 습관을...
		
		
		return new PageMaker(3, cri, 0);		// 여기선 cri에 있는 search를 가져오기 위함
	}

}
