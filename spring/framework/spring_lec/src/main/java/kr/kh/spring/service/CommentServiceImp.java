package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;

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

}
