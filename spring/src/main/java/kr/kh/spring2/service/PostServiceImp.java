package kr.kh.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.PostDao;
import kr.kh.spring2.model.vo.BoardVO;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	private PostDao postDao;

	@Override
	public List<BoardVO> getBoardList() {
		// 매개변수 없으니 매개변수 체크할 필요 x
		return postDao.selectBoardList();
	}
	
	
}
