package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;

@Mapper
public interface PostDAO {


	List<PostVO> selectPostList();

	List<BoardVO> selectBoardList();

	boolean insertBoard(@Param("bo_name")String bo_name);

}
