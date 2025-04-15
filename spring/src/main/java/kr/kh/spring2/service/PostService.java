package kr.kh.spring2.service;

import java.util.List;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.FileVO;
import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;
import kr.kh.spring2.pagination.PageMaker;

public interface PostService {

	List<BoardVO> getBoardList();

	List<PostVO> getPostList(Criteria cri);   //클래스 다형성 때문에 postCriteria도 올수있기때문에 여기는 criteria라고 써있지만 po_bo_num도 필드값으로 가져옴

	PageMaker getPageMaker(Criteria cri);

	PostVO getPost(int po_num);

	List<FileVO> getFileList(int po_num);

	boolean insertPost(PostVO post, MemberVO user);
}
