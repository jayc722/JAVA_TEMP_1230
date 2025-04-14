package kr.kh.spring2.dao;

import java.util.List;

import kr.kh.spring2.model.vo.BoardVO;

public interface PostDao {

	List<BoardVO> selectBoardList();

}
