package kr.kh.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.PostDao;
import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.FileVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;
import kr.kh.spring2.pagination.PageMaker;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	private PostDao postDao;

	@Override
	public List<BoardVO> getBoardList() {
		// 매개변수 없으니 매개변수 체크할 필요 x
		return postDao.selectBoardList();
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		
		if(cri == null) return null;
		
		return postDao.selectPostList(cri);
	}
	

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		if(cri == null) {
			return null;
		}
		int count = postDao.selectCountPostList(cri);
		return new PageMaker(1, cri, count);
	}

	@Override
	public PostVO getPost(int po_num) {
		//if(po_num<0)return null;
		
		return postDao.selectPost(po_num);
	}

	@Override
	public List<FileVO> getFileList(int po_num) {
		
		return postDao.selectFileList(po_num);
	}
	
}
