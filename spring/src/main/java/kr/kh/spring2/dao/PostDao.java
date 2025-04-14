package kr.kh.spring2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.PostCriteria;

public interface PostDao {

	List<BoardVO> selectBoardList();

	List<PostVO> selectPostList(@Param("criteria") PostCriteria cri);


}
