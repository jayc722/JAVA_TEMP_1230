package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;

@Service					//없으면  Unsatisfied dependency 에러 뜸			
public class PostServiceImp implements PostService {

	@Autowired
	private PostDAO postDao;	// root-container에 마이바티스-스프링 스캔에 의해 어노테이션 따로 등록 안해도 자동으로 들어가짐

	@Override
	public List<PostVO> getPostList() {
		// TODO Auto-generated method stub
		return postDao.selectPostList();
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return postDao.selectBoardList();
	}

	@Override
	public boolean insertBoard(String bo_name) {
		// TODO Auto-generated method stub
		if(bo_name == null || bo_name.trim().length() == 0) {
			return false;
		}
		try {
			return postDao.insertBoard(bo_name);			//bo_name unique 걸려있어서 무작정 넣으면 예외 발생
		}catch(Exception e) {
			//e.printStackTrace();				//추가 실패	-> return false 로 넘어감.
		}
		return false;
	}
	
	
	
	
}
