package kr.kh.spring2.service;

import java.util.List;

import kr.kh.spring2.model.vo.BoardVO;

public interface PostService {

	List<BoardVO> getBoardList();

}
