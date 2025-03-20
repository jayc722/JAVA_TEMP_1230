package kr.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.PostDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.MemberVO;
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
	
	

	@Override
	public boolean deleteBoard(int bo_num) {
		return postDao.deleteBoard(bo_num);
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		if(board == null || board.getBo_name() == null || board.getBo_name().trim().length() == 0) {
			return false;
		}
		return postDao.updateBoard(board);
	}

	@Override
	public boolean insertPost(PostVO post, MemberVO user) {
		if(post == null || post.getPo_title().trim().length() == 0 || post.getPo_content().length() == 0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		post.setPo_me_id(user.getMe_id());
		boolean res = postDao.insertPost(post);
		
		//첨부파일 있을때 필요
		
		return res;
	}

	@Override
	public PostVO getPost(int po_num) {
		//int라 null처리 불요
				
		return postDao.selectPost(po_num);
	}

	@Override
	public boolean deletePost(int po_num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//게시글 정보를 가져옴
		PostVO post = postDao.selectPost(po_num);
		//게시글의 작성자와 회원이 다르면 false 리턴
		if(post == null || !post.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//게시글 수정
		boolean res = postDao.deletePost(po_num);			//첨부파일 추가되면 첨부파일 삭제하기 위해....
		
		return res;
	}

	@Override
	public boolean updatePost(PostVO post, MemberVO user) {
		if(post == null || post.getPo_title().trim().length() == 0 || post.getPo_content().length() == 0) {
			return false;
		}
		if(user == null) {
			return false;
		}
		//게시글 정보를 가져옴
		PostVO dbPost = postDao.selectPost(post.getPo_num());
		//작성자인지 확인
		if(dbPost == null || !dbPost.getPo_me_id().equals(user.getMe_id())) {
			return false;
		}
		
		boolean res = postDao.updatePost(post);

		return res;
	}

		
}
